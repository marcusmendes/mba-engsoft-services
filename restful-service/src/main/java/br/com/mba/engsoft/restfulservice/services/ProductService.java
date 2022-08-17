package br.com.mba.engsoft.restfulservice.services;

import br.com.mba.engsoft.restfulservice.entities.Product;
import br.com.mba.engsoft.restfulservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> list(Integer page) {
        return this.productRepository.listAllPaginated(page);
    }
}
