package com.gsxy.filesystemserver.domain;

import java.io.Serializable;

/**
 * (Course)实体类
 *
 * @author Oh...Yeah!!!
 * @since 2024-07-30 11:11:43
 */
public class Course implements Serializable {
    private static final long serialVersionUID = 400177797478316665L;
/**
     * 课程号
     */
    private String cno;
/**
     * 课程名
     */
    private String cname;
/**
     * 教师编号
     */
    private String tno;

    public Course() {
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", tno='" + tno + '\'' +
                '}';
    }
}

