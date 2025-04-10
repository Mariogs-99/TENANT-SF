package sv.gov.cnr.cnrpos.models.mappers.security;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sv.gov.cnr.cnrpos.entities.Menu;
import sv.gov.cnr.cnrpos.entities.RCatalogos;
import sv.gov.cnr.cnrpos.models.dto.CategoryDTO;
import sv.gov.cnr.cnrpos.models.dto.UserMenuDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-31T09:14:18-0600",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250325-2231, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class UserMenuMapperImpl extends UserMenuMapper {

    @Override
    public Menu toEntity(UserMenuDTO source) {
        if ( source == null ) {
            return null;
        }

        Menu menu = new Menu();

        menu.setCategory( categoryDTOToRCatalogos( source.getCategory() ) );
        menu.setIdCategory( source.getIdCategory() );
        menu.setIdMenu( source.getIdMenu() );
        menu.setNameMenu( source.getNameMenu() );
        menu.setSlugMenu( source.getSlugMenu() );

        return menu;
    }

    @Override
    public UserMenuDTO toDto(Menu target) {
        if ( target == null ) {
            return null;
        }

        UserMenuDTO userMenuDTO = new UserMenuDTO();

        userMenuDTO.setCategory( rCatalogosToCategoryDTO( target.getCategory() ) );
        userMenuDTO.setIdCategory( target.getIdCategory() );
        userMenuDTO.setIdMenu( target.getIdMenu() );
        userMenuDTO.setNameMenu( target.getNameMenu() );
        userMenuDTO.setSlugMenu( target.getSlugMenu() );

        return userMenuDTO;
    }

    @Override
    public UserMenuDTO toUserMenuDTO(Menu source) {
        if ( source == null ) {
            return null;
        }

        UserMenuDTO userMenuDTO = new UserMenuDTO();

        userMenuDTO.setIdMenu( source.getIdMenu() );
        userMenuDTO.setNameMenu( source.getNameMenu() );
        userMenuDTO.setSlugMenu( source.getSlugMenu() );
        userMenuDTO.setCategory( map( sourceCategoryValor( source ) ) );
        userMenuDTO.setIdCategory( source.getIdCategory() );

        return userMenuDTO;
    }

    protected RCatalogos categoryDTOToRCatalogos(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        RCatalogos rCatalogos = new RCatalogos();

        rCatalogos.setAlterno( categoryDTO.getAlterno() );
        rCatalogos.setAlternoA( categoryDTO.getAlternoA() );
        rCatalogos.setAlternoB( categoryDTO.getAlternoB() );
        rCatalogos.setCatPadre( categoryDTO.getCatPadre() );
        rCatalogos.setDescripcion( categoryDTO.getDescripcion() );
        rCatalogos.setGrupo( categoryDTO.getGrupo() );
        rCatalogos.setGrupoPadre( categoryDTO.getGrupoPadre() );
        rCatalogos.setIdCatalogo( categoryDTO.getIdCatalogo() );
        rCatalogos.setIdMh( categoryDTO.getIdMh() );
        rCatalogos.setIdMhPadre( categoryDTO.getIdMhPadre() );
        rCatalogos.setIdPadre( categoryDTO.getIdPadre() );
        rCatalogos.setSubGrupo( categoryDTO.getSubGrupo() );
        rCatalogos.setValor( categoryDTO.getValor() );

        return rCatalogos;
    }

    protected CategoryDTO rCatalogosToCategoryDTO(RCatalogos rCatalogos) {
        if ( rCatalogos == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setAlterno( rCatalogos.getAlterno() );
        categoryDTO.setAlternoA( rCatalogos.getAlternoA() );
        categoryDTO.setAlternoB( rCatalogos.getAlternoB() );
        categoryDTO.setCatPadre( rCatalogos.getCatPadre() );
        categoryDTO.setDescripcion( rCatalogos.getDescripcion() );
        categoryDTO.setGrupo( rCatalogos.getGrupo() );
        categoryDTO.setGrupoPadre( rCatalogos.getGrupoPadre() );
        categoryDTO.setIdCatalogo( rCatalogos.getIdCatalogo() );
        categoryDTO.setIdMh( rCatalogos.getIdMh() );
        categoryDTO.setIdMhPadre( rCatalogos.getIdMhPadre() );
        categoryDTO.setIdPadre( rCatalogos.getIdPadre() );
        categoryDTO.setSubGrupo( rCatalogos.getSubGrupo() );
        categoryDTO.setValor( rCatalogos.getValor() );

        return categoryDTO;
    }

    private String sourceCategoryValor(Menu menu) {
        if ( menu == null ) {
            return null;
        }
        RCatalogos category = menu.getCategory();
        if ( category == null ) {
            return null;
        }
        String valor = category.getValor();
        if ( valor == null ) {
            return null;
        }
        return valor;
    }
}
