package com.gsxy.filesystemserver.service;
import com.gsxy.filesystemserver.domain.Course;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Course)表服务接口
 *
 * @author Oh...Yeah!!!
 * @since 2024-08-03 15:30:14
 */
public interface CourseService {

    /**
     * 查询所有科目
     * @return
     */
    ResponseVo queryAllCourse();

    /**
     * 通过ID查询单条数据
     *
     * @param cno 主键
     * @return 实例对象
     */
    Course queryById(String cno);

    /**
     * 分页查询
     *
     * @param course      筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Course> queryByPage(Course course, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param course 实例对象
     * @return 实例对象
     */
    Course insert(Course course);

    /**
     * 修改数据
     *
     * @param course 实例对象
     * @return 实例对象
     */
    Course update(Course course);

    /**
     * 通过主键删除数据
     *
     * @param cno 主键
     * @return 是否成功
     */
    boolean deleteById(String cno);

}
