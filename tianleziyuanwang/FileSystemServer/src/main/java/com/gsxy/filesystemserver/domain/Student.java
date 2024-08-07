package com.gsxy.filesystemserver.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author Oh...Yeah!!!
 * @since 2024-07-30 11:11:43
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 535110288872584095L;
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
     * 生日
     */
    private Date sbirthday;
/**
     * 班级
     */
    private String sclass;

    public Student() {
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

    public Date getSbirthday() {
        return sbirthday;
    }

    public void setSbirthday(Date sbirthday) {
        this.sbirthday = sbirthday;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sbirthday=" + sbirthday +
                ", sclass='" + sclass + '\'' +
                '}';
    }
}

