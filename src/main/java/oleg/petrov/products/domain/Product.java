package oleg.petrov.products.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Product {
    private Long id;

    @NotBlank(message = "Название товара обязательно")
    private String name;

    @NotNull(message = "Цена обязательна")
    @Min(value = 0, message = "Цена не может быть отрицательной")
    private Double price;

    private String category;
    private String description;
}
