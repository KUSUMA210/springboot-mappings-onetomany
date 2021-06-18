package com.otsi.mappings.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.otsi.mappings.model.User;
import com.otsi.mappings.service.ServiceClass;

@RestController
public class ControllerClass {

	@Autowired
	private ServiceClass serviceClass;

	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User userData = serviceClass.addUser(user);
		return new ResponseEntity<>(userData, HttpStatus.OK);
	}

	@GetMapping("/get-user-role")
	public List<User> getAllUsers() {
		return serviceClass.getUser();
	}

	@PutMapping("/updateuser")
	public User updateUser(@RequestBody User user) throws Exception {
		return serviceClass.updateUserById(user);

	}

	@PatchMapping("/upuser/{id}")
	public User upUser(@PathVariable Long id, @RequestBody User user) throws Exception {
		return serviceClass.upUserById(id, user);

	}

	@DeleteMapping("/deleteuser")
	public String deleteUser(@RequestParam("id") Long id) {
		return serviceClass.removeUser(id);

	}

	@GetMapping("/getAllUsersAndRoles/{name}")
	public List<User> getAllUsersAndRoles(@PathVariable String name) {
		return serviceClass.getAllUsersAndRoles(name);
	}

	@GetMapping("/getAllUsersAndRolesById/{roleId}")
	public List<User> getAllUsersAndRoles(@PathVariable Long roleId) {
		return serviceClass.getAllUsersAndRolesById(roleId);

	}
	
	@DeleteMapping
	public String deleteUserById(@RequestParam Long roleId) {
		serviceClass.deleteUser(roleId);
		return "Delete Employee Data success fully";
	}

	
}
