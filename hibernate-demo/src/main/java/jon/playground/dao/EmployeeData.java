package jon.playground.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import jon.playground.model.Employee;

public class EmployeeData {
	
	@Autowired
	private EntityManager manager;

	@Transactional
	public List<Employee> get() {
		Session session = manager.unwrap(Session.class);
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		return query.getResultList();
	}

	@Transactional
	public Employee get(int id) {
		Session session = manager.unwrap(Session.class);
		Employee e = session.get(Employee.class, id);
		return e;
	}

	@Transactional
	public void save(Employee e) {
		Session session = manager.unwrap(Session.class);
		session.save(e);
	}

	@Transactional
	public void update(Employee e) {
		Session session = manager.unwrap(Session.class);
		session.update(e);
	}
	
	@Transactional
	public void delete(int id) {
		Session session = manager.unwrap(Session.class);
		Employee e = session.get(Employee.class, id);
		session.delete(e);
	}
	

}
