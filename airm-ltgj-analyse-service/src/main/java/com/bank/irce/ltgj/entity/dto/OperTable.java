package com.bank.irce.ltgj.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class OperTable implements Serializable {

    private List<EdmpAccessLog> edmpAccessLog = new ArrayList<>();

//    private List<ModelInvokeHistory> modelInvokeHistorie = new ArrayList<>();

    private FxgdMasterAduitCredit masterAuditCredit;

    private String sessionId;

    /**
     * 征信报文
     */
    private String context = "-999";

    public OperTable() {

    }

    public OperTable(String sessionId) {
        this.sessionId = sessionId;
    }
}
