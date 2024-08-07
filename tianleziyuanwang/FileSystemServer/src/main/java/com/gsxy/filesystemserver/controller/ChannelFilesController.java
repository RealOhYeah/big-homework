package com.gsxy.filesystemserver.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.filesystemserver.domain.ChannelFiles;
import com.gsxy.filesystemserver.domain.bo.CarouselFileQueryBo;
import com.gsxy.filesystemserver.domain.bo.ChannelFileQueryBo;
import com.gsxy.filesystemserver.service.ChannelFilesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 通道文件
 *
 * @author 杨易达
 * @since 2024-03-14 15:41:15
 */
@RestController
@RequestMapping(value = "/channelFiles",produces = "text/plain;charset=UTF-8")
public class ChannelFilesController {
    /**
     * 服务对象
     */
    @Resource
    private ChannelFilesService channelFilesService;

    /**
     * @author hln 2023-3-26
     *  根据channelId获取file信息
     * @param channelID
     * @return
     */
    @GetMapping(value = "/getFileInformation/{channelID}")
    public String getFileInformation(@PathVariable("channelID") Long channelID){
        return JSONArray.toJSONString(channelFilesService.getFileInformation(channelID));
    }

    /**
     * @author hln 2023-3-14
     * 分页查询
     * @param channelFiles
     * @return
     */
    @PostMapping(value = "/queryByPage")
    public String queryByPage(@RequestBody ChannelFileQueryBo channelFiles) {
        return JSONArray.toJSONString(channelFilesService.queryByPage(channelFiles));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping(value = "/queryById/{id}")
    public String queryById(@PathVariable("id") Long id) {
        return JSONArray.toJSONString(this.channelFilesService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param channelFiles 实体
     * @return 新增结果
     */
    @PostMapping(value = "/add")
    public String add(ChannelFiles channelFiles) {
        return JSONArray.toJSONString(this.channelFilesService.insert(channelFiles));
    }

    /**
     * 编辑数据
     *
     * @param channelFiles 实体
     * @return 编辑结果
     */
    @PostMapping(value = "/edit")
    public String edit(@RequestBody ChannelFiles channelFiles) {
        return JSONArray.toJSONString(this.channelFilesService.update(channelFiles));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping(value = "/deleteById/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return JSONArray.toJSONString(this.channelFilesService.deleteById(id));
    }

}

