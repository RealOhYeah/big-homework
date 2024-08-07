<!--
 * @Author: tianleiyu 
 * @Date: 2024-03-25 14:03:19
 * @LastEditTime: 2024-03-25 16:44:30
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /vue-example-main/src/view/unauhu-top.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<!--
    name
-->
<template>
    <div id="top">
        <div class="modal fade" tabindex="-1" role="dialog" id="modal-cookies" data-backdrop="false" aria-labelledby="modal-cookies" aria-hidden="true">
            <div class="modal-dialog modal-dialog-aside left-4 right-4 bottom-4">
                <div class="modal-content bg-dark-dark">
                    <div class="modal-body">
                        <!-- Text -->
                        <p class="text-sm text-white mb-3">
                            We use cookies so that our themes work for you. By using our website, you agree to our use of cookies.
                        </p>
                        <!-- Buttons -->
                        <a   class="btn btn-sm btn-white" target="_blank">Learn more</a>
                        <button type="button" class="btn btn-sm btn-primary mr-2" data-dismiss="modal">OK</button>
                    </div>
                </div>
            </div>
        </div>

        <a class="btn btn-block btn-dark text-truncate rounded-0 py-2 d-none d-lg-block" style="z-index: 1000;color:aliceblue" target="_blank">
            <strong>哈尔滨广厦学院</strong>  图床系统 V0.2 版本 通过 信息学院专业社团 TLM开发组 打造
        </a>


        <div>
            <nav class="navbar navbar-expand-lg navbar-light bg-white">
                <div class="container">
                    <!-- Brand -->
                    <a class="navbar-brand"  href="/h">
                        <img alt="Image placeholder" style="height:3.4rem" src="../assets/gs_xy_logo.png" id="navbar-logo">
                    </a>
                    <!-- Toggler -->
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <!-- Collapse -->
                    <div class="collapse navbar-collapse" id="navbarCollapse">
                        <ul class="navbar-nav mt-4 mt-lg-0 ml-auto">
                            <!-- <li class="nav-item ">
                                <router-link class="nav-link" to="/fileLogin"  >图床系统</router-link>
                            </li>
                            <li class="nav-item ">
                                <router-link class="nav-link" to="/carouselLogin"  >轮播图系统</router-link>
                            </li> -->
                            <li class="nav-item ">
                                <a class="nav-link" href=""  >友情链接</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    </div>
  </template>
  
  <script>
import router from '@/router';

  export default {
    name: 'App',
  
    components: {
 
    },
  
    data() {
      return {
         
      }
    },
  
    methods: {
       
    }
  }
  </script>
  