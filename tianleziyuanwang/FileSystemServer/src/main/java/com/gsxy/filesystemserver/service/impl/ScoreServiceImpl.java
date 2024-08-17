package com.gsxy.filesystemserver.service.impl;

import com.gsxy.filesystemserver.domain.Course;
import com.gsxy.filesystemserver.domain.Score;
import com.gsxy.filesystemserver.domain.ScoreAll;
import com.gsxy.filesystemserver.domain.Student;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;
import com.gsxy.filesystemserver.domain.vo.StudentRankingVo;
import com.gsxy.filesystemserver.mapper.ScoreDao;
import com.gsxy.filesystemserver.mapper.StudentDao;
import com.gsxy.filesystemserver.service.ScoreService;
import com.gsxy.filesystemserver.service.StudentService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private StudentDao studentDao;

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
     * 查看所有学生成绩排名(总分、平均分、个人信息)
     * @return
     */
    @Override
    public ResponseVo queryRanking() {

        HashMap<String, HashMap<String, Object>> stringHashMapHashMap = getStringHashMapHashMap();

        HashMap<String, Object> map = new HashMap<>();

        for (String s : stringHashMapHashMap.keySet()) {
            HashMap<String, Object> map1 = stringHashMapHashMap.get(s);
            Double sum = 0.0;
            for (Object dou :  map1.values()) {
                sum +=  ((Integer)dou).doubleValue();
            }
            map.put(s, sum);
        }

//        StudentRankingVo studentRankingVo = new StudentRankingVo();

        HashMap<String, HashMap<String, Object>> averageAndtota = new HashMap<>();

//        ArrayList<Student> list = studentDao.queryAllStudent();

        for (String s : map.keySet()) {
            HashMap<String, Object> map2 = new HashMap<>();
            Double d =  (Double) map.get(s);
            map2.put("总分", d);
            map2.put("平均分", d/stringHashMapHashMap.get(s).size());

            Student stu  = studentDao.queryByName(s);

            map2.put("性别", stu.getSsex());
            map2.put("学号", stu.getSno());
            map2.put("班级", stu.getSclass());

            averageAndtota.put(s, map2);
         }


        return new ResponseVo("success", averageAndtota, "200");
    }


    /**
     * 查看所有学生成绩
     * @return
     */
    @Override
    public ResponseVo queryAll() {

        HashMap<String, HashMap<String, Object>> map = getStringHashMapHashMap();

        System.out.println("???");
        System.out.println(map);


        return new ResponseVo("success", map, "200");
    }


    /**
     * 获取所有学生成绩
     * @return
     */
    private HashMap<String, HashMap<String, Object>> getStringHashMapHashMap() {
        ArrayList<ScoreAll> scoreAlls = scoreDao.queryAll();

        HashMap<String, HashMap<String,Object>> map = new HashMap<>();

        scoreAlls.forEach(scoreAll -> {
            HashMap<String, Object> map1 = new HashMap<>();
            if(map.containsKey(scoreAll.getSname())){
                map1 = map.get(scoreAll.getSname());
            }

            map1.put(scoreAll.getCname(), scoreAll.getDegree());
            map.put(scoreAll.getSname(), map1);
        });
        return map;
    }

}
