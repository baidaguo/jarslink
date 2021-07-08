package com.alibaba.action;

import com.alipay.jarslink.api.Action;

/**
 * Created by HASEE on 2018/4/22.
 */
public class WelComeAction implements Action<String, String> {

    @Override
    public String execute(String s) {
        return "welcome " + s;
    }

    @Override
    public String getActionName() {
        return "welcome-action";
    }
}
