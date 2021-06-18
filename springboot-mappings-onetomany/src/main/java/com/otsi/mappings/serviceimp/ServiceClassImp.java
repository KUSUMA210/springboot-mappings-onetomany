package com.otsi.mappings.serviceimp;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.otsi.mappings.model.Role;
import com.otsi.mappings.model.User;
import com.otsi.mappings.repository.RoleRepository;
import com.otsi.mappings.repository.UserRepository;
import com.otsi.mappings.service.ServiceClass;

@Service
public class ServiceClassImp implements ServiceClass {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;

	public User addUser(User user) {
		Role roleData = roleRepository.findById(user.getRole().getRoleId()).orElse(null);
		if (null == roleData) {
			roleData = new Role();
			// roleData.setId(user.getRole().getId());
			roleData.setDescription(user.getRole().getDescription());
			roleData.setName(user.getRole().getName());
			roleRepository.save(roleData);
		}
		user.setRole(roleData);
		return userRepository.save(user);
	}

	public List<User> getUser() {
		return userRepository.findAll();
	}

	@Override
	public User updateUserById(User user) throws Exception {
		// Optional<User> userData = userRepository.findById(user.getId());
		Optional<Role> roleData = roleRepository.findById(user.getRole().getRoleId());
		if (!roleData.isPresent()) {
			throw new Exception("Invalid  role id : " + user.getRole().getRoleId());
		}
		User userinfo = new User();
		Role roleinfo = new Role();
		userinfo.setUserId(user.getUserId());
		userinfo.setFirstName(user.getFirstName());
		userinfo.setLastName(user.getLastName());
		userinfo.setMobile(user.getMobile());
		roleinfo.setName(user.getRole().getName());
		roleinfo.setRoleId(user.getRole().getRoleId());
		roleinfo.setDescription(user.getRole().getDescription());
		roleRepository.save(roleinfo);
		userinfo.setRole(roleinfo);
		return userRepository.save(userinfo);
	}

	@Override
	public String removeUser(long id) {
		userRepository.deleteById(id);
		return "record deleted successfully";

	}

	@Override
	public User upUserById(Long id, User user) throws Exception {
		Optional<Role> roleData = roleRepository.findById(id);
		if (!roleData.isPresent()) {
			throw new Exception("Invalid  role id : " + user.getRole().getRoleId());
		}
		user.setRole(roleData.get());
		return userRepository.saveAndFlush(user);
	}

	@Override
	public List<User> getAllUsersAndRoles(String name) {
		return userRepository.getAllUsersAndRolesByName(name);
	}

	@Override
	public List<User> getAllUsersAndRolesById(Long roleId) {
		return userRepository.getAllUsersAndRolesById(roleId);
	}

	@Override
	public void deleteUser(Long roleId) {
		userRepository.deleteUser(roleId);
		
	}

	
	
	
}
