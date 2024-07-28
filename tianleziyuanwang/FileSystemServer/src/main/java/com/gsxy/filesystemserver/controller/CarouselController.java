package com.gsxy.filesystemserver.controller;

import cn.hutool.http.server.HttpServerResponse;
import com.alibaba.fastjson2.JSONArray;
import com.gsxy.filesystemserver.domain.bo.CarouselAddBo;
import com.gsxy.filesystemserver.domain.bo.CarouselQueryBo;
import com.gsxy.filesystemserver.domain.Carousel;
import com.gsxy.filesystemserver.service.CarouselService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 轮播图
 *
 * @author 杨易达
 * @since 2024-03-13 11:01:01
 */
@RestController
@RequestMapping(value = "carousel",produces = "text/plain;charset=UTF-8")
public class CarouselController {

    /**
     * 服务对象
     */
    @Resource
    private CarouselService carouselService;

    /**
     * @author hln 2023-3-13
     * 分页查询
     * @param carouselQueryBo
     * @return
     */
    @PostMapping(value = "/queryByPage")
    public String queryByPage(@RequestBody CarouselQueryBo carouselQueryBo) {
        return JSONArray.toJSONString(carouselService.queryByPage(carouselQueryBo));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping(value = "/queryById/{id}")
    public String queryById(@PathVariable("id") Long id) {
        return JSONArray.toJSONString(carouselService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param carousel 实体
     * @return 新增结果
     */
    @PostMapping(value = "/add")
    public String add(@RequestBody CarouselAddBo carousel) {
        return JSONArray.toJSONString(carouselService.insert(carousel));
    }

    /**
     * 编辑数据
     *
     * @param carousel 实体
     * @return 编辑结果
     */
    @PostMapping(value = "/edit")
    public String edit(@RequestBody Carousel carousel) {
        return JSONArray.toJSONString(carouselService.update(carousel));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping(value = "/deleteById/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return JSONArray.toJSONString(carouselService.deleteById(id));
    }

    /**
     * @author hln 2024-3-31
     * 批量删除
     */
    @PostMapping(value = "/deleteList")
    public String deleteList(@RequestBody List<Long> list){
        return JSONArray.toJSONString(carouselService.deleteList(list));
    }

}

