package com.gsxy.filesystemserver.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gsxy.filesystemserver.domain.Teacher;
import org.springframework.data.domain.PageRequest;

/**
 * (Teacher)表服务接口
 *
 * @author Oh...Yeah!!!
 * @since 2024-08-03 15:30:15
 */
public interface TeacherService {

    /**
     * 通过ID查询单条数据
     *
     * @param tno 主键
     * @return 实例对象
     */
    Teacher queryById(String tno);

    /**
     * 分页查询
     *
     * @param teacher     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Teacher> queryByPage(Teacher teacher, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    Teacher insert(Teacher teacher);

    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    Teacher update(Teacher teacher);

    /**
     * 通过主键删除数据
     *
     * @param tno 主键
     * @return 是否成功
     */
    boolean deleteById(String tno);

}
