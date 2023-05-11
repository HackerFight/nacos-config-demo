package com.qiuguan.cloud.nacos.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiuguan
 * @date 2023/05/08 22:24:11  星期一
 *
 * 在SpringCloud工程中，可以使用@RefreshScope+@Value实现配置文件内容变更后的动态刷新。
 *
 * 在SpringBoot工程中，可以使用@NacosValue来实现配置文件内容变更后的动态刷新。
 */
@RestController
public class NacosExt2Controller {

    //注意在SpringCloud项目中不能使用@NacosValue注解，虽然这个注解存在，但是其源码的实现不存在。
    @NacosValue(value = "${nacos.dynamic.config}", autoRefreshed = true)
    private String config;


    @GetMapping("/nacos/dynamic/config")
    public String getConfig(){
        return this.config;
    }
}
