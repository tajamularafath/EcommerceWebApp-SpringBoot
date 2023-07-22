package com.qci.ecommercewebapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qci.ecommercewebapp.Model.Category;
@Repository
public interface CatalogRepo extends JpaRepository<Category, Integer> {

}
