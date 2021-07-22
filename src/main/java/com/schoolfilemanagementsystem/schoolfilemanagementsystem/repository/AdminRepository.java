package com.schoolfilemanagementsystem.schoolfilemanagementsystem.repository;

import com.schoolfilemanagementsystem.schoolfilemanagementsystem.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
}
