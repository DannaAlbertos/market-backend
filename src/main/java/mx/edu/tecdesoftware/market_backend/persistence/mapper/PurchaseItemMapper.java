package mx.edu.tecdesoftware.market_backend.persistence.mapper;

import mx.edu.tecdesoftware.market_backend.domain.PurchaseItem;
import mx.edu.tecdesoftware.market_backend.persistence.entity.Compra_Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idCompra", target = "purchaseId"),
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem(Compra_Producto producto);

    List<PurchaseItem> toPurchaseItems(List<Compra_Producto> productos);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true)
    })
    Compra_Producto toCompraProducto(PurchaseItem item);
}