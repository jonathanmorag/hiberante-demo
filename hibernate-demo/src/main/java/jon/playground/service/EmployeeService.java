package jon.playground.service;

import java.util.List;

import jon.playground.model.Employee;

public interface EmployeeService {
	List<Employee> get();
	Employee get(int id);
	void save(Employee e);
	void delete(int id);
	void update(Employee e);
}
