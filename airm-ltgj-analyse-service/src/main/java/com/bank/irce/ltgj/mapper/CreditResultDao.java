package com.bank.irce.ltgj.mapper;

import com.bank.irce.ltgj.entity.CreditResult;
import com.bank.irce.ltgj.entity.CreditResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreditResultDao {
    long countByExample(CreditResultExample example);

    int deleteByExample(CreditResultExample example);

    int insert(CreditResult record);

    int insertSelective(CreditResult record);

    List<CreditResult> selectByExample(CreditResultExample example);

    int updateByExampleSelective(@Param("record") CreditResult record, @Param("example") CreditResultExample example);

    int updateByExample(@Param("record") CreditResult record, @Param("example") CreditResultExample example);
}