package com.qci.ecommercewebapp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qci.ecommercewebapp.Model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

    Optional<Admin> findByUsername(String username);

    Optional<Admin> findByPassword(String password);

}