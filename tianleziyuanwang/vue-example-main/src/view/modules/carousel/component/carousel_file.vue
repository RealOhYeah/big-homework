<template>
    <div>
        <section >
            <div class="container">
                <!-- 新增按钮 -->
                <el-row>
                    <el-col :span="5" style="margin-left:10px">
                        <el-button type="primary" @click="addCarouse">新增按钮</el-button>
                        <el-input  placeholder="请输入内容" @keyup.enter.native="loadTable(1)"></el-input>
                    </el-col>
                </el-row>
                <!-- 新增弹框 -->
                <el-dialog title="提示" :visible.sync="dialogVisible" width="40%">
                    <el-form ref="form" :model="form" label-width="80px">
                        <el-form-item label="创建时间:">
                            <el-input v-model="form.createTime"></el-input>
                        </el-form-item>
                        <el-form-item label="轮播图ID:">
                            <el-input v-model="form.carouselId"></el-input>
                        </el-form-item>
                        <el-form-item label="文件名ID:">
                            <el-input v-model="form.fileId"></el-input>
                        </el-form-item>
                        <el-form-item label="图片停留时间:">
                            <el-input v-model="form.seconds"></el-input>
                        </el-form-item>
                        <el-form-item label="排序ID:">
                            <el-input v-model="form.soft"></el-input>
                        </el-form-item>
                        <el-form-item label="创建人:">
                            <el-input v-model="form.createBy"></el-input>
                        </el-form-item>
                        <el-form-item label="状态:">
                            <el-input v-model="form.status"></el-input>
                        </el-form-item>
                    </el-form>
                    <span slot="footer" class="dialog-footer">
                        <el-button @click="dialogVisible = false">取 消</el-button>
                        <el-button type="primary" @click="updateForm">确 定</el-button>
                    </span>
                </el-dialog>
                <!-- 表格数据 -->
                <el-table :data="tableData" border style="width: 100%">
                    <el-table-column fixed prop="createTime" label="创建时间" width="180">
                    </el-table-column>
                    <el-table-column prop="carouselId" label="轮播图ID" width="150">
                    </el-table-column>
                    <el-table-column prop="fileId" label="文件名ID" width="150">
                    </el-table-column>
                    <el-table-column prop="seconds" label="图片停留时间" width="150">
                    </el-table-column>
                    <el-table-column prop="soft" label="排序ID" width="150">
                    </el-table-column>
                    <el-table-column prop="createBy" label="创建人" width="150">
                    </el-table-column>
                    <el-table-column prop="status" label="状态" width="150">
                    </el-table-column>
                    <el-table-column label="操作">
                        <template slot-scope="scope">
                            <el-button size="mini" type="success" @click="handleEdit(scope.row)">编辑</el-button>
                            <el-button size="mini" type="danger" @click="handleDelete(scope.row.id)">删除</el-button>
                        </template>
                    </el-table-column>
                </el-table>
                <br>
                <br>
                <!-- 分页查询 -->
                <el-pagination background layout="prev, pager, next" :total="1000"></el-pagination>
            </div>
        </section>
    </div>
</template>

<script>
import { carouselPaganation, carouselAdd, carouselDelet, carouselEdit } from '@/api/carousel_file'
export default {
    name:'carousel',
    data() {
        return {
            //分页查询
            pageNation:{
                start: 1,
                size: 5,
            },
            total:'',
            //分页数据
            tableData: [],
            //显示新增对话框
            dialogVisible: false,
            //新增表格对象
            form:{}
            
        }
    },
    created(){
        this.loadTable(1);
    },
    methods: {
        loadTable(num){
            //分页查询接口
            carouselPaganation(this.pageNation).then(res => {
                // console.log(res);
                if (res.data.code == '0x200') {
                    this.tableData = res.data.data.list;
                    // console.log(this.tableData);
                }
            })
        },
        //添加按钮
        addCarouse() {
            this.dialogVisible = true;
            this.form = {}
            
        },
        //添加按钮-确定按钮
        updateForm(){
            //ajax发送的是json字符串类型参数
            let data = JSON.stringify(this.form);
            //判断是新增按钮还是修改按钮，有id为修改。无为新增
            if(this.form.id){
                carouselEdit(data).then(res=>{
                    if (res.status == 200) {
                        //关闭对话框
                        this.dialogVisible = false;
                        //更新数据
                        this.loadTable(1);
                    }
                    // console.log(res);
                })
            }else{
                carouselAdd(data).then(res=>{
                    if(res.status == 200){
                        //关闭对话框
                        this.dialogVisible = false;
                        //更新数据
                        this.loadTable(1);
                    }
                   
                })
            }
        },
        //编辑按钮
        handleEdit(event) {
            this.form.id = event.id;
            this.dialogVisible = true;
        },
        //删除按钮
        handleDelete(event) {
            carouselDelet(event).then(res=>{
                // console.log(res);
            })
        },
        //
        
    }
    
}
</script>
<style>

</style>