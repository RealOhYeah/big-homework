package com.gsxy.filesystemserver.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.filesystemserver.domain.ChannelList;
import com.gsxy.filesystemserver.domain.bo.ChannelListPagingToGetDataBo;
import com.gsxy.filesystemserver.service.ChannelListService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

/**
 * (ChannelList)表控制层
 *
 * @author Oh...Yeah!!!
 * @since 2024-04-17 15:02:40
 */
@RestController
@RequestMapping(value = "channelList", produces = "text/plain;charset=UTF-8")
public class ChannelListController {
    /**
     * 服务对象
     */
    @Resource
    private ChannelListService channelListService;



    /**
     * 通过show_id查询多条数据
     * @param showId
     * @return
     */
    @GetMapping("/queryByShowId")
    public String queryByShowId(@RequestParam("showId") Long  showId) {
        return JSONArray.toJSONString(channelListService.queryByShowId(showId));
    }


    /**
     * 分页查询
     *
     * @param
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
    public String queryByPage(@RequestBody ChannelListPagingToGetDataBo channelListPagingToGetDataBo) {

        return JSONArray.toJSONString(channelListService.queryByPage(channelListPagingToGetDataBo));
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public String queryById(@PathVariable("id") Long  id) {
        return JSONArray.toJSONString(channelListService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param channelList 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public String add(@RequestBody ChannelList channelList) {
        return JSONArray.toJSONString(channelListService.insert(channelList));
    }


    /**
     * 编辑数据
     *
     * @param channelList 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public String edit(@RequestBody ChannelList channelList) {
        return JSONArray.toJSONString(channelListService.update(channelList));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/deleteById")
    public String deleteById(@RequestParam("id") Long id) {
        return JSONArray.toJSONString(channelListService.deleteById(id));
    }

}

