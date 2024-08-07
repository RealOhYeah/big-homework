package com.gsxy.filesystemserver.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.gsxy.filesystemserver.domain.bo.CarouselFileQueryBo;
import com.gsxy.filesystemserver.domain.bo.FindCarouselFileByCarouseIdBo;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;
import com.gsxy.filesystemserver.domain.CarouselFile;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * (CarouselFile)表服务接口
 *
 * @author makejava
 * @since 2024-03-13 11:06:04
 */
public interface CarouselFileService {

    /**
     * 查询当前轮播图通道文件
     * @param carouselId
     * @return
     */
    List<FindCarouselFileByCarouseIdBo> findByCarouselId(Long carouselId);

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
     * @param carouselFile 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */

//    Page<CarouselFile> queryByPage(CarouselFile carouselFile, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param carouselFile 实例对象
     * @return 实例对象
     */
    ResponseVo insert(CarouselFile carouselFile);

    /**
     * 修改数据
     *
     * @param carouselFile 实例对象
     * @return 实例对象
     */
    ResponseVo update(CarouselFile carouselFile);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    ResponseVo deleteById(Long id);

    /**
     * @author hln
     * 分页查询
     * @param carouselFiles
     * @return
     */
    ResponseVo queryByPage(CarouselFileQueryBo carouselFiles);

    /**
     *  @Auther Oh… Yeah!!! 2024-3-25
     * 查看图片
     * @param carouselId
     * @return byte[]
     */
    byte[] checkFile(Long carouselId) throws IOException;
}
