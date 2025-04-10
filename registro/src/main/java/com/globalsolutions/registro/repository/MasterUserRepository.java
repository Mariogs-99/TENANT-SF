package com.globalsolutions.registro.repository;

import com.globalsolutions.registro.model.MasterUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterUserRepository extends JpaRepository<MasterUser, Long> {
    boolean existsByUsuario(String usuario);
}
