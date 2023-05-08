package com.qiuguan.cloud.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiuguan
 * @date 2023/05/08 01:09:03  星期一
 *
 *
 */
@RefreshScope
@RestController
public class NacosExtController {

    /**
     *<style>
     * spring:
     *   cloud:
     *    nacos:
     *      config:
     *        extension-configs:  #请看自定义dataId.png图片
     *          - dataId: test01.yaml  #nacos上的dataId
     *            group: group_01
     *            refresh: true
     *          - dataId: test02.yaml
     *            group: group_02 #nacos上的dataId
     *            refresh: false
     *</style>
     */
    @Value("${nacos.hacke.name}")
    private String name;

    @GetMapping("/getName")
    public String getName() {
        return this.name;
    }
}
