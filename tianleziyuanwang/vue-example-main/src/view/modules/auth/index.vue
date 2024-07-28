<!--
 * @Author: tianleiyu 
 * @Date: 2024-03-13 15:03:22
 * @LastEditTime: 2024-03-25 15:52:03
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /vue-example-main/src/view/modules/auth/index.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<!--
    陈志祥
    @email: 1017850280@qq.com
-->
<template>
  <div id="app">
    <Top></Top>
    <div>
      <router-view/>
    </div>
    <Foot></Foot>
  </div>
</template>

<script>
 

import Top from '../../unauhu-top.vue';
import Foot from "../../main-foot.vue";
// import Login from './component/login.vue';
// import fileLogin from './component/fileLogin.vue';
// import carouselLogin from './component/carouselLogin.vue'

export default {
  name: 'App',

  components: {
    Top, Foot
  },

  data() {
    return {
      openTemplate: 0,
      user: {
        username: "root",
        password: "admin"
      }
    }
  },

  methods: {
  //   handleChildEvent(dataFromChild) {
  //     // 接收到子组件传递的数据
  //     console.log(dataFromChild);
  //   },

  //   AddHandle() {
  //     this.AddUserInfoService();
  //   },

  //   AddUserInfoService() {
  //     add(this.user).then(res => {
  //       console.log(res);
  //     });
  //   },

  //   FindByIdHandle() {
  //     let params = {
  //       "id": 1
  //     }

  //     getUserInfoById(params).then(res => {
  //       console.log(res, "findById")
  //     })
  //   }
  // }
  }
}
</script>