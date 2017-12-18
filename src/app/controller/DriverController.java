package app.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import app.entity.TripInfo;
import app.logic.PublishTrip;

@Controller
public class DriverController {

	@RequestMapping(value = "/user_driver")
	public String userDriver(HttpServletRequest request,Model model){
		
		PublishTrip p = new PublishTrip();
		ArrayList<TripInfo> allTripOrders = p.serachNyacTripOrder(1);
		model.addAttribute("allTripOrders",allTripOrders);
		
		return "user_driver";
	}
	
	@RequestMapping(value = "/user_driver_wallet")
	public String userDriverWallet(HttpServletRequest request,Model model){

		return "user_driver_wallet";
	}
	
	@RequestMapping(value = "/user_driver_me")
	public String userDriverMe(HttpServletRequest request,Model model){

		return "user_driver_me";
	}
	
}
