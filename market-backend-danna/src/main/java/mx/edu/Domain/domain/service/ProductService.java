import java.util.List;


public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List getAll()
    {
        return productRepository.getAll();
    }

    public Optional<Producto> getProduct(int productId)
    {
        return productRepository.getProduct(productId);
    }
    pubblic Optional<<List>Producto> getBYCategory(int categoryId)
    {
        return productRepository.getCategory(categoryId)
    }
    public product save(Product product)
    {
        return productRepository.delete(productId)
    }
    public boolean delete(int productId)

        if (getProduct(productId).ispresent()){
        productRepository.delete(productId);
        return true;
    } else {
        return false;
    }
}