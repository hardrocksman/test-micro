package generate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * T_SE_PAYMENTDETAIL_HF
 * @author 
 */
@Data
public class TSePaymentdetailHf implements Serializable {
    /**
     * URID
     */
    private String urid;

    /**
     * 付款交易单URID
     */
    private String paymentid;

    /**
     * 计划编制ID
     */
    private String budgetsid;

    /**
     * 金额
     */
    private Double amount;

    /**
     * 备注
     */
    private String memo;

    /**
     * 创建时间
     */
    private Date createdon;

    /**
     * 创建人
     */
    private String createdby;

    /**
     * 修改时间
     */
    private Date lastmodifiedon;

    /**
     * 修改人
     */
    private String lastmodifiedby;

    /**
     * 修改版本
     */
    private Short rowversion;

    /**
     * 描述
     */
    private String description;

    /**
     * 租户ID
     */
    private BigDecimal tenantid;

    /**
     * 组织
     */
    private String orgid;

    /**
     * 部门
     */
    private String deptid;

    /**
     * 工程项目
     */
    private String projectitemid;

    /**
     * 资金类别
     */
    private String capitalcategoryid;

    /**
     * 现金流量项目ID
     */
    private String cashflowitemid;

    /**
     * 合同号
     */
    private String contractcode;

    /**
     * 收方内部账户ID
     */
    private String oppinternalaccountid;

    /**
     * 付方内部账户ID
     */
    private String ourinternalaccountid;

    /**
     * 税额
     */
    private String taxamount;

    /**
     * 税率
     */
    private String taxrate;

    /**
     * 支出项目
     */
    private String extfield1;

    /**
     * 支出内容
     */
    private String extfield2;

    /**
     * 扩展字段3
     */
    private String extfield3;

    /**
     * 扩展字段4
     */
    private String extfield4;

    /**
     * 扩展字段5
     */
    private String extfield5;

    private static final long serialVersionUID = 1L;
}