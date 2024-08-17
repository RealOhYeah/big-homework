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

               <!--  待完成  -->
                <!-- <el-dialog title="信息" :visible.sync="isAdd">
                    <el-form :model="form">
                        <el-form-item v-for="field in formFieldsWithTypes" :key="field.name" :label="field.label">
                            <template v-if="field.type === 'string'">
                                <el-input v-model="form[field.name]"></el-input>
                            </template>
                            <template v-else-if="field.type === 'number'">
                                <el-input-number v-model.number="form[field.name]"></el-input-number>
                            </template>
                            <template v-else-if="field.type === 'date'">
                                <el-date-picker v-model="form[field.name]" type="date"
                                    value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择日期"></el-date-picker>
                            </template          
                        </el-form-item>
                    </el-form>
                    <div slot="footer" class="dialog-footer">
                        <el-button @click="isAdd = false">取 消</el-button>
                        <el-button type="primary" @click="addChannels">确 定</el-button>
                    </div>
                </el-dialog> -->

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
import { queryRanking } from '@/api/score.js'; 
 
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
 
      console.log(res);   
      const aver = res.data.data
       
      console.log(aver);

      if (res.data.code == "0x200") {

        _this.scoreList = res.data.data; 
        this.$message({
          showClose: true,
          message: "查询成功!",
          type: "success",
        });
      }
      
    });
  },

  methods: {

    scoreInput(){

    } 

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