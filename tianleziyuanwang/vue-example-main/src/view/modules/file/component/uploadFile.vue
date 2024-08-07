<!--
    name
-->
<template>
    <div id="app">
      <el-drawer
        title="上传文件"
        :visible.sync="drawer"
        :direction="direction">
        <div>
          
            <div   style="display: flex; justify-content: center; align-items: center;">
              <b>通道: &nbsp; &nbsp;</b>
              <br>
              <el-select v-model="channelId" placeholder="请选择" style="width: 65%;">
                <el-option
                  v-for="item in channelList"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id">
                </el-option>
              </el-select>
            </div>

            <br>

            <div style="display: flex; justify-content: center; align-items: center;">
              <el-upload
                class="upload-demo"
                drag
                action="#"
                ref="upload"
                :headers="getHeaders()"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :on-change="getUploadFile"
                :on-success="handleSuccess"
                :file-list="fileList"
                :auto-upload="false"
                :show-file-list="true"
                multiple>
                <i class="el-icon-upload"></i>
                <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                <div class="el-upload__tip" slot="tip">上传文件介绍</div>
              </el-upload>
            </div>
  
            <div style="display: flex; justify-content: center; align-items: center;">
              <button type="button" style="width: 75%;" v-if="isUploading" class="btn btn-primary" @click="uploadFile()">Submit</button>
              <el-button type="btn primary" style="width: 75%;" v-else  :loading="true">上传中</el-button>
            </div>
        </div>
      </el-drawer>
    </div>
  </template>
  
  <script>

  import { fileUpload } from '@/api/file.js'
  
  import { insertFileToChannel} from '@/api/channelFile.js'
  import { currentTimeData } from '@/api/channel.js'

  export default {
    name: 'App',
    
 
  
    data() {
      return {
        channelId: -1,
        drawer: false,
        direction: 'rtl',
        fileList: [],
        options: [{
          id: '-1',
          name: '不选择'
        }, {
          id: '1',
          name: '2024年年度总结Ppt任务'
        }, {
          id: '2',
          name: '2024年各部门财富汇总'
        }, {
          id: '3',
          name: '2024各部门盈利'
        }, {
          id: '4',
          name: '二级学院工作汇报'
        }],

        channelList: [],

        //文件
        fleraw: null,

        //上传状态
        isUploading:true
      }
    },
  

    created() {
      this.getdata()
    },

    methods: {
      a1(){
        alert("修改");
      },
      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      },
      async getdata(){
        await currentTimeData().then(res => {
         this.channelList = res.data.data;
        // this.$refs.uploadFile.channelList = res.data;
        console.log(this.channelList,"我他妈的服了11");
        console.log(this.channelList.size,"??");
      })
      },

      //携带鉴权token
      getHeaders(){
        return {
                Authorization:  "qweqweqweq"
            }
      },

      handlePreview(file) {
            console.log(file);
      },

      handleRemove(file, fileList) {
            console.log(file, fileList);
      },

      async uploadFile(){
        this.isUploading = false;
        let fileId;

        await fileUpload({
          "file": this.fleraw,
          "channelId": this.channelId
        }).then(res => {
          console.log(res,"file upload success")
          fileId = res.data.data.id; 
        })

        console.log(fileId,"file Id");

        let params = {
          "fileId": fileId,
          "channelId": this.channelId
        }

        // if(this.channelId != -1){
          await insertFileToChannel(params).then(res=>{
              console.log(res,"over");
              
              this.$message({
                message: '上传成功',
                type: 'success'
              });
              this.isUploading =  true
              this.fileList = [];
              this.channelId = -1;
              this.$emit('getList')
              this.drawer = false;

          })
        // }
      },

      getUploadFile(file, fileList) {
        this.fleraw = file.raw; 
          //this.$refs.upload.submit(); // 手动触发上传

          // console.log(uploadPromisem,"now");
          // //上传响应结果
          // uploadPromise.then(res => {
          //     console.log(res,"qweqw");
          // })
      },

      handleSuccess(response, file, fileList) {

      }
    }
  }
  </script>
  