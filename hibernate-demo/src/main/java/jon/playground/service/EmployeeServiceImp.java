package jon.playground.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jon.playground.model.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private EntityManager manager;

	@Transactional
	@Override
	public List<Employee> get() {
		Session session = manager.unwrap(Session.class);
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		return query.getResultList();
	}

	@Transactional
	@Override
	public Employee get(int id) {
		Session session = manager.unwrap(Session.class);
		Employee e = session.get(Employee.class, id);
		return e;
	}

	@Transactional
	@Override
	public void save(Employee e) {
		Session session = manager.unwrap(Session.class);
		session.save(e);
	}

	@Transactional
	@Override
	public void delete(int id) {
		Session session = manager.unwrap(Session.class);
		Employee e = session.get(Employee.class, id);
		session.delete(e);
	}
	
	@Transactional
	@Override
	public void update(Employee e) {
		Session session = manager.unwrap(Session.class);
		session.update(e);
	}

}
