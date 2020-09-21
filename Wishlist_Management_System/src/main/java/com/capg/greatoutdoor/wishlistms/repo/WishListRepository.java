package com.capg.greatoutdoor.wishlistms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.greatoutdoor.wishlistms.model.WishList;

public interface WishListRepository extends JpaRepository<WishList, String> {

}
