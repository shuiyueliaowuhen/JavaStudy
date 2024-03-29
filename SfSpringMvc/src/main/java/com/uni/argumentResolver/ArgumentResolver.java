package com.uni.argumentResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public interface ArgumentResolver {
    
    boolean support(Class<?> type, int paramIndex, Method method);
    
    //参数解析方法
    Object argumentResolver(HttpServletRequest request,
                                   HttpServletResponse response, Class<?> type,
                                   int paramIndex,//参数索引下坐标,有很多注解,你得知道是哪个参数的注解,每个参数的索引顺序不一样
                                   Method method);
}
