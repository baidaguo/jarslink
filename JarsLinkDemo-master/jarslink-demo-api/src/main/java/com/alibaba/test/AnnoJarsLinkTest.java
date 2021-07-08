package com.alibaba.test;

import com.alipay.jarslink.api.Module;
import com.alipay.jarslink.api.ModuleConfig;
import com.alipay.jarslink.api.ModuleLoader;
import com.alipay.jarslink.api.ModuleManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URL;

/**
 * Created by HASEE on 2018/4/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:jarslink.xml"})
public class AnnoJarsLinkTest {

    @Autowired
    private ModuleLoader moduleLoader;
    @Autowired
    private ModuleManager moduleManager;

    @Test
    public void test1() {
        URL demoModule = Thread.currentThread().getContextClassLoader().getResource("jarslink-demo-anno-action-1.0-SNAPSHOT.jar");
        ModuleConfig moduleConfig = new ModuleConfig();
        moduleConfig.setName("anno-action");
        moduleConfig.setEnabled(true);
        moduleConfig.setVersion("1.0.0");
        moduleConfig.setProperties(ImmutableMap.of("svnPath", new Object()));
        moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
        //扫描模块下的Action
        moduleConfig.addScanPackage("com.alibaba.action");
        Module module = moduleLoader.load(moduleConfig);
        moduleManager.register(module);
        System.out.println("string to long " + module.doAction("string-to-long", "500"));
    }

}
