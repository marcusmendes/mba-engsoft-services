package br.com.mba.engsoft.grpcservice.services;

import br.com.mba.engsoft.grpcservice.entities.Product;
import br.com.mba.engsoft.grpcservice.repositories.ProductRepository;
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
