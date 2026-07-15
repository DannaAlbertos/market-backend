package mx.edu.tecdesoftware.market_backend.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table (name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column ( name = "id_compra")
    private Integer idCompra;

    @Column (name = "id_cliente")
    private String idCliente;

    private LocalDateTime fecha;

    @Column (name = "medio_pago")
    private String medioPago;

    private String comentario;
    private String estado;

    //Relación con cliente:
    //Muchas compras para un cliente
    @ManyToOne
    @JoinColumn(name = "id_cliente",
            insertable = false, updatable = false)
    private Cliente cliente;

    //Una compra tiene muchos productos
    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Compra_Producto> productos;


    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getIdCliente() { return idCliente; }

    public void setIdCliente(String idcliente) {
        idCliente = idcliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Compra_Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Compra_Producto> productos) {
        this.productos = productos;
    }
}
