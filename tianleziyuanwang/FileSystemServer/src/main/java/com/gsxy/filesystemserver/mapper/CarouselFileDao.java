package com.gsxy.filesystemserver.mapper;

import com.gsxy.filesystemserver.domain.DeleteLog;
import com.gsxy.filesystemserver.domain.FileUploads;
import com.gsxy.filesystemserver.domain.CarouselFile;
import com.gsxy.filesystemserver.domain.bo.FindCarouselFileByCarouseIdBo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (CarouselFile)表数据库访问层
 *
 * @author 杨易达
 * @since 2024-03-13 11:06:04
 */
@Mapper
public interface CarouselFileDao {



    /**
     * 查询当前轮播图通道文件
     * @param carouselId
     * @return
     */
    @Select("select t1.font_color,t1.introduce_text,t1.seconds,t1.id,t1.soft,t2.original_file_name,t2.file_type,t2.download_path,t1.create_time from carousel_file t1 LEFT JOIN file_uploads t2 on t1.file_id = t2.id where t1.carousel_id = #{carouselId} order by t1.soft asc")
    List<FindCarouselFileByCarouseIdBo> findByCarouselId(@Param("carouselId") Long carouselId);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CarouselFile queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param carouselFile 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<CarouselFile> queryAllByLimit(CarouselFile carouselFile, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param carouselFile 查询条件
     * @return 总行数
     */
    long count(CarouselFile carouselFile);

    /**
     * 新增数据
     *
     * @param carouselFile 实例对象
     * @return 影响行数
     */
    int insert(CarouselFile carouselFile);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CarouselFile> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CarouselFile> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CarouselFile> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<CarouselFile> entities);

    /**
     * 修改数据
     *
     * @param carouselFile 实例对象
     * @return 影响行数
     */
    int update(CarouselFile carouselFile);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 分页查询
     * @return
     */
    List<CarouselFile> queryByPage(@Param("start") Long start, @Param("size") Integer size, @Param("params") CarouselFile carouselFile);

    /**
     * @author hln 2024-3-14
     * 分页查询
     * @return
     */
    Long countCarousel(@Param("params") CarouselFile carouselFile);

    int selectRole(Long userId);


    List<CarouselFile> queryByPageToRole(@Param("start") Long start, @Param("size") Integer size, @Param("params") CarouselFile carouselFile);

    /**
     * @author hln 2024-3-25
     * 记录删除操作日志
     * @param deleteLog
     */
    void insertIntoDelteLog(DeleteLog deleteLog);


    /**
     *  @Auther Oh… Yeah!!! 2024-3-25
     * 查看图片
     * @param carouselId
     * @return FileUploads
     */
    FileUploads checkFile(Long carouselId);
}

