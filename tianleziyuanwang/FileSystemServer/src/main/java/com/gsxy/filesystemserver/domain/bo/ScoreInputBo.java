package com.gsxy.filesystemserver.domain.bo;

import java.io.Serializable;
import java.util.Date;

public class ScoreInputBo implements Serializable {

    /**
     * 学号
     */
    private String sno;
    /**
     * 姓名
     */
    private String sname;
    /**
     * 性别
     */
    private String ssex;
    /**
     * 班级
     */
    private String sclass;
    /**
     * 课程号
     */
    private String cno;
    /**
     * 成绩
     */
    private Double degree;


    public ScoreInputBo() {
    }

    public ScoreInputBo(String sno, String sname, String ssex, String sclass, String cno, Double degree) {
        this.sno = sno;
        this.sname = sname;
        this.ssex = ssex;
        this.sclass = sclass;
        this.cno = cno;
        this.degree = degree;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public Double getDegree() {
        return degree;
    }

    public void setDegree(Double degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "ScoreInputBo{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sclass='" + sclass + '\'' +
                ", cno='" + cno + '\'' +
                ", degree=" + degree +
                '}';
    }
}


