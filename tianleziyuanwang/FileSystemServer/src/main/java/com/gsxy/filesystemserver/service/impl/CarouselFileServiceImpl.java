package com.gsxy.filesystemserver.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.filesystemserver.domain.Carousel;
import com.gsxy.filesystemserver.domain.DeleteLog;
import com.gsxy.filesystemserver.domain.FileUploads;
import com.gsxy.filesystemserver.domain.bo.CarouselFileQueryBo;
import com.gsxy.filesystemserver.domain.bo.FindCarouselFileByCarouseIdBo;
import com.gsxy.filesystemserver.domain.vo.CarouselFileQueryVo;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;
import com.gsxy.filesystemserver.domain.CarouselFile;
import com.gsxy.filesystemserver.mapper.CarouselFileDao;
import com.gsxy.filesystemserver.service.CarouselFileService;
import com.gsxy.filesystemserver.utils.ThreadLocalUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (CarouselFile)表服务实现类
 *
 * @author makejava
 * @since 2024-03-13 11:06:04
 */
@Service("carouselFileService")
public class CarouselFileServiceImpl implements CarouselFileService {
    @Resource
    private CarouselFileDao carouselFileDao;

    @Value("${filePath}")
    private String filePath;

    /**
     * 查询当前轮播图通道文件
     * @param carouselId
     * @return
     */
    @Override
    public List<FindCarouselFileByCarouseIdBo> findByCarouselId(Long carouselId){
        return carouselFileDao.findByCarouselId(carouselId);
    }

    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ResponseVo queryById(Long id) {
        CarouselFile carouselFile = carouselFileDao.queryById(id);
        return new ResponseVo("查询成功",carouselFile,"0x200");
    }

    /**
     * 分页查询
     *
     * @param carouselFile 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @Override
//    public Page<CarouselFile> queryByPage(CarouselFile carouselFile, PageRequest pageRequest) {
//        long total = this.carouselFileDao.count(carouselFile);
//        return new PageImpl<>(this.carouselFileDao.queryAllByLimit(carouselFile, pageRequest), pageRequest, total);
//    }

    /**
     * 新增数据
     *
     * @param carouselFile 实例对象
     * @return 实例对象
     */
    @Override
    public ResponseVo insert(CarouselFile carouselFile) {
        System.err.println(carouselFile);
        String str = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userInfo").get("id");
        Long userId = Long.valueOf(str);
        carouselFile.setCreateBy(userId);
        carouselFile.setCreateTime(new Date());
        int juge = carouselFileDao.insert(carouselFile);

        if(juge == 0) {
            return new ResponseVo("添加失败",null,"0x500");
        }

        return new ResponseVo("添加成功",juge,"0x200");
    }

    /**
     * 修改数据
     *
     * @param carouselFile 实例对象
     * @return 实例对象
     */
    @Override
    public ResponseVo update(CarouselFile carouselFile) {

        //获取当前执行操作的用户id
        String userStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userInfo").get("id");
        carouselFile.setUpdateBy(Long.valueOf(userStr));
        carouselFile.setUpdateTime(new Date());

        int juge = carouselFileDao.update(carouselFile);

        if(juge == 0) {
            return new ResponseVo("修改失败",null,"0x500");
        }

        return new ResponseVo("修改成功",juge,"0x200");
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public ResponseVo deleteById(Long id) {
        int juge = carouselFileDao.deleteById(id);

        if (juge == 0) {
            return new ResponseVo("删除失败", null, "0x500");
        }

        //记录删除操作日志
        DeleteLog deleteLog = new DeleteLog();

        String userIdStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userInfo").get("id");
        Long userId = Long.valueOf(userIdStr);

        deleteLog.setDeleteBy(userId);
        deleteLog.setDeleteTime(new Date());
        deleteLog.setTableName("carousel_file");

        carouselFileDao.insertIntoDelteLog(deleteLog);

        return new ResponseVo("删除成功", juge, "0x200");
    }

    /**
     * @author hln 2024-3-14
     * 分页查询
     * @param carouselFiles
     * @return
     */
    @Override
    public ResponseVo queryByPage(CarouselFileQueryBo carouselFiles) {

        String userIdStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userInfo").get("id");
        Long userId = Long.valueOf(userIdStr);

        if(userId == null || userId == 0L) {
            return new ResponseVo("token验证失败",null,"0x500");
        }

        int role = carouselFileDao.selectRole(userId);

        List<CarouselFile> list = new ArrayList<>();

        if (role == 5){
            list = carouselFileDao.queryByPage(carouselFiles.getStart(),carouselFiles.getSize(),carouselFiles.getCarouselFile());
        } else {
            carouselFiles.getCarouselFile().setCreateBy(userId);
            list = carouselFileDao.queryByPageToRole(carouselFiles.getStart(),carouselFiles.getSize(),carouselFiles.getCarouselFile());
        }

        Long count = carouselFileDao.countCarousel(carouselFiles.getCarouselFile());

        return new ResponseVo("查询成功",new CarouselFileQueryVo(list,count),"0x200");
    }

    /**
     *  @Auther Oh… Yeah!!! 2024-3-25
     * 查看图片
     * @param carouselId
     * @return byte[]
     */
    @Override
    public byte[] checkFile(Long carouselId) throws IOException {

        String downloadPath = carouselFileDao.checkFile(carouselId).getDownloadPath();

        FileInputStream inputStream = new FileInputStream(filePath+downloadPath);

        byte[] bytes = new byte[inputStream.available()];

        inputStream.read(bytes, 0, inputStream.available());

        return bytes;

    }

}
