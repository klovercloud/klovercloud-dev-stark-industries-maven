package com.starkindustries.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.starkindustries.data.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, String>{

}
