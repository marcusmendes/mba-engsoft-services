package br.com.mba.engsoft.soapservice.endpoint;

import br.com.mba.engsoft.soapservice.GetProductsRequest;
import br.com.mba.engsoft.soapservice.GetProductsResponse;
import br.com.mba.engsoft.soapservice.Product;
import br.com.mba.engsoft.soapservice.ProductPagination;
import br.com.mba.engsoft.soapservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProductEndpoint {

    private static final String NAMESPACE_URI = "http://www.springframework.org/schema/web-services";

    private final ProductRepository productRepository;

    @Autowired
    public ProductEndpoint(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductsRequest")
    @ResponsePayload
    public GetProductsResponse getProductsResponse(@RequestPayload GetProductsRequest request) {
        Page<Product> products = productRepository.listProducts(request.getPage());

        ProductPagination productPagination = new ProductPagination();
        productPagination.getContent().addAll(products.getContent());
        productPagination.setTotalElements(products.getTotalElements());
        productPagination.setTotalPages(products.getTotalPages());
        productPagination.setTotal(products.getSize());

        GetProductsResponse getProductsResponse = new GetProductsResponse();
        getProductsResponse.setProducts(productPagination);
        return getProductsResponse;
    }
}
