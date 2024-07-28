package com.gsxy.filesystemserver.service;

import com.gsxy.filesystemserver.domain.bo.CarouselAddBo;
import com.gsxy.filesystemserver.domain.bo.CarouselQueryBo;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;
import com.gsxy.filesystemserver.domain.Carousel;

import java.util.List;

/**
 * (Carousel)表服务接口
 *
 * @author makejava
 * @since 2024-03-13 11:01:01
 */
public interface CarouselService {

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
     * @param carousel 实例对象
     * @return 实例对象
     */
    ResponseVo insert(CarouselAddBo carousel);

    /**
     * 修改数据
     *
     * @param carousel 实例对象
     * @return 实例对象
     */
    ResponseVo update(Carousel carousel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    ResponseVo deleteById(Long id);

    /**
     * @param carouselQueryBo
     * @return
     * @author hln 2023-3-13
     * 分页查询
     */
    ResponseVo queryByPage(CarouselQueryBo carouselQueryBo);

    /**
     * @author hln 2024-3-31
     * 批量删除
     */
    ResponseVo deleteList(List<Long> list);
}
