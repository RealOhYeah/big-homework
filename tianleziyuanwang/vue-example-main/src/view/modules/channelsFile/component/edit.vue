<!--
 * @Author: tianleiyu 
 * @Date: 2024-03-26 10:34:27
 * @LastEditTime: 2024-04-09 09:20:38
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /vue-example-main/src/view/modules/channelsFile/component/edit.vue
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
                    <!-- <el-button @click="viewFile(scope.row.id)" type="text" size="small">文件查看</el-button> -->
                    <el-button @click="downFile(scope.row.downloadPath)" type="text" size="small">下载资源</el-button>
                    <el-button @click="selectById(scope.row)" type="text" size="small">修改</el-button>
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
                        <el-date-picker v-model="form[field.name]" type="date" value-format="yyyy-MM-dd HH:mm:ss"
                            placeholder="选择日期"></el-date-picker>
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
import { downloadFile, deleteHandeler ,updateFile} from '@/api/file.js'
export default {
    data() {
        return {
            isUpdate: false,
            form: {
                updateFileName:''
            }
        }
    },
    methods: {
        viewFile(val) {
            // 在某个方法中
            this.$router.push({ name: 'carouselFile', params: { id: val } })

        },
        selectById(file) {
            this.isUpdate = true;
            console.log(file);
            this.form = file
        },

        updateChannels() {
            console.log(this.form);
            this.form.updateFileName = this.form.originalFileName
            console.log(this.form);
            updateFile(this.form).then(res => {
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
            console.log(id);
            var data = {
                id: id
            }
            deleteHandeler(data).then(res => {
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

        downFile(val) {
            downloadFile({
                "imgUrl": val
            }).then(response => {

                // 从响应头中获取Content-Disposition字段
                const contentDisposition = response.headers['content-disposition'];

                // 从Content-Disposition中解析文件名
                let fileName = 'downloaded-file';
                if (contentDisposition) {
                    const matches = contentDisposition.match(/filename="(.*?)"/);
                    if (matches) {
                        fileName = matches[1];
                    }
                }

                // 创建一个URL对象
                const url = window.URL.createObjectURL(new Blob([response.data]));

                // 创建一个a标签
                const link = document.createElement('a');
                link.href = url;
                link.setAttribute('download', fileName);

                // 模拟点击下载链接
                document.body.appendChild(link);
                link.click();

                // 清理
                link.parentNode.removeChild(link);
                window.URL.revokeObjectURL(url);
            }).catch(error => {
                this.$message({
                    showClose: true,
                    message: '资源不存在!',
                    type: 'error'
            });
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