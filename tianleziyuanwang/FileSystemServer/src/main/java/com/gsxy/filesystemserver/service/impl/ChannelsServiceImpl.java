package com.gsxy.filesystemserver.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.filesystemserver.domain.ChannelFiles;
import com.gsxy.filesystemserver.domain.DeleteLog;
import com.gsxy.filesystemserver.domain.FileUploads;
import com.gsxy.filesystemserver.domain.bo.ChannelsQueryBo;
import com.gsxy.filesystemserver.domain.vo.ChannelFilesQueryVo;
import com.gsxy.filesystemserver.domain.vo.ChannelsQueryVo;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;
import com.gsxy.filesystemserver.domain.Channels;
import com.gsxy.filesystemserver.mapper.ChannelsMapper;
import com.gsxy.filesystemserver.service.ChannelsService;
import com.gsxy.filesystemserver.utils.ThreadLocalUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 通道(Channels)表服务实现类
 *
 * @author 杨易达
 * @since 2024-03-13 08:38:02
 */
@Service("channelsService")
public class ChannelsServiceImpl implements ChannelsService {
    @Resource
    private ChannelsMapper channelsDao;

    /**
     * 获取当前时间可用数据
     * @return
     */
    @Override
    public ResponseVo currentTimeData() {
        List<Channels> channels = channelsDao.currentTimeData();
        Channels channels1 =  new Channels();
        channels1.setId(-1L);
        channels1.setName("不选择");
        channels.add(channels1);
//        return new ResponseVo("查询成功", channels ,"0x200");
        return new ResponseVo("查询成功", channels ,"0x200");
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ResponseVo queryById(Long id) {
        Channels channels = channelsDao.queryById(id);
        return new ResponseVo("查询成功",channels,"0x200");
    }

    /**
     * 分页查询
     *
     * @param channels 筛选条件
     * @param start 分页对象
     * @param size 数量
     * @return 查询结果
     */
    @Override
    public ResponseVo queryByPage(Channels channels, Long start, Long size) {
        System.err.println();
        long total = this.channelsDao.count(channels);

        List<Channels> list = this.channelsDao.queryAllByLimit(channels, start, size);
        Map<String,Object> map = new HashMap<>();

        map.put("total",total);
        map.put("list",list);
        return new ResponseVo("修改成功",map,"0x200");
    }

    /**
     * 新增数据
     *
     * @param channels 实例对象
     * @return 实例对象
     */
    @Override
    public ResponseVo insert(Channels channels) {
        String userId = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userInfo").get("id");
        channels.setCreateBy(Long.valueOf(userId));
        channels.setCreateTime(new Date());
        this.channelsDao.insert(channels);
        return new ResponseVo("添加成功",null,"0x200");
    }

    /**
     * 修改数据
     *
     * @param channels 实例对象
     * @return 实例对象
     */
    @Override
    public ResponseVo update(Channels channels) {
        this.channelsDao.update(channels);
        return new ResponseVo("修改成功",this.queryById(channels.getId()),"0x200");
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public ResponseVo deleteById(Long id) {
        int i = channelsDao.deleteById(id);

        if(i == 0) {
            return new ResponseVo("删除失败",null,"0x500");
        }

        //记录删除操作日志
        DeleteLog deleteLog = new DeleteLog();

        String userIdStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userInfo").get("id");
        Long userId = Long.valueOf(userIdStr);

        deleteLog.setDeleteBy(userId);
        deleteLog.setDeleteTime(new Date());
        deleteLog.setTableName("channels");

        channelsDao.insertIntoDelteLog(deleteLog);

        return new ResponseVo("删除成功",i,"0x200");
    }

    /**
     * 分页查询
     * @author hln 2024-3-16
     * @param channels 筛选条件
     * @return 查询结果
     */
    @Override
    public ResponseVo queryByPage(ChannelsQueryBo channels) {

        String userIdStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userInfo").get("id");
        Long userId = Long.valueOf(userIdStr);

        if(userId == null || userId == 0L) {
            return new ResponseVo("token验证失败",null,"0x500");
        }

        int role = channelsDao.selectRole(userId);

        List<Channels> list = new ArrayList<>();

        if (role == 5){
            list = channelsDao.queryByPage(channels.getStart(),channels.getSize(),channels.getChannels());
        } else {
            channels.getChannels().setCreateBy(userId);
            list = channelsDao.queryByPageToRole(channels.getStart(),channels.getSize(),channels.getChannels());
        }

        Long count = channelsDao.countCarousel(channels.getChannels());

        return new ResponseVo("查询成功",new ChannelsQueryVo(list,count),"0x200");
    }

    /**
     * @auythor hln 2024-3-25
     *  根据channle_id查询file数据并返回
     * @param id
     * @return
     */
    @Override
    public ResponseVo queryFileById(Long id) {

        FileUploads file = channelsDao.queryFileById(id);

        return new ResponseVo("查询成功",file,"0x200");
    }
}
