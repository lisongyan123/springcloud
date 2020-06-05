package com.example.cloudservice.service;

import com.example.cloudservice.domain.AuthAccountLog;
import java.util.List;

public interface AccountLogService {

    List<AuthAccountLog> getAccountLogList();
}
