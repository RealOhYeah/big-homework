<!--
 * @Author: tianleiyu 
 * @Date: 2024-03-13 21:35:50
 * @LastEditTime: 2024-04-01 23:53:19
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /vue-example-main/src/view/modules/carousel/index.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
    <div id="app">
        <Top></Top>
        <section>
            <div class="container">

                <el-button @click="isAdd = true" v-if="false" type="primary" round class="but">新增</el-button>

                <el-button @click="delectList" type="primary" v-if="false" round class="but">批量删除</el-button>

                <carousel :list="list" :columns="myColumns" :rules="rules" :formFields="formFieldsWithTypes"
                    @currentChange="currentChange" @selection="selection">
                </carousel>

                <el-dialog title="信息" :visible.sync="isAdd">
                    <el-form :model="form" :rules="rules" ref="form">
                        <el-form-item v-for="field in formFieldsWithTypes" :key="field.name" :label="field.label"
                            :prop="field.name">
                            <template v-if="field.type === 'string'">
                                <el-input v-model="form[field.name]"></el-input>
                            </template>
                            <template v-else-if="field.type === 'number'">
                                <el-input-number v-model.number="form[field.name]"></el-input-number>
                            </template>
                            <template v-else-if="field.type === 'date'">
                                <el-date-picker v-model="form[field.name]" type="date"
                                    value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择日期"></el-date-picker>
                            </template>
                        </el-form-item>
                    </el-form>
                    <div slot="footer" class="dialog-footer">
                        <el-button @click="isAdd = false">取 消</el-button>
                        <el-button type="primary" @click="addCarousel('form')">确 定</el-button>
                    </div>
                </el-dialog>
                <div class="but"></div>
                <el-pagination background layout="prev, pager, next" :page-size="pageSize" :current-page="currentPage"
                    :total="total" @current-change="currentChange">
                </el-pagination>
                <div class="but"></div>
            </div>
        </section>
        <Foot></Foot>
    </div>
</template>

<script>
import Top from '../../auth-top.vue';
import Foot from "../../main-foot.vue";
import carousel from "./component/edit.vue"
import { getDataByPage, addCarousel ,deleteList} from '@/api/carousel';

export default {
    name: 'App',

    components: {
        Top, Foot, carousel
    },

    data() {
        return {
            pageSize: 50,
            currentPage: 1,
            total: 0,
            list: [],
            formFields: [
                // { name: 'id', label: '序号' },
                { name: 'name', type: 'string', label: '名字' },
                { name: 'maxNumber', type: 'number', label: '最大数量' },
                { name: 'createTime', label: '创建时间' },
            ],
            isAdd: false,
            form: {},

            //批量删除的数组
            multipleSelection:[]
        }
    },
    mounted() {
        this.currentChange(1)
        console.log(this.rules);
    },
    methods: {


        handleClick(row) {
            console.log(row);
        },
        addCarousel(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    addCarousel(this.form).then(res => {
                        if (res.data.code === '0x200') {
                            this.currentChange(1)
                            this.isAdd = false
                            this.$message({
                                showClose: true,
                                message: '添加成功!',
                                type: 'success'
                            });
                            this.form = {}
                            // this.formFields = []
                        } else {
                            this.$message({
                                showClose: true,
                                message: res.data.message,
                                type: 'error'
                            });
                            this.form = {}

                        }

                    })
                } else {
                    console.log('验证失败');
                    return false;
                }
            });


        },
        //改变页数调用
        currentChange(val) {
            if (val) {
                this.currentPage = val
            }
            // this.currentPage = val || 1
            let data = {
                start: (this.currentPage - 1) * this.pageSize,
                size: this.pageSize,
                "carousel": {

                }
            }
            getDataByPage(data).then((res) => {
                // console.log(res);
                if (res.data.code === '0x200') {
                    this.list = res.data.data.list
                    this.total = res.data.data.count
                    console.log(this.total);
                }
            })
        },
        handleChildEvent(dataFromChild) {
            // 接收到子组件传递的数据
            console.log(dataFromChild);
        },

        selection(val){
            this.multipleSelection = val
        },
        delectList(){
            deleteList(this.multipleSelection).then((res)=>{
                if (res.data.code === '0x200') {
                            this.currentChange(1)
                            this.isAdd = false
                            this.$message({
                                showClose: true,
                                message: '删除成功!',
                                type: 'success'
                            });
                            this.currentChange(1)
                        } else {
                            this.$message({
                                showClose: true,
                                message: res.data.message,
                                type: 'error'
                            });
                            this.currentChange(1)
                        }
            })
        },

        AddHandle() {
        },

        AddUserInfoService() {

        },

        FindByIdHandle() {

        }
    },
    computed: {
        myColumns() {
            return this.formFields.map(field => ({
                prop: field.name,
                label: field.label,
            }));
        },
        formFieldsWithTypes() {
            return this.formFields.filter(field => field.type);
        },
        rules() {
            return this.formFields.reduce((rules, field) => {
                let rule;
                switch (field.type) {
                    case 'string':
                        rule = [
                            { required: true, message: '请输入' + field.label, trigger: 'blur' },
                            // { min: 3, max: 5, message: field.label + '长度在 3 到 5 个字符', trigger: 'blur' },
                        ];
                        break;
                    case 'number':
                        rule = [
                            { type: 'number', min: 0, max: 100, message: field.label + '大小要在0到100', trigger: 'blur' },
                        ];
                        break;
                    case 'date':
                        rule = [
                            { type: 'date', required: true, message: '请选择' + field.label, trigger: 'change' },
                        ];
                        break;
                    default:
                        rule = [];
                }
                let newRules = Object.assign({}, rules);
                newRules[field.name] = rule;
                return newRules;
                //...运算符会报错
                // return { ...rules, [field.name]: rule };
            }, {});
        }
    },

}
</script>
<style scoped>
.but {
    margin-bottom: 20px;
}
</style>