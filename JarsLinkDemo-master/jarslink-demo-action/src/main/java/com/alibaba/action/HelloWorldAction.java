package com.alibaba.action;

import com.alipay.jarslink.api.Action;

/**
 * Created by HASEE on 2018/4/22.
 */
public class HelloWorldAction implements Action<String, String> {

    @Override
    public String execute(String s) {
        return s + ":hello world222";
    }

    @Override
    public String getActionName() {
        return "hello-world-action";
    }

}
