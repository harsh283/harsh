package com.capg.greatoutdoor.productms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.greatoutdoor.productms.model.ProductMaster;

public interface IProductMasterRepository extends JpaRepository<ProductMaster, String> {

}
