package generate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * T_SE_PAYMENTS_HF
 * @author 
 */
@Data
public class TSePaymentsHf implements Serializable {
    /**
     * URID
     */
    private String urid;

    /**
     * 组织
     */
    private String orgid;

    /**
     * 付款单号
     */
    private String notecode;

    /**
     * 申请组织
     */
    private String applyorgid;

    /**
     * 部门
     */
    private String deptid;

    /**
     * 付款日期
     */
    private Date paydate;

    /**
     * 交易类型
     */
    private String paytypeid;

    /**
     * 结算方式
     */
    private String settlementmodeid;

    /**
     * 支付类型：1-直联2-现金3-支票4-承兑汇票5-结算中心99-其它
     */
    private String dealtype;

    /**
     * 直联收付方式：1-普通支付2-批量代付4-批量代扣5-实时单笔扣款6-实时付款7-零余额扣款8-短信验证码扣款9-POS机扣款A-短信回复扣款B-语音扣款
     */
    private String directpayway;

    /**
     * 直联线路代码
     */
    private String directchannelcode;

    /**
     * 直联线路指令代码
     */
    private String directchannelcmdcode;

    /**
     * 直联跨行支付系统代码
     */
    private String directinterbankcode;

    /**
     * 摘要
     */
    private String abstracts;

    /**
     * 备注
     */
    private String memo;

    /**
     * 付方组织
     */
    private String ourorgid;

    /**
     * 付方银行
     */
    private String ourbankid;

    /**
     * 付方开户银行
     */
    private String ourbanklocations;

    /**
     * 付方银行账户
     */
    private String ourbankaccountid;

    /**
     * 付方账号
     */
    private String ourbankaccountnumber;

    /**
     * 付方户名
     */
    private String ourbankaccountname;

    /**
     * 付方银行区域
     */
    private String ourbankareaid;

    /**
     * 付方银行区域代码
     */
    private String ourbankareacode;

    /**
     * 付方银行区域名称
     */
    private String ourbankareaname;

    /**
     * 付方国别代码
     */
    private String ourcountrycode;

    /**
     * 付方币种
     */
    private String ourcurrencyid;

    /**
     * 付方直联币种代码
     */
    private String ourdirectcurcode;

    /**
     * 付方金额
     */
    private Double ouramount;

    /**
     * 付方汇率
     */
    private Double ourexchangerate;

    /**
     * 付方本币金额
     */
    private Double ourlocalcurrencyamount;

    /**
     * 收方对象类型1-内部组织2-交易对手
     */
    private String oppobjecttype;

    /**
     * 收方组织
     */
    private String opporgid;

    /**
     * 收方代码
     */
    private String oppcode;

    /**
     * 收方名称
     */
    private String oppname;

    /**
     * 收方交易对手类别
     */
    private String oppcounterpartycategoryid;

    /**
     * 收方交易对手
     */
    private String oppcounterpartyid;

    /**
     * 收方银行
     */
    private String oppbankid;

    /**
     * 收方开户银行
     */
    private String oppbanklocationid;

    /**
     * 收方开户银行
     */
    private String oppbanklocations;

    /**
     * 收方账户ID
     */
    private String oppbankaccountid;

    /**
     * 收方账号
     */
    private String oppbankaccountnumber;

    /**
     * 收方户名
     */
    private String oppbankaccountname;

    /**
     * 收方银行区域
     */
    private String oppbankareaid;

    /**
     * 收方银行区域代码
     */
    private String oppbankareacode;

    /**
     * 收方银行区域名称
     */
    private String oppbankareaname;

    /**
     * 收方国别代码
     */
    private String oppcountrycode;

    /**
     * 收方币种
     */
    private String oppcurrencyid;

    /**
     * 收方直联币种代码
     */
    private String oppdirectcurcode;

    /**
     * 收方金额
     */
    private Double oppamount;

    /**
     * 收方汇率
     */
    private Double oppexchangerate;

    /**
     * 收方本币金额
     */
    private Double opplocalcurrencyamount;

    /**
     * 收方手机号
     */
    private String oppcellphone;

    /**
     * 收方公私标识:1-对私,2-对公,
     */
    private String oppprivateflag;

    /**
     * 收方卡折类型:1-折,2-借记卡,3-贷记卡,4-准贷记卡
     */
    private String oppcardtype;

    /**
     * 收方证件类型:0-身份证,1-户口簿,2-护照,3-军官证,4-士兵证,5-港澳居民来往内地通行证,6-台湾同胞来往内地通行证,7-临时身份证,8-外国人居留证,9-警官证,99-其他证件
     */
    private String oppcerttype;

    /**
     * 收方证件号码
     */
    private String oppcertnumber;

    /**
     * 收方邮件地址
     */
    private String oppemailaddress;

    /**
     * 联行号
     */
    private String cnaps;

    /**
     * 同城标识:0-异地,1-同城
     */
    private String issameregion;

    /**
     * 同行标识:0-跨行,1-同行
     */
    private String issamebank;

    /**
     * 加急标识:0-不加急,1-加急
     */
    private String isurgent;

    /**
     * 用途
     */
    private String purpose;

    /**
     * 代收付用途
     */
    private String purposeid;

    /**
     * 直联渠道代收付用途
     */
    private String directchannelpurpose;

    /**
     * 附言(对账码)
     */
    private String checkcode;

    /**
     * 支付状态:1-未支付,2-已支付,3-支付失败,4-支付中,5-提交未知,6-退票,7-状态码未知
     */
    private String paystate;

    /**
     * 支付人
     */
    private String paypersonid;

    /**
     * 指令发送时间
     */
    private Date paysenddate;

    /**
     * 状态确认时间
     */
    private Date paymadedate;

    /**
     * 支付信息码
     */
    private String payinfocode;

    /**
     * 支付信息
     */
    private String payinfo;

    /**
     * 支付批号
     */
    private String payreqbatchno;

    /**
     * 支付批内顺序号（支付批内代表顺序的码：1.2.3...）
     */
    private String payreqbatchsequenceno;

    /**
     * 支付流水号（支付批内唯一）
     */
    private String payreqserialno;

    /**
     * 退票时间
     */
    private Date refunddate;

    /**
     * 作废状态:1-未作废,2-已作废
     */
    private String cancelstate;

    /**
     * 凭证号
     */
    private String finvouchercode;

    /**
     * 生成关联交易状态:1-未生成,2-已生成,3-生成失败,4-生成中
     */
    private String genrelatedtransstate;

    /**
     * 单据来源:1-清算产生,2-手工录入,3-文件导入,4-接口导入,5-收付款申请单,6-资金交易单
     */
    private String recordsource;

    /**
     * 单据来源ID
     */
    private String recordsourceid;

    /**
     * 来源对接系统
     */
    private String srcoutsystemid;

    /**
     * 来源批号
     */
    private String srcbatchno;

    /**
     * 来源流水号(来源批内唯一)
     */
    private String srcserialno;

    /**
     * 来源业务单据号
     */
    private String srcnotecode;

    /**
     * 拆分号
     */
    private String splitno;

    /**
     * 批次号
     */
    private String passelno;

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

    /**
     * 修改版本
     */
    private Short rowversion;

    /**
     * 描述
     */
    private String description;

    /**
     * 核对流水状态:0-未核对,1-已核对
     */
    private String ischeck;

    /**
     * 核对流水批号
     */
    private String checkbatchno;

    /**
     * 支付失败是否发送短信
     */
    private String ispayfailsendmsg;

    private Double splitedamount;

    /**
     * 拆分合并标识：0-未拆分合并,1-已部分拆分,2-已全部拆分,3-已合并
     */
    private String splitmergeflag;

    /**
     * 计划项目ID
     */
    private String budgetitemid;

    /**
     * 终止状态：1-未终止，2-已终止
     */
    private String terminatestate;

    /**
     * 已付金额
     */
    private Double ourpaidamount;

    /**
     * 手续费
     */
    private Double costs;

    /**
     * 汇款路径：1：境内人民币，2：境内外币，3：跨境外币，4：境外外币，5：购汇，6：结汇
     */
    private String remittancepath;

    /**
     * 合规:0-未检测,1-合规,2-不合规,3-检测中
     */
    private String compliancestate;

    /**
     * 不合规原因
     */
    private String complianceinfo;

    /**
     * 租户ID
     */
    private BigDecimal tenantid;

    /**
     * 来源系统地址
     */
    private String srcoutsystemurl;

    /**
     * 作废时间
     */
    private Date canceldate;

    /**
     * 银行交易流水号
     */
    private String bankserialnumber;

    /**
     * 资金类别
     */
    private String capitalcategoryid;

    /**
     * 现金流项目ID
     */
    private String cashflowitemid;

    private static final long serialVersionUID = 1L;
}