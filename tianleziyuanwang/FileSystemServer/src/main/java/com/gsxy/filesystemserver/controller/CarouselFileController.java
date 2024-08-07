package com.gsxy.filesystemserver.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.filesystemserver.domain.bo.CarouselFileQueryBo;
import com.gsxy.filesystemserver.domain.CarouselFile;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;
import com.gsxy.filesystemserver.service.CarouselFileService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * 轮播图文件
 *
 * @author 杨易达
 * @since 2024-03-13 11:06:04
 */
@RestController
@RequestMapping(value = "carouselFile",produces = "text/plain;charset=UTF-8")
public class CarouselFileController {
    /**
     * 服务对象
     */
    @Resource
    private CarouselFileService carouselFileService;

    /**
     *  @Auther Oh… Yeah!!! 2024-3-25
     * 查看图片
     * @param carouselId
     * @return byte[]
     */
    @GetMapping(value = "/checkFile",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] checkFile(@RequestParam("carouselId") Long carouselId) throws IOException {

        return carouselFileService.checkFile(carouselId);
    }

    /**
     * findByCarouselId
     * @param carouselId
     * @return
     */
    @GetMapping("/findByCarouselId")
    public String findByCarouselId(@RequestParam("carouselId") Long carouselId){

        return JSONArray.toJSONString(new ResponseVo<>(  "",carouselFileService.findByCarouselId(carouselId),"0x200     "));
    }


    /**
     * @author hln 2023-3-13
     * 分页查询
     * @param carouselFiles
     * @return
     */
    @PostMapping(value = "/queryByPage")
    public String queryByPage(@RequestBody CarouselFileQueryBo carouselFiles) {
        return JSONArray.toJSONString(carouselFileService.queryByPage(carouselFiles));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping(value = "/queryById/{id}")
    public String queryById(@PathVariable("id") Long id) {
        return JSONArray.toJSONString(carouselFileService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param carouselFile 实体
     * @return 新增结果
     */
    @PostMapping(value = "/add")
    public String add(@RequestBody CarouselFile carouselFile) {
        return JSONArray.toJSONString(carouselFileService.insert(carouselFile));
    }

    /**
     * 编辑数据
     *
     * @param carouselFile 实体
     * @return 编辑结果
     */
    @PostMapping(value = "/edit")
    public String edit(@RequestBody CarouselFile carouselFile) {
        return JSONArray.toJSONString(carouselFileService.update(carouselFile));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping(value = "/deleteById/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return JSONArray.toJSONString(carouselFileService.deleteById(id));
    }

}

