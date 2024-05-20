package com.koko.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//国际化
public class MyLocaleResolver implements LocaleResolver {
    //解析请求z
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求中的语言参数
        String lan = request.getParameter("l");
        Locale locale = Locale.getDefault(); //如果没有就使用默认的

        //如果请求的链接携带了国际化的参数
        if (!StringUtils.isEmpty(lan)) {
            String[] split = lan.split("_");
            //国家，地区
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
