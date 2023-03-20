package com.luo.bhutils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommonsUtils {
    public static Logger log = LoggerFactory.getLogger(CommonsUtils.class);
    public static String Bean2Json(Object bean){
        return  JSON.toJSONString(bean);
    }
    public static Object Json2Bean(JSONObject json){
        return JSONObject.toJavaObject(json, Object.class);
    }
    public static String objectToJson(Object obj) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        try {
            String json = gson.toJson(obj);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 将Object转换成Map
     *
     * @param obj
     * @return
     */
    public static Map<String, Object> objectToMap(Object obj) {

        try {
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
            String json = gson.toJson(obj);
            return jsonToMap(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将Object类型的map转换成String类型
     *
     * @param map
     * @return
     */
    public static Map<String, String> mapToMap(Map<String, Object> map) {
        Map<String, String> returnMap = new HashMap<>();
        for (String key : map.keySet()) {
            returnMap.put(key, String.valueOf(map.get(key)));
        }
        return returnMap;
    }
    /**
     * 任意类型转换成Map
     * @return
     */
    public static Map<String, String> object2Map(Object obj) {
        Map<String, String> hashMap = new HashMap();
        try {
            Class c = obj.getClass();
            Method m[] = c.getDeclaredMethods();
            for (int i = 0; i < m.length; i++) {
                if (m[i].getName().indexOf("get")==0) {
                    // 得到Map的key
                    String suffixKey = m[i].getName().substring(4);
                    String prefixKey = m[i].getName().substring(3,4).toLowerCase();
                    hashMap.put(prefixKey + suffixKey, String.valueOf(m[i].invoke(obj, new Object[0])));
                }
            }
        } catch (Throwable e) {
            log.error(e.getMessage());
        }
        return hashMap;
    }


    /**
     * 把json字符串转化为对象
     *
     * @param jsonString
     * @param clazz
     * @return
     */
    public static Object jsonToObject(String jsonString, Class<?> clazz) {

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        Object obj = null;
        try {
            obj = gson.fromJson(jsonString, clazz);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * josn转arrayList
     *
     * @param jsonArray
     * @return
     */
    public static ArrayList<?> jsonArrayToArrayList(String jsonArray) {

        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .serializeNulls()
                .create();
        ArrayList<?> list = null;
        try {
            Type listType = new TypeToken<ArrayList<?>>() {
            }.getType();

            list = gson.fromJson(jsonArray, listType);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * JSON 转 ArrayList
     */
    public static ArrayList<?> jsonArrayToArrayList(String jsonArray, Class<?> clazz) {

        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .serializeNulls()
                .create();
        ArrayList<?> list = null;
        try {

            list = (ArrayList<?>) gson.fromJson(jsonArray, clazz);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 把json转换为map类型的数据
     *
     * @param json
     * @return
     */
    public static Map<String, Object> jsonToMap(String json) {

        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .serializeNulls()
                .create();
        Map<String, Object> map = null;
        try {
            Type type = new TypeToken<Map<String, Object>>() {
            }.getType();

            map = gson.fromJson(json, type);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return map;
    }
}
