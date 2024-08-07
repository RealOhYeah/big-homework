<!--
 * @Author: tianleiyu 
 * @Date: 2024-03-25 15:02:30
 * @LastEditTime: 2024-03-25 16:36:43
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /vue-example-main/src/view/modules/auth/component/fileLogin.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>

    <div class="hello">
      <!-- Main content -->
      <section>
        <div class="container">
          <!-- Title -->
          <!-- Section title -->
          <div class="row mb-5 justify-content-center text-center">
            <div class="col-lg-6">
  
              <h2 class=" mt-4">登入您的账户</h2>
              <div class="mt-2">
                <p class="lead lh-180">Login Your Account</p>
              </div>
  
              <div>
                <div class="form-group">
                  <label for="exampleInputEmail1">Username</label>
                  <input v-model="user.username" type="email" class="form-control" id="exampleInputEmail1"
                    aria-describedby="emailHelp">
                  <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone
                    else.</small>
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">Password</label>
                  <input v-model="user.password" type="password" class="form-control" id="exampleInputPassword1" @keyup.enter="loginService">
                </div>
                <div class="form-group form-check">
  
                  <!-- 如果您 <a href="#">忘记了密码</a>，或者 <a href="/h/user/register">去注册一个账户</a> -->
                </div>
                <button class="btn btn-primary" style="width:100%" @click="loginService()">Submit</button>
  
              </div>
            </div>
          </div>
  
        </div>
      </section>
    </div>
  </template>
  
  <script>
  
  //请不要删除api
  import { login } from '@/api/auth.js'
  
  export default {
    name: 'HelloWorld',
    components: {
  
    },
    data() {
      return {
        user: {
          username: "",
          password: ""
        },
        //按钮开关
        switchbutton: false,
      }
    },
    mounted() {
  
    },
  
    methods: {
  
      async loginService() {
          let result = await login(this.user)
          if (result.data.code == "0x200") {
            // console.log(result);
            this.$cookie.set('token', result.data.data.token);
            this.$cookie.set('logintype', 'fileLogin');
            this.$router.push("file");
          }
      }
  
    }
  }
  </script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
  
  <style scoped>
  h1,
  h2 {
    font-weight: normal;
  }
  
  ul {
    list-style-type: none;
    padding: 0;
  }
  
  li {
    display: inline-block;
    margin: 0 10px;
  }
  
  a {
    color: #42b983;
  }
  </style>