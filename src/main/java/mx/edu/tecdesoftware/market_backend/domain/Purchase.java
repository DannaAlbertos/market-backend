package mx.edu.tecdesoftware.market_backend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.List;

public class Purchase {

    @JsonProperty("idCompra")
    private Integer purchaseId;

    @JsonProperty("idCliente")
    private String clientId;

    @JsonProperty("fecha")
    private LocalDateTime date;

    @JsonProperty("medioPago")
    private String paymentMethod;

    @JsonProperty("comentario")
    private String comment;

    @JsonProperty("estado")
    private String status;

    @JsonProperty("productos")
    private List<PurchaseItem> items;

    // Getters y Setters...
    public Integer getPurchaseId() { return purchaseId; }
    public void setPurchaseId(Integer purchaseId) { this.purchaseId = purchaseId; }

    public String getClientId() { return clientId; }
    public void setClientId(String clientId) { this.clientId = clientId; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<PurchaseItem> getItems() { return items; }
    public void setItems(List<PurchaseItem> items) { this.items = items; }
}