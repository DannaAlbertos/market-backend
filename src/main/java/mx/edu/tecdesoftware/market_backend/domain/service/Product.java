package mx.edu.tecdesoftware.market_backend.domain.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    @JsonProperty("idProducto")
    private Integer productId; // Cambiado a Integer

    @JsonProperty("nombre")
    private String name;

    @JsonProperty("id_categoria")
    private Integer categoryId; // Cambiado a Integer

    @JsonProperty("codigoBarras")
    private String barcode;

    @JsonProperty("precioVenta")
    private Double price; // Cambiado a Double

    @JsonProperty("cantidadStock")
    private Integer stock; // Cambiado a Integer

    @JsonProperty("estado")
    private Boolean active; // Cambiado a Boolean

    // Getters y Setters
    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }

    public String getBarcode() { return barcode; }
    public void setBarcode(String barcode) { this.barcode = barcode; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public Boolean getActive() { return active; } // Se recomienda getActive para Boolean
    public void setActive(Boolean active) { this.active = active; }
}