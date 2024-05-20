package com.example.crud;

import com.example.crud.model.Permission;
import com.example.crud.model.Role;
import com.example.crud.model.User;
import com.example.crud.repository.PermissionRepository;
import com.example.crud.repository.RoleRepository;
import com.example.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public void run(String... args) {
        // Create permissions
        Permission perm1 = new Permission();
        perm1.setName("user_view");
        Permission perm2 = new Permission();
        perm2.setName("user_edit");
        // Save permissions
        permissionRepository.save(perm1);
        permissionRepository.save(perm2);

        // Create roles and assign permissions
        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        adminRole.setPermissions(new HashSet<>(permissionRepository.findAll()));

        Role userRole = new Role();
        userRole.setName("ROLE_USER");
        Set<Permission> userPermissions = new HashSet<>();
        userPermissions.add(perm1); // Add specific permissions for user role
        userRole.setPermissions(userPermissions);

        roleRepository.save(adminRole);
        roleRepository.save(userRole);

        // Create user and assign roles
        User adminUser = new User();
        adminUser.setUsername("admin");
        adminUser.setPassword("admin");
        adminUser.setEmail("admin@example.com");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRoles(adminRoles);

        userRepository.save(adminUser);
    }
}
