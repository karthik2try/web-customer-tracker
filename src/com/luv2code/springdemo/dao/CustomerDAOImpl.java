package com.luv2code.springdemo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Customer order by lastName");
		
		List<Customer> customersList = query.getResultList();
		
		return customersList;
	}

	@Override
	public void addCustomer(Customer customer) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Customer cust = session.get(Customer.class, id);
		
		return cust;
	}

	@Override
	public void deleteCustomer(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query qry = session.createQuery("delete from Customer where id = "+id);
		
		qry.executeUpdate();
	}
	
}
