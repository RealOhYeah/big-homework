package com.gsxy.filesystemserver.mapper;

import com.gsxy.filesystemserver.domain.DeleteLog;
import com.gsxy.filesystemserver.domain.bo.CarouselAddBo;
import com.gsxy.filesystemserver.domain.bo.CarouselQueryBo;
import com.gsxy.filesystemserver.domain.Carousel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Carousel)表数据库访问层
 *
 * @author 杨易达
 * @since 2024-03-13 11:01:01
 */
@Mapper
public interface CarouselDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Carousel queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param carousel 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Carousel> queryAllByLimit(Carousel carousel, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param carousel 查询条件
     * @return 总行数
     */
    long count(Carousel carousel);

    /**
     * 新增数据
     *
     * @param carousel 实例对象
     * @return 影响行数
     */
    int insert(CarouselAddBo carousel);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Carousel> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Carousel> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Carousel> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Carousel> entities);

    /**
     * 修改数据
     *
     * @param carousel 实例对象
     * @return 影响行数
     */
    void update(Carousel carousel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * @author hln 2023-3-13
     * 分页查询
     * @return
     */
    List<Carousel> queryByPage(@Param("start") Long start, @Param("size") Integer size, @Param("params")Carousel carousel);

    /**
     * @author hln 2023-3-13
     * 分页查询
     * @param carousel
     * @return
     */
    Long countCarousel(@Param("params") Carousel carousel);

    /**
     * 查询权限
     * @param userId
     * @return
     */
    int selectRole(Long userId);


    List<Carousel> queryByPageToRole(@Param("start") Long start, @Param("size") Integer size, @Param("params")Carousel carousel);

    /**
     * @author hln 2024-3-25
     * 记录删除操作日志
     * @param deleteLog
     */
    void insertIntoDelteLog(DeleteLog deleteLog);

}

