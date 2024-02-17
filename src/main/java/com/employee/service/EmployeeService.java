package com.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.EmployeeEntity;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository emprepo;

	public EmployeeEntity saveEmployee(EmployeeEntity emp) {
		return emprepo.save(emp);

	}

	public Optional<EmployeeEntity> getEmployee(Integer id) {
		return emprepo.findById(id);
	}

	public void deleteById(Integer id) {
		emprepo.deleteById(id);
	}

	public EmployeeEntity updateEmployee(EmployeeEntity emp) {
		EmployeeEntity existingEmployee = emprepo.findById(emp.getId()).orElse(null);
		existingEmployee.setId(emp.getId());
		existingEmployee.setName(emp.getName());
		existingEmployee.setLocation(emp.getLocation());
		return emprepo.save(existingEmployee);
	}
}
