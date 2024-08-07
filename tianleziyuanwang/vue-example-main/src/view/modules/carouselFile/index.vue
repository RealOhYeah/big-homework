<template>
  <div id="app">
    <Top></Top>

    <EditInfo ref="editInfo"></EditInfo>
    <UploadFile ref="uploadFile"></UploadFile>

    <section>
      <div class="container">

        <el-button type="primary" @click="showUpdataLoad()">上传文件</el-button>

        <el-button type="primary" @click="deleteAll()">批量删除</el-button>

        <!-- <table class="table">
          <thead class="thead-light">
            <tr>
              <th scope="col">#</th>
              <th scope="col">文件名</th>
              <th scope="col">文件类型</th>
              <th scope="col">创建时间</th>
              <th scope="col">排序</th>
              <th scope="col">最大秒数</th>
              <th scope="col">操作</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="obj in fileFile">
              <th scope="row"></th>
              <td>{{ obj.originalFileName }}</td>
              <td>{{ obj.fileType }}</td>
              <td>{{ obj.createTime }}</td>
              <td>{{ obj.soft }}</td>
              <td>{{ obj.seconds/1000 }}</td>
              <td>
                <el-link type="primary" @click="downFileTest(obj.downloadPath)">下载资源</el-link>
                <el-link type="primary" @click="editInfo(obj)">修改</el-link>
                <el-link type="primary" @click="openfile(obj.downloadPath)">查看图片</el-link>
                <el-popconfirm title="这是一段内容确定删除吗？" @confirm="deleteHandeler(obj.id)">
                  <el-link type="primary"  slot="reference">删除</el-link>
                </el-popconfirm>
              </td>
            </tr>
          </tbody>
        </table> -->

        <el-table :data="fileFile" style="width: 100%" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="50"></el-table-column>
          <el-table-column v-for="column in myColumns" :key="column.prop" :prop="column.prop" :label="column.label"
            :width="column.width">
          </el-table-column>
          <el-table-column fixed="right" label="操作" width="300">
            <template slot-scope="scope">
              <el-link type="primary" @click="downFileTest(scope.row.downloadPath)">下载资源</el-link>
              <el-link type="primary" @click="editInfo(scope.row)">修改</el-link>
              <el-link type="primary" @click="openfile(scope.row.downloadPath)">查看图片</el-link>
              <el-popconfirm title="这是一段内容确定删除吗？" @confirm="deleteHandeler(scope.row.id)">
                <!-- <el-button @click="deleteById(scope.row.id)" type="text" size="small">删除</el-button> -->
                <el-link type="primary" slot="reference">删除</el-link>
              </el-popconfirm>

            </template>
          </el-table-column>
        </el-table>

        <!-- <el-pagination
                    background
                    layout="prev, pager, next"
                    :page-size="size"
                    :pager-count="11"
                    @current-change="getMerchantInformation"
                    :total="total">
                </el-pagination> -->
        <br>
        <br>
      </div>
    </section>

    <el-dialog title="图片预览" :visible.sync="picture">
      <div class="block">
        <el-image :src="picUrl"></el-image>
      </div>
    </el-dialog>

    <Foot></Foot>
  </div>
</template>

<script>

import Top from '../../auth-top.vue';
import Foot from "../../main-foot.vue";
import { findByCarouselId, carouselDelet } from '@/api/carousel_file';
import UploadFile from './component/uploadlImage.vue';
import EditInfo from './component/editInfo.vue';
import { downloadFile, deleteFlieList } from '@/api/file.js'

export default {
  name: 'App',

  components: {
    Top, Foot, UploadFile, EditInfo
  },

  data() {
    return {
      openTemplate: 0,
      user: {
        username: "root",
        password: "admin"
      },
      fileFile: [],
      formFields: [
        // { name: 'id', label: '序号' },
        { name: 'originalFileName', type: 'string', label: '文件名', widthValue: '160' },
        { name: 'fileType', type: 'string', label: '文件类型', widthValue: '100' },
        { name: 'createTime', type: 'number', label: '创建时间', widthValue: '250' },
        { name: 'soft', type: 'number', label: '排序', widthValue: '100' },
        { name: 'seconds', type: 'number', label: '最大秒数', widthValue: '100' },
      ],
      picture: false,
      picUrl: '',
      //多选框
      multipleSelection: []
    }
  },

  created() {
    this.findById();
  },

  methods: {
    deleteHandeler(val) {
      let params = {
        "id": val
      }
      carouselDelet(params).then(res => {
        this.findById();
      });
      this.$message({
        message: '删除成功',
        type: 'success'
      });
    },

    editInfo(val) {
      //this.$refs.editInfo.carouselId = this.$route.params.id;
      this.$refs.editInfo.carouselFileId = val.id;
      this.$refs.editInfo.seconds = val.seconds;
      this.$refs.editInfo.sort = val.soft;
      this.$refs.editInfo.introduceText = val.introduceText;
      this.$refs.editInfo.drawer = true;
    },

    findById() {
      // 在路由参数生效后执行相关操作
      // console.log(this.$route.params.id + "asda");
      findByCarouselId({
        "carouselId": this.$route.params.id
      }).then(res => {

        res.data.data.forEach(element => {
          element.seconds = element.seconds / 1000;
        });
        this.fileFile = res.data.data
      })
    },
    /**
     *  展示上传load
     */
    showUpdataLoad() {
      this.$refs.uploadFile.carouselId = this.$route.params.id;
      this.$refs.uploadFile.drawer = true;
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
          message: '资源不存在!',
          type: 'error'
        });
      });
    
    },
    openfile(val) {
      console.log(val);
      this.picUrl = "http://" + window.location.hostname + ":" + window.location.port + "/file/getFile?imgUrl=" + val;
      this.picture = true;
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
      // console.log(this.multipleSelection);
    },
    deleteAll() {
      let ids = [];
      this.multipleSelection.forEach(element => {
        ids.push(element.id);
      })
      deleteFlieList(ids).then(res => {
        if (res.data.code === '0x200') {
          this.$message({
            message: '删除成功',
            type: 'success'
          });
          this.findById();
        }else{
          this.$message({
            message: '删除失败',
            type: 'error'
          });
        }

      })

    }
  },
  computed: {
    myColumns() {
      return this.formFields.map(field => ({
        prop: field.name,
        label: field.label,
        width: field.widthValue
      }));
    },
  }
}
</script>