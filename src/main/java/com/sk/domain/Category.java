package com.sk.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Category {
    private Integer id;

    private String categoryName;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;

    private Product product;

    public Category() {
    }

    public Category(Integer id, String categoryName, Date createTime, Date updateTime, Boolean deleted) {
        this.id = id;
        this.categoryName = categoryName;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}