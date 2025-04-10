package sv.gov.cnr.cnrpos.models.mappers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sv.gov.cnr.cnrpos.entities.Compra;
import sv.gov.cnr.cnrpos.entities.MenuItems;
import sv.gov.cnr.cnrpos.models.dto.CompraDTO;
import sv.gov.cnr.cnrpos.models.dto.MenuItemsDTO;
import sv.gov.cnr.cnrpos.models.dto.PermissionDTO;
import sv.gov.cnr.cnrpos.models.dto.RolDTO;
import sv.gov.cnr.cnrpos.models.dto.UserDTO;
import sv.gov.cnr.cnrpos.models.security.Permission;
import sv.gov.cnr.cnrpos.models.security.Rol;
import sv.gov.cnr.cnrpos.models.security.User;
import sv.gov.cnr.cnrpos.models.security.User.UserBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-31T09:14:17-0600",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250325-2231, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class CompraMapperImpl extends CompraMapper {

    @Override
    public Compra toEntity(CompraDTO source) {
        if ( source == null ) {
            return null;
        }

        Compra compra = new Compra();

        compra.setCodigoGeneracion( source.getCodigoGeneracion() );
        compra.setCreatedAt( source.getCreatedAt() );
        compra.setDeletedAt( source.getDeletedAt() );
        compra.setFechaEmision( source.getFechaEmision() );
        compra.setIdCompra( source.getIdCompra() );
        compra.setIdProveedor( source.getIdProveedor() );
        compra.setNumeroControl( source.getNumeroControl() );
        compra.setSelloRecepcion( source.getSelloRecepcion() );
        compra.setSucursal( source.getSucursal() );
        compra.setTipoDocumento( source.getTipoDocumento() );
        compra.setTipoOperacion( source.getTipoOperacion() );
        compra.setTotalExento( source.getTotalExento() );
        compra.setTotalGravado( source.getTotalGravado() );
        compra.setTotalOperacion( source.getTotalOperacion() );
        compra.setUpdatedAt( source.getUpdatedAt() );
        compra.setUser( userDTOToUser( source.getUser() ) );

        return compra;
    }

    @Override
    public CompraDTO toDtoList(Compra target) {
        if ( target == null ) {
            return null;
        }

        CompraDTO compraDTO = new CompraDTO();

        compraDTO.setIdCompra( target.getIdCompra() );
        compraDTO.setCodigoGeneracion( target.getCodigoGeneracion() );
        compraDTO.setNumeroControl( target.getNumeroControl() );
        compraDTO.setFechaEmision( target.getFechaEmision() );
        compraDTO.setTipoOperacion( target.getTipoOperacion() );
        compraDTO.setSelloRecepcion( target.getSelloRecepcion() );
        compraDTO.setIdProveedor( target.getIdProveedor() );
        compraDTO.setTotalGravado( target.getTotalGravado() );
        compraDTO.setTotalExento( target.getTotalExento() );
        compraDTO.setTotalOperacion( target.getTotalOperacion() );
        compraDTO.setTipoDocumento( target.getTipoDocumento() );

        return compraDTO;
    }

    @Override
    public CompraDTO toDto(Compra target) {
        if ( target == null ) {
            return null;
        }

        CompraDTO compraDTO = new CompraDTO();

        compraDTO.setIdCompra( target.getIdCompra() );
        compraDTO.setCodigoGeneracion( target.getCodigoGeneracion() );
        compraDTO.setNumeroControl( target.getNumeroControl() );
        compraDTO.setFechaEmision( target.getFechaEmision() );
        compraDTO.setTipoOperacion( target.getTipoOperacion() );
        compraDTO.setSelloRecepcion( target.getSelloRecepcion() );
        compraDTO.setIdProveedor( target.getIdProveedor() );
        compraDTO.setTotalGravado( target.getTotalGravado() );
        compraDTO.setTotalExento( target.getTotalExento() );
        compraDTO.setTotalOperacion( target.getTotalOperacion() );
        compraDTO.setUser( userToUserDTO( target.getUser() ) );
        compraDTO.setSucursal( target.getSucursal() );
        compraDTO.setTipoDocumento( target.getTipoDocumento() );

        return compraDTO;
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

    protected Rol rolDTOToRol(RolDTO rolDTO) {
        if ( rolDTO == null ) {
            return null;
        }

        Rol rol = new Rol();

        rol.setCreatedAt( rolDTO.getCreatedAt() );
        rol.setDeletedAt( rolDTO.getDeletedAt() );
        rol.setDescriptionRole( rolDTO.getDescriptionRole() );
        rol.setIdRole( rolDTO.getIdRole() );
        rol.setNameRole( rolDTO.getNameRole() );
        rol.setPermission( permissionDTOSetToPermissionSet( rolDTO.getPermission() ) );
        List<Long> list = rolDTO.getPermissionIds();
        if ( list != null ) {
            rol.setPermissionIds( new ArrayList<Long>( list ) );
        }
        rol.setUpdatedAt( rolDTO.getUpdatedAt() );
        Set<User> set1 = rolDTO.getUser();
        if ( set1 != null ) {
            rol.setUser( new HashSet<User>( set1 ) );
        }

        return rol;
    }

    protected Set<Rol> rolDTOSetToRolSet(Set<RolDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Rol> set1 = new HashSet<Rol>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RolDTO rolDTO : set ) {
            set1.add( rolDTOToRol( rolDTO ) );
        }

        return set1;
    }

    protected User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.carnet( userDTO.getCarnet() );
        user.docNumber( userDTO.getDocNumber() );
        user.docType( userDTO.getDocType() );
        user.email( userDTO.getEmail() );
        user.firstname( userDTO.getFirstname() );
        user.idBranch( userDTO.getIdBranch() );
        user.idCompany( userDTO.getIdCompany() );
        user.idPosition( userDTO.getIdPosition() );
        user.idUser( userDTO.getIdUser() );
        user.isActive( userDTO.getIsActive() );
        user.lastname( userDTO.getLastname() );
        user.password( userDTO.getPassword() );
        user.phone( userDTO.getPhone() );
        List<Long> list = userDTO.getRolIds();
        if ( list != null ) {
            user.rolIds( new ArrayList<Long>( list ) );
        }
        user.roles( rolDTOSetToRolSet( userDTO.getRoles() ) );
        user.testMode( userDTO.getTestMode() );
        user.tipo( userDTO.getTipo() );
        user.usuario( userDTO.getUsuario() );

        return user.build();
    }

    protected MenuItemsDTO menuItemsToMenuItemsDTO(MenuItems menuItems) {
        if ( menuItems == null ) {
            return null;
        }

        MenuItemsDTO menuItemsDTO = new MenuItemsDTO();

        menuItemsDTO.setCreatedAt( menuItems.getCreatedAt() );
        menuItemsDTO.setDeletedAt( menuItems.getDeletedAt() );
        menuItemsDTO.setDescriptionMenuItems( menuItems.getDescriptionMenuItems() );
        menuItemsDTO.setIdMenu( menuItems.getIdMenu() );
        menuItemsDTO.setIdMenuItems( menuItems.getIdMenuItems() );
        menuItemsDTO.setImageMenuItems( menuItems.getImageMenuItems() );
        menuItemsDTO.setNameMenuItems( menuItems.getNameMenuItems() );
        menuItemsDTO.setType( menuItems.getType() );
        menuItemsDTO.setUpdatedAt( menuItems.getUpdatedAt() );
        menuItemsDTO.setUriMenuItems( menuItems.getUriMenuItems() );

        return menuItemsDTO;
    }

    protected Set<MenuItemsDTO> menuItemsSetToMenuItemsDTOSet(Set<MenuItems> set) {
        if ( set == null ) {
            return null;
        }

        Set<MenuItemsDTO> set1 = new HashSet<MenuItemsDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( MenuItems menuItems : set ) {
            set1.add( menuItemsToMenuItemsDTO( menuItems ) );
        }

        return set1;
    }

    protected PermissionDTO permissionToPermissionDTO(Permission permission) {
        if ( permission == null ) {
            return null;
        }

        PermissionDTO permissionDTO = new PermissionDTO();

        permissionDTO.setCreatedAt( permission.getCreatedAt() );
        permissionDTO.setDeletedAt( permission.getDeletedAt() );
        permissionDTO.setDescriptionPermissions( permission.getDescriptionPermissions() );
        permissionDTO.setIdPermissions( permission.getIdPermissions() );
        permissionDTO.setImagePermissions( permission.getImagePermissions() );
        permissionDTO.setMenuItems( menuItemsSetToMenuItemsDTOSet( permission.getMenuItems() ) );
        permissionDTO.setMethodPermissions( permission.getMethodPermissions() );
        permissionDTO.setNamePermissions( permission.getNamePermissions() );
        Set<Rol> set1 = permission.getRoles();
        if ( set1 != null ) {
            permissionDTO.setRoles( new HashSet<Rol>( set1 ) );
        }
        permissionDTO.setSlugPermissions( permission.getSlugPermissions() );
        permissionDTO.setUpdatedAt( permission.getUpdatedAt() );
        permissionDTO.setUriPermissions( permission.getUriPermissions() );

        return permissionDTO;
    }

    protected Set<PermissionDTO> permissionSetToPermissionDTOSet(Set<Permission> set) {
        if ( set == null ) {
            return null;
        }

        Set<PermissionDTO> set1 = new HashSet<PermissionDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Permission permission : set ) {
            set1.add( permissionToPermissionDTO( permission ) );
        }

        return set1;
    }

    protected RolDTO rolToRolDTO(Rol rol) {
        if ( rol == null ) {
            return null;
        }

        RolDTO rolDTO = new RolDTO();

        rolDTO.setCreatedAt( rol.getCreatedAt() );
        rolDTO.setDeletedAt( rol.getDeletedAt() );
        rolDTO.setDescriptionRole( rol.getDescriptionRole() );
        rolDTO.setIdRole( rol.getIdRole() );
        rolDTO.setNameRole( rol.getNameRole() );
        rolDTO.setPermission( permissionSetToPermissionDTOSet( rol.getPermission() ) );
        List<Long> list = rol.getPermissionIds();
        if ( list != null ) {
            rolDTO.setPermissionIds( new ArrayList<Long>( list ) );
        }
        rolDTO.setUpdatedAt( rol.getUpdatedAt() );
        Set<User> set1 = rol.getUser();
        if ( set1 != null ) {
            rolDTO.setUser( new HashSet<User>( set1 ) );
        }

        return rolDTO;
    }

    protected Set<RolDTO> rolSetToRolDTOSet(Set<Rol> set) {
        if ( set == null ) {
            return null;
        }

        Set<RolDTO> set1 = new HashSet<RolDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Rol rol : set ) {
            set1.add( rolToRolDTO( rol ) );
        }

        return set1;
    }

    protected UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setCarnet( user.getCarnet() );
        userDTO.setDocNumber( user.getDocNumber() );
        userDTO.setDocType( user.getDocType() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setFirstname( user.getFirstname() );
        userDTO.setIdBranch( user.getIdBranch() );
        userDTO.setIdCompany( user.getIdCompany() );
        userDTO.setIdPosition( user.getIdPosition() );
        userDTO.setIdUser( user.getIdUser() );
        userDTO.setIsActive( user.getIsActive() );
        userDTO.setLastname( user.getLastname() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setPhone( user.getPhone() );
        List<Long> list = user.getRolIds();
        if ( list != null ) {
            userDTO.setRolIds( new ArrayList<Long>( list ) );
        }
        userDTO.setRoles( rolSetToRolDTOSet( user.getRoles() ) );
        userDTO.setTestMode( user.getTestMode() );
        userDTO.setTipo( user.getTipo() );
        userDTO.setUsuario( user.getUsuario() );

        return userDTO;
    }
}
