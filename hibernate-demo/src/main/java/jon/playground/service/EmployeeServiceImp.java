package jon.playground.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jon.playground.dao.EmployeeData;
import jon.playground.model.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeData employeeData;

	@Transactional
	@Override
	public List<Employee> get() {
		return employeeData.get();
	}

	@Transactional
	@Override
	public Employee get(int id) {
		return employeeData.get(id);
	}

	@Transactional
	@Override
	public void save(Employee e) {
		employeeData.save(e);
	}

	@Transactional
	@Override
	public void update(Employee e) {
		employeeData.update(e);
	}

	@Transactional
	@Override
	public void delete(int id) {
		employeeData.delete(id);
	}

}
