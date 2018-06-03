package com.packtpub.mmj.zuul.server;

/**
 * Created by USER on 5/30/2018.
 */
public class PostFilter extends EdgeApp {

    @Override
    public String filterType() {
        return "post";
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
        System.out.println("Inside Response Filter");

        return null;
    }

}