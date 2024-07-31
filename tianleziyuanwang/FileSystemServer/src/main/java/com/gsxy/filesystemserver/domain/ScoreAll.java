package com.gsxy.filesystemserver.domain;

import java.io.Serializable;

public class ScoreAll implements Serializable {

    private String sname;
    private String cname;
    private Integer degree;

    public ScoreAll() {
    }

    public ScoreAll(String sname, String cname, Integer degree) {
        this.sname = sname;
        this.cname = cname;
        this.degree = degree;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "ScoreAll{" +
                "sname='" + sname + '\'' +
                ", cname='" + cname + '\'' +
                ", degree=" + degree +
                '}';
    }
}
