// src/main/java/com/example/crud/repository/RoleRepository.java
package com.example.crud.repository;

import com.example.crud.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
