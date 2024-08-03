package com.gsxy.filesystemserver.service.impl;

import com.gsxy.filesystemserver.dao.CourseDao;
import com.gsxy.filesystemserver.domain.Course;
import com.gsxy.filesystemserver.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Course)表服务实现类
 *
 * @author Oh...Yeah!!!
 * @since 2024-08-03 15:30:14
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseDao courseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param cno 主键
     * @return 实例对象
     */
    @Override
    public Course queryById(String cno) {
        return this.courseDao.queryById(cno);
    }

    /**
     * 分页查询
     *
     * @param course      筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Course> queryByPage(Course course, PageRequest pageRequest) {
        long total = this.courseDao.count(course);
        return new PageImpl<>(this.courseDao.queryAllByLimit(course, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param course 实例对象
     * @return 实例对象
     */
    @Override
    public Course insert(Course course) {
        this.courseDao.insert(course);
        return course;
    }

    /**
     * 修改数据
     *
     * @param course 实例对象
     * @return 实例对象
     */
    @Override
    public Course update(Course course) {
        this.courseDao.update(course);
        return this.queryById(course.getCno());
    }

    /**
     * 通过主键删除数据
     *
     * @param cno 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String cno) {
        return this.courseDao.deleteById(cno) > 0;
    }
}
