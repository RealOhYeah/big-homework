<!--
   杨易达
   @email: y51288033@outlook.com
           y51288033@gmail.com
-->
<template>
    <div id="app">
        userinfo
        <a href="http://127.0.0.1:8001/file/getimage?imgUrl=1/71491f69-981e-4358-936e-5df0f592a1f2.png">qqqqq</a>
    </div>
  </template>

<script>
    export default {
        props: ["userinfo"],

        name: 'App',

        data() {
            return {

            }
        },

        mounted() {
            console.log("UserInfo component mounted!");
            console.log("userinfo prop:", this.userinfo);
        },

        methods: {

        }
    }
</script>

