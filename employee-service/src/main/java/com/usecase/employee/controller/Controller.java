package com.usecase.employee.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.employee.model.Employee;
import com.usecase.employee.service.EmployeeService;
import com.usecase.employee.service.impl.IEmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class Controller {
	
    @Autowired
    private IEmployeeServiceImpl service;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return this.service.addEmployee(employee);
    }
    
    @GetMapping("/employeeId/{id}")
	public ResponseEntity<Employee> findById(@PathVariable("id") Long id) {
    	
    	Employee employee=service.findById(id);
    	
    		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
    	
	}
	
	@GetMapping("/allEmployee")
	public List<Employee> findAllEmployee() {
//		LOGGER.info("Employee find");
		return service.findAllEmployee();
	}
	
	@GetMapping("/department/{departmentId}")
	public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId) {
//		LOGGER.info("Employee find: departmentId={}", departmentId);
		return service.findByDepartment(departmentId);
	}
	
	@GetMapping("/organization/{organizationId}")
	public List<Employee> findByOrganization(@PathVariable("organizationId") Long organizationId) {
//		LOGGER.info("Employee find: organizationId={}", organizationId);
		return service.findByOrganization(organizationId);
	}
	
	@DeleteMapping("/delete/{deleteId}")
	public String deleteById(@PathVariable("deleteId") Long deleteId) {
		
		return service.deleteById(deleteId);
	}
	
	@DeleteMapping("/deleteAll")
	public String deleteAllEmployee() {
		service.deleteAllEmployee();
		return "All Employees has been deleted";
	}
	
	@PutMapping("update/{employeeId}")
	public Employee updateEmployee(@PathVariable("employeeId") Long employeeId, @RequestBody Employee employee) {
		return service.updateEmployee(employeeId,employee);
	}
}