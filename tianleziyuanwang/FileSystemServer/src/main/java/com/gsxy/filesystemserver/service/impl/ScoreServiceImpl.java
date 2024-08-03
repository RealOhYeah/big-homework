package com.gsxy.filesystemserver.service.impl;

import com.gsxy.filesystemserver.domain.Course;
import com.gsxy.filesystemserver.domain.Score;
import com.gsxy.filesystemserver.domain.ScoreAll;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;
import com.gsxy.filesystemserver.mapper.ScoreDao;
import com.gsxy.filesystemserver.service.ScoreService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * (Score)表服务实现类
 *
 * @author Oh...Yeah!!!
 * @since 2024-07-30 11:15:54
 */
@Service
public class ScoreServiceImpl implements ScoreService {
    @Resource
    private ScoreDao scoreDao;

    /**
     * 通过ID查询单条数据
     *
     * @param sno 主键
     * @return 实例对象
     */
    @Override
    public Score queryById(String sno) {
        return this.scoreDao.queryById(sno);
    }

    /**
     * 分页查询
     *
     * @param score       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Score> queryByPage(Score score, PageRequest pageRequest) {
        long total = this.scoreDao.count(score);
        return new PageImpl<>(this.scoreDao.queryAllByLimit(score, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    @Override
    public Score insert(Score score) {
        this.scoreDao.insert(score);
        return score;
    }

    /**
     * 修改数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    @Override
    public Score update(Score score) {
        this.scoreDao.update(score);
        return this.queryById(score.getSno());
    }

    /**
     * 通过主键删除数据
     *
     * @param sno 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String sno) {
        return this.scoreDao.deleteById(sno) > 0;
    }

    /**
     * 查询所有成绩
     * @return
     */
    @Override
    public ResponseVo queryAll() {

        ArrayList<ScoreAll> scoreAlls = scoreDao.queryAll();

        HashMap<String, HashMap<String,Integer>> map = new HashMap<>();

        scoreAlls.forEach(scoreAll -> {
            HashMap<String, Integer> map1 = new HashMap<>();
            if(map.containsKey(scoreAll.getSname())){
                map1 = map.get(scoreAll.getSname());
            }

            map1.put(scoreAll.getCname(), scoreAll.getDegree());
            map.put(scoreAll.getSname(), map1);
        });

        System.out.println("???");
        System.out.println(map);


        return new ResponseVo("success", map, "200");
    }

    /**
     * 查询所有科目
     * @return
     */
    @Override
    public ResponseVo queryAllCourse() {

        ArrayList<Course> courses = scoreDao.queryAllCourse();
        return new ResponseVo("success", courses, "200");
    }
}
