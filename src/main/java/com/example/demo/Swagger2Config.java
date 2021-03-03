package com.example.demo;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * todo
 * author：xuyy
 * date：2021/3/3  5:19 下午
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class Swagger2Config {

    @Bean
    public Docket defaultApi2() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("openapi")
                .apiInfo(apiInfo())
                .select()
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //兼容allinone而改造，因Api.class在同一个容器共享，不能区分web端api和openApi 20/11/13 tmh
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any())
                .build();
        //.securitySchemes(unifiedAuth());
        return docket;

    }

    //基本信息的配置，信息会在api文档上显示
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("私有云openApi文档")
                .contact(new Contact("megvii", "", "www.megvii.com"))
                .version("1.0.0")
                .build();
    }

    private static List<ApiKey> unifiedAuth() {
        List<ApiKey> arrayList = new ArrayList();
        arrayList.add(new ApiKey("ctimestamp", "ctimestamp", "header"));
        arrayList.add(new ApiKey("cnonce", "cnonce", "header"));
        arrayList.add(new ApiKey("cappkey", "cappkey", "header"));
        arrayList.add(new ApiKey("csign", "csign", "header"));
        return arrayList;
    }


}
