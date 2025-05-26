package org.app.lifemarchforecastingbackend.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

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
                title = "Wikiurfu Application backend",
                description = "API для wkiurfu",
                version = "1.0.0"
        )
)
public class OpenApiConfig {
    // Swagger Config
}
