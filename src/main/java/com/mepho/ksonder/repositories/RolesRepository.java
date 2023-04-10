package com.mepho.ksonder.repositories;

import com.mepho.ksonder.models.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Long> {

    //Roles findByName(String role);
    //boolean existsByName(String name);

}
