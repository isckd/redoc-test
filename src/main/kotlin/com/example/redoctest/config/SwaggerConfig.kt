package com.example.redoctest.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.PropertySource

//import springfox.documentation.builders.PathSelectors
//import springfox.documentation.builders.RequestHandlerSelectors
//import springfox.documentation.spi.DocumentationType
//import springfox.documentation.spring.web.plugins.Docket

//@Configuration
//class SwaggerConfig {
//
//    @Bean
//    fun api(): Docket {
//        return Docket(DocumentationType.SWAGGER_2)
//            .select()
//            .apis(RequestHandlerSelectors.any())
//            .paths(PathSelectors.any())
//            .build()
//
//    }
//}

@Configuration
@PropertySource("classpath:specs/petstore.yaml", factory = YamlPropertySourceFactory::class)
class SwaggerConfig {

    @Bean
    @Primary
    fun openApi(): OpenAPI {
        return OpenAPI().info(
            Info()
                .title("Petstore API")
                .description("Petstore API")
                .version("1.0.0")
        )
    }


}