package com.gsxy.filesystemserver.service;

import com.gsxy.filesystemserver.domain.ChannelList;
import com.gsxy.filesystemserver.domain.bo.ChannelListPagingToGetDataBo;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;

/**
 * (ChannelList)表服务接口
 *
 * @author Oh...Yeah!!!
 * @since 2024-04-17 15:02:40
 */
public interface ChannelListService {

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    ResponseVo  queryById(Long  id);

    /**
     * 分页查询
     *
     * @return 查询结果
     */
    ResponseVo queryByPage(ChannelListPagingToGetDataBo channelListPagingToGetDataBo);

    /**
     * 新增数据
     *
     * @param channelList 实例对象
     * @return 实例对象
     */
    ResponseVo insert(ChannelList channelList);

    /**
     * 修改数据
     *
     * @param
     * @return 实例对象
     */
    ResponseVo update(ChannelList channelList);

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    ResponseVo deleteById(Long id);


    /**
     * 通过show_id查询多条数据
     * @param showId
     * @return
     */
    ResponseVo queryByShowId(Long showId);
}
