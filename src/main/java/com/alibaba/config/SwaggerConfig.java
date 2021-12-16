package com.alibaba.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @project: open-stulife-sdk
 * @ClassName: SwaggerConfig
 * @author: nzcer
 * @creat: 2021/12/10 0:06
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo())
                .select()
                //配置要扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.alibaba.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("BBSER API DOC")
                .description("This is a restful api document of BBSER")
                .version("V1.0")
                .termsOfServiceUrl("urn:tos")
                //.contact(new Contact("逝不等琴生", "https://blog.csdn.net/qq_40563761", "simaqinsheng@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}
