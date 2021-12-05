package com.test.micro.sharding.dao;

import com.test.micro.sharding.entity.Merchant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MerchantDao {
    int deleteByPrimaryKey(String urid);

    int insert(Merchant record);

    int insertSelective(Merchant record);

    Merchant selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(Merchant record);

    int updateByPrimaryKey(Merchant record);

    int batchInsert(@Param("merchantList") List<Merchant> records);
}