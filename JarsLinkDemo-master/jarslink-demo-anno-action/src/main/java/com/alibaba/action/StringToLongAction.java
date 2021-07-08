package com.alibaba.action;

import com.alipay.jarslink.api.Action;
import org.springframework.context.annotation.Configuration;

/**
 * Created by HASEE on 2018/4/23.
 */
@Configuration
public class StringToLongAction implements Action<String, Long> {

    @Override
    public Long execute(String s) {
        return Long.valueOf(s);
    }

    @Override
    public String getActionName() {
        return "string-to-long";
    }
}
