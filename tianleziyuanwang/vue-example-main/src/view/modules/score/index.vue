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

          <el-form :model="form" status-icon :rules="rules" ref="form" label-width="100px" class="demo-ruleForm">
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

            <el-form-item label="成绩" prop="degree" :label-width="formLabelWidth" required>
              <el-input v-model.number="form.degree" autocomplete="off"></el-input>
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
 
    var validatePass1 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入学号'));
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('sno');
        }
        callback();
      }
    };

    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入姓名'));
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('sname');
        }
        callback();
      }
    };
    var validatePass3 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请选择性别'));
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('ssex');
        }
        callback();
      }
    };
    var validatePass4 = (rule, value, callback) => {
     
      if (value === '') {
        callback(new Error('请输入班级'));
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('sclass');
        }
        callback();
      }
    };
    var validatePass5 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入课程号'));
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('cno');
        }
        callback();
      }
    };
    var validatePass6 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入成绩'));
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('degree');
        }
        callback();
      }
    };
    var validatePass6 = (rule, value, callback) => {
      console.log("?????")
      console.log(value);
       
      if (!value) {
        return callback(new Error('请输入成绩'));
      }
      setTimeout(() => {
        if (!Number.isInteger(value)) {
          callback(new Error('请输入数字值'));
        } else {
          if (value >= 0 && value <= 100) {
            callback();
          } else {
            callback(new Error('成绩必须在0到100之间'));
          } 
        }
      }, 100);
    };
  
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
          {validator: validatePass1, trigger: 'blur' } 
        ],
        sname: [
          {validator: validatePass2, trigger: 'blur' }
        ], 
        ssex: [
          { validator: validatePass3,   trigger: 'blur' }
        ],
        sclass: [
          { validator: validatePass4, trigger: 'blur' }
        ],
        cno: [
          { validator: validatePass5,   trigger: 'blur' }
        ],
        degree: [
          { validator: validatePass6, trigger: 'blur' }
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
              this.$refs[formName].resetFields();

            })
           
        }else {
          console.log('error submit!!');
          return false;
            this.$refs[formName].resetFields();

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