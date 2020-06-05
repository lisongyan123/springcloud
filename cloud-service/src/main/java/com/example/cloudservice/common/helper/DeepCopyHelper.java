package com.example.cloudservice.common.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DeepCopyHelper {

    /**
     * 单个对象的深拷贝，srcObj对应的需实现java.io.Serializable接口
     */
    public static Object depthClone(Object srcObj) {
        Object cloneObj = null;
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(out);
            oo.writeObject(srcObj);
            ByteArrayInputStream in = new ByteArrayInputStream(
                    out.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(in);
            cloneObj = oi.readObject();
        } catch (Exception ex) {
            return null;
        }
        return cloneObj;
    }

    /**
     * 多个对象的深拷贝，srcObj对应的需实现java.io.Serializable接口
     */
    public static <T> List<T> listDepthClone(List<T> list) {
        List<T> newList = new ArrayList<>();
        for (Object item : list) {
            if (item == null) {
                continue;
            }
            Object val = depthClone(item);
            if (val != null) {
                newList.add((T) val);
            }
        }
        return newList;
    }
}
