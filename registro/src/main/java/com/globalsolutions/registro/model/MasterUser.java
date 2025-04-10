package com.globalsolutions.registro.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "master_user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MasterUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String usuario;

    @Column(nullable = false)
    private String clave;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private MasterCompany company;
}
