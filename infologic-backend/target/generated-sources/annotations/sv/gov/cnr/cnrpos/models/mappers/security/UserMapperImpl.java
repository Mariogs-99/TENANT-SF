package sv.gov.cnr.cnrpos.models.mappers.security;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sv.gov.cnr.cnrpos.models.dto.UserDTO;
import sv.gov.cnr.cnrpos.models.security.User;
import sv.gov.cnr.cnrpos.models.security.User.UserBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-31T09:14:19-0600",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250325-2231, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl extends UserMapper {

    @Override
    public User toEntity(UserDTO source) {
        if ( source == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.carnet( source.getCarnet() );
        user.docNumber( source.getDocNumber() );
        user.docType( source.getDocType() );
        user.email( source.getEmail() );
        user.firstname( source.getFirstname() );
        user.idBranch( source.getIdBranch() );
        user.idCompany( source.getIdCompany() );
        user.idPosition( source.getIdPosition() );
        user.idUser( source.getIdUser() );
        user.isActive( source.getIsActive() );
        user.lastname( source.getLastname() );
        user.password( source.getPassword() );
        user.phone( source.getPhone() );
        List<Long> list = source.getRolIds();
        if ( list != null ) {
            user.rolIds( new ArrayList<Long>( list ) );
        }
        user.testMode( source.getTestMode() );
        user.tipo( source.getTipo() );
        user.usuario( source.getUsuario() );

        return user.build();
    }

    @Override
    public UserDTO toDTO(User target) {
        if ( target == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setIdUser( target.getIdUser() );
        userDTO.setFirstname( target.getFirstname() );
        userDTO.setLastname( target.getLastname() );
        userDTO.setEmail( target.getEmail() );
        userDTO.setDocType( target.getDocType() );
        userDTO.setDocNumber( target.getDocNumber() );
        userDTO.setPhone( target.getPhone() );
        userDTO.setIsActive( target.getIsActive() );
        userDTO.setTestMode( target.getTestMode() );
        userDTO.setIdCompany( target.getIdCompany() );
        userDTO.setIdBranch( target.getIdBranch() );
        userDTO.setIdPosition( target.getIdPosition() );
        userDTO.setCarnet( target.getCarnet() );
        userDTO.setTipo( target.getTipo() );
        userDTO.setUsuario( target.getUsuario() );

        userDTO.setRolIds( target.getRoless() );

        return userDTO;
    }

    @Override
    public UserDTO toPageDTO(User target) {
        if ( target == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setIdUser( target.getIdUser() );
        userDTO.setFirstname( target.getFirstname() );
        userDTO.setLastname( target.getLastname() );
        userDTO.setCarnet( target.getCarnet() );
        userDTO.setUsuario( target.getUsuario() );
        userDTO.setEmail( target.getEmail() );
        userDTO.setIsActive( target.getIsActive() );
        userDTO.setTestMode( target.getTestMode() );
        userDTO.setTipo( target.getTipo() );

        return userDTO;
    }
}
