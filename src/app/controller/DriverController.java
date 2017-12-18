package app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DriverController {

	@RequestMapping(value = "/user_driver")
	public String userPassenger(HttpServletRequest request,Model model){
		
		
		
		
		return "user_driver";
	}
	
	
}
