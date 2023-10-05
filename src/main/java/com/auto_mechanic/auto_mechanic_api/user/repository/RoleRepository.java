package com.auto_mechanic.auto_mechanic_api.user.repository;

import com.auto_mechanic.auto_mechanic_api.user.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
