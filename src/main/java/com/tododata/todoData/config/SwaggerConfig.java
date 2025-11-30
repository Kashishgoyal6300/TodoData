package com.tododata.todoData.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myCustomConfig() {

        Server localServer = new Server()
                .url("http://localhost:8080")
                .description("Local Server");

        Server liveServer = new Server()
                .url("http://localhost:8081")
                .description("Live Server");

        return new OpenAPI()
                .info(new Info()
                        .title("TodoApp API's")
                        .description("By Kashish Goyal")
                )
                .servers(List.of(localServer, liveServer));
    }
}
