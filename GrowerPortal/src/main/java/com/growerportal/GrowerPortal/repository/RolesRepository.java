package com.growerportal.GrowerPortal.repository;

import com.growerportal.GrowerPortal.entity.Roles;
import com.growerportal.GrowerPortal.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
    Optional<Roles> findByName(ERole name);
}