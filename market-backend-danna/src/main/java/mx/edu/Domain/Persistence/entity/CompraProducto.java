package mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "compras_productos")
public class CompraProducto {
    @Id

    @EmbeddedId
    private CompraProductoPK id;
    // Saber los productos que hay en la compra

    //Unir la abla en compras
    @ManyToOne
    @JoinColumn(name ="id_compra", insertable = false, updatable = false)
    private Compra compra;

    private Integer cantidad;
    private double total;
    private Boolean estado;

    public CompraProductoPK getId() {
        return id;
    }

    public void setId(CompraProductoPK id) {
        this.id = id;
    }
}