package com.gsxy.filesystemserver.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.filesystemserver.domain.Teacher;
import com.gsxy.filesystemserver.service.TeacherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Teacher)表控制层
 *
 * @author Oh...Yeah!!!
 * @since 2024-08-03 15:30:15
 */
@RestController
@RequestMapping("teacher")
public class TeacherController {
    /**
     * 服务对象
     */
    @Resource
    private TeacherService teacherService;


    /**
     * 查询所有老师
     * @return
     */
    @GetMapping("/teacher")
    public String queryAllTeacher() {
        return JSONArray.toJSONString(teacherService.queryAllTeacher());
    }



    /**
     * 分页查询
     *
     * @param teacher     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Teacher>> queryByPage(Teacher teacher, PageRequest pageRequest) {
        return ResponseEntity.ok(this.teacherService.queryByPage(teacher, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Teacher> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.teacherService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param teacher 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Teacher> add(Teacher teacher) {
        return ResponseEntity.ok(this.teacherService.insert(teacher));
    }

    /**
     * 编辑数据
     *
     * @param teacher 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Teacher> edit(Teacher teacher) {
        return ResponseEntity.ok(this.teacherService.update(teacher));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.teacherService.deleteById(id));
    }

}

