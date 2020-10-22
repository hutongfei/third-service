package com.my.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

import java.util.*;

/**
 * @author hutf
 * @createTime 2020年10月22日 15:16:00
 */
public class ToJsonMainClass {

    public static void main(String[] args) {
//        System.out.println(toJson_fastjson());

        System.out.println(toJson_gson());
    }

    /**
     * GSON 方式，支持嵌套
     */
    private static String toJson_gson() {
        List<Map<String, Object>> itemList = new ArrayList<>();
        HashMap<String, Object> item = new HashMap<>();
        item.put("key", "value");
        itemList.add(item);

        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map = null;
        for (int i = 0; i < 5; i++) {
            map = new HashMap<>();
            map.put("name", "System.name");
            map.put("id", UUID.randomUUID().toString());
            if (i == 1) {
             map.put("list", itemList);
            }
            list.add(map);
        }
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    /**
     * fastJson 支持嵌套
     * @return
     */
    private static String toJson_fastjson() {
        JSONObject j1 = new JSONObject();
        j1.put("key", "value");

        JSONObject j2 = new JSONObject();
        j2.put("key", "value");

        JSONArray item = new JSONArray();
        item.add(j1);
        item.add(j2);

        JSONArray array = new JSONArray();
        JSONObject object = null;
        for (int i = 0; i < 3; i++) {
            object = new JSONObject();
            object.put("id", UUID.randomUUID().toString());
            object.put("name", "System.name" + i);
            if (i == 1) {
                object.put("list", item);
            }else {
                object.put("list", null);
            }
            array.add(object);
        }
        return array.toJSONString();
    }
}
