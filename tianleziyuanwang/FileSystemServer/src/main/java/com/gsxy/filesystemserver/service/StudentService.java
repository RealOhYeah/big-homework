package com.gsxy.filesystemserver.service;

import com.gsxy.filesystemserver.domain.Student;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Student)表服务接口
 *
 * @author Oh...Yeah!!!
 * @since 2024-08-03 15:30:15
 */
public interface StudentService {

    /**
     * 通过ID查询单条数据
     *
     * @param sno 主键
     * @return 实例对象
     */
    Student queryById(String sno);

    /**
     * 分页查询
     *
     * @param student     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Student> queryByPage(Student student, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student insert(Student student);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student update(Student student);

    /**
     * 通过主键删除数据
     *
     * @param sno 主键
     * @return 是否成功
     */
    boolean deleteById(String sno);

    /**
     * 查询所有学生
     * @return
     */
    ResponseVo queryAllStudent();

}
