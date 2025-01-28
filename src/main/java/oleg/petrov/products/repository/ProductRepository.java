package oleg.petrov.products.repository;

import oleg.petrov.products.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository {
    private final Map<Long, Product> productStorage = new HashMap<>();
    private Long idCounter = 1L;

    public List<Product> findAll() {
        return new ArrayList<>(productStorage.values());
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(idCounter++);
        }
        productStorage.put(product.getId(), product);
        return product;
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(productStorage.get(id));
    }

    public void deleteById(Long id) {
        productStorage.remove(id);
    }
}
