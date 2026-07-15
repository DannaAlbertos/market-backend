package mx.edu.tecdesoftware.market_backend.persistence;

import mx.edu.tecdesoftware.market_backend.persistence.crud.CompraCrudRepository;
import mx.edu.tecdesoftware.market_backend.persistence.entity.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;

    public List<Compra> getAll() {
        return (List<Compra>) compraCrudRepository.findAll();
    }

    public Optional<List<Compra>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId);
    }

    public Compra save(Compra compra) {
        return compraCrudRepository.save(compra);
    }
}