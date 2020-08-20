package com.bank.irce.ltgj.common;

import com.alibaba.fastjson.JSONObject;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
/**
 * @ProjectName: credit-project
 * @Package: com.bairong.external.service.util
 * @ClassName: Xml2JsonUtil
 * @Author: Matianhang
 * @Description: ${description}
 * @Date: 2019/6/20 15:01
 * @Version: 1.0
 */
public class Xml2JsonUtil {


    /**
     * 转换一个xml格式的字符串到json格式
     *
     * @param xml xml格式的字符串
     * @return 成功返回json 格式的字符串;失败反回null
     */
    @SuppressWarnings("unchecked")
    public static JSONObject xml2JSON(String xml) {
        JSONObject obj = new JSONObject();
        try {
            Document doc = DocumentHelper.parseText(xml);
            Element root = doc.getRootElement();
            obj.put(root.getName(), iterateElement(root));
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 一个迭代方法
     *
     * @param element
     * @return java.util.Map 实例
     */
    @SuppressWarnings("unchecked")
    private static Map iterateElement(Element element) {
        List jiedian = element.elements();
        Element et = null;
        Map obj = new HashMap();
        Object temp;
        List list = null;
        for (int i = 0; i < jiedian.size(); i++) {
            list = new LinkedList();
            et = (Element) jiedian.get(i);
            if ("".equals(et.getTextTrim())) {
                if (et.elements().size() == 0) {
                    continue;
                }
                if (obj.containsKey(et.getName())) {
                    temp = obj.get(et.getName());
                    if (temp instanceof List) {
                        list = (List) temp;
                        list.add(iterateElement(et));
                    } else if (temp instanceof Map) {
                        list.add((HashMap) temp);
                        list.add(iterateElement(et));
                    } else {
                        list.add((String) temp);
                        list.add(iterateElement(et));
                    }
                    obj.put(et.getName(), list);
                } else {
                    obj.put(et.getName(), iterateElement(et));
                }
            } else {
                if (obj.containsKey(et.getName())) {
                    temp = obj.get(et.getName());
                    if (temp instanceof List) {
                        list = (List) temp;
                        list.add(et.getTextTrim());
                    } else if (temp instanceof Map) {
                        list.add((HashMap) temp);
                        list.add(iterateElement(et));
                    } else {
                        list.add((String) temp);
                        list.add(et.getTextTrim());
                    }
                    obj.put(et.getName(), list);
                } else {
                    obj.put(et.getName(), et.getTextTrim());
                }

            }

        }
        return obj;
    }

    public static String getXmlString(String xmlpath) throws UnsupportedEncodingException {
        String xmlString;
        byte[] strBuffer = null;
        int flen = 0;
        File xmlfile = new File(xmlpath);
        try {
            InputStream in = new FileInputStream(xmlfile);
            flen = (int) xmlfile.length();
            strBuffer = new byte[flen];
            in.read(strBuffer, 0, flen);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        xmlString = new String(strBuffer, "GBK"); //构建String时，可用byte[]类型，
        return xmlString;
    }

    public static String inputStreamToStr(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static Long between_days(String subtraction, String subtracted) {

        SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");// 自定义时间格式
        SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy.MM.dd");// 自定义时间格式
        if ("".equals(subtracted)) {
            subtracted = yyyy_MM_dd.format(new Date());
        }
        Calendar calendar_subtraction = Calendar.getInstance();// 获取日历对象
        Calendar calendar_subtracted = Calendar.getInstance();
        Date date_subtraction = null;
        Date date_subtracted = null;
        try {
            date_subtraction = yyyyMMdd.parse(subtraction);//字符串转Date
            date_subtracted = yyyy_MM_dd.parse(subtracted);
            calendar_subtraction.setTime(date_subtraction);// 设置日历
            calendar_subtracted.setTime(date_subtracted);
        } catch (ParseException e) {
            e.printStackTrace();//格式化异常
        }
        long time_a = calendar_subtraction.getTimeInMillis();
        long time_b = calendar_subtracted.getTimeInMillis();
        long between_days = (time_b - time_a) / (1000 * 3600 * 24);//计算相差天数
        return between_days;
    }

    // 测试
    public static void main(String[] args) {
        String xmlStr = "<getOmElement>" +
                "<HEADER>" +
                "<SOURCEID>MDM</SOURCEID>" +
                "<SOURCEID>MDM</SOURCEID>" +
                "<myChild/>" +
                "<DESTINATIONID>DAXT</DESTINATIONID>" +
                "<SIZE>1</SIZE>" +
                "<TYPE>ADD</TYPE>" +
                "<BO>ORG</BO>" +
                "<CHECK>" +
                "checkCode"
                + "</CHECK>" +
                "</HEADER>" +
                "<REQUEST>" +
                "<DATAROW>" +
                "<ORGUUID>460c5239-13f662e8f67-2f1936027f000a1d675dd1399911234</ORGUUID>" +
                "</DATAROW>" +
                "<DATAROW>" +
                "<ORGUUID>460c5239-13f662e8f67-2f1936027f000a1d675dd139991369c4</ORGUUID>" +
                "</DATAROW>" +
                "</REQUEST>" +
                "</getOmElement>";

        System.out.println(Xml2JsonUtil.xml2JSON(xmlStr));
    }
}
