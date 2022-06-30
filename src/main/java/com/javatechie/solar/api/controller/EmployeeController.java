package com.javatechie.solar.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.solar.api.model.Employee;
import com.javatechie.solar.api.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;

	@PostConstruct
	public void addEmployees() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(376, "Antonio", " ", " ", " ", " ", " "));
		employees.add(new Employee(377, "Fernando", " ", " ", " ", " ", " "));
		employees.add(new Employee(378, "Pilar", " ", " ", " ", " ", " "));
		repository.saveAll(employees);
	}

	@GetMapping("/getTodos")
	public Iterable<Employee> getEmployees() {
		return repository.findAll();
	}

	@GetMapping("/getEmpleado/{nombre}")
	public Employee getEmployeeByName(@PathVariable String nombre) {
		return repository.findByName(nombre);
	}
	
	@RequestMapping("/delete")
	 public String deleteAllDocuments() {
	     try { //delete all documents from solr core
	    	 repository.deleteAll();
	      return "documents deleted succesfully!";
	     }catch (Exception e){
	       return "Failed to delete documents";
	     }
	 }
	
	 @GetMapping("/deleteId/{numEmpleado}")
	 public String deleteDocument(@PathVariable String numEmpleado) {
	     try { 
	    	 repository.deleteById(Integer.parseInt(numEmpleado));
	      return "document deleted succesfully!";
	     }catch (Exception e){
	       return "Failed to delete document";
	     }
	 }
	

}
