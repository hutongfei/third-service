package com.my.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author hutf
 * @createTime 2020年10月22日 15:42:00
 */
public class ToObjectMainClass {

    public static void main(String[] args) {
        String ss = "[{\"name\":\"System.name\",\"id\":\"6758dd83-e03e-4500-ab8d-852eedd901e1\"},{\"name\":\"System.name\",\"id\":\"2bbae7f0-6a42-4185-8836-db1450e157a1\",\"list\":[{\"key\":\"value\"}]},{\"name\":\"System.name\",\"id\":\"cdd49346-e8a8-4ae9-8bbc-635d5d4a236f\"},{\"name\":\"System.name\",\"id\":\"84cafe85-decd-4ac5-80e2-24177e0c0695\"},{\"name\":\"System.name\",\"id\":\"9d5ed009-4c89-45f6-8e18-4c40a5c48615\"}]\n";
        toObject_fastJson("{\"name\":\"System.name\",\"id\":\"6758dd83-e03e-4500-ab8d-852eedd901e1\"}");
    }

    public static Map<String, Object> toObject_fastJson(String str) {
        JSONObject object = JSONObject.parseObject(str);
        if (object.getString("name") != null) {
            System.out.println(object.get("name"));
        }
        return null;
    }
}
