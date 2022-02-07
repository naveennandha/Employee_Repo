package com.example.demo.application.learning.dao;

import com.example.demo.application.learning.entity.EmpData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<EmpData, Integer> {
}
