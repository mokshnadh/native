package com.packtpub.mmj.zuul.server;

/**
 * Created by USER on 5/30/2018.
 */
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

public class PreFilter extends EdgeApp {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        System.out.println("Request Method : " + request.getMethod() + " Request URL : " + request.getRequestURL().toString());

        return null;
    }

}