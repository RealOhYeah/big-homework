<!--
 * @Author: tianleiyu 
 * @Date: 2024-03-18 16:44:04
 * @LastEditTime: 2024-03-26 13:00:37
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /vue-example-main/src/view/modules/channels/component/edit.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->

<template>
    <div class="">
        <el-table :data="list" border style="width: 90%">
            <el-table-column label="#" width="50"></el-table-column>
            <el-table-column v-for="column in columns" :key="column.prop" :prop="column.prop" :label="column.label">
            </el-table-column>
            <el-table-column fixed="right" label="操作" width="300">
                <template slot-scope="scope">
                    <el-button @click="viewFile(scope.row.id)" type="text" size="small">文件查看</el-button>
                    <el-button @click="selectById(scope.row.id)" type="text" size="small">修改</el-button>
                    <el-popconfirm title="这是一段内容确定删除吗？" @confirm="deleteById(scope.row.id)">
                        <el-button type="text" size="small" slot="reference">删除</el-button>
                    </el-popconfirm>
                    <!-- <el-button @click="deleteById(scope.row.id)" type="text" size="small">删除</el-button> -->
                </template>
            </el-table-column>
        </el-table>

        <el-dialog title="修改" :visible.sync="isUpdate">
            <el-form :model="form">
                <el-form-item v-for="field in formFields" :key="field.name" :label="field.label">
                    <template v-if="field.type === 'string'">
                        <el-input v-model="form[field.name]"></el-input>
                    </template>
                    <template v-else-if="field.type === 'number'">
                        <el-input-number v-model.number="form[field.name]"></el-input-number>
                    </template>
                    <template v-else-if="field.type === 'date'">
                        <el-date-picker v-model="form[field.name]" type="date" value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择日期"></el-date-picker>
                    </template>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="isUpdate = false">取 消</el-button>
                <el-button type="primary" @click="updateChannels">确 定</el-button>
            </div>
        </el-dialog>
    </div>

</template>

<script>
import { selectById, updateChannels, deleteById } from '@/api/channel'
export default {
    data() {
        return {
            isUpdate: false,
            form: {}
        }
    },
    methods: {
        viewFile(val){
            // 在某个方法中
            this.$router.push({ name: 'channelsFile', params: { id: val }})

        },
        selectById(id) {
            this.isUpdate = true;
            selectById(id).then(res => {
                console.log(res);
                this.form = res.data.data;
            })
        },
        
        updateChannels() {
            updateChannels(this.form).then(res => {
                console.log(res);

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
    },


};
</script>