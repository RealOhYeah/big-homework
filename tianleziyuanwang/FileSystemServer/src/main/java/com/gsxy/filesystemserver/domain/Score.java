package com.gsxy.filesystemserver.domain;

import java.io.Serializable;

/**
 * (Score)实体类
 *
 * @author Oh...Yeah!!!
 * @since 2024-07-30 11:11:42
 */
public class Score implements Serializable {
    private static final long serialVersionUID = 387276371830374039L;
/**
     * 学号
     */
    private String sno;
/**
     * 课程号
     */
    private String cno;
/**
     * 成绩
     */
    private Double degree;

    public Score() {
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
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
        return "Score{" +
                "sno='" + sno + '\'' +
                ", cno='" + cno + '\'' +
                ", degree=" + degree +
                '}';
    }
}

