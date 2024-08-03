package com.gsxy.filesystemserver.dao;

import com.gsxy.filesystemserver.domain.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Course)表数据库访问层
 *
 * @author Oh...Yeah!!!
 * @since 2024-08-03 15:30:14
 */
public interface CourseDao {

    /**
     * 通过ID查询单条数据
     *
     * @param cno 主键
     * @return 实例对象
     */
    Course queryById(String cno);

    /**
     * 查询指定行数据
     *
     * @param course   查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Course> queryAllByLimit(Course course, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param course 查询条件
     * @return 总行数
     */
    long count(Course course);

    /**
     * 新增数据
     *
     * @param course 实例对象
     * @return 影响行数
     */
    int insert(Course course);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Course> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Course> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Course> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Course> entities);

    /**
     * 修改数据
     *
     * @param course 实例对象
     * @return 影响行数
     */
    int update(Course course);

    /**
     * 通过主键删除数据
     *
     * @param cno 主键
     * @return 影响行数
     */
    int deleteById(String cno);

}

