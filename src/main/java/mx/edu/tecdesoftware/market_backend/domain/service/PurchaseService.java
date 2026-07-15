package mx.edu.tecdesoftware.market_backend.domain.service;

import mx.edu.tecdesoftware.market_backend.domain.Purchase;
import mx.edu.tecdesoftware.market_backend.persistence.CompraRepository;
import mx.edu.tecdesoftware.market_backend.persistence.entity.Compra;
import mx.edu.tecdesoftware.market_backend.persistence.entity.Producto; // Asegúrate de importar tu entidad Producto
import mx.edu.tecdesoftware.market_backend.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private PurchaseMapper mapper;

    public List<Purchase> getAll() {
        return mapper.toPurchases(compraRepository.getAll());
    }

    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraRepository.getByClient(clientId).map(mapper::toPurchases);
    }

    @Transactional
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);

        if (compra.getProductos() != null) {
            compra.getProductos().forEach(producto -> {
                // 1. Vincular la compra (padre) al producto
                producto.setCompra(compra);

                // 2. CORRECCIÓN: Resolver el "null association" de producto
                // Creamos un objeto Producto "placeholder" con el ID que ya tenemos
                // en la llave primaria compuesta, para satisfacer a Hibernate.
                if (producto.getProducto() == null) {
                    Producto p = new Producto();
                    // Accedemos al idProducto desde la llave primaria embebida
                    p.setIdProducto(producto.getId().getIdProducto());
                    producto.setProducto(p);
                }
            });
        }

        return mapper.toPurchase(compraRepository.save(compra));
    }
}