package sv.gov.cnr.cnrpos.models.mappers.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sv.gov.cnr.cnrpos.entities.MenuItems;
import sv.gov.cnr.cnrpos.models.dto.MenuItemsDTO;
import sv.gov.cnr.cnrpos.models.dto.PermissionDTO;
import sv.gov.cnr.cnrpos.models.dto.RolDTO;
import sv.gov.cnr.cnrpos.models.security.Permission;
import sv.gov.cnr.cnrpos.models.security.Rol;
import sv.gov.cnr.cnrpos.models.security.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-31T09:14:18-0600",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250325-2231, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class RolMapperImpl extends RolMapper {

    @Override
    public Rol toEntity(RolDTO source) {
        if ( source == null ) {
            return null;
        }

        Rol rol = new Rol();

        rol.setCreatedAt( source.getCreatedAt() );
        rol.setDeletedAt( source.getDeletedAt() );
        rol.setDescriptionRole( source.getDescriptionRole() );
        rol.setIdRole( source.getIdRole() );
        rol.setNameRole( source.getNameRole() );
        rol.setPermission( permissionDTOSetToPermissionSet( source.getPermission() ) );
        List<Long> list = source.getPermissionIds();
        if ( list != null ) {
            rol.setPermissionIds( new ArrayList<Long>( list ) );
        }
        rol.setUpdatedAt( source.getUpdatedAt() );
        Set<User> set1 = source.getUser();
        if ( set1 != null ) {
            rol.setUser( new HashSet<User>( set1 ) );
        }

        return rol;
    }

    @Override
    public RolDTO toDto(Rol target) {
        if ( target == null ) {
            return null;
        }

        RolDTO rolDTO = new RolDTO();

        rolDTO.setIdRole( target.getIdRole() );
        rolDTO.setNameRole( target.getNameRole() );
        rolDTO.setDescriptionRole( target.getDescriptionRole() );
        List<Long> list = target.getPermissionIds();
        if ( list != null ) {
            rolDTO.setPermissionIds( new ArrayList<Long>( list ) );
        }
        rolDTO.setPermission( permissionSetToPermissionDTOSet( target.getPermission() ) );

        return rolDTO;
    }

    @Override
    public PermissionDTO toDtoPermission(Permission permission) {
        if ( permission == null ) {
            return null;
        }

        PermissionDTO permissionDTO = new PermissionDTO();

        permissionDTO.setIdPermissions( permission.getIdPermissions() );
        permissionDTO.setNamePermissions( permission.getNamePermissions() );
        permissionDTO.setDescriptionPermissions( permission.getDescriptionPermissions() );
        permissionDTO.setImagePermissions( permission.getImagePermissions() );
        permissionDTO.setMethodPermissions( permission.getMethodPermissions() );
        permissionDTO.setSlugPermissions( permission.getSlugPermissions() );
        permissionDTO.setUriPermissions( permission.getUriPermissions() );

        return permissionDTO;
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

    protected Permission permissionDTOToPermission(PermissionDTO permissionDTO) {
        if ( permissionDTO == null ) {
            return null;
        }

        Permission permission = new Permission();

        permission.setCreatedAt( permissionDTO.getCreatedAt() );
        permission.setDeletedAt( permissionDTO.getDeletedAt() );
        permission.setDescriptionPermissions( permissionDTO.getDescriptionPermissions() );
        permission.setIdPermissions( permissionDTO.getIdPermissions() );
        permission.setImagePermissions( permissionDTO.getImagePermissions() );
        permission.setMenuItems( menuItemsDTOSetToMenuItemsSet( permissionDTO.getMenuItems() ) );
        permission.setMethodPermissions( permissionDTO.getMethodPermissions() );
        permission.setNamePermissions( permissionDTO.getNamePermissions() );
        Set<Rol> set1 = permissionDTO.getRoles();
        if ( set1 != null ) {
            permission.setRoles( new HashSet<Rol>( set1 ) );
        }
        permission.setSlugPermissions( permissionDTO.getSlugPermissions() );
        permission.setUpdatedAt( permissionDTO.getUpdatedAt() );
        permission.setUriPermissions( permissionDTO.getUriPermissions() );

        return permission;
    }

    protected Set<Permission> permissionDTOSetToPermissionSet(Set<PermissionDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Permission> set1 = new HashSet<Permission>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PermissionDTO permissionDTO : set ) {
            set1.add( permissionDTOToPermission( permissionDTO ) );
        }

        return set1;
    }

    protected Set<PermissionDTO> permissionSetToPermissionDTOSet(Set<Permission> set) {
        if ( set == null ) {
            return null;
        }

        Set<PermissionDTO> set1 = new HashSet<PermissionDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Permission permission : set ) {
            set1.add( toDtoPermission( permission ) );
        }

        return set1;
    }
}
