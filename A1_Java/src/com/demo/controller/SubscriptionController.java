package com.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SubscriptionController {
	
	@RequestMapping(value="/subscribe",method=RequestMethod.GET)

	public String subscribe(HttpServletRequest request) {
		
		String orderDetails = new OrderDetails().getOrderDetails(request );
		String truncatedOrderDetails = Operations.truncate(orderDetails, 250);
		Logging.log(truncatedOrderDetails);
		return "result";

	}
}
