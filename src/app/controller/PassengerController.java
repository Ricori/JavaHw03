package app.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import app.entity.TripInfo;
import app.entity.TripOrderInfo;
import app.logic.OrderTrip;
import app.logic.PublishTrip;

@Controller
public class PassengerController {

	@RequestMapping(value = "/user_passenger")
	public String userPassenger(HttpServletRequest request,Model model){
		return "user_passenger";
	}
	
	@RequestMapping(value = "/user_passenger_tripinfo")
	public String userPassengerTrip(HttpServletRequest request,Model model){
		HttpSession seesion = request.getSession();
		Integer userid = (Integer) seesion.getAttribute("userid");
		//进行中行程
		OrderTrip o = new OrderTrip();
		ArrayList<TripOrderInfo> tripingOrders = o.searchTripingOrder(userid);
		model.addAttribute("tripingOrders",tripingOrders);
		
		//发布中行程
		PublishTrip p = new PublishTrip(); 
		ArrayList<TripInfo> allPublishTrips = p.serachPublishTrip(userid);
		model.addAttribute("allPublishTrips",allPublishTrips);
		
		//已完成行程
		ArrayList<TripOrderInfo> endTripOrders = o.serachEndTripOrder(userid,1);
		model.addAttribute("endTripOrders",endTripOrders);
		
		return "user_passenger_trip";
	}
	
	@RequestMapping(value = "/user_passenger_wallet")
	public String userPassengerWallet(HttpServletRequest request,Model model){
		return "user_passenger_wallet";
	}
	
	@RequestMapping(value = "/user_passenger_me")
	public String userPassengerMe(HttpServletRequest request,Model model){
		return "user_passenger_me";
	}
	
	@RequestMapping(value = "/publishTrip")
	public String publishTrip(HttpServletRequest request,Model model){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		String splace = request.getParameter("splace");
		String eplace = request.getParameter("eplace");
		String stimed = request.getParameter("stimed");
		String stimehm = request.getParameter("stimehm");
		String people = request.getParameter("people");
		String price = request.getParameter("price");
		
		if(splace == null || eplace == null || stimed == null || 
			stimehm == null || people == null || price == null){
			model.addAttribute("success",0);
			return "user_publishok";
		}

		Timestamp starttime = Timestamp.valueOf(stimed + " " + stimehm + ":00");
		
		HttpSession seesion = request.getSession();
		Integer userid = (Integer) seesion.getAttribute("userid");
		
		TripInfo tripInfo = new TripInfo(userid,0,0,starttime,splace,
				eplace,Integer.parseInt(people),Double.parseDouble(price));
		
		PublishTrip publishTrip = new PublishTrip();
		try {
			if(publishTrip.addPublishTrip(tripInfo)){
				model.addAttribute("success",1);
				model.addAttribute("tripinfo",tripInfo);
				return "user_publishok";
			}else{
				model.addAttribute("success",0);
				return "user_publishok";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}

	}

}
