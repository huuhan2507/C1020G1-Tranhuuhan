package com.example.repository;


import com.example.entity.login.User;
import com.example.entity.login.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findByUser(User user);

    UserRole findUserRoleByUser(User user);
}
