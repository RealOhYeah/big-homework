package com.gsxy.filesystemserver.domain.bo;

/**
 * 文件修改bo类
 */
public class FileUpdateBo {

    /**
     * 文件id
     */
    private Long id;

    /**
     * 生成的文件名
     */
    private String fileName;

    /**
     * 修改后文件名
     */
    private String updateFileName;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 下载文件路径
     */
    private String downloadPath;

    /**
     * 修改人
     */
    private Long createBy;

    /**
     * 状态
     */
    private Integer status;

    public FileUpdateBo() {}

    public FileUpdateBo(Long id, String fileName, String updateFileName, String fileType, String downloadPath, Long createBy, Integer status) {
        this.id = id;
        this.fileName = fileName;
        this.updateFileName = updateFileName;
        this.fileType = fileType;
        this.downloadPath = downloadPath;
        this.createBy = createBy;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUpdateFileName() {
        return updateFileName;
    }

    public void setUpdateFileName(String updateFileName) {
        this.updateFileName = updateFileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FileUpdateBo{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", updateFileName='" + updateFileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", downloadPath='" + downloadPath + '\'' +
                ", createBy=" + createBy +
                ", status=" + status +
                '}';
    }
}
