package com.misumi.service.internal_trainserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PageController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "first_page";
	}

	@RequestMapping(value = "/first_page", method = RequestMethod.GET)
	public String login() {
		return "first_page";
	}
}
