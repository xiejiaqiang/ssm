package com.entity.po.file;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * t_file_info
 * @author 
 */
public class TFileInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 批次编号
     */
    @Column(name = "batchNo")
    private String batchNo;

    /**
     * 文件名称
     */
    @Column(name = "fileName")
    private String fileName;

    /**
     * 文件后缀
     */
    @Column(name = "fileSuffix")
    private String fileSuffix;

    /**
     * 保存文件名称
     */
    @Column(name = "savefileName")
    private String savefileName;

    /**
     * 所在路径
     */
    @Column(name = "filePath")
    private String filePath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public String getSavefileName() {
        return savefileName;
    }

    public void setSavefileName(String savefileName) {
        this.savefileName = savefileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private static final long serialVersionUID = 1L;
}