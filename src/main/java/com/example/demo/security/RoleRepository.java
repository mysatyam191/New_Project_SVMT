package com.example.demo.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(
            value = "SELECT * FROM Role where id NOT IN (SELECT role_id from user_role WHERE user_id = ?1)",
            nativeQuery = true
    )
    List<Role> getUserNotRoles(Integer userId);

}
