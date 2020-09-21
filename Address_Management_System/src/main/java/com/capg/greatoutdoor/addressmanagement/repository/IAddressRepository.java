package com.capg.greatoutdoor.addressmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.greatoutdoor.addressmanagement.model.Address;

public interface IAddressRepository extends JpaRepository<Address, String> {

}
