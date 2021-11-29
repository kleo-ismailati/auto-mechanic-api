package com.codemonkeys.carmechanicbackend.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codemonkeys.carmechanicbackend.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
