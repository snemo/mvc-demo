package com.wojciecholech.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wojciecholech.mvc.domain.Payment;
import com.wojciecholech.mvc.repository.PaymentDAO;

/**
 * @author woj.olech@gmail.com
 *
 */
@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDAO paymentDAO;
	
	@Override
	@Transactional
	public Payment create(Payment payment) {		
		return paymentDAO.save(payment);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Payment> getAllPayments() {
		return paymentDAO.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Payment get(Long id) {
		return paymentDAO.get(id);
	}
	
	@Override
	public void problem() {
		throw new RuntimeException("Some business error!");
	}
}
