package oleg.petrov.products.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import oleg.petrov.products.domain.Product;
import oleg.petrov.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(@Valid Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, @Valid Product updatedProduct) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Товар не найден"));
        updatedProduct.setId(id);
        return productRepository.save(updatedProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
