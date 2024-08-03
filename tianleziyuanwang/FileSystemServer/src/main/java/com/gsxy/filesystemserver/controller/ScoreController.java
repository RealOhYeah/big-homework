package com.gsxy.filesystemserver.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.filesystemserver.domain.Score;
import com.gsxy.filesystemserver.domain.bo.CarouselQueryBo;
import com.gsxy.filesystemserver.domain.bo.ImportStudentScore;
import com.gsxy.filesystemserver.service.ScoreService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.FileOutputStream;

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
     * 学生成绩录入
     * @param importStudentScore
     * @return
     */
    @PostMapping
    public String scoreInput(ImportStudentScore importStudentScore) {


     return null;
    }

    /**
     * 查询所有科目
     * @return
     */
    @GetMapping("/course")
    public String queryAllCourse() {
        return JSONArray.toJSONString(scoreService.queryAllCourse());
    }


    /**
     * 查询所有数据
     * @return
     */
    @PostMapping(value = "/queryAll")
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
    @GetMapping
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
    @PostMapping
    public ResponseEntity<Score> add(Score score) {
        return ResponseEntity.ok(this.scoreService.insert(score));
    }

    /**
     * 编辑数据
     *
     * @param score 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Score> edit(Score score) {
        return ResponseEntity.ok(this.scoreService.update(score));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.scoreService.deleteById(id));
    }

}

