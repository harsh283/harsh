package com.capg.greatoutdoor.greatoutdoormanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.greatoutdoor.greatoutdoormanagement.model.ProductMaster;
import com.capg.greatoutdoor.greatoutdoormanagement.model.User;
import com.capg.greatoutdoor.greatoutdoormanagement.service.IGreatOutdoorService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IGreatOutdoorService service;
@PostMapping("/registeraproductmaster")
public ProductMaster registerProductMaster(@RequestBody ProductMaster master)
{
	return service.registerProductMaster(master);
}
@DeleteMapping("/deleteuser/{userId}")
public boolean deleteAddress(@PathVariable String userId)
{
	return service.deleteUser(userId);
}
@GetMapping("/getallusers")
public List<User> getAllUsers()
{
	return service.getAllUsers();
}
}
