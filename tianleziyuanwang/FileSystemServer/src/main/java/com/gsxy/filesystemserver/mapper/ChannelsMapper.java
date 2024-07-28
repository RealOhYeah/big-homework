package com.gsxy.filesystemserver.mapper;

import com.gsxy.filesystemserver.domain.Channels;
import com.gsxy.filesystemserver.domain.DeleteLog;
import com.gsxy.filesystemserver.domain.FileUploads;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 通道(Channels)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-13 08:38:02
 */
@Mapper
public interface ChannelsMapper {

    /**
     * 获取当前时间可用数据
     * @return
     */
    @Select("select name,id from channels where now() >= start_time and now() <= end_time")
    public List<Channels> currentTimeData();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Channels queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param channels 查询条件
     * @param size
     * @return 对象列表
     */
    List<Channels> queryAllByLimit(@Param("channels") Channels channels, @Param("size") Long size,
                                   @Param("start") Long start
                                   );

    /**
     * 统计总行数
     *
     * @param channels 查询条件
     * @return 总行数
     */
    long count(Channels channels);

    /**
     * 新增数据
     *
     * @param channels 实例对象
     * @return 影响行数
     */
    int insert(Channels channels);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Channels> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Channels> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Channels> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Channels> entities);

    /**
     * 修改数据
     *
     * @param channels 实例对象
     * @return 影响行数
     */
    int update(Channels channels);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 分页查询
     * @author hln 2024-3-16
     * @return 查询结果
     */
    List<Channels> queryByPage(@Param("start") Long start, @Param("size") Integer size, @Param("params")Channels channels);

    /**
     * @author hln 2024-3-16
     * 查询数据总条数
     * @param channels
     * @return
     */
    Long countCarousel(@Param("params")Channels channels);

    int selectRole(Long userId);

    List<Channels> queryByPageToRole(@Param("start") Long start, @Param("size") Integer size, @Param("params")Channels channels);

    /**
     * @auythor hln 2024-3-25
     *  根据channle_id查询file数据并返回
     * @param id
     * @return
     */
    FileUploads queryFileById(Long id);

    /**
     * @author hln 2024-3-25
     * 记录删除操作日志
     * @param deleteLog
     */
    void insertIntoDelteLog(DeleteLog deleteLog);
}

