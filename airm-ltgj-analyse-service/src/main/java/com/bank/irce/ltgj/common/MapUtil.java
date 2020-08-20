package com.bank.irce.ltgj.common;

import com.alibaba.fastjson.JSONObject;
import com.bank.irce.ltgj.annotation.FieldValue;
import com.bank.irce.ltgj.entity.dto.ValidateConstant;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: credit-project
 * @Package: com.bairong.unify.service.util
 * @ClassName: MapUtil
 * @Author: Matianhang
 * @Description: ${description}
 * @Date: 2019/7/5 17:52
 * @Version: 1.0
 */
public class MapUtil {

    public static void setNullAttributeToDefaultValue(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                //暴力破解
                field.setAccessible(true);
                FieldValue fieldValue = field.getAnnotation(FieldValue.class);
                if (fieldValue == null) {
                    continue;
                }
                //判断field的类型
                switch (field.getType().getSimpleName()) {
                    case "String":
                        if (StringUtils.isEmpty(field.get(obj))) {
                            field.set(obj, ValidateConstant.VALUE_TYPE_STRING_DEFAULT_VALUE);
                        }
                        break;
                    case "Integer":
                        numberTypeHandler(obj, field, fieldValue.type());
                        break;
                    case "BigDecimal":
                        numberTypeHandler(obj, field, fieldValue.type());
                        break;
                }
            } catch (Exception e) {
                LoggerUtil.logBusinessErrorFile(e.getMessage());
            }
        }
    }

    public static void numberTypeHandler(Object target, Field field, String type) throws Exception {
        Object value = field.get(target);
        if (ValidateConstant.VALUE_TYPE_INT.equals(type)) {
            if (StringUtils.isEmpty(value) || new BigDecimal(ValidateConstant.VALUE_TYPE_BIG_DECIMAL_DEFAULT_VALUE).doubleValue()==new BigDecimal(value.toString()).doubleValue() || new BigDecimal(value.toString()).doubleValue() < 0) {
                //默认值赋值为0
                field.set(target, transformValue(field.getType().getSimpleName(), ValidateConstant.VALUE_TYPE_INT_DEFAULT_VALUE));
            }
        }
        if (ValidateConstant.VALUE_TYPE_BIG_DECIMAL.equals(type)) {
            if (StringUtils.isEmpty(value) ||new BigDecimal(ValidateConstant.VALUE_TYPE_INT_DEFAULT_VALUE).doubleValue()==new BigDecimal(value.toString()).doubleValue() || new BigDecimal(value.toString()).doubleValue() < 0) {
                //默认为-99988
                field.set(target, transformValue(field.getType().getSimpleName(), ValidateConstant.VALUE_TYPE_BIG_DECIMAL_DEFAULT_VALUE));
            }
        }
    }
    public static Object transformValue(String type, String value) {
        if(type.equals("Integer")){
            return Integer.parseInt(value);
        }
        if(type.equals("BigDecimal")){
            return new BigDecimal(value);
        }
        return value;
    }


    public static void setValueToList(List list, String value, String[] ifs, String[] results) {
        for (int i = 0; i < results.length; i++) {
            if (i == results.length - 1) {
                list.add(results[i]);
            } else {
                if (ifs[i].equals(value)) {
                    list.add(results[i]);
                    return;
                }
            }
        }
    }

    public static void setValueToJSonObject(JSONObject params, String attName, String value, String[] ifs, String[] results) {
        for (int i = 0; i < results.length; i++) {
            if (i == results.length - 1) {
                params.put(attName, results[i]);
            } else {
                if (ifs[i].equals(value)) {
                    params.put(attName, results[i]);
                    return;
                }
            }
        }
    }

    public static void setValueToObject(Object object, String attName, String value, String[] ifs, String[] results) throws NoSuchFieldException, IllegalAccessException {
        Class aClass = object.getClass();
        Field field = aClass.getDeclaredField(attName);
        field.setAccessible(true);
        for (int i = 0; i < results.length; i++) {
            if (i == results.length - 1) {
                field.set(object, results[i]);
            } else {
                if (ifs[i].equals(value)) {
                    field.set(object, results[i]);
                    return;
                }
            }
        }
    }

    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null) {
            return null;
        }

        Object obj = beanClass.newInstance();

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                continue;
            }
            field.setAccessible(true);
            field.set(obj, map.get(field.getName()));
        }
        return obj;
    }

    public static Map<String, Object> objectToMap(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }

        Map<String, Object> map = new HashMap<String, Object>();

        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }

        return map;
    }

    public static Map<String, Object> returnMap(JSONObject jsonObject, String key1) {
        if (jsonObject != null) {
            if (jsonObject.get(key1) != null && jsonObject.get(key1) instanceof Map) {
                return (Map<String, Object>) jsonObject.get(key1);
            }
        }
        return Collections.EMPTY_MAP;
    }

    public static Map<String, Object> returnMap(JSONObject jsonObject, String key1, String key2) {
        if (jsonObject != null) {
            if (jsonObject.get(key1) != null && jsonObject.get(key1) instanceof Map) {
                Map<String, Object> map1 = (Map<String, Object>) jsonObject.get(key1);
                if (map1.get(key2) != null && map1.get(key2) instanceof Map) {
                    return (Map<String, Object>) map1.get(key2);
                }
            }
        }
        return Collections.EMPTY_MAP;
    }

    public static Map<String, Object> returnMap(JSONObject jsonObject, String key1, String key2, String key3) {
        if (jsonObject != null) {
            if (jsonObject.get(key1) != null && jsonObject.get(key1) instanceof Map) {
                Map<String, Object> map1 = (Map<String, Object>) jsonObject.get(key1);
                if (map1.get(key2) != null && map1.get(key2) instanceof Map) {
                    Map<String, Object> map2 = (Map<String, Object>) map1.get(key2);
                    if (map2.get(key3) != null && map2.get(key3) instanceof Map) {
                        return (Map<String, Object>) map2.get(key3);
                    }
                }
            }
        }
        return Collections.EMPTY_MAP;
    }

    public static Map<String, Object> returnMap(Map<String, Object> map, String key) {
        if (map != null) {
            if (map.get(key) != null && map.get(key) instanceof Map) {
                return (Map<String, Object>) map.get(key);
            }
        }
        return Collections.EMPTY_MAP;
    }

    public static List returnList(Map<String, Object> map, String key1) {
        if (map != null) {
            if (map.get(key1) != null && map.get(key1) instanceof List) {
                return (List) map.get(key1);
            }
        }
        return Collections.EMPTY_LIST;
    }

    public static List returnList(Map<String, Object> map, String key1, String key2) {
        if (map != null) {
            if (map.get(key1) != null && map.get(key1) instanceof Map) {
                Map<String, Object> map1 = (Map<String, Object>) map.get(key1);
                if (map1.get(key2) != null && map1.get(key2) instanceof List) {
                    return (List) map1.get(key2);
                }
            }
        }
        return Collections.EMPTY_LIST;
    }

    public static List returnList(Map<String, Object> map, String key1, String key2, String key3) {
        if (map != null) {
            if (map.get(key1) != null && map.get(key1) instanceof Map) {
                Map<String, Object> map1 = (Map<String, Object>) map.get(key1);
                if (map1.get(key2) != null && map1.get(key2) instanceof Map) {
                    Map<String, Object> map2 = (Map<String, Object>) map1.get(key2);
                    if (map2.get(key3) != null && map2.get(key3) instanceof List) {
                        return (List) map2.get(key3);
                    }
                }
            }
        }
        return Collections.EMPTY_LIST;
    }

    public static List returnList(Map<String, Object> map, String key1, String key2, String key3, String key4) {
        if (map != null) {
            if (map.get(key1) != null && map.get(key1) instanceof Map) {
                Map<String, Object> map1 = (Map<String, Object>) map.get(key1);
                if (map1.get(key2) != null && map1.get(key2) instanceof Map) {
                    Map<String, Object> map2 = (Map<String, Object>) map1.get(key2);
                    if (map2.get(key3) != null && map2.get(key3) instanceof Map) {
                        Map<String, Object> map3 = (Map<String, Object>) map2.get(key3);
                        if (map3.get(key4) != null && map3.get(key4) instanceof List) {
                            return (List) map3.get(key4);
                        }
                    }
                }
            }
        }
        return Collections.EMPTY_LIST;
    }

    public static List returnList(Map<String, Object> map, String key1, String key2, String key3, String key4, String key5) {
        if (map != null) {
            if (map.get(key1) != null && map.get(key1) instanceof Map) {
                Map<String, Object> map1 = (Map<String, Object>) map.get(key1);
                if (map1.get(key2) != null && map1.get(key2) instanceof Map) {
                    Map<String, Object> map2 = (Map<String, Object>) map1.get(key2);
                    if (map2.get(key3) != null && map2.get(key3) instanceof Map) {
                        Map<String, Object> map3 = (Map<String, Object>) map2.get(key3);
                        if (map3.get(key4) != null && map3.get(key4) instanceof Map) {
                            Map<String, Object> map4 = (Map<String, Object>) map3.get(key4);
                            if (map4.get(key5) != null && map4.get(key5) instanceof List) {
                                return (List) map4.get(key5);
                            }
                        }
                    }
                }
            }
        }
        return Collections.EMPTY_LIST;
    }


}
