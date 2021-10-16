package com.codemonkeys.carmechanicbackend.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.codemonkeys.carmechanicbackend.admin.model.Admin;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String>{

}
