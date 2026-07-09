@Entity *
@Table (name = "clientes")
public class cliente{
    @Id
    @GeneratedValue(Strategy = GenerationType.IDENTITY)
    @Column (name = "id_cliente")
    private Integer idCliente;

    private String nombre;

    private String apellidos;

    private String direccion;
    @column (name = "correo_electronico")
    private String correoElectronico;

    @OneToMany(mappedBy = "cliente")
    private List<Compras> comprasList;
}
