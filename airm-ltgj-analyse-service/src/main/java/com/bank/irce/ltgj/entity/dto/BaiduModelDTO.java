package com.bank.irce.ltgj.entity.dto;

import com.google.gson.Gson;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/7/14
 */
@Data
@NoArgsConstructor
public class BaiduModelDTO {

    public static final Integer ZERO = 0;
    public static final Integer ONE = 1;
    public static final String BAIDU_INFO = "BAIDU_INFO";
    public static final String PHONE = "phone";
    public static final String IDENTITY = "identity";
    public static final String RESULT = "result";
    public static final String NULL = "";
    public static final String BLACKLEVEL = "blackLevel";
    public static final String BLACKSCORE = "blackScore";
    public static final String VALUES = "values";
    public static final String TWO_SCORE = "score";
    public static final String SCOREINFO = "scoreInfo";

    private String sessonid;
    private String BLACK_LEVEL;
    private Integer BLACK_SCORE;
    private Integer SCORE;
    private Integer SCORE_INFO;

    interface Converter<T, K, V> {
        T convert(K k,V v);
    }

    public BaiduModelDTO(String sessonid) {
        this.sessonid = sessonid;
        this.BLACK_LEVEL = "-1";
        this.BLACK_SCORE = -1;
        this.SCORE = -1;
        this.SCORE_INFO = -1;
    }

    public BaiduModelDTO(String jsonStr, String sessonid) {
        Converter<Integer,String,String> converter = (var1,var2) -> Math.max(Integer.valueOf(var1), Integer.valueOf(var2));
        BaiduInfo baiduInfoJson = new Gson().fromJson(jsonStr,BaiduInfo.class);
        this.sessonid = sessonid;
        this.BLACK_LEVEL = String.valueOf(BaiduFeat.getDataFromBaiduJson(baiduInfoJson.getOSFX11(),RESULT,NULL,BLACKLEVEL,baiduInfoJson));
        this.BLACK_SCORE = Integer.valueOf(BaiduFeat.getDataFromBaiduJson(baiduInfoJson.getOSHC11(),RESULT,NULL,BLACKSCORE,baiduInfoJson));
        this.SCORE = converter.convert(BaiduFeat.getScoreFromBaiduJson(baiduInfoJson.getOSDT11(),RESULT,IDENTITY,VALUES,baiduInfoJson),
                BaiduFeat.getScoreFromBaiduJson(baiduInfoJson.getOSDT11(),RESULT,PHONE,VALUES,baiduInfoJson));
        this.SCORE_INFO = Integer.valueOf(BaiduFeat.getDataFromBaiduJson(baiduInfoJson.getOSXY11(),RESULT,SCOREINFO,TWO_SCORE,baiduInfoJson));
    }
}

