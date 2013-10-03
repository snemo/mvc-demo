package com.wojciecholech.mvc.controller;

import java.util.List;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wojciecholech.mvc.domain.Payment;
import com.wojciecholech.mvc.service.PaymentService;

/**
 * 
 * @author woj.olech@gmai.com
 *
 */
@Controller
@RequestMapping("/nsa")
public class NSAControlloer {

	private static final Logger LOG = LoggerFactory.getLogger(NSAControlloer.class);
	
	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(value="/payments", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Payment> payments() {
		LOG.info("payments()");
		return paymentService.getAllPayments();
	}
	
	@RequestMapping("/list")
	public String list() {
		LOG.info("list()");
		return "nsa/list";
	}
	
	@RequestMapping("/longpolling")
	public @ResponseBody Callable<String> longPolling() {
		return new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(3000);
				return "Message appears...";
			}
		};		
	}
}
