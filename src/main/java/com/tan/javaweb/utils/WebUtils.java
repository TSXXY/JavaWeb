package com.tan.javaweb.utils;


import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {
    public static <T> T copy(Map map, T t) {
        try {
            BeanUtils.populate(t, map);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return t;
    }

    public static int parseInt(String s,int defaultValue){
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}