package com.wojciecholech.mvc.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wojciecholech.mvc.domain.Payment;
import com.wojciecholech.mvc.repository.PaymentDAO;
import com.wojciecholech.mvc.service.PaymentService;

/**
 * @author woj.olech@gmail.com
 *
 */
@Controller
@RequestMapping(value="/payment")
public class PaymentController {
	
	private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping("/create")
	public String create() {
		LOG.info("create");
		return "payment/new";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@Valid Payment payment) {
		LOG.info("save({})", payment);
		paymentService.create(payment);
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		LOG.info("list()");
		model.addAttribute("payments", paymentService.getAllPayments());
		return "payment/list";
	}
	
	@RequestMapping("/show/{id}")
	public String show(@PathVariable Long id, Model model) {
		LOG.info("show({})", id);
		model.addAttribute("payment", paymentService.get(id));
		return "payment/show";
	}
	
	@RequestMapping("/problem")
	public String problem() {
		LOG.info("problem");
		paymentService.problem();
		return "payment/problem";
	}

}
