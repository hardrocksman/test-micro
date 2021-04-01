package com.test.micro.sharding.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * T_SE_MERCHANT_HF
 * @author 
 */
@Data
public class Merchant implements Serializable {
    /**
     * URID
     */
    private String urid;

    /**
     * 租户ID
     */
    private BigDecimal tenantid;

    /**
     * 租户编码
     */
    private String tenantcode;

    /**
     * 商户号
     */
    private String merchantno;

    /**
     * 商户名称
     */
    private String merchantname;

    /**
     * 商户私钥
     */
    private String merchantsecret;

    /**
     * 是否有效
     */
    private String isactive;

    /**
     * 修改版本
     */
    private Short rowversion;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建人
     */
    private String createdby;

    /**
     * 创建时间
     */
    private Date createdon;

    /**
     * 修改人
     */
    private String lastmodifiedby;

    /**
     * 修改时间
     */
    private Date lastmodifiedon;

    private static final long serialVersionUID = 1L;
}