package com.entity.po.mdse;
import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * t_mdse_cat
 * @author 
 */
public class TMdseCat implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 商品分类编号
     */
    @Column(name = "mdseCatNo")
    private String mdseCatNo;

    /**
     * 商品分类名称
     */
    @Column(name = "mdseCatName")
    private String mdseCatName;

    /**
     * 父id
     */
    @Column(name = "parentId")
    private Long parentId;
    /**
     * 状态/OPEN/CLOSED
     */
    @Column(name = "state")
    private String state;

    /**
     * 创建时间
     */
    @Column(name = "creationTime")
    private Date creationTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMdseCatNo() {
        return mdseCatNo;
    }

    public void setMdseCatNo(String mdseCatNo) {
        this.mdseCatNo = mdseCatNo;
    }

    public String getMdseCatName() {
        return mdseCatName;
    }

    public void setMdseCatName(String mdseCatName) {
        this.mdseCatName = mdseCatName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    private static final long serialVersionUID = 1L;
}