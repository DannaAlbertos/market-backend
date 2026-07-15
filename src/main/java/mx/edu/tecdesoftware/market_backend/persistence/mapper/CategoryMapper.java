package mx.edu.tecdesoftware.market_backend.persistence.mapper;

import mx.edu.tecdesoftware.market_backend.domain.service.Category;
import mx.edu.tecdesoftware.market_backend.persistence.entity.Categoria;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
        @Mappings({
            @Mapping(source = "idCategoria",
                    target = "categoryID"),
            @Mapping(source = "descripcion",
                    target = "category"),
            @Mapping(source = "estado",
                    target = "active")
        })
        Category toCategory(Categoria categoria);

        @InheritConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
