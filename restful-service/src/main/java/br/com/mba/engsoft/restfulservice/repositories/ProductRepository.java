package br.com.mba.engsoft.restfulservice.repositories;

import br.com.mba.engsoft.restfulservice.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    private static final String COLLECTION = "products";
    private static final Integer MAX_PAGE_SIZE = 50;

    private final MongoTemplate mongoTemplate;

    @Autowired
    public ProductRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Page<Product> listAllPaginated(Integer page) {
        PageRequest pageRequest = PageRequest.of(page, MAX_PAGE_SIZE);

        Query query = new Query();
        query.with(pageRequest);

        List<Product> products = mongoTemplate.find(query, Product.class, COLLECTION);
        long total = mongoTemplate.estimatedCount(COLLECTION);

        return new PageImpl<>(products, pageRequest, total);
    }
}
