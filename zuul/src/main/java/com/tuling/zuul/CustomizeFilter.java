package com.tuling.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 自定义过滤器
 */
@Component
public class CustomizeFilter extends ZuulFilter {

    /**
     * 过滤器的类型
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序，相同类型数字越小越先执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 返回布尔值判断，过滤器是否要过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

   /* *//**
     * 过滤逻辑，校验accessToken
     * @return
     * @throws ZuulException
     *//*
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String accessToken = request.getHeader("Authorization");
        System.out.println("经过了路由器。。。。。。");
        if (StringUtils.isEmpty(accessToken)){
            //不进行路由
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            HttpServletResponse response = currentContext.getResponse();
            response.setCharacterEncoding("utf-8");
            try {
                response.getWriter().write("没有token");
            } catch (IOException e) {
                e.printStackTrace();
            }
            currentContext.setResponse(response);
            currentContext.set("isSuccess",false);
            return null;
        }
        return null;
    }*/



    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        MyResettableServletRequest wrapper = null;
        try {
            wrapper = new MyResettableServletRequest(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Cookie[] cookies = wrapper.getCookies();
        System.out.println("经过了路由器。。。。。。");
        if (cookies == null || cookies.length == 0 || (cookies.length == 1 && cookies[0].getName().equals("JSESSIONID"))){
            //不进行路由
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            currentContext.setResponseBody("{\"result\":\"accessToken为空!\"}");
            currentContext.getResponse().setContentType("text/html;charset=UTF-8");
            currentContext.set("isSuccess",false);
            return null;
        }
        return null;
    }


}
