
package com.wojciecholech.mvc.repository;

import java.util.List;

import com.wojciecholech.mvc.domain.Payment;

/**
 * @author woj.olech@gmail.com
 *
 */
public interface PaymentDAO {
	
	Payment save(Payment payment);
	
	Payment get(Long id);
	
	List<Payment> findAll();
	
	void deleteAll();
}
