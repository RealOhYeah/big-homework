package com.gsxy.filesystemserver.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.filesystemserver.domain.Channels;
import com.gsxy.filesystemserver.domain.bo.ChannelsQueryBo;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;
import com.gsxy.filesystemserver.service.ChannelsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 通道(Channels)表控制层
 *
 * @author 杨易达
 * @since 2024-03-13 08:38:02
 * todo 查询还在生效的通道   韩来凝做
 */
@RestController
@RequestMapping(value = "/channels",produces = "text/plain;charset=UTF-8")
public class ChannelsController {
    /**
     * 服务对象
     */
    @Resource
    private ChannelsService channelsService;

    /**
     * @auythor hln 2024-3-25
     *  根据channle_id查询file数据并返回
     * @param id
     * @return
     */
    @GetMapping("/queryFileById/{id}")
    public String queryFileById(@PathVariable("id") Long id){
        return JSONArray.toJSONString(channelsService.queryFileById(id));
    }

    /**
     * 分页查询
     * @author hln 2024-3-16
     * @param channels 筛选条件
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
//    public String queryByPage(Channels channels, Long start, Long size) {
    public String queryByPage(@RequestBody ChannelsQueryBo channels) {
        return JSONArray.toJSONString(channelsService.queryByPage(channels));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById/{id}")
    public String queryById(@PathVariable("id") Long id) {
        return JSONArray.toJSONString(channelsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param channels 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public String add(@RequestBody Channels channels) {
        return JSONArray.toJSONString(channelsService.insert(channels));
    }

    /**
     * 编辑数据
     *
     * @param channels 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public String edit(@RequestBody Channels channels) {
        return JSONArray.toJSONString(channelsService.update(channels));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return JSONArray.toJSONString(channelsService.deleteById(id));
    }


    /**
     * 获取当前接口可用数据
     * @return
     */
    @GetMapping(value = "/currentTimeData")
    public String currentTimeData(){
        return JSONArray.toJSONString(channelsService.currentTimeData());
    }
}

