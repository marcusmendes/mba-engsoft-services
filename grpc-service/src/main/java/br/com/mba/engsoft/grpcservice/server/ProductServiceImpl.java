package br.com.mba.engsoft.grpcservice.server;


import br.com.mba.engsoft.grpcservice.Product;
import br.com.mba.engsoft.grpcservice.ProductRequest;
import br.com.mba.engsoft.grpcservice.ProductResponse;
import br.com.mba.engsoft.grpcservice.ProductServiceGrpc;
import br.com.mba.engsoft.grpcservice.services.ProductService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.List;

import static org.springframework.util.ObjectUtils.*;
import static org.springframework.util.StringUtils.hasText;

@GrpcService
public class ProductServiceImpl extends ProductServiceGrpc.ProductServiceImplBase {

    private final ProductService productService;

    @Autowired
    public ProductServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void list(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        List<Product> products = productService.list(request.getPage())
                .stream()
                .map(product -> {
                    Product.Builder newBuilder = Product.newBuilder();

                    if (hasText(product.getId())) newBuilder.setId(product.getId());
                    if (hasText(product.getName())) newBuilder.setName(product.getName());
                    if (hasText(product.getSku())) newBuilder.setSku(product.getSku());
                    if (hasText(product.getSlug())) newBuilder.setSlug(product.getSlug());
                    if (hasText(product.getPermalink())) newBuilder.setPermalink(product.getPermalink());
                    if (!isEmpty(product.getDateCreated())) newBuilder.setDateCreated(product.getDateCreated().toString());
                    if (!isEmpty(product.getDateModified())) newBuilder.setDateModified(product.getDateModified().toString());
                    if (hasText(product.getType())) newBuilder.setType(product.getType());
                    if (hasText(product.getStatus())) newBuilder.setStatus(product.getStatus());
                    newBuilder.setFeatured(product.isFeatured());
                    if (hasText(product.getCatalogVisibility())) newBuilder.setCatalogVisibility(product.getCatalogVisibility());
                    if (hasText(product.getDescription())) newBuilder.setDescription(product.getDescription());
                    if (hasText(product.getShortDescription())) newBuilder.setShortDescription(product.getShortDescription());
                    if (!isEmpty(product.getPrice())) newBuilder.setPrice(product.getPrice().floatValue());
                    if (!isEmpty(product.getRegularPrice())) newBuilder.setRegularPrice(product.getRegularPrice().floatValue());
                    if (!isEmpty(product.getSalePrice())) newBuilder.setSalePrice(product.getSalePrice().floatValue());
                    if (!isEmpty(product.getDateOnSaleFrom())) newBuilder.setDateOnSaleFrom(product.getDateOnSaleFrom().toString());
                    if (!isEmpty(product.getDateOnSaleTo())) newBuilder.setDateOnSaleTo(product.getDateOnSaleTo().toString());
                    if (hasText(product.getImage())) newBuilder.setImage(product.getImage());

                    return newBuilder.build();
                })
                .toList();

        ProductResponse productResponse = ProductResponse.newBuilder().addAllProducts(products).build();
        responseObserver.onNext(productResponse);
        responseObserver.onCompleted();
    }
}
