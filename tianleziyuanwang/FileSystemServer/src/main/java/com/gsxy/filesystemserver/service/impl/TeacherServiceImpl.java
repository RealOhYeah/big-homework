package com.gsxy.filesystemserver.service.impl;

import com.gsxy.filesystemserver.domain.Course;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;
import com.gsxy.filesystemserver.mapper.TeacherDao;
import com.gsxy.filesystemserver.domain.Teacher;
import com.gsxy.filesystemserver.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * (Teacher)表服务实现类
 *
 * @author Oh...Yeah!!!
 * @since 2024-08-03 15:30:15
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherDao teacherDao;

    /**
     * 通过ID查询单条数据
     *
     * @param tno 主键
     * @return 实例对象
     */
    @Override
    public Teacher queryById(String tno) {
        return this.teacherDao.queryById(tno);
    }

    /**
     * 分页查询
     *
     * @param teacher     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Teacher> queryByPage(Teacher teacher, PageRequest pageRequest) {
        long total = this.teacherDao.count(teacher);
        return new PageImpl<>(this.teacherDao.queryAllByLimit(teacher, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    @Override
    public Teacher insert(Teacher teacher) {
        this.teacherDao.insert(teacher);
        return teacher;
    }

    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    @Override
    public Teacher update(Teacher teacher) {
        this.teacherDao.update(teacher);
        return this.queryById(teacher.getTno());
    }

    /**
     * 通过主键删除数据
     *
     * @param tno 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String tno) {
        return this.teacherDao.deleteById(tno) > 0;
    }

    /**
     * 查询所有老师
     * @return
     */
    @Override
    public ResponseVo queryAllTeacher() {

        ArrayList<Teacher> teachers = teacherDao.queryAllTeacher();
        return new ResponseVo("success", teachers, "200");
    }
}
