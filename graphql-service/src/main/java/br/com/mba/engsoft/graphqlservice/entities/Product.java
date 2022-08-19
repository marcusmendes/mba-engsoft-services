package br.com.mba.engsoft.graphqlservice.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "products")
public class Product {

    protected String id;
    protected String name;
    protected String slug;
    protected String permalink;
    protected LocalDateTime dateCreated;
    protected LocalDateTime dateModified;
    protected String type;
    protected String status;
    protected boolean featured;
    protected String catalogVisibility;
    protected String description;
    protected String shortDescription;
    protected String sku;
    protected BigDecimal price;
    protected BigDecimal regularPrice;
    protected BigDecimal salePrice;
    protected LocalDateTime dateOnSaleFrom;
    protected LocalDateTime dateOnSaleTo;
    protected String image;

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDateTime dateModified) {
        this.dateModified = dateModified;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public String getCatalogVisibility() {
        return catalogVisibility;
    }

    public void setCatalogVisibility(String catalogVisibility) {
        this.catalogVisibility = catalogVisibility;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(BigDecimal regularPrice) {
        this.regularPrice = regularPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public LocalDateTime getDateOnSaleFrom() {
        return dateOnSaleFrom;
    }

    public void setDateOnSaleFrom(LocalDateTime dateOnSaleFrom) {
        this.dateOnSaleFrom = dateOnSaleFrom;
    }

    public LocalDateTime getDateOnSaleTo() {
        return dateOnSaleTo;
    }

    public void setDateOnSaleTo(LocalDateTime dateOnSaleTo) {
        this.dateOnSaleTo = dateOnSaleTo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", permalink='" + permalink + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", featured=" + featured +
                ", catalogVisibility='" + catalogVisibility + '\'' +
                ", description='" + description + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", sku='" + sku + '\'' +
                ", price=" + price +
                ", regularPrice=" + regularPrice +
                ", salePrice=" + salePrice +
                ", dateOnSaleFrom=" + dateOnSaleFrom +
                ", dateOnSaleTo=" + dateOnSaleTo +
                ", image='" + image + '\'' +
                '}';
    }
}
