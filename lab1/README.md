# Take-API-backend

REST API для управления документами пользователей (создание, обновление,
удаление, выборка по пользователю, фильтрация подписанных/неподписанных,
поиск по диапазону дат создания).

Стек: Spring Boot 4.0.5, Spring Data JPA, PostgreSQL, Lombok, Java 17.

## Запуск
1. Поднять PostgreSQL и создать БД `documents_db`.
2. Указать креды в `src/main/resources/application.properties`.
3. `./mvnw spring-boot:run`

База endpoint'ов: `/api/documents`.
