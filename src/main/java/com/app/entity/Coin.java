package com.app.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "coin")
public class Coin implements Serializable {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "code_name_zh", nullable = false)
    private String codeNameZh;

    @Column(name = "symbol", nullable = false)
    private String symbol;

    @Column(name = "rate_float", nullable = false)
    private BigDecimal rateFloat;

    @Column(name = "description")
    private String description;

    @UpdateTimestamp
    @Column(name = "update_time")
    private Date updateTime;

    @CreationTimestamp
    @Column(name = "create_time")
    private Date createTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeNameZh() {
        return codeNameZh;
    }

    public void setCodeNameZh(String codeNameZh) {
        this.codeNameZh = codeNameZh;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getRateFloat() {
        return rateFloat;
    }

    public void setRateFloat(BigDecimal rateFloat) {
        this.rateFloat = rateFloat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
