package com.bank.irce.ltgj.mapper;

import com.bank.irce.ltgj.entity.AirmLtgjModelInvokeHistory;

public interface AirmLtgjModelInvokeHistoryDao {
    int insert(AirmLtgjModelInvokeHistory record);

    int insertSelective(AirmLtgjModelInvokeHistory record);
}