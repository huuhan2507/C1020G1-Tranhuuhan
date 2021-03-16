package com.example.repository;


import com.example.entity.login.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
}
