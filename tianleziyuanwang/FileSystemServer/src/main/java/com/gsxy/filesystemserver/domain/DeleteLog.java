package com.gsxy.filesystemserver.domain;

import java.util.Date;

public class DeleteLog {

    private Long id;//ID

    private Long deleteBy;//执行删除操作人的id

    private Date deleteTime;//删除时间

    private String tableName;//执行的操作是删除哪个表数据

    private String fileName;//删除的文件名

    public DeleteLog(Long id, Long deleteBy, Date deleteTime, String tableName, String fileName) {
        this.id = id;
        this.deleteBy = deleteBy;
        this.deleteTime = deleteTime;
        this.tableName = tableName;
        this.fileName = fileName;
    }

    public DeleteLog() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeleteBy() {
        return deleteBy;
    }

    public void setDeleteBy(Long deleteBy) {
        this.deleteBy = deleteBy;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "DeleteLog{" +
                "id=" + id +
                ", deleteBy=" + deleteBy +
                ", deleteTime=" + deleteTime +
                ", tableName='" + tableName + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
