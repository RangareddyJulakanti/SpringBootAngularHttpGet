package com.rangareddy.restful.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.rangareddy.restful.model.Student;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rangareddy.restful.model.Customer;

@RestController
@RequestMapping(value="/api")
public class WebController {

	private Map<Integer, Customer> customers = new HashMap<Integer, Customer>(){

		{
	        put(1, new Customer(1, "Raj", "Kiran", 24));
	        put(2, new Customer(2, "Ranga", "Reddy", 30));
	        put(3, new Customer(3, "Hari", "Krishna", 31));
	    }
	};
	private Map<Integer, Student> studentMap = new HashMap<Integer, Student>(){

		{
			put(1, new Student("1","Ranga"));
			put(2, new Student("2","Raju"));
			put(3, new Student("3","Chiru"));
		}
	};
	
	@GetMapping(value="/customer",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getCustomers(){
		List<Customer> results = customers.entrySet().stream()
									.map(entry ->entry.getValue())
									.collect(Collectors.toList());
		return results;
	}
	@GetMapping(value="/student",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getStudents(){
		List<Student> results = studentMap.entrySet().stream()
				.map(entry ->entry.getValue())
				.collect(Collectors.toList());
		return results;
	}
}