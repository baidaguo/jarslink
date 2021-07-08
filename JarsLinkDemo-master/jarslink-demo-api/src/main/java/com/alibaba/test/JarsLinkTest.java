package com.alibaba.test;

import com.alibaba.service.ModuleRefreshSchedulerImpl;
import com.alipay.jarslink.api.Action;
import com.alipay.jarslink.api.Module;
import com.alipay.jarslink.api.ModuleLoader;
import com.alipay.jarslink.api.ModuleManager;
import com.alipay.jarslink.api.impl.AbstractModuleRefreshScheduler;
import com.alipay.jarslink.api.impl.ModuleManagerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;
import java.util.Set;

/**
 * Created by HASEE on 2018/4/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:jarslink.xml"})
public class JarsLinkTest {

    @Autowired
    private ModuleLoader moduleLoader;
    @Autowired
    private ModuleManager moduleManager;
    @Autowired
    private AbstractModuleRefreshScheduler moduleRefreshScheduler;

    @Test
    public void test1() {
//        System.out.println("moduleLoader = " + moduleLoader);
//        System.out.println("moduleManager = " + moduleManager);
//        System.out.println("moduleRefreshScheduler = " + moduleRefreshScheduler);
        Module module = moduleLoader.load(ModuleRefreshSchedulerImpl.buildModuleConfig());//加载模块,加载一个模块
        moduleManager.register(module);
        /*获取指定的Action，执行方式一*/
        Module mod = moduleManager.find("hello-world");
        Map<String, Action> actions = mod.getActions();
//        Set<String> keys = actions.keySet();
//        for (String key : keys) {
//            System.out.println(key + ", " + actions.get(key));
//        }
        Action xmlaction = actions.get("XMLACTION");
        System.out.println(xmlaction.execute("hello world"));
        /*获取指定的Action，执行方式二*/
        //doAction参数：模块中action的名称，action中execute方法的参数
        String result = module.doAction("XMLACTION", "hello world");
        System.out.println(result);
    }

    @Test
    public void test2() {
        //加载和注册模块
        Module module = moduleLoader.load(ModuleRefreshSchedulerImpl.buildModuleConfig_Demo());//加载模块,加载一个模块
        moduleManager.register(module);
        String result = module.doAction("hello-world-action", "rabbit");
        System.out.println("result = " + result);
        String result1 = module.doAction("welcome-action", "rabbit");
        System.out.println("result1 = " + result1);
    }

}
