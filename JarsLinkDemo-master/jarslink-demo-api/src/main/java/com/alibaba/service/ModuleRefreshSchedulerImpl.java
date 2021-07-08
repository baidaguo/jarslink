package com.alibaba.service;

import com.alipay.jarslink.api.ModuleConfig;
import com.alipay.jarslink.api.impl.AbstractModuleRefreshScheduler;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.net.URL;
import java.util.List;

/**
 * Created by HASEE on 2018/4/22.
 */
public class ModuleRefreshSchedulerImpl extends AbstractModuleRefreshScheduler {


    @Override
    public List<ModuleConfig> queryModuleConfigs() {
        //加载所有的模块配置信息
        return ImmutableList.of(buildModuleConfig(), buildModuleConfig_Demo());
    }

    public static ModuleConfig buildModuleConfig() {
        URL demoModule = Thread.currentThread().getContextClassLoader().getResource("jarslink-module-demo-1.0.0.jar");
        ModuleConfig moduleConfig = new ModuleConfig();
        moduleConfig.setName("hello-world");//设置模块名称
        moduleConfig.setEnabled(true);
        moduleConfig.setVersion("1.0.0");//设置版本
        moduleConfig.setProperties(ImmutableMap.of("svnPath", new Object()));
        moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
        return moduleConfig;
    }

    public static ModuleConfig buildModuleConfig_Demo() {
        URL demoModule = Thread.currentThread().getContextClassLoader().getResource("jarslink-demo-action-1.0-SNAPSHOT.jar");
        ModuleConfig moduleConfig = new ModuleConfig();
        moduleConfig.setName("demo-action");
        moduleConfig.setEnabled(true);
        moduleConfig.setVersion("1.0.0");
        //配置自定义的properties信息
        moduleConfig.setProperties(ImmutableMap.of("svnPath", new Object()));
        moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
        return moduleConfig;
    }

}
