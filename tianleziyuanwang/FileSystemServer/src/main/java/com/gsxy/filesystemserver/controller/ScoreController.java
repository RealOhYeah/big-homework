package com.gsxy.filesystemserver.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.filesystemserver.domain.Score;
import com.gsxy.filesystemserver.domain.bo.ScoreInputBo;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;
import com.gsxy.filesystemserver.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * (Score)表控制层
 *
 * @author Oh...Yeah!!!
 * @since 2024-07-30 11:15:54
 */
@RestController
@RequestMapping("score")
public class ScoreController {
    /**
     * 服务对象
     */
    @Autowired
    private ScoreService scoreService;


    /**
     * 查看所有学生成绩排名(总分、平均分、个人信息)
     * @return
     */
    @PostMapping(value = "/queryRanking" ,produces = "text/plain;charset=UTF-8")
    public String queryRanking() {
        return JSONArray.toJSONString(scoreService.queryRanking());
    }



    /**
     * 学生成绩录入
     * @param scoreInputBo
     * @return
     */
    @PostMapping("scoreInput")
    public String scoreInput(@RequestBody ScoreInputBo scoreInputBo) {

        scoreService.scoreInput(scoreInputBo);

        return JSONArray.toJSONString(new ResponseVo("success", null, "0x200"));
    }



    /**
     * 查看所有学生成绩
     * @return
     */
    @PostMapping( "/queryAll")
    public String queryAll() {
        return JSONArray.toJSONString(scoreService.queryAll());
    }


    /**
     * 分页查询
     *
     * @param score       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("queryByPage")
    public ResponseEntity<Page<Score>> queryByPage(Score score, PageRequest pageRequest) {
        return ResponseEntity.ok(this.scoreService.queryByPage(score, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Score> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.scoreService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param score 实体
     * @return 新增结果
     */
    @PostMapping("add")
    public ResponseEntity<Score> add(Score score) {
        return ResponseEntity.ok(this.scoreService.insert(score));
    }

    /**
     * 编辑数据
     *
     * @param score 实体
     * @return 编辑结果
     */
    @PutMapping("edit")
    public ResponseEntity<Score> edit(Score score) {
        return ResponseEntity.ok(this.scoreService.update(score));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.scoreService.deleteById(id));
    }

}

