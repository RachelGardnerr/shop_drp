package com.sk.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Purchase {
    private Integer id;

    private Integer productId;

    private String purchaseDate;

    private String proDate;

    private String expDate;

    private BigDecimal purchasePrice;

    private Integer count;

    private BigDecimal amount;

    private String receiptImg;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;

    private Category category;

    private Product product;

    private Supplier supplier;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate == null ? null : purchaseDate.trim();
    }

    public String getProDate() {
        return proDate;
    }

    public void setProDate(String proDate) {
        this.proDate = proDate == null ? null : proDate.trim();
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate == null ? null : expDate.trim();
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getReceiptImg() {
        return receiptImg;
    }

    public void setReceiptImg(String receiptImg) {
        this.receiptImg = receiptImg == null ? null : receiptImg.trim();
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