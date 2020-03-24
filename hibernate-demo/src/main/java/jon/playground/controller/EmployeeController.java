package jon.playground.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jon.playground.model.Employee;
import jon.playground.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/employees")
	public List<Employee> get() {
		return service.get();
	}
	
	@PostMapping("/employee")
	public Employee save(@RequestBody Employee e) {
		service.save(e);
		return e;
	}
	
	@GetMapping("/employee/{id}")
	public Employee get(@PathVariable int id) {
		Employee e = service.get(id);
		if(e == null)
			throw new RuntimeException(String.format("Employee with ID: %d does not exist", id));
		return e;
	}
	
	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable int id) {
		Employee e = service.get(id);
		if(e == null)
			return String.format("Employee with ID: %d does not exist", id);
		service.delete(id);
		return String.format("Employee with ID: %d has been deleted", id);
	}
	
	@PutMapping("/employee")
	public Employee update(@RequestBody Employee e) {
		service.update(e);
		return e;
	}
}
