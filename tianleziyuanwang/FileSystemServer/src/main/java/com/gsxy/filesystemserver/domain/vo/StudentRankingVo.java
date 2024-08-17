package com.gsxy.filesystemserver.domain.vo;

import com.gsxy.filesystemserver.domain.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentRankingVo implements Serializable {

    private String totalScore;
    private String averageScore;
    private String sName;
    private String sSex;
    private String sId;
    private String sClass;

    public StudentRankingVo() {
    }

    public StudentRankingVo(String totalScore, String averageScore, String sName, String sSex, String sId, String sClass) {
        this.totalScore = totalScore;
        this.averageScore = averageScore;
        this.sName = sName;
        this.sSex = sSex;
        this.sId = sId;
        this.sClass = sClass;
    }

    public String getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(String totalScore) {
        this.totalScore = totalScore;
    }

    public String getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(String averageScore) {
        this.averageScore = averageScore;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    @Override
    public String toString() {
        return "StudentRankingVo{" +
                "totalScore='" + totalScore + '\'' +
                ", averageScore='" + averageScore + '\'' +
                ", sName='" + sName + '\'' +
                ", sSex='" + sSex + '\'' +
                ", sId='" + sId + '\'' +
                ", sClass='" + sClass + '\'' +
                '}';
    }
}
