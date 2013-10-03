package com.wojciecholech.mvc.controller;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.wojciecholech.mvc.domain.Payment;
import com.wojciecholech.mvc.repository.PaymentDAO;

/**
 * @author woj.olech@gmail.com
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@WebAppConfiguration
public class PaymentControllerIT {

	@Autowired
    private WebApplicationContext wac;
	
	@Autowired
	private PaymentDAO paymentDAO;
	
	private MockMvc mockMvc;
	
	@Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
	
	public void tearDown() {
		paymentDAO.deleteAll();
	}
	
	@Test
	public void shouldCreate() throws Exception {
		mockMvc.perform(get("/payment/create"))
				  .andExpect(status().isOk())
				  .andExpect(view().name("payment/new"));
	}
	
	@Test
	public void shouldSave() throws Exception {
		  mockMvc.perform(post("/payment/save")
				  .param("firstName", "John")
				  .param("lastName", "Doe")
				  .param("email", "john.doe@gmail.com")
				  .param("amount", "300"))
				  .andExpect(view().name("redirect:list"));
		  
		  List<Payment> payments = paymentDAO.findAll();
		  assertThat(payments, hasSize(1));
	}
	
	@Test
	public void shouldList() throws Exception {
		//given
		paymentDAO.save(new Payment("John", "Doe", "john.doe@gmail.com", new BigDecimal(300)));
		
		mockMvc.perform(get("/payment/list"))
				.andExpect(status().isOk())
				.andExpect(view().name("payment/list"))
				.andExpect(model().attributeExists("payments"));
	}
	
	
}
