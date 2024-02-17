package com.employee.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.EmployeeEntity;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService empservice;

	@PostMapping("/com/saveEmployee")
	public EmployeeEntity addemployee(@RequestBody EmployeeEntity emp) {
		return empservice.saveEmployee(emp);
	}

	@GetMapping("/com/getEmployee/{id}")
	public Optional<EmployeeEntity> getEmployee(@PathVariable Integer id) {
		return empservice.getEmployee(id);
	}

	@DeleteMapping("/com/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		empservice.deleteById(id);
		return "Deleted Employee Data";
	}

	@PutMapping("/com/updateEmployee")
	public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity emp) {
		return empservice.updateEmployee(emp);
	}
}
