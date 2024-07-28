package com.gsxy.filesystemserver.service;

import com.gsxy.filesystemserver.domain.Channels;
import com.gsxy.filesystemserver.domain.bo.ChannelsQueryBo;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;

import java.util.List;

/**
 * 通道(Channels)表服务接口
 *
 * @author makejava
 * @since 2024-03-13 08:38:02
 */
public interface ChannelsService {
    /**
     * 获取当前时间可用数据
     * @return
     */
    ResponseVo currentTimeData();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ResponseVo queryById(Long id);

    /**
     * 分页查询
     *
     * @param channels 筛选条件
     * @param start      分页对象
     * @param size
     * @return 查询结果
     */
    ResponseVo queryByPage(Channels channels , Long start, Long size);

    /**
     * 新增数据
     *
     * @param channels 实例对象
     * @return 实例对象
     */
    ResponseVo insert(Channels channels);

    /**
     * 修改数据
     *
     * @param channels 实例对象
     * @return 实例对象
     */
    ResponseVo update(Channels channels);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    ResponseVo deleteById(Long id);

    /**
     * 分页查询
     * @author hln 2024-3-16
     * @param channels 筛选条件
     * @return 查询结果
     */
    ResponseVo queryByPage(ChannelsQueryBo channels);

    /**
     * @auythor hln 2024-3-25
     *  根据channle_id查询file数据并返回
     * @param id
     * @return
     */
    ResponseVo queryFileById(Long id);
}
