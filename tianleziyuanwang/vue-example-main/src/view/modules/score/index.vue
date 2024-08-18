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

        <el-button type="primary" @click="dialogFormVisible = true">录入学生成绩</el-button>

        <el-dialog title="学生成绩录入" :visible.sync="dialogFormVisible">

          <el-form :model="form" :rules="rules" ref="form">
            <el-form-item label="学号" prop="sno" :label-width="formLabelWidth" required>
              <el-input v-model="form.sno" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="姓名" prop="sname" :label-width="formLabelWidth" required>
              <el-input v-model="form.sname" autocomplete="off"></el-input>
            </el-form-item>

            <el-form-item label="性别" prop="ssex" :label-width="formLabelWidth" required>
              <el-select v-model="form.ssex" placeholder="请选择性别">
                <el-option label="男" value="男"></el-option>
                <el-option label="女" value="女"></el-option>
              </el-select>
            </el-form-item>

            <el-form-item label="班级" prop="sclass" :label-width="formLabelWidth" required>
              <el-input v-model="form.sclass" autocomplete="off"></el-input>
            </el-form-item>

            <el-form-item label="课程号" prop="cno" :label-width="formLabelWidth" required>
              <el-input v-model="form.cno" autocomplete="off"></el-input>
            </el-form-item>

            <el-form-item label="成绩" prop="degree" :label-width="formLabelWidth"  required>
              <el-input v-model="form.degree" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item style="  padding-left: 70%;">
              <el-button @click="resetForm('form')">取 消</el-button>
              <el-button type="primary" @click="scoreIn('form')">确 定</el-button>
            </el-form-item>
          </el-form>
        </el-dialog>

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
import { queryRanking,scoreInput } from '@/api/score.js'; 
 
export default {
  name: 'VueExampleMainIndex',

    components: {
        Top, Foot
    },

  data() {
    return {
      dialogFormVisible: false,
      //学生成绩列表
      scoreList: [],
      form: {
        sno: '',
        sname: '',
        ssex: '',
        sclass: '',
        cno: '', 
        degree: ''  
      },
      formLabelWidth: '120px',
      rules: {
        sno: [
          { required: true, message: '请输入学号', trigger: 'blur' } 
        ],
        sname: [
          { required: true, message: '请输入姓名', trigger: 'blur' }
        ],
        ssex: [
          { required: true, message: '请选择性别', trigger: 'blur' }
        ],
        sclass: [
          { required: true, message: '请输入班级', trigger: 'blur' }
        ],
        cno: [
          { required: true, message: '请输入课程号', trigger: 'blur' }
        ],
        degree: [
          { required: true, message: '请输入分数(数值在 0 到 100 的范围内)', trigger: 'blur' }
        ],

      }
      
    };
  },

  mounted() {
    console.log("Hello World") 

  },

  created(){
  
    const _this = this;
    queryRanking().then((res) => {
 
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


    scoreIn(formName){
 
          this.$refs[formName].validate((valid) => {
          if (valid) { 
  
            this.dialogFormVisible = false
            scoreInput(this.form).then((res) => {
              console.log(res);
              if (res.data.code == "0x200") {
                this.$message({
                  showClose: true,
                  message: "录入成功!",
                  type: "success",
                }); 
              }
            })
           
        }
      });
      },
      
      resetForm(formName) { 
        this.$refs[formName].resetFields();
       
        this.$message({
          showClose: true,
          message: "录入取消",
          type: "fail",
        });
        this.dialogFormVisible = false
      },
      
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