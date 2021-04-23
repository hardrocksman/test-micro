package com.test.micro.sharding.service.impl;

import com.test.micro.sharding.dao.MerchantDao;
import com.test.micro.sharding.dao.PaymentDao;
import com.test.micro.sharding.dao.PaymentdetailDao;
import com.test.micro.sharding.entity.Merchant;
import com.test.micro.sharding.entity.Payment;
import com.test.micro.sharding.entity.Paymentdetail;
import com.test.micro.sharding.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
//import org.apache.shardingsphere.shardingjdbc.jdbc.core.datasource.ShardingDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class PaymentsServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;
    @Autowired
    PaymentdetailDao paymentdetailDao;
    @Autowired
    MerchantDao merchantDao;
    @Autowired
    DataSource dataSource;

    @Override
    public void insertMerchant(String urid) {
        Merchant merchant = new Merchant();
        merchant.setUrid(urid);
        merchant.setTenantid(new BigDecimal("10001"));
        merchant.setTenantcode("Ats");
        merchant.setMerchantno("1234567890");
        merchant.setCreatedon(new Date());
        merchant.setCreatedby("TEST");
        merchant.setLastmodifiedon(new Date());
        merchant.setLastmodifiedby("TEST");
        merchant.setRowversion((short) 1);
        merchant.setDescription("TEST-ABC");
        merchant.setIsactive("1");
        merchant.setMerchantname("TEST-ABC");
        merchant.setMerchantsecret("122322");

        merchantDao.insert(merchant);
    }

    @Override
    public void insertPayment(String urid) {
        Payment payment = new Payment();
        payment.setUrid(urid);
        payment.setOrgid("2222");
        payment.setNotecode(UUID.randomUUID().toString());
        payment.setApplyorgid("2222");
        payment.setOurorgid("2222");
        payment.setOuramount(23132.0);
        payment.setOurexchangerate(1.0);
        payment.setOurlocalcurrencyamount(222.0);
        payment.setOppobjecttype("2");
        payment.setOppamount(23132.0);
        payment.setOppexchangerate(1.0);
        payment.setOpplocalcurrencyamount(222.0);
        payment.setOppobjecttype("2");
        payment.setIssamebank("1");
        payment.setIssameregion("1");
        payment.setIsurgent("2");
        payment.setPaystate("1");
        payment.setCancelstate("1");
        payment.setGenrelatedtransstate("1");
        payment.setRecordsource("4");
        payment.setCreatedby("TEST");
        payment.setCreatedon(new Date());

        payment.setLastmodifiedby("TEST");
        payment.setLastmodifiedon(new Date());
        payment.setRowversion((short) 1);
        payment.setIscheck("0");
        payment.setSplitedamount(0.0);
        payment.setSplitmergeflag("0");
        payment.setTenantid(new BigDecimal("10001"));
        payment.setTerminatestate("0");
        payment.setOurpaidamount(0.0);
        payment.setCosts(0.0);
        payment.setOppprivateflag("0");
        payment.setIspayfailsendmsg("0");
        payment.setSrcoutsystemid("1234567890");

        Paymentdetail paymentdetail = new Paymentdetail();
        paymentdetail.setPaymentid(urid);
        paymentdetail.setUrid(urid);
        paymentdetail.setAmount(2.2);
        paymentdetail.setCreatedby("TEST");
        paymentdetail.setCreatedon(new Date());
        paymentdetail.setRowversion((short) 1);
        paymentdetail.setLastmodifiedby("TEST");
        paymentdetail.setLastmodifiedon(new Date());
        paymentdetail.setTenantid(new BigDecimal("10001"));
        paymentdetail.setOrgid("2222");

        paymentDao.insert(payment);
        paymentdetailDao.insert(paymentdetail);
    }

    @Override
    public List<Payment> getPayment(List<String> urids) {
        return paymentDao.getPayments(urids);
    }

    @Override
    public List<Payment> getPaymentBetween(String uridStart, String uridEnd) {
        return paymentDao.getPaymentsBetween(uridStart, uridEnd);
    }

    @Override
    public Payment getPaymentWithMerchant(String urid) {
        return paymentDao.selectWithMerchant(urid);
    }

    @Override
    public Paymentdetail getDetail(String urid) {
        Paymentdetail record = new Paymentdetail();
        record.setUrid(urid);
        return paymentdetailDao.getPayDetail(record);
    }

    @Override
    public List<Payment> getPayments() {
        try {
//            String sql = "select * from (select '1' moneyway, splitmergeflag, checkcode, finvouchercode, abstracts, ouramount, ourbankaccountnumber, ischeck, orgid, oppbankaccountid, oppbankaccountname, oppbankaccountnumber, checkbatchno, urid, notecode, applyorgid, deptid, paydate, paytypeid, settlementmodeid, dealtype, directpayway, directchannelcode, directchannelcmdcode, directinterbankcode, memo, ourorgid, ourbankid, ourbanklocations, ourbankaccountid, ourbankaccountname, ourbankareaid, ourbankareacode, ourbankareaname, ourcountrycode, ourcurrencyid, ourdirectcurcode, ourexchangerate, ourlocalcurrencyamount, oppobjecttype, opporgid, oppcode, oppname, oppcounterpartycategoryid, oppcounterpartyid, oppbankid, oppbanklocationid, oppbanklocations, oppbankareaid, oppbankareacode, oppbankareaname, oppcountrycode, oppcurrencyid, oppdirectcurcode, oppamount, oppexchangerate, opplocalcurrencyamount, oppcellphone, oppprivateflag, oppcardtype, oppcerttype, oppcertnumber, oppemailaddress, cnaps, issameregion, issamebank, isurgent, purpose, purposeid, directchannelpurpose, paystate, paypersonid, paysenddate, paymadedate, payinfocode, payinfo, payreqbatchno, payreqbatchsequenceno, payreqserialno, refunddate, cancelstate, genrelatedtransstate, recordsource, recordsourceid, srcoutsystemid, srcbatchno, srcserialno, srcnotecode, splitno, passelno, bankserialnumber, createdby, createdon, lastmodifiedby, lastmodifiedon, rowversion, description, TERMINATESTATE, tenantid\n" +
//                    "from T_SE_PAYMENTS_HF\n" +
//                    "where URID<? " +
//                    "AND URID>=? " +
//                    "AND TENANTID=? " +
//                    "AND PAYMADEDATE>=STR_TO_DATE(?,'%Y-%m-%d') " +
//                    "AND PAYMADEDATE<=STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s') " +
//                    "AND OURBANKACCOUNTID=? " +
//                    "AND  1=1\n" +
//                    "and PAYSTATE in ('2', '3')\n" +
//                    "AND ischeck = '0'\n" +
//                    "AND CANCELSTATE = '1'\n" +
//                    "AND splitmergeflag = '0') t";


//            String sql = "SELECT V_.* FROM (select t.* , amount output " +
//                    "from T_BA_BANKDAYBOOKS_HF t  " +
//                    "WHERE t.TENANTID=10001 " +
//                    "AND t.ACCOUNTID='1b3653945db34bf0bb76d9c3a63332a4' " +
//                    "AND t.TRADEDATE>=STR_TO_DATE('2021-04-01','%Y-%m-%d') " +
//                    "AND t.TRADEDATE<=STR_TO_DATE('2021-04-30 23:59:59','%Y-%m-%d %H:%i:%s') " +
//                    "AND  ischeck='0' and t.MONEYWAY ='1') V_ limit 20 offset 0";

            String sql = "SELECT V_.* FROM (SELECT\n" +
                    "\tt.*,\n" +
                    "\tDAYB.URID BANKFLOWID,\n" +
                    "\tBT.BANKSERIALNUMBER BANKHISTORYID,\n" +
                    "\tnvl( pay.urid, rec.urid ) tranurid\n" +
                    "FROM\n" +
                    "\tT_BA_ELERECEIPTS_HF T\n" +
                    "\tLEFT JOIN T_BA_ELERECEIPTRELATIONS ER ON T.URID = ER.ELERECEIPTID\n" +
                    "\tLEFT JOIN T_BA_BANKDAYBOOKS DAYB ON ER.BANKDAYBOOKID = DAYB.URID\n" +
                    "\tLEFT JOIN T_BA_BANKTRANSACTIONS BT ON ER.BANKTRANSID = BT.URID\n" +
                    "\tLEFT JOIN T_SE_PAYMENTS pay ON pay.notecode = t.ordernumber \n" +
                    " WHERE (T.ORGID in(6000001)) AND T.TRANDATE>='2021-04-01' AND T.TRANDATE<='2021-04-22 23:59:59' ORDER BY T.TRANDATE DESC) V_ limit 20 offset 0";

//            String sql = "select  * from T_SE_PAYMENTS_HF where urid<=? and urid >= ?";

//            MySqlStatementParser parser = new MySqlStatementParser(sql);
//            com.alibaba.druid.sql.ast.SQLStatement statement = parser.parseStatement();
//            MySqlAlterTableStatement alter = (MySqlAlterTableStatement)statement;
//            SQLExprTableSource source = alter.getTableSource();
//            String tableName = source.toString();

//            SQLStatement tree = new SQLParserEngine("MySQL").parse(sql, true);


            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setFetchSize(1000);
//            pstmt.setString(1, "585296392986038271");
//            pstmt.setString(2, "574787144883634176");
//            pstmt.setInt(3, 10001);
//            pstmt.setString(4, "2021-04-01");
//            pstmt.setString(5, "2021-04-30 23:59:59");
//            pstmt.setString(6, "1b3653945db34bf0bb76d9c3a63332a4");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                log.info(rs.getString(1));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
