package com.gsxy.filesystemserver.mapper;

import com.gsxy.filesystemserver.domain.ChannelFiles;
import com.gsxy.filesystemserver.domain.DeleteLog;
import com.gsxy.filesystemserver.domain.FileUploads;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (ChannelFiles)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-14 15:41:15
 */
@Mapper
public interface ChannelFilesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ChannelFiles queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param channelFiles 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<ChannelFiles> queryAllByLimit(ChannelFiles channelFiles, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param channelFiles 查询条件
     * @return 总行数
     */
    long count(ChannelFiles channelFiles);

    /**
     * 新增数据
     *
     * @param channelFiles 实例对象
     * @return 影响行数
     */
    int insert(ChannelFiles channelFiles);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ChannelFiles> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ChannelFiles> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ChannelFiles> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ChannelFiles> entities);

    /**
     * 修改数据
     *
     * @param channelFiles 实例对象
     * @return 影响行数
     */
    int update(ChannelFiles channelFiles);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * @param channelFiles
     * @return
     * @author hln 2023-3-14
     * 分页查询
     */
    List<ChannelFiles> queryByPage(@Param("start") Long start, @Param("size") Integer size, @Param("params") ChannelFiles channelFiles);

    /**
     * @author hln 2023-3-14
     * 查询总数
     * @param channelFiles
     * @return
     */
    Long countCarousel(@Param("params") ChannelFiles channelFiles);

    int selectRole(Long userId);

    List<ChannelFiles> queryByPageToRole(@Param("start") Long start, @Param("size") Integer size, @Param("params") ChannelFiles channelFiles);

    /**
     * @author hln 2024-3-25
     * 记录删除操作日志
     * @param deleteLog
     */
    void insertIntoDelteLog(DeleteLog deleteLog);

    /**
     * @param channelID
     * @return
     * @author hln 2023-3-26
     * 根据channelId获取file信息
     */
    List<FileUploads> getFileInformation(Long channelID);
}

