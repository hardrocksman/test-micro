package generate;

import generate.TSePaymentdetailHf;

public interface TSePaymentdetailHfDao {
    int deleteByPrimaryKey(String urid);

    int insert(TSePaymentdetailHf record);

    int insertSelective(TSePaymentdetailHf record);

    TSePaymentdetailHf selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(TSePaymentdetailHf record);

    int updateByPrimaryKey(TSePaymentdetailHf record);
}