@Entity new *
@table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(Strategy = GenerationType.IDENTITY)
    @column(name = "id_categoria")
    private Integer idCategoria;

    private String descripcion;
    private Boolean estado;
    @OneToMany(mappdBy = "categoria")
    private List<producto> productos;

    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public List<producto> getProductos() {
        return productos;
    }

    public void setProductos(List<producto> productos) {
        this.productos = productos;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Categoria() {

    }

}