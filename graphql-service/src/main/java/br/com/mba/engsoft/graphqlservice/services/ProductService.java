package br.com.mba.engsoft.graphqlservice.services;

import br.com.mba.engsoft.graphqlservice.entities.Product;
import br.com.mba.engsoft.graphqlservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> list(Integer page) {
        return this.productRepository.listAllPaginated(page);
    }
}
