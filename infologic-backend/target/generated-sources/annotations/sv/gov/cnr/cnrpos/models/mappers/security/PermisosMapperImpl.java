package sv.gov.cnr.cnrpos.models.mappers.security;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sv.gov.cnr.cnrpos.entities.MenuItems;
import sv.gov.cnr.cnrpos.models.dto.MenuItemsDTO;
import sv.gov.cnr.cnrpos.models.dto.PermissionDTO;
import sv.gov.cnr.cnrpos.models.security.Permission;
import sv.gov.cnr.cnrpos.models.security.Rol;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-31T09:14:18-0600",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250325-2231, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class PermisosMapperImpl extends PermisosMapper {

    @Override
    public Permission toEntity(PermissionDTO source) {
        if ( source == null ) {
            return null;
        }

        Permission permission = new Permission();

        permission.setCreatedAt( source.getCreatedAt() );
        permission.setDeletedAt( source.getDeletedAt() );
        permission.setDescriptionPermissions( source.getDescriptionPermissions() );
        permission.setIdPermissions( source.getIdPermissions() );
        permission.setImagePermissions( source.getImagePermissions() );
        permission.setMenuItems( menuItemsDTOSetToMenuItemsSet( source.getMenuItems() ) );
        permission.setMethodPermissions( source.getMethodPermissions() );
        permission.setNamePermissions( source.getNamePermissions() );
        Set<Rol> set1 = source.getRoles();
        if ( set1 != null ) {
            permission.setRoles( new HashSet<Rol>( set1 ) );
        }
        permission.setSlugPermissions( source.getSlugPermissions() );
        permission.setUpdatedAt( source.getUpdatedAt() );
        permission.setUriPermissions( source.getUriPermissions() );

        return permission;
    }

    @Override
    public PermissionDTO toDtoList(Permission target) {
        if ( target == null ) {
            return null;
        }

        PermissionDTO permissionDTO = new PermissionDTO();

        permissionDTO.setIdPermissions( target.getIdPermissions() );
        permissionDTO.setNamePermissions( target.getNamePermissions() );
        permissionDTO.setDescriptionPermissions( target.getDescriptionPermissions() );
        permissionDTO.setMenuItems( menuItemsSetToMenuItemsDTOSet( target.getMenuItems() ) );
        permissionDTO.setImagePermissions( target.getImagePermissions() );
        permissionDTO.setMethodPermissions( target.getMethodPermissions() );
        Set<Rol> set1 = target.getRoles();
        if ( set1 != null ) {
            permissionDTO.setRoles( new HashSet<Rol>( set1 ) );
        }
        permissionDTO.setSlugPermissions( target.getSlugPermissions() );
        permissionDTO.setUriPermissions( target.getUriPermissions() );

        return permissionDTO;
    }

    @Override
    public MenuItemsDTO toMenuItemsDTO(MenuItems target) {
        if ( target == null ) {
            return null;
        }

        MenuItemsDTO menuItemsDTO = new MenuItemsDTO();

        menuItemsDTO.setIdMenuItems( target.getIdMenuItems() );
        menuItemsDTO.setUriMenuItems( target.getUriMenuItems() );
        menuItemsDTO.setType( target.getType() );

        return menuItemsDTO;
    }

    @Override
    public PermissionDTO toDto(Permission target) {
        if ( target == null ) {
            return null;
        }

        PermissionDTO permissionDTO = new PermissionDTO();

        permissionDTO.setIdPermissions( target.getIdPermissions() );
        permissionDTO.setNamePermissions( target.getNamePermissions() );
        permissionDTO.setDescriptionPermissions( target.getDescriptionPermissions() );
        permissionDTO.setMenuItems( menuItemsSetToMenuItemsDTOSet1( target.getMenuItems() ) );
        permissionDTO.setImagePermissions( target.getImagePermissions() );
        permissionDTO.setMethodPermissions( target.getMethodPermissions() );
        permissionDTO.setSlugPermissions( target.getSlugPermissions() );
        permissionDTO.setUriPermissions( target.getUriPermissions() );

        return permissionDTO;
    }

    @Override
    public MenuItemsDTO toMenuItemDTO(MenuItems target) {
        if ( target == null ) {
            return null;
        }

        MenuItemsDTO menuItemsDTO = new MenuItemsDTO();

        menuItemsDTO.setIdMenuItems( target.getIdMenuItems() );
        menuItemsDTO.setIdMenu( target.getIdMenu() );
        menuItemsDTO.setNameMenuItems( target.getNameMenuItems() );
        menuItemsDTO.setType( target.getType() );

        return menuItemsDTO;
    }

    protected MenuItems menuItemsDTOToMenuItems(MenuItemsDTO menuItemsDTO) {
        if ( menuItemsDTO == null ) {
            return null;
        }

        MenuItems menuItems = new MenuItems();

        menuItems.setCreatedAt( menuItemsDTO.getCreatedAt() );
        menuItems.setDeletedAt( menuItemsDTO.getDeletedAt() );
        menuItems.setDescriptionMenuItems( menuItemsDTO.getDescriptionMenuItems() );
        menuItems.setIdMenu( menuItemsDTO.getIdMenu() );
        menuItems.setIdMenuItems( menuItemsDTO.getIdMenuItems() );
        menuItems.setImageMenuItems( menuItemsDTO.getImageMenuItems() );
        menuItems.setNameMenuItems( menuItemsDTO.getNameMenuItems() );
        menuItems.setType( menuItemsDTO.getType() );
        menuItems.setUpdatedAt( menuItemsDTO.getUpdatedAt() );
        menuItems.setUriMenuItems( menuItemsDTO.getUriMenuItems() );

        return menuItems;
    }

    protected Set<MenuItems> menuItemsDTOSetToMenuItemsSet(Set<MenuItemsDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<MenuItems> set1 = new HashSet<MenuItems>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( MenuItemsDTO menuItemsDTO : set ) {
            set1.add( menuItemsDTOToMenuItems( menuItemsDTO ) );
        }

        return set1;
    }

    protected Set<MenuItemsDTO> menuItemsSetToMenuItemsDTOSet(Set<MenuItems> set) {
        if ( set == null ) {
            return null;
        }

        Set<MenuItemsDTO> set1 = new HashSet<MenuItemsDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( MenuItems menuItems : set ) {
            set1.add( toMenuItemsDTO( menuItems ) );
        }

        return set1;
    }

    protected Set<MenuItemsDTO> menuItemsSetToMenuItemsDTOSet1(Set<MenuItems> set) {
        if ( set == null ) {
            return null;
        }

        Set<MenuItemsDTO> set1 = new HashSet<MenuItemsDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( MenuItems menuItems : set ) {
            set1.add( toMenuItemDTO( menuItems ) );
        }

        return set1;
    }
}
