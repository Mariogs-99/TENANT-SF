package com.globalsolutions.registro.repository;

import com.globalsolutions.registro.model.MasterCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterCompanyRepository extends JpaRepository<MasterCompany, Long> {
    boolean existsByNit(String nit);
}
