package br.com.mba.engsoft.graphqlservice.repositories;

import br.com.mba.engsoft.graphqlservice.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Product> listAllPaginated(Integer page) {
        PageRequest pageRequest = PageRequest.of(page, MAX_PAGE_SIZE);

        Query query = new Query();
        query.with(pageRequest);

        return mongoTemplate.find(query, Product.class, COLLECTION);
    }
}
