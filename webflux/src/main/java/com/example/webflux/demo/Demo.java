package com.example.webflux.demo;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Slf4j
public class Demo {
    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        List<A> a = Arrays.asList(
                new A("1", "good", "arg1", "arg2", null, null),
                new A("1", "good", "arg1", "arg2", null, null),
                new A("2", "good", "arg1", "arg2", null, null),
                new A("2", "good", "arg1", "arg2", null, null),
                new A("3", "good", "arg1", "arg2", null, null),
                new A("1", "good1", "arg1", "arg2", null, null)
        );
        Map<Object, List<A>> map = a.stream().collect(Collectors.groupingBy(A::getId));
        log.info(JSON.toJSONString(map));
        map.entrySet().stream().forEach(v -> {
            Long count1 = v.getValue().stream().map(k -> k.getName()).distinct().count();
            Long count2 = v.getValue().stream().map(k -> k.getArg2()).distinct().count();
            v.getValue().stream().forEach(k -> {
                k.setNum1(count1);
                k.setNum2(count2);
            });
        });
//        List list = map.entrySet().stream().filter(distinctByKey(A::getArg1)).collect(Collectors.toList());
        a = a.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(()
                -> new TreeSet<>(Comparator.comparing(A::getId))), ArrayList::new));
        //[{"arg1":"arg1","arg2":"arg2","id":"1","name":"good","num1":2,"num2":1},
        // {"arg1":"arg1","arg2":"arg2","id":"2","name":"good","num1":1,"num2":1},
        // {"arg1":"arg1","arg2":"arg2","id":"3","name":"good","num1":1,"num2":1}]
        log.info(JSON.toJSONString(a));
        System.out.println("*****************");
    }

    /**
     * 获取合同选择下拉框数据
     *
     * @param purchaseContractGoods
     * @return
     */
    public List<Map<String, Object>> findGoodsNoSelectInit(A purchaseContractGoods) {
        //获取根据对象查询到的所有数据
        List<A> list = new ArrayList<>();
        //用于存储select2下拉框的map集合
        List<Map<String, Object>> mapList = new ArrayList<>();

        //根据list对象中的某个字段进行去重处理
        List<A> distinctList = list.stream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(A::getId))), ArrayList::new));
        //去重后的数据循环放入下拉框数据中
        distinctList.forEach(item -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", item.getArg1());
            map.put("text", item.getArg2());
            map.put("name", item.getName());
            mapList.add(map);
        });
        return mapList;
    }


    private static <T> Predicate<T> distinctByKey(Supplier keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.get(), Boolean.TRUE) == null;
    }
}

class A {
    String id;
    String name;
    String arg1;
    String arg2;
    Long num1;
    Long num2;

    public A(String id, String name, String arg1, String arg2, Long num1, Long num2) {
        this.id = id;
        this.name = name;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.num1 = num1;
        this.num2 = num2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    public Long getNum1() {
        return num1;
    }

    public void setNum1(Long num1) {
        this.num1 = num1;
    }

    public Long getNum2() {
        return num2;
    }

    public void setNum2(Long num2) {
        this.num2 = num2;
    }

}
