package com.bank.irce.ltgj.mapper;

import com.bank.irce.ltgj.entity.dto.FxgdMasterAduitCredit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/7/14
 */
public interface FxgdMasterAduitCreditMapper extends BaseMapper<FxgdMasterAduitCredit> {

    FxgdMasterAduitCredit queryMasterAuditCreditByCreNo(@Param("idNo") String idNo);

}
