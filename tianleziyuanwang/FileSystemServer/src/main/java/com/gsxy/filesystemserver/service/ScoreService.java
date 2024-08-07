package com.gsxy.filesystemserver.service;

import com.gsxy.filesystemserver.domain.Score;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Score)表服务接口
 *
 * @author Oh...Yeah!!!
 * @since 2024-07-30 11:15:54
 */
public interface ScoreService {

    /**
     * 通过ID查询单条数据
     *
     * @param sno 主键
     * @return 实例对象
     */
    Score queryById(String sno);

    /**
     * 分页查询
     *
     * @param score       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Score> queryByPage(Score score, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    Score insert(Score score);

    /**
     * 修改数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    Score update(Score score);

    /**
     * 通过主键删除数据
     *
     * @param sno 主键
     * @return 是否成功
     */
    boolean deleteById(String sno);

    /**
     * 查看所有学生成绩
     * @return
     */
    ResponseVo queryAll();


    /**
     * 查看所有学生成绩排名
     * @return
     */
    ResponseVo queryRanking();
}
