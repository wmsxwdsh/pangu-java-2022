package com.pangu.utils.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * @author LZG
 */
public class GsonUtil {

    private static Gson gson = new Gson();


    /**
     * Json字符串转Class
     *
     * @param jsonStr
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T jsonToClass(String jsonStr, Class<T> cls) {
        if (null == jsonStr || "".equals(jsonStr)) {
            return null;
        }
        T t = gson.fromJson(jsonStr, cls);
        return t;
    }

    /**
     * json转list
     *
     * @param strJsonData
     * @param cls
     * @return
     */
    public static List<?> jsonToList(String jsonStr, Class<?> cls) {
        List<?> list = gson.fromJson(jsonStr, new TypeToken<List<?>>() {}.getType());
        return null != list ? list : null;
    }

    /**
     * Class对象转Json字符串
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String classToJson(Class<T> obj) {
        return gson.toJson(obj);
    }

}

