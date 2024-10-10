package com.example.lab7gtics20202396.Repositories;

import com.example.lab7gtics20202396.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
