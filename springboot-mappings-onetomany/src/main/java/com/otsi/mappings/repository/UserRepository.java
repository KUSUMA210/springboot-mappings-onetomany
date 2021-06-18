package com.otsi.mappings.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.otsi.mappings.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query(value = "select u FROM User u  JOIN  u.role r where u.role.name=:name")
	List<User> getAllUsersAndRolesByName(@Param("name") String name);

	@Query(value = "select u FROM User u  JOIN  u.role r where u.role.roleId=:roleId")
	List<User> getAllUsersAndRolesById(@Param("roleId") Long roleId);
	
	@Modifying
	@Query("delete from User u where u.role.roleId = ?1")
	@Transactional
	void deleteUser(Long roleId);

}
