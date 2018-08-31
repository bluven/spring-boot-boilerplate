package com.github.bluven.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Created by songk on 18/3/15.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket swaggerSpringMvcPluginForExternalApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo("only for demo"))
                .groupName("demo")
                .useDefaultResponseMessages(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.bluven.demo"))
                .build();
    }

    private ApiInfo apiInfo(String title) {
        return new ApiInfoBuilder()
                .title(title)
                .contact("燕剑波")
                .version("1.0")
                .build();
    }

}
