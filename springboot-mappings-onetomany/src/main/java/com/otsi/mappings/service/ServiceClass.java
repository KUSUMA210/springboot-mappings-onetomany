package com.otsi.mappings.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.otsi.mappings.model.User;

public interface ServiceClass {

	User addUser(User user);

	List<User> getUser();

	User updateUserById(User user) throws Exception;

	String removeUser(long id);

	User upUserById(Long id, User user) throws Exception;

	List<User> getAllUsersAndRoles(String name);

	List<User> getAllUsersAndRolesById(Long roleId);
	
	void deleteUser(Long roleId);
}
