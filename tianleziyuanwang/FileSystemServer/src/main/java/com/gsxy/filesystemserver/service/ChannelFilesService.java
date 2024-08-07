package com.gsxy.filesystemserver.service;

import com.gsxy.filesystemserver.domain.ChannelFiles;
import com.gsxy.filesystemserver.domain.bo.ChannelFileQueryBo;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (ChannelFiles)表服务接口
 *
 * @author makejava
 * @since 2024-03-14 15:41:15
 */
public interface ChannelFilesService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ResponseVo queryById(Long id);


    /**
     * 新增数据
     *
     * @param channelFiles 实例对象
     * @return 实例对象
     */
    ResponseVo insert(ChannelFiles channelFiles);

    /**
     * 修改数据
     *
     * @param channelFiles 实例对象
     * @return 实例对象
     */
    ResponseVo update(ChannelFiles channelFiles);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    ResponseVo deleteById(Long id);

    /**
     * @author hln 2023-3-14
     * 分页查询
     * @param channelFiles
     * @return
     */
    ResponseVo queryByPage(ChannelFileQueryBo channelFiles);

    /**
     * @author hln 2023-3-26
     *  根据channelId获取file信息
     * @param channelID
     * @return
     */
    ResponseVo getFileInformation(Long channelID);
}
