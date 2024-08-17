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
              <th scope="col">#</th>
              <th scope="col">排名</th>
              <th scope="col">姓名</th>
              <th scope="col">性别</th>
              <th scope="col">学号</th>
              <th scope="col">班级</th>
              <th scope="col">总分</th>
              <th scope="col">平均分</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(obj,  index) in scoreList">
              <th scope="row"></th>
              <td>{{ index + 1 }}</td>
              <td>{{ obj.sName }}</td>
              <td>{{ obj.sSex }}</td>
              <td>{{ obj.sId }}</td>
              <td>{{ obj.sClass }}</td>
              <td>{{ obj.totalScore }}</td>
              <td>{{ obj.averageScore }}</td>



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
  
    const _this = this;
    queryRanking('').then((res) => {

      console.log("9999999999999999999")  
      console.log(res);  

      console.log("6666666666666666666666666")

      const aver = res.data.data
      

      console.log("777777777777777777")
      console.log(aver);

      if (res.data.code == "0x200") {

        _this.scoreList = res.data.data;

        console.log("1111111111111111111111111111111111111")


        this.$message({
          showClose: true,
          message: "查询成功!",
          type: "success",
        });
      }
      
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