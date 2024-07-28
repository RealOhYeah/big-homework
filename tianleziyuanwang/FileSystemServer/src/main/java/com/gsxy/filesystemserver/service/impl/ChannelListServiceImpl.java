package com.gsxy.filesystemserver.service.impl;

import com.gsxy.filesystemserver.domain.ChannelList;
import com.gsxy.filesystemserver.domain.bo.ChannelListPagingToGetDataBo;
import com.gsxy.filesystemserver.domain.bo.FindCarouselFileByCarouseIdBo;
import com.gsxy.filesystemserver.domain.vo.ChannelListPagingToGetDataVo;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;
import com.gsxy.filesystemserver.mapper.ChannelListMapper;
import com.gsxy.filesystemserver.service.CarouselFileService;
import com.gsxy.filesystemserver.service.ChannelListService;
import org.apache.poi.sl.draw.geom.Guide;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (ChannelList)表服务实现类
 *
 * @author Oh...Yeah!!!
 * @since 2024-04-17 15:02:40
 */
@Service("channelListService")
public class ChannelListServiceImpl implements ChannelListService {
    @Resource
    private ChannelListMapper channelListMapper;

    @Resource
    private CarouselFileService carouselFileService;

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    @Override
    public ResponseVo queryById(Long  id) {

        ChannelList channelList = channelListMapper.queryById(id);

        if (channelList == null){
            return new ResponseVo("查询失败，可能不存在此信息", null,"0x500");
        }

        return new ResponseVo("查询成功", channelList,"0x200");
    }

    /**
     * 分页查询
     *
     * @param channelListPagingToGetDataBo
     * @return
     */
    @Override
    public ResponseVo queryByPage(ChannelListPagingToGetDataBo channelListPagingToGetDataBo) {
        ChannelList channelList = channelListPagingToGetDataBo.getChannelList();
        if (channelList==null){
            channelList = new ChannelList();
        }
//        guide.setCreateBy(Long.valueOf(userId));

        List<ChannelList> fileList = channelListMapper.channelListPagingToGetData(channelListPagingToGetDataBo.getStart(),channelListPagingToGetDataBo.getSize(),channelListPagingToGetDataBo.getChannelList());
        Long count = channelListMapper.getCount(channelListPagingToGetDataBo.getChannelList());
//        System.out.println(count);

//        HashMap<String,Object> map = new HashMap<>();
//        map.put("count",count);
//        map.put("list",fileList);

        return new ResponseVo("查询成功",new ChannelListPagingToGetDataVo(fileList,Math.toIntExact(count)),"0x200");
    }

    /**
     * 新增数据
     *
     * @param channelList 实例对象
     * @return 实例对象
     */

    @Override
    public ResponseVo insert(ChannelList channelList) {
        int insert = channelListMapper.insert(channelList);

        if (insert == 0){
            return new ResponseVo("添加失败，可能已经存在此信息", null,"0x500");
        }

        return new ResponseVo("添加成功", null,"0x200");
    }

    /**
     * 修改数据
     *
     * @param
     * @return 实例对象
     */
    @Override
    public ResponseVo update(ChannelList channelList) {
        int update = channelListMapper.update(channelList);

        if (update == 0){
            return new ResponseVo("修改失败，可能不存在此信息", null,"0x500");
        }

        return new ResponseVo("修改成功", null,"0x200");
    }

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    @Override
    public ResponseVo deleteById(Long id) {

        int deleteById = channelListMapper.deleteById(id);

        if (deleteById == 0){
            return  new ResponseVo("删除失败，可能不存在此信息", null,"0x500");
        }

        return new ResponseVo("删除成功", null,"0x200");

    }

    /**
     * 通过show_id查询多条数据
     * @param showId
     * @return
     */
    @Override
    public ResponseVo queryByShowId(Long showId) {
        List<ChannelList> channelList = channelListMapper.queryByShowId(showId);
        List<FindCarouselFileByCarouseIdBo> res = new ArrayList<>();
        System.err.println(res);
        for (ChannelList list : channelList) {
            System.err.println("????");
            System.err.println(list);
            System.err.println(list.getChannelId());
            List<FindCarouselFileByCarouseIdBo> byCarouselId = carouselFileService.findByCarouselId(list.getChannelId());
            res.addAll(byCarouselId);
        }

        System.err.println(res);
        return new ResponseVo("查询成功", res,"0x200");
    }

}
