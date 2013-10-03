package com.wojciecholech.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author woj.olech@gmail.com
 *
 */
@ControllerAdvice
public class DemoControllerAdvice {

	private static final Logger LOG = LoggerFactory.getLogger(DemoControllerAdvice.class);
	
	@ExceptionHandler(RuntimeException.class)
    public ModelAndView handleClientException(final Exception exception) {
		LOG.error("Error occurred:", exception);
        return new ModelAndView("error", "message", exception.getMessage());
    }
}
