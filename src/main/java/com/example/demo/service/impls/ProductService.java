package com.example.demo.service.impls;

import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.dto.ProductDto;
import com.example.demo.service.interfaces.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("product-service")
public class ProductService implements ServiceInterface<Product, ProductDto,Long> {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setQuantity(productDto.getQuantity());
        product.setPrice(productDto.getPrice());

        productRepository.save(product);
    }

    @Override
    public Product findById(Long id)  {
       return productRepository.findById(id).orElseThrow();
    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(
                product -> new ProductDto(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getQuantity()))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Long id,ProductDto productDto) {
        //TODO
    }

    @Override
    public void delete(Long id) {
        //TODO
    }

}
