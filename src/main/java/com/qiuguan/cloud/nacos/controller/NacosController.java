package com.qiuguan.cloud.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiuguan
 * @date 2023/05/08 01:09:03  星期一
 */
@RefreshScope
@RestController
public class NacosController {

    /**
     * 从配置文件中读取nacos.properies.info，如果没有配置则就取spring.application.name，如果
     * spring.application.name 也没有配置，则取最终的默认值 ""
     */
    @Value("${nacos.properies.info:${spring.application.name:}}")
    private String properties;

    /**
     * 演示nacos的配置中心功能
     * 在bootstrap.yaml配置文件中，有说明nacos配置中心的配置规则
     * #${prefix}-${spring.profiles.active}.${file-extension}
     *
     * 所以我们就要去nacos中配置，参考图片nacos-config.png
     * 注意：要在在bootstrap.yaml配置文件中指定的namespace下创建【前提是我们在配置文件中指定了自定义namespace】
     *
     * ${nacos.config.info} 启动时如果无法从配置文件中读取到，则会报错，所以使用 : 可以指定一个""默认值这样就不会
     * 报错【${nacos.config.info:}】，如果不指定默认值，则我们需要先在nacos中创建好后再启动，否则将无法启动。
     */
    @Value("${nacos.config.info}")
    private String config;

    @GetMapping("/nacos/get")
    public String getInfo(){
        System.out.println("properties = " + properties);
        return this.config;
    }
}
