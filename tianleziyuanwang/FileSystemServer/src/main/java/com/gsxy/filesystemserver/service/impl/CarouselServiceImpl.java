package com.gsxy.filesystemserver.service.impl;

import com.gsxy.filesystemserver.domain.DeleteLog;
import com.gsxy.filesystemserver.domain.bo.CarouselAddBo;
import com.gsxy.filesystemserver.domain.bo.CarouselQueryBo;
import com.gsxy.filesystemserver.domain.vo.CarouselQueryVo;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;
import com.gsxy.filesystemserver.domain.Carousel;
import com.gsxy.filesystemserver.mapper.CarouselDao;
import com.gsxy.filesystemserver.service.CarouselService;
import com.gsxy.filesystemserver.utils.ThreadLocalUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (Carousel)表服务实现类
 *
 * @author makejava
 * @since 2024-03-13 11:01:01
 */
@Service("carouselService")
public class CarouselServiceImpl implements CarouselService {
    @Resource
    private CarouselDao carouselDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ResponseVo queryById(Long id) {
        Carousel carousel = carouselDao.queryById(id);
        return new ResponseVo("查询成功",carousel,"0x200");
    }



    /**
     * 新增数据
     *
     * @param carousel 实例对象
     * @return 实例对象
     */
    @Override
    public ResponseVo insert(CarouselAddBo carousel) {

//        String userIdStr = ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id").toString();
        String userIdStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userInfo").get("id");
        Long userId = Long.valueOf(userIdStr);
        carousel.setCreateBy(userId);
        carousel.setCreateTime(new Date());

        int juge = carouselDao.insert(carousel);

        if(juge == 0) {
            return new ResponseVo("添加失败",null,"0x500");
        }

        return new ResponseVo("添加成功",juge,"0x200");
    }

    /**
     * 修改数据
     *
     * @param carousel 实例对象
     * @return 实例对象
     */
    @Override
    public ResponseVo update(Carousel carousel) {

        String userIdStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userInfo").get("id");
        carousel.setUpdateBy(Long.valueOf(userIdStr));
        carousel.setUpdateTime(new Date());

        carouselDao.update(carousel);
        return new ResponseVo("修改成功",null,"0x200");
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public ResponseVo deleteById(Long id) {
        int juge = carouselDao.deleteById(id);

        if(juge == 0) {
            return new ResponseVo("删除失败",null,"0x500");
        }

        //记录删除操作日志
        DeleteLog deleteLog = new DeleteLog();

        String userIdStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userInfo").get("id");
        Long userId = Long.valueOf(userIdStr);

        deleteLog.setDeleteBy(userId);
        deleteLog.setDeleteTime(new Date());
        deleteLog.setTableName("carousel");

        carouselDao.insertIntoDelteLog(deleteLog);

        return new ResponseVo("删除成功",juge,"0x200");
    }

    /**
     * @param carouselQueryBo
     * @return
     * @author hln 2023-3-13
     * 分页查询
     */
    @Override
    public ResponseVo queryByPage(CarouselQueryBo carouselQueryBo) {

        String userIdStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userInfo").get("id");
        Long userId = Long.valueOf(userIdStr);

        if(userId == null || userId == 0L) {
            return new ResponseVo("token验证失败",null,"0x500");
        }

        int role = carouselDao.selectRole(userId);

        List<Carousel> list = new ArrayList<>();

        //先不考虑superman
        if (role == 5 && false){
            list = carouselDao.queryByPage(carouselQueryBo.getStart(),carouselQueryBo.getSize(),carouselQueryBo.getCarousel());
        } else {
            System.err.println("????"+userId);
            carouselQueryBo.getCarousel().setCreateBy(userId);
            System.err.println(carouselQueryBo.getCarousel());
            list = carouselDao.queryByPageToRole(carouselQueryBo.getStart(),carouselQueryBo.getSize(),carouselQueryBo.getCarousel());
        }

        Long count = carouselDao.countCarousel(carouselQueryBo.getCarousel());

        System.out.println(list);
        return new ResponseVo("查询成功",new CarouselQueryVo(list,count),"0x200");
    }

    /**
     * @author hln 2024-3-31
     * 批量删除
     */
    @Override
    public ResponseVo deleteList(List<Long> list) {

        list.stream().forEach(id -> carouselDao.deleteById(id));

        return new ResponseVo("删除成功",null,"0x200");
    }
}
