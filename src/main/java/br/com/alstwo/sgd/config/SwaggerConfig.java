package br.com.alstwo.sgd.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(){
      return new OpenAPI()
              .info(
                      new Info()
                      .title("API do SGD")
                      .version("1.0")
                      .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                      .description("Sistema de Gerenciamento de Datacenters")
              ).addServersItem(
                      new Server().url("http://localhost:8081")
              );
    }
}
