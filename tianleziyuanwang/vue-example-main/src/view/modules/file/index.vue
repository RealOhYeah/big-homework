<!--
    杨易达 2024-3-12
    开发和对接文件板块
    @email: y51288033@outlook.com
-->
<template>
  <div id="app">
    <Top></Top>
 
    <!--上传文件-->
    <UploadFile ref="uploadFile" @getList="pagingtoGetDataHadler"></UploadFile>

    <section>
      <div class="container">
        <el-button type="primary" @click="showUpdataLoad()">上传文件</el-button>

        <table class="table">
          <thead class="thead-light">
            <tr>
              <th scope="col">#</th>
              <th scope="col">文件名</th>
              <th scope="col">文件类型</th>
              <th scope="col">创建时间</th>
              <th scope="col">当前状态</th>
              <th scope="col">操作</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="obj in fileFile">
              <th scope="row"></th>
              <td>{{ obj.originalFileName }}</td>
              <td>{{ obj.fileType }}</td>
              <td>{{ obj.createTime }}</td>
              <td>--</td>
              <td>
                <el-link type="primary" @click="downFileTest(obj.downloadPath)">下载资源</el-link>
                <!-- <el-link type="primary" @click="copy(obj.downloadPath)">复制下载链接</el-link> -->
                <el-link type="primary" @click="selectorChannel(obj.id)">发送到通道</el-link>
                <el-link type="success" v-if="hide">修改内容</el-link>
                <el-link type="warning" v-if="hide">修改权限</el-link>
                <el-popconfirm title="这是一段内容确定删除吗？" @confirm="deleteHandeler(obj.id)">
                  <el-link type="danger" slot="reference">删除</el-link>
                  <!-- <el-button type="text" size="small" >删除</el-button> -->
                </el-popconfirm>
                <!-- <el-link type="danger" @click="deleteHandeler(obj.id)">删除</el-link> -->
              </td>
            </tr>
          </tbody>
        </table>

        <!-- 用于选择通道的对话框 -->
        <el-dialog title="选择通道" :visible.sync="isSelectorChannel">
          <el-table :data="channelList">
            <el-table-column property="name" label="通道名字"></el-table-column>
            <el-table-column fixed="right" label="操作" width="200">
              <template slot-scope="scope">
                <el-button @click="addChannels(scope.row.id)" type="text" size="small">选择此通道</el-button>
              </template>
            </el-table-column>
          </el-table>
          <el-pagination background layout="prev, pager, next" :page-size="pageSize" :current-page="currentPage"
            :total="total" @current-change="currentChange">
          </el-pagination>
        </el-dialog>

        <el-pagination background layout="prev, pager, next" :page-size="size" :pager-count="11"
          @current-change="getMerchantInformation" :total="total">
        </el-pagination>

        <br>
        <br>
      </div>
    </section>

    <Foot></Foot>
  </div>
</template>

<script>
import Top from '../../auth-top.vue';
import Foot from "../../main-foot.vue";
import UploadFile from './component/uploadFile.vue';
import { pagingtoGetData, downloadFile, deleteHandeler } from '@/api/file.js'
import { addChannels, getDataByPage } from '@/api/channel'

import { insertFileToChannel } from '@/api/channelFile.js'

export default {
  name: 'App',

  components: {
    Top, Foot, UploadFile
  },

  data() {
    return {
      //隐藏功能
      hide:false,

      openTemplate: 0,
      user: {
        username: "root",
        password: "admin"
      },

      //文件列表
      fileFile: [],

      //查询参数
      start: 0,
      size: 10,

      //总数据数量
      total: 0,

      //筛选参数
      fileUploads: {
        originalFileName: "",
        //todo 补充其他参数
      },

      //选择通道的开关
      isSelectorChannel: false,
      //临时存储fileid
      fileId: -1,
      //通道列表
      channelList: [],
      //通道列表的分页
      pageSize: 50,
      currentPage: 1,
      channelTotal: 0,

    }
  },
  created() {
    this.getMerchantInformation(1);
  },
  methods: {
    //删除
    deleteHandeler(val) {
      var data = {
        id: val
      }
      deleteHandeler(data).then(res => {
        if (res.data.code === "0x200") {
          this.$message({
            showClose: true,
            message: '删除成功!',
            type: 'success'
          });
          this.getMerchantInformation(1);
        } else {
          this.$message({
            showClose: true,
            message: res.data.message,
            type: 'error'
          });
        }
      });
    },

    getMerchantInformation(val) {
      this.start = (val - 1) * this.size;
      this.pagingtoGetDataHadler();
    },

    downFileTest(val) {
      downloadFile({
        "imgUrl": val
      }).then(response => {

        // 从响应头中获取Content-Disposition字段
        const contentDisposition = response.headers['content-disposition'];

        // 从Content-Disposition中解析文件名
        let fileName = 'downloaded-file';
        if (contentDisposition) {
          const matches = contentDisposition.match(/filename="(.*?)"/);
          if (matches) {
            fileName = matches[1];
          }
        }

        // 创建一个URL对象
        const url = window.URL.createObjectURL(new Blob([response.data]));

        // 创建一个a标签
        const link = document.createElement('a');
        link.href = url;
        link.setAttribute('download', fileName);

        // 模拟点击下载链接
        document.body.appendChild(link);
        link.click();

        // 清理
        link.parentNode.removeChild(link);
        window.URL.revokeObjectURL(url);
      }).catch(error => {
        this.$message({
          showClose: true,
          message: '资源不存在!',
          type: 'error'
        });
      });
      ;
    },

    /**
     * 分页获取数据 
     */
    pagingtoGetDataHadler() {
      let params = {
        "start": this.start,
        "size": this.size,
        "fileUploads": this.fileUploads,
      }

      pagingtoGetData(params).then(res => {
        // console.log(res, "Qweqweqeq");
        this.fileFile = res.data.data.list;
        this.total = res.data.data.count;
      });
    },

    /**
     *  展示上传load
     */
    async showUpdataLoad() {
      // await currentTimeData().then(res => {
      //   // this.channelList = res.data;
      //   this.$refs.uploadFile.channelList = res.data;
      //   console.log(this.$refs.uploadFile.channelList,"我他妈的服了11");
      // })
      this.$refs.uploadFile.drawer = true;
    },

    handleChildEvent(dataFromChild) {
      // 接收到子组件传递的数据
      console.log(dataFromChild);
    },

    AddHandle() {
      this.AddUserInfoService();
    },

    AddUserInfoService() {
      add(this.user).then(res => {
        console.log(res);
      });
    },

    FindByIdHandle() {
      let params = {
        "id": 1
      }

      getUserInfoById(params).then(res => {
        console.log(res, "findById")
      })
    },
    //copy功能
    // copy(data) {
    //   let url = 'http://192.168.0.211:7112/file/getFile?imgUrl=' + data;
    //   let oInput = document.createElement('input');
    //   oInput.value = url;
    //   document.body.appendChild(oInput);
    //   oInput.select(); // 选择对象;
    //   console.log(oInput.value)
    //   document.execCommand("Copy"); // 执行浏览器复制命令
    //   this.$message({
    //     message: '复制成功',
    //     type: 'success'
    //   });
    //   oInput.remove()
    // },
    //选择通道
    selectorChannel(id) {
      this.currentChange(1)
      this.fileId = id
      this.isSelectorChannel = true;
    },
    //通道的分页
    currentChange(val) {
      if (val) {
        this.currentPage = val;
      }
      let data = {
        start: (this.currentPage - 1) * this.pageSize,
        size: this.pageSize,
        "channels": {
          "id": "",
          "name": "",
          "startTime": "",
          "endTime": "",
          "createBy": "",
          "createTime": "",
          "delFlag": "",
          "status": ""
        }
      }
      console.log(data);
      getDataByPage(data).then((res) => {
        // console.log(res);
        if (res.data.code === '0x200') {
          this.channelList = res.data.data.list
          this.channelTotal = res.data.data.count
          console.log(this.channelTotal);
        }
      })
    },
    // 添加到选择的通道中
    addChannels(channelId) {
      let params = {
        "fileId": this.fileId,
        "channelId": channelId
      }
      insertFileToChannel(params).then(res => {
        console.log(res);
        this.$message({
          message: '添加成功!',
          type: 'success'
        });
        this.isSelectorChannel = false;
      })
    },
  }
}
</script>