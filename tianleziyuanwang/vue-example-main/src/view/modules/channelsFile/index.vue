<!--
 * @Author: tianleiyu 
 * @Date: 2024-03-26 10:19:49
 * @LastEditTime: 2024-03-26 14:37:20
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /vue-example-main/src/view/modules/channelsFile/index.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
    <div>
        <Top></Top>
        <!-- 新增按钮 -->
        <section>
            <div class="container">
                <el-button @click="isAdd = true" type="primary" round class="but">新增</el-button>

                <ChannelsFile :list="list" :columns="myColumns" :formFields="formFieldsWithTypes"
                    @currentChange="findById">
                </ChannelsFile>

                <!-- <div class="but"></div>
                <el-pagination background layout="prev, pager, next" :page-size="pageSize" :current-page="currentPage"
                    :total="total" @current-change="currentChange">
                </el-pagination>
                <div class="but"></div> -->
                <el-dialog title="Info" :visible.sync="isAdd">
                    <div>
                        <div style="display: flex; justify-content: center; align-items: center;">
                            <el-upload class="upload-demo" drag action="#" ref="upload" :headers="getHeaders()"
                                :on-preview="handlePreview" :on-remove="handleRemove" :on-change="getUploadFile"
                                :on-success="handleSuccess" :file-list="fileList" :auto-upload="false"
                                :show-file-list="true" multiple>
                                <i class="el-icon-upload"></i>
                                <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                                <div class="el-upload__tip" slot="tip">上传文件介绍</div>
                            </el-upload>
                        </div>

                        <div style="display: flex; justify-content: center; align-items: center;">
                            <button type="button" style="width: 75%;" v-if="isUploading" class="btn btn-primary"
                                @click="uploadFile()">Submit</button>
                            <el-button type="btn primary" style="width: 75%;" v-else :loading="true">上传中</el-button>
                        </div>
                    </div>
                    <div slot="footer" class="dialog-footer">
                        <el-button @click="isAdd = false">关闭</el-button>
                    </div>
                </el-dialog>


            </div>
        </section>

        <Foot></Foot>
    </div>
</template>

<script>
import Top from '../../auth-top.vue';
import Foot from "../../main-foot.vue";

import ChannelsFile from "./component/edit.vue"
import { getFileInformation } from '@/api/channelFile'
import { fileUpload } from '@/api/file.js'
  
import { insertFileToChannel} from '@/api/channelFile.js'
export default {
    components: {
        Top, Foot, ChannelsFile
    },
    data() {
        return {
            pageSize: 50,
            currentPage: 1,
            total: 0,
            list: [],
            formFields: [
                // { name: 'id', label: '序号' },
                { name: 'originalFileName', type: 'string', label: '文件名' },
                // { name: 'maxNumber', type: 'number', label: '最大数量' },
                { name: 'fileType', label: '文件类型' },
                { name: 'createTime', label: '创建时间' },
            ],
            isAdd: false,
            form: {},
            channelId: this.$route.params.id,

            //文件列表
            fileList: [],
            //上传状态
            isUploading: true
        }
    },
    mounted() {
        this.findById()
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
        findById() {
            // 在路由参数生效后执行相关操作
            // console.log(this.$route.params.id + "asda");
            getFileInformation(this.channelId).then(res => {
                this.list = res.data.data
            })
        },
        //编辑按钮
        handleEdit(event) {
        },
        //删除按钮
        handleDelete(event) {

        },
        //携带鉴权token
        getHeaders() {
            return {
                Authorization: "qweqweqweq"
            }
        },

        handlePreview(file) {
            console.log(file);
        },

        handleRemove(file, fileList) {
            console.log(file, fileList);
        },

        async uploadFile() {
            this.isUploading = false;
            let fileId;
            await fileUpload({
                "file": this.fleraw,
                "channelId": this.channelId
            }).then(res => {
                console.log(res, "file upload success")
                fileId = res.data.data.id;
            })

            let params = {
                "fileId": fileId,
                "channelId": this.channelId
            }

            if (this.channelId != -1) {
                await insertFileToChannel(params).then(res => {
                    console.log(res, "over");

                    this.$message({
                        message: '上传成功',
                        type: 'success'
                    });
                    this.isUploading = true
                    this.fileList = [];
                    this.findById()
                    this.isAdd = false;

                })
            }
        },

        getUploadFile(file, fileList) {
            this.fleraw = file.raw;
            //this.$refs.upload.submit(); // 手动触发上传

            // console.log(uploadPromisem,"now");
            // //上传响应结果
            // uploadPromise.then(res => {
            //     console.log(res,"qweqw");
            // })
        },

        handleSuccess(response, file, fileList) {

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
    }

}
</script>
<style scoped>
.but {
    margin-bottom: 20px;
}
</style>