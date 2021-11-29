package com.codemonkeys.carmechanicbackend.user.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codemonkeys.carmechanicbackend.user.admin.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

}
