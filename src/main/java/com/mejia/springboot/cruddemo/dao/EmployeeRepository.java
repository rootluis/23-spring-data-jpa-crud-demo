package com.mejia.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mejia.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
