# Product Manager API

## 1. Описание

Это CRUD-приложение для управления товарами в магазине. Приложение позволяет:
- Создавать товары
- Просматривать список всех товаров
- Редактировать товары
- Удалять товары

Данные хранятся в оперативной памяти, что делает приложение легковесным и удобным для тестирования.

---
## Используемые технологии
Java 21
Spring Boot 3
Spring Web 6
Gradle
---

## Структура кода

### **1.1 Модель**
Файл: `Product.java`  
Модель `Product` представляет сущность товара с полями

### **1.2 Репозиторий**
Файл: `ProductRepository.java`  
Репозиторий реализован в виде хранилища `Map<Long, Product>`.

### **1.3 Сервис**
Файл: `ProductService.java`  
Содержит бизнес-логику приложения.

### **1.4 Контроллер**
Файл: `ProductController.java`  
Контроллер обеспечивает доступ к API.

---

## 3. Swagger и маршруты

Swagger file находится в папке src/main/resources/static/swagger.yaml

![img.png](img.png)

---

## 3. Методы валидации данных и обработки ошибок

### **2.1 Валидация данных**

Для валидации данных используются аннотации из библиотеки `jakarta.validation`:
- `@NotBlank` — проверяет, что строка не пустая. Используется для `name`.
- `@NotNull` — проверяет, что поле не равно `null`. Используется для `price`.
- `@Min` — проверяет, что значение числа больше или равно заданному минимуму. Используется для `price` (значение ≥ 0).

Пример из модели `Product`:
```java
@NotBlank(message = "Название товара обязательно")
private String name;

@NotNull(message = "Цена обязательна")
@Min(value = 0, message = "Цена не может быть отрицательной")
private Double price;
