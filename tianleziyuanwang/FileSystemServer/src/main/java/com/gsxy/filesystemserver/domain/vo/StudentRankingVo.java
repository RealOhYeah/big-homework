package com.gsxy.filesystemserver.domain.vo;

import com.gsxy.filesystemserver.domain.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentRankingVo implements Serializable {


    private HashMap<String, HashMap<String, Double>> averageAndtota;

    ArrayList<Student> list;

    public StudentRankingVo() {
    }

    public StudentRankingVo(HashMap<String, HashMap<String, Double>> averageAndtota, ArrayList<Student> list) {
        this.averageAndtota = averageAndtota;
        this.list = list;
    }

    public HashMap<String, HashMap<String, Double>> getAverageAndtota() {
        return averageAndtota;
    }

    public void setAverageAndtota(HashMap<String, HashMap<String, Double>> averageAndtota) {
        this.averageAndtota = averageAndtota;
    }

    public ArrayList<Student> getList() {
        return list;
    }

    public void setList(ArrayList<Student> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "StudentRankingVo{" +
                "averageAndtota=" + averageAndtota +
                ", list=" + list +
                '}';
    }
}
