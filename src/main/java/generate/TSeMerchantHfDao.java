package generate;

import generate.TSeMerchantHf;

public interface TSeMerchantHfDao {
    int deleteByPrimaryKey(String urid);

    int insert(TSeMerchantHf record);

    int insertSelective(TSeMerchantHf record);

    TSeMerchantHf selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(TSeMerchantHf record);

    int updateByPrimaryKey(TSeMerchantHf record);
}