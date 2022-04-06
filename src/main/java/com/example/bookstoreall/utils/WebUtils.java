package com.example.bookstoreall.utils;

import com.example.bookstoreall.poje.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class WebUtils {
    public  static <T> T copyParamToBean(Map value, T bean){
        try {
            System.out.println("注入前"+bean);
            BeanUtils.populate(bean,value);
            System.out.println("注入后"+bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bean;
    }
}
