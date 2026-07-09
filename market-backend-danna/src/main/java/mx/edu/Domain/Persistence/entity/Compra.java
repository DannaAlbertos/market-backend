public class Compra {

    @Id
    @GeneratedValue(Strategy = GenerationType.IDENTITY)
    @Column (name = "Id_compra")
    private Integer IdCompra;

    @Column (name = "Id_compra")
    private String IdCliente;

    private LocalDataTime fecha;

    @Column (name = "Id_compra")
    private String medioPago;

    private String estado;

    // Relacion con clientes: Muchas compras para un cliente
    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable)
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getIdCompra() {
        return IdCompra;
    }

    public void setIdCompra(Integer idCompra) {
        IdCompra = idCompra;
    }

    public String getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(String idCliente) {
        IdCliente = idCliente;
    }

    public LocalDataTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDataTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}