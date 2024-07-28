<!--
    name
-->
<template>
  <div id="app">
    <el-drawer title="上传文件" :visible.sync="drawer" :direction="direction">
      <el-form label-position="top" label-width="80px" >
        <el-form-item label="排序">
          <el-input-number v-model="sort" style="width: 58%;" :step="1"></el-input-number>
        </el-form-item>
        <el-form-item label="时长(秒)">
          <el-input-number v-model="seconds" style="width: 58%;" :step="1"></el-input-number>
        </el-form-item>
        <el-form-item label="介绍">
          <el-input v-model="introduceText" type="textarea" autosize placeholder="请输入内容" style="width: 58%;"></el-input>
        </el-form-item>
        <el-form-item label="设置字体颜色">
          <div style="display: flex;">
            <el-color-picker v-model="color" show-alpha :predefine="predefineColors">
          </el-color-picker>
          &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
          <el-button @click="pickColor" plain>吸管工具</el-button>
          </div>
          
        </el-form-item>
        <el-form-item label="示例">
          <label for="color" :style="{ color: color }">哈尔滨广厦学院</label>
        </el-form-item>
        <el-form-item label="上传文件">
          <el-upload class="upload-demo" action="#" drag ref="upload" :headers="getHeaders()"
            :on-preview="handlePreview" :on-remove="handleRemove" :on-change="getUploadFile" :on-success="handleSuccess"
            :file-list="fileList" :auto-upload="false" :show-file-list="true" multiple :accept="'.png,.jpg,.mov'">
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
          </el-upload> 
        </el-form-item>
        <el-form-item>
          <button type="button" style="width: 75%;" v-if="isUploading" class="btn btn-primary"
            @click="uploadFile()">Submit</button>
          <el-button type="btn btn-primary primary" style="width: 75%;" v-else :loading="true">上传中</el-button>
        </el-form-item>
      </el-form>
    </el-drawer>
  </div>
</template>

<script>

import { fileUpload, carouselAdd } from '@/api/carousel_file.js'

import { insertFileToChannel } from '@/api/channelFile.js'
import { currentTimeData } from '@/api/channel.js'

export default {
  name: 'App',

  data() {
    return {
      channelId: "-1",
      drawer: false,
      direction: 'rtl',
      fileList: [],
      // options: [{
      //   value: '-1',
      //   label: '不选择'
      // }, {
      //   value: '1',
      //   label: '2024年年度总结Ppt任务'
      // }, {
      //   value: '2',
      //   label: '2024年各部门财富汇总'
      // }, {
      //   value: '3',
      //   label: '2024各部门盈利'
      // }, {
      //   value: '4',
      //   label: '二级学院工作汇报'
      // }],

      channelList: [],

      //文件
      fleraw: null,
      //轮播图id
      carouselId: -1,
      //顺序
      sort: 1,
      //最大停留时间
      seconds: 5,
      //介绍文字
      introduceText: "",

      //  上传状态
      isUploading: true,

      color: '#000000',
      predefineColors: [
        '#000000',
        '#ffffff',
        '#ff4500',
        '#ff8c00',
        '#ffd700',
        '#90ee90',
        '#00ced1',
        '#1e90ff',
        '#c71585',
        'rgba(255, 69, 0, 0.68)',
        'rgb(255, 120, 0)',
        'hsv(51, 100, 98)',
        'hsva(120, 40, 94, 0.5)',
        'hsl(181, 100%, 37%)',
        'hsla(209, 100%, 56%, 0.73)',
        '#c7158577'
      ]

    }
  },
  created() {
    // this.getData();
  },
  methods: {
    // getData(){
    //   currentTimeData().then(res => {
    //   // console.log(res, "我他妈的服了！！！！！！");
    //   this.channelList = res.data;
    // })
    // },

    async pickColor() {
      if (!window.EyeDropper) {
        this.color = "Your browser does not support the EyeDropper API";
        return;
      }
      const dropper = new EyeDropper();
      try {
        const result = await dropper.open();
        this.color = result.sRGBHex;
      } catch (error) {
        console.error(error);
      }
    },

    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        })
        .catch(_ => { });
    },

    //携带鉴权token
    getHeaders() {
      return {
        Authorization: "qweqweqweq"
      }
    },

    handlePreview(file) {
      console.log(file);
    },

    handleRemove(file, fileList) {
      // console.log(file, fileList);
    },

    async uploadFile() {
      this.isUploading = false;
      console.log(this.fileList,"文件通道");

      for(let i = 0 ; i < this.fileList.length ; i++){
        let fileId;

        await fileUpload({
          "file": this.fileList[i].raw,
          "channelId": this.channelId
        }).then(res => {
          // console.log(res, "file upload success")
          fileId = res.data.data.id;
        })
        // console.log(fileId, "file Id");
        let params = {
          "fileId": fileId,
          "carouselId": this.carouselId,
          "soft": this.sort,
          "seconds": this.seconds * 1000,
          "introduceText": this.introduceText,
          "fontColor": this.color
        }
        //上传管道通道文件夹的关联
        await carouselAdd(params).then(res => {
          this.$parent.findById();
        })
        this.isUploading = true;
        this.$message({
          type: 'success',
          message: '上传成功!'
        })
      }

      this.sort = 1
      this.seconds = 5
      this.introduceText = ""
      this.fileList = []
      this.drawer = false;
      this.getData()
    },

    getUploadFile(file, fileList) {
      this.fileList = fileList;
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

<style scoped>
.from {
  padding: 20px;
}

/deep/ .el-form-item{
  margin-bottom: 10px;
}
/deep/ .el-form--label-top{
  padding: 0;
}
/deep/ .el-form-item__label{
  line-height: 0;
}
/deep/ .el-form{
  padding: 20px;
}
/deep/ .el-upload-dragger{
  width: 300px;
}
</style>