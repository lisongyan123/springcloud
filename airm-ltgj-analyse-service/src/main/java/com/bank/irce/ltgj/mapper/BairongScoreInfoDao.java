package com.bank.irce.ltgj.mapper;

import com.bank.irce.ltgj.entity.BairongScoreInfo;
import com.bank.irce.ltgj.entity.BairongScoreInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BairongScoreInfoDao {
    long countByExample(BairongScoreInfoExample example);

    int deleteByExample(BairongScoreInfoExample example);

    int insert(BairongScoreInfo record);

    int insertSelective(BairongScoreInfo record);

    List<BairongScoreInfo> selectByExampleWithBLOBs(BairongScoreInfoExample example);

    List<BairongScoreInfo> selectByExample(BairongScoreInfoExample example);

    int updateByExampleSelective(@Param("record") BairongScoreInfo record, @Param("example") BairongScoreInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") BairongScoreInfo record, @Param("example") BairongScoreInfoExample example);

    int updateByExample(@Param("record") BairongScoreInfo record, @Param("example") BairongScoreInfoExample example);
}