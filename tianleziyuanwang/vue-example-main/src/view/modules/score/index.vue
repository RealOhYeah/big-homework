<template>
  <div id="app">
    <Top></Top>
    <section>
      <div style="    width: 100%;
                      margin-right: auto;
                      margin-left: auto;
                      padding-right: 15px;
                      padding-left: 15px;
                      max-width: 960px;">

        <el-button type="primary" @click="scoreInput()">录入学生成绩</el-button>

        <table class="table">
          <thead class="thead-light">
            <tr>
              <th scope="col">排名</th>
              <th scope="col">姓名</th>
              <th scope="col">性别</th>
              <th scope="col">学号</th>
              <th scope="col">班级</th>
              <th scope="col">总分</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="obj in scoreList">
              <th scope="row"></th>
              <!-- <td>{{ obj.originalFileName }}</td>
              <td>{{ obj.fileType }}</td>
              <td>{{ obj.createTime }}</td> -->
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
      </div>
    </section>
    <Foot></Foot>
  </div>
</template>

<script>
import Top from '../../auth-top.vue';
import Foot from "../../main-foot.vue";
import { queryRanking, queryAll } from '@/api/score.js'; 
 
export default {
  name: 'VueExampleMainIndex',

    components: {
        Top, Foot
    },

  data() {
    return {

      //学生成绩列表
      scoreList: [],
    
    };
  },

  mounted() {
    console.log("Hello World")


  },

  created(){

    // queryAll().then((res) => {
    //   console.log("77777777777777");
    //   console.log(res); 
    // });

    const _this = this;
    queryRanking('').then((res) => {

      console.log("6666666666666");
      console.log(res);


      if (res.data.code === "0x200") {
        this.$message({
          showClose: true,
          message: "查询成功!",
          type: "success",
        });
      }
      _this.tableData = res.data.data.list;
      // console.log("???");
      // console.log(_this.tableData);
    });
  },

  methods: {


  },


};
</script>

<style>
*,
*::before,
*::after {
  box-sizing: border-box;
}

.target {
  position: absolute;
  left: 50%;
  top: 25%;
  transform: translate(-50%, -50%);
}
</style>