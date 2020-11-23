package com.mejia.springboot.cruddemo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mejia.springboot.cruddemo.dao.EmployeeRepository;
import com.mejia.springboot.cruddemo.entity.Employee;
import com.mejia.springboot.cruddemo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		this.employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> finAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findEmployee(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		}else {
			throw new RuntimeException("No se encontro el empleado: " + theId);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);

	}

	@Override
	public void delete(int theId) {
		employeeRepository.deleteById(theId);

	}

}
