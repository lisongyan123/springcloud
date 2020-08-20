package com.bank.irce.ltgj.mapper;

import com.bank.irce.ltgj.entity.OtherResult;
import com.bank.irce.ltgj.entity.OtherResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OtherResultDao {
    long countByExample(OtherResultExample example);

    int deleteByExample(OtherResultExample example);

    int insert(OtherResult record);

    int insertSelective(OtherResult record);

    List<OtherResult> selectByExample(OtherResultExample example);

    int updateByExampleSelective(@Param("record") OtherResult record, @Param("example") OtherResultExample example);

    int updateByExample(@Param("record") OtherResult record, @Param("example") OtherResultExample example);
}