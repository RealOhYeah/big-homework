<!--
   杨易达
   @email: y51288033@outlook.com
           y51288033@gmail.com
-->
<template>
    <div id="app">
<<<<<<< HEAD
       this is  my profile
=======
        this is my qqqqq
>>>>>>> 12760db2ee4a74a7c4973a94f6694ea0011ce5c0
    </div>
  </template>
  
<script>
    export default {
 

        name: 'App',

        data() {
            return {
        
            }
        },  

        mounted() {
            console.log("用户的简历")
            this.$emit('childEvent', "你好我给我的父组件值");
        },

        methods: {

 
        }
    }
</script>
    
  