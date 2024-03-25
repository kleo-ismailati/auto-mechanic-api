package com.auto_mechanic.auto_mechanic_api.v1.repositories;

import com.auto_mechanic.auto_mechanic_api.v1.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
