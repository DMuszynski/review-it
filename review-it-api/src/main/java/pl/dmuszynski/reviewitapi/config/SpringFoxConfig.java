package pl.dmuszynski.reviewitapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {
    @Bean
    public Docket getApi() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .paths(PathSelectors.ant("/review-it/**"))
                .apis(RequestHandlerSelectors.basePackage("pl.dmuszynski.reviewitapi.controller"))
                .build().apiInfo(this.getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Review-it API")
                .description("Movie discovery and review - Web application")
                .contact(new Contact("Damian Muszyński", " ", "d.muszynski112@gmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("0.0.1-SNAPSHOT")
                .build();
    }
}
