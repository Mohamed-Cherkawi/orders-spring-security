package com.example.demo.rest;

import com.example.demo.domain.Product;
import com.example.demo.service.dto.ProductDto;
import com.example.demo.service.interfaces.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class ProductController {
    private static final Logger logger = Logger.getLogger(ProductController.class.getName());
    ServiceInterface<Product, ProductDto,Long> service ;

    @Autowired
    public ProductController( @Qualifier("product-service") ServiceInterface<Product, ProductDto,Long> service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductDto> getAllProducts(){
        logger.log(Level.INFO,"Looking for all the products");
        return service.getAll();
    }
    @PostMapping("/product")
    public ProductDto saveProduct(@RequestBody ProductDto product ){
        logger.log(Level.INFO,"Saving Product");
        service.save(product);
        logger.log(Level.FINE,"Product successfully");
        return product;
    }


    @DeleteMapping("/product/{reference}")
    public String deleteProductById(@PathVariable("reference") Long id){
        service.delete(id);
        logger.log(Level.FINE,"Deleted Successfully");
        return "Deleted Successfully";

    }

    @PutMapping("/product/{reference}")
    public ProductDto updateProduct(@PathVariable("reference") Long id,@RequestBody ProductDto productDto){
         logger.log(Level.INFO,"Updating product ...");
         service.update(id,productDto);
         logger.log(Level.FINE,"Product Successfully");
        return productDto;
    }
}
