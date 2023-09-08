package com.market.restservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductRepository productRepository;

  @PostMapping
  public Product create(@RequestBody Product product) {
    return productRepository.save(product);
  }

  @PutMapping("/{id}")
  public Product update(@PathVariable Long id, @RequestBody Product updatedProduct) {
    Product existingProduct = productRepository.findById(id).orElse(null);
    if (existingProduct != null) {
      existingProduct.setName(updatedProduct.getName());
      existingProduct.setPrice(updatedProduct.getPrice());
      return productRepository.save(existingProduct);
    }
    return null;
  }

  @PatchMapping("/{id}")
  public Product patch(@PathVariable Long id, @RequestBody Product patchProduct) {
    Product existingProduct = productRepository.findById(id).orElse(null);
    if (existingProduct != null) {
      if (patchProduct.getName() != null) {
        existingProduct.setName(patchProduct.getName());
        existingProduct.setPrice(patchProduct.getPrice());
      }
      return productRepository.save(existingProduct);
    }
    return null;
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    productRepository.deleteById(id);
  }

  @GetMapping
  public List<Product> getAll() {
    return productRepository.findAll();
  }

  @GetMapping("/search")
  public List<Product> search(@RequestParam String name) {
    return productRepository.findByNameContaining(name);
  }

  @GetMapping("/{id}")
  public Product getById(@PathVariable Long id) {
    return productRepository.findById(id).orElse(null);
  }
}
