package br.com.mba.engsoft.graphqlservice.controllers;

import br.com.mba.engsoft.graphqlservice.entities.Product;
import br.com.mba.engsoft.graphqlservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @QueryMapping
    public List<Product> listProducts(@Argument Integer page) {
        return productService.list(page);
    }
}
