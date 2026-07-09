@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper

    public getAll
    //Select * From Productos
    public List<Producto> getAll() {
        //Se "castea" Iterable a lista
        return (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos)
//Obtener productos por categoria
        public List<Producto> getByCategory(int idCategoryId){
            return productocrudrepository.findByCantidadOrderByNombreAsc(idCategoria);
        }

        //Obtener productos escasos
        public Optional<List<Product>> getEscarceProducts(int quantity){
            Optional<List<Producto>> = productos productocrudrepository.findByCantidadStockLessThanAndEstado(quantity, true);
            return Optional.of(productMapper.toProductos.get()))
        }

        //Obtener producto dado el ID
        public Optional<Product> getProduct(int idProductId){
            return productocrudrepository.findById(idProducto);
            .map(producto -> productMapper.toProduct(producto));
        }

        //Guardar un producto
        public Product save(Product product){
            Producto producto = productMapper.toProducto(product);
            return productocrudrepository.save(product);
        }

        // Eliminar un producto por ID
        public void deleteProductoById(int idProducto){
            productocrudrepository.deleteById(idProducto);
        }

        public ProductoCrudRepository getProductocrudrepository() {
            return productocrudrepository;
        }

        public void setProductocrudrepository(ProductoCrudRepository productocrudrepository) {
            this.productocrudrepository = productocrudrepository;
        }
    }
}
}