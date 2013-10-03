package com.wojciecholech.mvc.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wojciecholech.mvc.domain.Payment;

/**
 * @author woj.olech@gmail.com
 *
 */
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class PaymentDAOImpl implements PaymentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Payment save(Payment payment) {
		getCurrentSession().persist(payment);
		return payment;
	}
	
	@Override
	public List<Payment> findAll() {
		Query query = getCurrentSession().getNamedQuery("Payment.findAll");
        return query.list();
	}
	
	@Override
	public Payment get(Long id) {
		return (Payment)getCurrentSession().get(Payment.class, id);
	}
	
	@Override
	public void deleteAll() {
		Query query = getCurrentSession().getNamedQuery("Payment.deleteAll");
		query.executeUpdate();		
	}
	
	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
}
