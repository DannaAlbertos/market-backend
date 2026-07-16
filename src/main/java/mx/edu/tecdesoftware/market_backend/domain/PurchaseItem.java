package mx.edu.tecdesoftware.market_backend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PurchaseItem {

    private Integer purchaseId;

    @JsonProperty("idProducto")
    private Integer productId;

    @JsonProperty("cantidad")
    private Integer quantity;

    private Double total;

    @JsonProperty("estado")
    private Boolean active;

    // Getters y Setters
    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}