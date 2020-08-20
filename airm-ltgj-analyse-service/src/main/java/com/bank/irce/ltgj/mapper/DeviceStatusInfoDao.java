package com.bank.irce.ltgj.mapper;

import com.bank.irce.ltgj.entity.DeviceStatusInfo;
import com.bank.irce.ltgj.entity.DeviceStatusInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceStatusInfoDao {
    long countByExample(DeviceStatusInfoExample example);

    int deleteByExample(DeviceStatusInfoExample example);

    int insert(DeviceStatusInfo record);

    int insertSelective(DeviceStatusInfo record);

    List<DeviceStatusInfo> selectByExample(DeviceStatusInfoExample example);

    int updateByExampleSelective(@Param("record") DeviceStatusInfo record, @Param("example") DeviceStatusInfoExample example);

    int updateByExample(@Param("record") DeviceStatusInfo record, @Param("example") DeviceStatusInfoExample example);
}