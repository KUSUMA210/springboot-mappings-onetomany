package com.otsi.mappings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.otsi.mappings.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}