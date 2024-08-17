<!--
 * @Author: tianleiyu 
 * @Date: 2024-03-13 15:03:22
 * @LastEditTime: 2024-08-17 15:56:04
 * @LastEditors: Oh...Yeah!!! 614988210@qq.com
 * @Description: 
 * @FilePath: /vue-example-main/src/view/auth-top.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<!--
    name
-->
<template>
    <div id="top">
        <div class="modal fade" tabindex="-1" role="dialog" id="modal-cookies" data-backdrop="false"
            aria-labelledby="modal-cookies" aria-hidden="true">
            <div class="modal-dialog modal-dialog-aside left-4 right-4 bottom-4">
                <div class="modal-content bg-dark-dark">
                    <div class="modal-body">
                        <!-- Text -->
                        <p class="text-sm text-white mb-3">
                            We use cookies so that our themes work for you. By using our website, you agree to our use
                            of cookies.
                        </p>
                        <!-- Buttons -->
                        <a class="btn btn-sm btn-white" target="_blank">Learn more</a>
                        <button type="button" class="btn btn-sm btn-primary mr-2" data-dismiss="modal">OK</button>
                    </div>
                </div>
            </div>
        </div>

        <a class="btn btn-block btn-dark text-truncate rounded-0 py-2 d-none d-lg-block"
            style="z-index: 1000;color:aliceblue" target="_blank">
            <strong>哈尔滨广厦学院</strong> 图床系统
        </a>


        <div>
            <nav class="navbar navbar-expand-lg navbar-light bg-white">
                <div class="container">
                    <!-- Brand -->
                    <a class="navbar-brand" href="/h">
                        <img alt="Image placeholder" style="height:3.4rem" src="../assets/gs_xy_logo.png"
                            id="navbar-logo">
                    </a>
                    <!-- Toggler -->
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                        aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <!-- Collapse -->
                    <div class="collapse navbar-collapse" id="navbarCollapse">
                        <ul class="navbar-nav mt-4 mt-lg-0 ml-auto">
                            <li class="nav-item " v-if="true">
                                <a @click.prevent="goScore" class="nav-link" href="">学生成绩管理</a>
                            </li>
                            <li class="nav-item " v-if="true">
                                <a @click.prevent="goChannel" class="nav-link" href="">通道管理</a>
                            </li>
                            <li class="nav-item " v-if="true">
                                <a @click.prevent="FileSystem" class="nav-link" href="">文件管理</a>
                            </li>

                            <li class="nav-item " v-if="true">
                                <a @click.prevent="goCarousel" class="nav-link" href="">轮播图通道</a>
                            </li>

                            <li class="nav-item ">
                                <a @click.prevent="accountOut" class="nav-link" href="">退出账号</a>
                            </li>
                            <!-- *1*绑定一个点击事件，*2*点击后清除里面的数据 本地的token，跳转到登陆页面this.$router.push('登录地址名：router——/auth') -->

                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</template>
  
  <script>
  export default {
    name: 'App',
  
    components: {
 
    },
  
    data() {
      return {
        //   channel: true,
        //  file:true,
        //  carousel:false,
        //  score:true
      }
    },
  
    created() {
      this.auth();
    },
    mounted() {
        this.loginType();
    },
    methods: {
        loginType(){
            var type = this.$cookie.get('logintype');
            console.log(type);
            if (type === 'fileLogin') {
                this.channel = true;
                this.file = true;
            }else if (type === 'carouselLogin') {
                this.carousel = true;
            }else{
                this.channel = true;
                this.file = true;
                this.carousel = true
               
            }
        },
        auth(){
            
        },
        goScore() {
            this.$router.push("score");
        },
        goCarousel(){
            this.$router.push("carousel");
        },
       thoroughfare(){
            this.$router.push({ name:'blogindex'})
       },
        FileSystem(){
            this.$router.push({name:'file'});
        },
        accountOut(){
                //删除token
                this.$cookie.delete('token')
                //删除用户类型
                var type = this.$cookie.get('logintype')
                //跳转到首页auth文件里面
                this.$router.push(`/${type}`)
        },
        goChannel(){
            this.$router.push("/channels");
        },
    }
  }
  </script>
  