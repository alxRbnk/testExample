package org.rbnk.example.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.rbnk.example.domain.Cake;
import org.rbnk.example.entity.CakeEntity;
import org.rbnk.example.entity.Ingredient;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CakeMapper {
    CakeMapper INSTANCE = Mappers.getMapper(CakeMapper.class);

    List<CakeEntity> toEntities(List<Cake> cakes);

    List<Cake> toDomains(List<CakeEntity> cakeEntities);

    @Mapping(source = "ingredients", target = "ingredients", qualifiedByName = "ingredientToString")
    Cake toDomain(CakeEntity cakeEntity);

    @Mapping(source = "ingredients", target = "ingredients", qualifiedByName = "stringToIngredient")
    CakeEntity toEntity(Cake cake);

    @Named("ingredientToString")
    default String ingredientToString(Ingredient ingredient) {
        return ingredient.getName();
    }

    @Named("stringToIngredient")
    default Ingredient stringToIngredient(String ingredientName) {
        return Ingredient.builder().name(ingredientName).build();
    }

}
