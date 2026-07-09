
public interface ProductRepository {

    List<Product> getall()
    Optional<List<Product>> getBycategory(categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    save(Product product);
    void delete (int productId);
}