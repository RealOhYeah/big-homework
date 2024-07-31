package com.gsxy.filesystemserver.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * (Teacher)实体类
 *
 * @author Oh...Yeah!!!
 * @since 2024-07-30 11:11:43
 */
public class Teacher implements Serializable {
    private static final long serialVersionUID = 278707923324597291L;
/**
     * 教师编号
     */
    private String tno;
/**
     * 姓名
     */
    private String tname;
/**
     * 性别
     */
    private String tsex;
/**
     * 生日
     */
    private Date tbirthday;
/**
     * 职称
     */
    private String prof;
/**
     * 部门
     */
    private String depart;

    public Teacher() {
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public Date getTbirthday() {
        return tbirthday;
    }

    public void setTbirthday(Date tbirthday) {
        this.tbirthday = tbirthday;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                ", tsex='" + tsex + '\'' +
                ", tbirthday=" + tbirthday +
                ", prof='" + prof + '\'' +
                ", depart='" + depart + '\'' +
                '}';
    }
}

