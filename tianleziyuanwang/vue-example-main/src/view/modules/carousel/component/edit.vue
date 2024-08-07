<!--
 * @Author: tianleiyu 
 * @Date: 2024-03-13 21:36:23
 * @LastEditTime: 2024-04-01 14:36:58
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /vue-example-main/src/view/modules/carousel/component/edit.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->

<template>
    <div class="">
        <el-table :data="list" border style="width: 100%"  @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="50" v-if="false"></el-table-column>
            <el-table-column v-for="column in columns" :key="column.prop" :prop="column.prop" :label="column.label">
            </el-table-column>
            <el-table-column fixed="right" label="操作" width="300">
                <template slot-scope="scope">
                    <el-button @click="viewFile(scope.row.id)" type="text" size="small">图片处理</el-button>
                    <el-button @click="viewCarousel(scope.row.id)" type="text" size="small">演示</el-button>
                    <el-button @click="viewCarousel1(scope.row.id)" type="text" size="small">系统尺度大小干预演示</el-button>
                    <el-button @click="selectById(scope.row.id)" type="text" size="small" v-if="false">修改</el-button>
                    <el-popconfirm v-if="false"  title="这是一段内容确定删除吗？" @confirm="deleteById(scope.row.id)">
                        <!-- <el-button @click="deleteById(scope.row.id)" type="text" size="small">删除</el-button> -->
                        <el-button type="text" size="small" slot="reference" >删除</el-button>
                    </el-popconfirm>
                    <!-- <el-button @click="deleteById(scope.row.id)" type="text" size="small">删除</el-button> -->

                </template>
            </el-table-column>
        </el-table>

        <el-dialog title="修改" :visible.sync="isUpdate">
            <el-form :model="form" :rules="rules" ref="form">
                <el-form-item v-for="field in formFields" :key="field.name" :label="field.label" :prop="field.name">
                    <template v-if="field.type === 'string'">
                        <el-input v-model="form[field.name]"></el-input>
                    </template>
                    <template v-else-if="field.type === 'number'">
                        <el-input-number v-model.number="form[field.name]"></el-input-number>
                    </template>
                    <template v-else-if="field.type === 'date'">
                        <el-date-picker v-model="form[field.name]" type="date" value-format="yyyy-MM-dd HH:mm:ss"
                            placeholder="选择日期"></el-date-picker>
                    </template>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="isUpdate = false">取 消</el-button>
                <el-button type="primary" @click="updateCarousel('form')">确 定</el-button>
            </div>
        </el-dialog>


    </div>

</template>

<script>
import { selectById, updateCarousel, deleteById } from '@/api/carousel'
export default {
    data() {
        return {
            isUpdate: false,
            form: {},
            
        }
    },
    mounted() {
    },
    methods: {
        viewCarousel1(val) {
            this.$router.push({ name: 'carousel_screen1', params: { id: val } })
        },
        viewCarousel(val) {
            this.$router.push({ name: 'carousel_screen2', params: { id: val } })
        },
        viewFile(val) {
            // 在某个方法中
            this.$router.push({ name: 'carouselFile', params: { id: val } })

        },
        selectById(id) {
            this.isUpdate = true;
            selectById(id).then(res => {
                // console.log(res);
                this.form = res.data.data;
            })
        },

        updateCarousel(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    updateCarousel(this.form).then(res => {
                        // console.log(res);
                        if (res.data.code === '0x200') {
                            this.$emit('currentChange')
                            this.isUpdate = false
                            this.$message({
                                showClose: true,
                                message: '修改成功!',
                                type: 'success'
                            });
                        } else {
                            this.$message({
                                showClose: true,
                                message: res.data.message,
                                type: 'error'
                            });
                        }
                    })
                } else {
                    console.log('验证失败');
                    return false;
                }
            });

        },
        deleteById(id) {
            deleteById(id).then(res => {
                if (res.data.code === '0x200') {
                    this.$emit('currentChange')
                    this.$message({
                        showClose: true,
                        message: '删除成功!',
                        type: 'success'
                    });

                } else {
                    this.$message({
                        showClose: true,
                        message: res.data.message,
                        type: 'error'
                    });
                }
            })
        },
        handleSelectionChange(val){
            var IdList = []
            for (let index = 0; index < val.length; index++) {
                var id = val[index].id;
                IdList.push(id);
            }
            this.$emit('selection',IdList)
            
        }
    },
    props: {
        list: {
            type: Array,
            required: true,
            default: () => [],
        },
        columns: {
            type: Array,
            required: true,
            default: () => [],
        },
        formFields: {
            type: Array,
            required: true,
            default: () => [],
        },
        rules: {
            type: Object,
            required: true,
            default: () => { },
        }
    },


};
</script>
<!-- 自己渲染获取的list -->
<!-- <template>  
    <div>  
      <el-table :data="list" border style="width: 100%">  
        <el-table-column  
          v-for="(column, index) in columns"  
          :key="index"  
          :prop="column.prop"  
          :label="column.label"  
          :width="column.width"  
        >  
        </el-table-column>  
      </el-table>  
    </div>  
  </template>  
    
  <script>  
  export default {  
    props: {  
      list: {  
        type: Array,  
        required: true,  
      },  
    },  
    computed: {  
      // 计算属性，返回格式化后的列定义  
      columns() {  
        // 假设每个对象都有相同的属性集，我们可以取第一个对象来获取属性名  
        const firstItem = this.list[0];  
        if (!firstItem) return [];  
    
        // 获取对象的所有键（属性名）  
        const keys = Object.keys(firstItem);  
          
        // 映射键到列定义对象  
        return keys.map((key) => ({  
          prop: key,  
          label: key, // 或者你可以根据需要将 key 转换为更友好的标签名  
          width: 120, // 或者你可以根据需要设置每列的宽度  
        }));  
      },  
       
    },  
  };  
  </script> -->