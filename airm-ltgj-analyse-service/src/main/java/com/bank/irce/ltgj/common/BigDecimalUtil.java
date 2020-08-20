package com.bank.irce.ltgj.common;

import java.math.BigDecimal;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: user
 * \* Date: 2019/10/17
 * \* Time: 16:39
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class BigDecimalUtil {

    public static BigDecimal divide( BigDecimal dividend,BigDecimal divisor,BigDecimal initValue){
        if (divisor.equals(new BigDecimal(0))){
            return initValue;
        }
        return dividend.divide(divisor,2,4);
    }

    /**
     * BigDecimal除法 四舍五入保留 2 位小数
     */
    public static BigDecimal figureOut(Object smsIncome,Object smsIncomeChina) {
        return new BigDecimal(String.valueOf(smsIncome))
                .divide(new BigDecimal(String.valueOf(smsIncomeChina)), 2, BigDecimal.ROUND_DOWN);
    }

}
