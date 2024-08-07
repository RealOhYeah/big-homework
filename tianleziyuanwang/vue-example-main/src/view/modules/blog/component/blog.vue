<!--
    陈志祥
    @email: 1017850280@qq.com
-->
<template>
    <div id="app">
        <section>
            <div class="container">
                <!-- 返回按钮 -->
                <el-page-header @back="goBack" content="通道管理"></el-page-header>

                <table class="table">
                    <thead class="thead-light">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">文件名</th>
                            <th scope="col">文件类型</th>
                            <th scope="col">创建时间</th>
                            <th scope="col">当前状态</th>
                            <th scope="col">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(item, index) in lists" :key="item.id">
                            <th scope="row"></th>
                            <td>{{item.originalFileName}}</td>
                            <td>{{item.fileType}}</td>
                            <td>{{item.updateTime}}</td>
                            <td>{{item.role?'公开':'私有'}}</td>
                            <td>
                                <el-link type="primary">下载资源</el-link>
                                <el-link @click="dialogVisible = true" type="success">修改内容</el-link>
                                <!-- <el-link type="danger">删除</el-link> -->
                                <!-- <el-popconfirm title="确定删除吗？"> -->

                                    <!-- <el-link type="danger"  @click="reference(item.id)">删除</el-link> -->

                                <!-- </el-popconfirm> -->
                                <!-- --上传文件 :http-request="newUpload"  :headers="{token} "-- -->
                                <el-upload class="upload-demo" action="#" :http-request="newUpload"
                                    :file-list="fileList" style="float: right;" :on-change="upChange"
                                    :show-file-list="false">
                                    <el-button size=" small" type="success">点击上传</el-button>

                                </el-upload>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <!-- 分页查询 -->
                <el-pagination background layout="prev, pager, next" :total="pageNations.size" >
                </el-pagination>
                <!-- 修改内容 -->
                <el-dialog title="请修改内容" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
                    <el-form ref="form" :model="form" label-width="80px">
                        <el-form-item label="活动名称">
                            <el-input v-model="form.name"></el-input>
                        </el-form-item>
                        <el-form-item label="活动区域">
                            <el-select v-model="form.region" placeholder="请选择活动区域">
                                <el-option label="区域一" value="shanghai"></el-option>
                                <el-option label="区域二" value="beijing"></el-option>
                            </el-select>
                        </el-form-item>
                    </el-form>
                    <span slot="footer" class="dialog-footer">
                        <el-button @click="dialogVisible = false">取 消</el-button>
                        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
                    </span>
                </el-dialog>
                <br>
                <br>
            </div>
        </section>
    </div>
</template>

<script>
import { uploadFile, pageNation,deletNum } from '@/api/blog'
export default {
    name: 'blog',
    data() {
        return {

            dialogVisible: false,
            form: {
                name: '',
            },
            fileList: [],
            // 分页数据
            pageNations:{
                start: 1,
                size: 5,
                status: '0',
                delFlag: '0',
            },
            //分页数据
            lists: [],
            //删除数据
            // deleteData: {
            //     id: -1
            // }
            
            
            


        }
    },
    methods: {
        //返回按钮
        goBack() {
            this.$router.push({ name: 'file' })
        },
        //修改内容
        handleClose(done) {
            this.$confirm('确认关闭？')
                .then(_ => {
                    done();
                })
                .catch(_ => { });
        },
        //覆盖默认文件上传
        newUpload() {
            // new FormData对象
            const formData = new FormData();
            // console.log(this.fileList[0].raw);
            //单个文件上传
            formData.append("file", this.fileList[0].raw)
            //接口的对接
            uploadFile(formData).then(res => (console.log(res)))


        },
        //文件改变钩子
        upChange(file, fileList) {
            this.fileList = fileList
        },
        //删除按钮
        reference(id) {
            // this.deleteData.id = id
            // console.log(thi.deleteData.id);
            // deletNum().then(res=>{
            //     console.log(res);
            // })
        },
    },
    created(){
        //分页查询的接口
            pageNation(this.pageNations).then(res => {
                if(res.data.code == '0x200'){
                    this.lists = res.data.data.list;
                    
                    // console.log(lists);
                }
        }
         
    )
    },
    mounted(){
        
    }
}

</script>