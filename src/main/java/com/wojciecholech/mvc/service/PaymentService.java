package com.wojciecholech.mvc.service;

import java.util.List;

import com.wojciecholech.mvc.domain.Payment;

/**
 * @author woj.olech@gmail.com
 *
 */
public interface PaymentService {

	Payment create(Payment payment);
	
	List<Payment> getAllPayments();
	
	Payment get(Long id);
	
	void problem();
}
