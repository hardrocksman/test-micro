package generate;

import generate.TSePaymentsHf;

public interface TSePaymentsHfDao {
    int deleteByPrimaryKey(String urid);

    int insert(TSePaymentsHf record);

    int insertSelective(TSePaymentsHf record);

    TSePaymentsHf selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(TSePaymentsHf record);

    int updateByPrimaryKey(TSePaymentsHf record);
}