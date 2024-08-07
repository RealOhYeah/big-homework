package com.gsxy.filesystemserver.mapper;

import com.gsxy.filesystemserver.domain.ChannelList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.sl.draw.geom.Guide;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (ChannelList)表数据库访问层
 *
 * @author Oh...Yeah!!!
 * @since 2024-04-17 15:02:40
 */
@Mapper
public interface ChannelListMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    ChannelList queryById(Long  id);



    /**
     * 新增数据
     *
     * @param channelList 实例对象
     * @return 影响行数
     */
    int insert(ChannelList channelList);



    /**
     * 修改数据
     *
     * @param channelList 实例对象
     * @return 影响行数
     */
    int update(ChannelList channelList);

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 分页查询
     * @param start
     * @param size
     * @param channelList
     * @return
     */

    List<ChannelList> channelListPagingToGetData(Long start, Integer size, @Param("params") ChannelList channelList);

    /**
     * 查找总数
     * @param
     * @return
     */
    Long getCount(@Param("params") ChannelList channelList);

    /**
     * 通过show_id查询多条数据
     * @param showId
     * @return
     */
    List<ChannelList> queryByShowId(@Param("id") Long showId);
}

