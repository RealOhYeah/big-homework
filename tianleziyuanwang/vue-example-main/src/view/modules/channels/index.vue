<!--
    陈志祥
    @email: 1017850280@qq.com
-->
<template>
    <div>
        <Top></Top>
        <!-- 新增按钮 -->
        <section>
            <div class="container">
                <el-button @click="isAdd = true" type="primary" round class="but">新增</el-button>

                <channels :list="list" :columns="myColumns" :formFields="formFieldsWithTypes"
                    @currentChange="currentChange">
                </channels>

                <el-dialog title="信息" :visible.sync="isAdd">
                    <el-form :model="form">
                        <el-form-item v-for="field in formFieldsWithTypes" :key="field.name" :label="field.label">
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
                        <el-button type="primary" @click="addChannels">确 定</el-button>
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

import channels from "./component/edit.vue"
import { getDataByPage, addChannels } from '@/api/channel'
export default {
    components: {
        Top, Foot, channels
    },
    data() {
        return {
            pageSize: 50,
            currentPage: 1,
            total: 0,
            list: [],
            formFields: [
                // { name: 'id', label: '序号' },
                { name: 'name', type: 'string', label: '通道名字' },
                // { name: 'maxNumber', type: 'number', label: '最大数量' },
                { name: 'startTime',type:'date', label: '开始时间' },
                { name: 'endTime',type:'date', label: '结束事件' }
            ],
            isAdd: false,
            form: {}

        }
    },
    mounted() {
        this.currentChange(1)
    },
    methods: {
        addChannels() {
            addChannels(this.form).then(res => {
                console.log(res);

                if (res.data.code === '0x200') {
                    this.currentChange(1)
                    this.isUpdate = false
                    this.$message({
                        showClose: true,
                        message: '添加成功!',
                        type: 'success'
                    });
                } else {
                    this.$message({
                        showClose: true,
                        message: res.data.message,
                        type: 'error'
                    });
                }


                this.isAdd = !this.isAdd;
            })
        },
        //改变页数调用
        currentChange(val) {
            if (val) {
                this.currentPage = val;
            }
            let data = {
                start: (this.currentPage - 1) * this.pageSize,
                size: this.pageSize,
                "channels": {
                    "id": "",
                    "name": "",
                    "startTime": "",
                    "endTime": "",
                    "createBy": "",
                    "createTime": "",
                    "delFlag": "",
                    "status": ""
                }
            }
            console.log(data);
            getDataByPage(data).then((res) => {
                // console.log(res);
                if (res.data.code === '0x200') {
                    this.list = res.data.data.list
                    this.total = res.data.data.count
                    console.log(this.total);
                }
            })
        },
        //编辑按钮
        handleEdit(event) {
        },
        //删除按钮
        handleDelete(event) {

        },
        //

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
    }

}
</script>
<style scoped>
.but {
    margin-bottom: 20px;
}
</style>