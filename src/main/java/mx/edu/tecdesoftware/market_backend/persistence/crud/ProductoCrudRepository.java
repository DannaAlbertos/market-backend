package mx.edu.tecdesoftware.market_backend.persistence.crud;

import mx.edu.tecdesoftware.market_backend.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    // Método corregido: Se usa 'CategoriaIdCategoria' para buscar por el ID dentro de la entidad Categoria
    List<Producto> findByCategoriaIdCategoriaOrderByNombreAsc(int idCategoria);

    // Obtener los productos con bajo stock
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidad, boolean estado);
}