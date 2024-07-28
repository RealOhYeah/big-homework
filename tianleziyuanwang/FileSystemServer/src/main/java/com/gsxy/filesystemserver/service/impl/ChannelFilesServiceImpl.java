package com.gsxy.filesystemserver.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.filesystemserver.domain.CarouselFile;
import com.gsxy.filesystemserver.domain.ChannelFiles;
import com.gsxy.filesystemserver.domain.DeleteLog;
import com.gsxy.filesystemserver.domain.FileUploads;
import com.gsxy.filesystemserver.domain.bo.ChannelFileQueryBo;
import com.gsxy.filesystemserver.domain.vo.CarouselFileQueryVo;
import com.gsxy.filesystemserver.domain.vo.ChannelFilesQueryVo;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;
import com.gsxy.filesystemserver.mapper.ChannelFilesDao;
import com.gsxy.filesystemserver.service.ChannelFilesService;
import com.gsxy.filesystemserver.utils.ThreadLocalUtil;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (ChannelFiles)表服务实现类
 *
 * @author makejava
 * @since 2024-03-14 15:41:15
 */
@Service("channelFilesService")
public class ChannelFilesServiceImpl implements ChannelFilesService {
    @Resource
    private ChannelFilesDao channelFilesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ResponseVo queryById(Long id) {
        ChannelFiles channelFiles = channelFilesDao.queryById(id);
        return new ResponseVo("查询成功",channelFiles,"0x200");
    }

    /**
     * 新增数据
     *
     * @param channelFiles 实例对象
     * @return 实例对象
     */
    @Override
    public ResponseVo insert(ChannelFiles channelFiles) {

        int juge = channelFilesDao.insert(channelFiles);

        if(juge == 0) {
            return new ResponseVo("添加失败",null,"0x500");
        }

        return new ResponseVo("添加成功",juge,"0x200");
    }

    /**
     * 修改数据
     *
     * @param channelFiles 实例对象
     * @return 实例对象
     */
    @Override
    public ResponseVo update(ChannelFiles channelFiles) {

        int juge = channelFilesDao.update(channelFiles);

        if(juge == 0) {
            return new ResponseVo("添加失败",null,"0x500");
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
        int juge = channelFilesDao.deleteById(id);

        if(juge == 0) {
            return new ResponseVo("删除失败",null,"0x500");
        }

        //记录删除操作日志
        DeleteLog deleteLog = new DeleteLog();

        String userIdStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userInfo").get("id");
        Long userId = Long.valueOf(userIdStr);

        deleteLog.setDeleteBy(userId);
        deleteLog.setDeleteTime(new Date());
        deleteLog.setTableName("channel_files");

        channelFilesDao.insertIntoDelteLog(deleteLog);

        return new ResponseVo("删除成功",juge,"0x200");
    }

    /**
     * @author hln 2023-3-14
     * 分页查询
     * @param channelFiles
     * @return
     */
    @Override
    public ResponseVo queryByPage(ChannelFileQueryBo channelFiles) {

        String userIdStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userInfo").get("id");
        Long userId = Long.valueOf(userIdStr);

        if(userId == null || userId == 0L) {
            return new ResponseVo("token验证失败",null,"0x500");
        }

        int role = channelFilesDao.selectRole(userId);

        List<ChannelFiles> list = new ArrayList<>();

//        if (role == 5){
//            list = channelFilesDao.queryByPage(channelFiles.getStart(),channelFiles.getSize(),channelFiles.getChannelFiles());
//        } else {
//            list = channelFilesDao.queryByPageToRole(channelFiles.getStart(),channelFiles.getSize(),channelFiles.getChannelFiles());
//        }

        list = channelFilesDao.queryByPage(channelFiles.getStart(),channelFiles.getSize(),channelFiles.getChannelFiles());

        Long count = channelFilesDao.countCarousel(channelFiles.getChannelFiles());

        return new ResponseVo("查询成功",new ChannelFilesQueryVo(list,count),"0x200");
    }

    /**
     * @author hln 2023-3-26
     *  根据channelId获取file信息
     * @param channelID
     * @return
     */
    @Override
    public ResponseVo getFileInformation(Long channelID) {

        List<FileUploads> files = channelFilesDao.getFileInformation(channelID);

        return new ResponseVo("查询成功",files,"0x200");
    }
}
