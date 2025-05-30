package com.example.WikiUrfu.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

/**
 * Класс конфигурации Swagger.
 * Swagger - инструмент для документирования и
 * тестирования API.
 *
 * @info - информация о API
 * @title - заголовок
 * @description - описание
 * @version - версия
 *
 */
@OpenAPIDefinition(
        info = @Info(
                title = "Wikiurfu API",
                description = "API for wikiurfu",
                version = "1.0.0"
        )
)
@SecurityScheme(
        name = "JWT",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
    // Swagger Config
}
