package app.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import app.entity.PayInfo;
import app.entity.TripInfo;
import app.entity.TripOrderInfo;
import app.entity.UserInfo;
import app.logic.OrderTrip;
import app.logic.Pay;
import app.logic.PublishTrip;
import app.logic.User;

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
		ArrayList<TripOrderInfo> tripingOrders = o.searchTripingOrder(userid,0);
		model.addAttribute("tripingOrders",tripingOrders);
		
		//发布中行程
		PublishTrip p = new PublishTrip(); 
		ArrayList<TripInfo> allPublishTrips = p.serachPublishTrip(userid);
		model.addAttribute("allPublishTrips",allPublishTrips);
		
		//已完成行程
		ArrayList<TripOrderInfo> endTripOrders = o.serachEndTripOrder(userid,0,1);
		model.addAttribute("endTripOrders",endTripOrders);
		
		return "user_passenger_trip";
	}
	
	@RequestMapping(value = "/user_passenger_wallet")
	public String userPassengerWallet(HttpServletRequest request,Model model){
		Integer userid = (Integer) request.getSession().getAttribute("userid");
		Pay pay = new Pay();
		ArrayList<PayInfo> payInfos = pay.searchPassengerPay(userid);
		model.addAttribute("payInfos",payInfos);
		return "user_passenger_wallet";
	}
	
	@RequestMapping(value = "/user_passenger_me")
	public String userPassengerMe(HttpServletRequest request,Model model){
		Integer userid = (Integer) request.getSession().getAttribute("userid");
		User u = new User();
		UserInfo user = u.getUser(userid);
		model.addAttribute("user",user);
		return "user_passenger_me";
	}
	
	//发布行程
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
	
	//乘客确认到达出发地
	@RequestMapping(value= "/user_passenger_confirmstart")
	public void userPassengerConfirmstart(HttpServletRequest request,HttpServletResponse response) 
			throws IOException {
		String idParameterString = request.getParameter("id");
		if(idParameterString == null || idParameterString.equals("")){
			response.sendRedirect(request.getContextPath() + "/user_passenger_tripinfo");
			return;
		}
		int tripid = Integer.parseInt(idParameterString);
		
		Integer userid = (Integer) request.getSession().getAttribute("userid");
		
		OrderTrip o = new OrderTrip();
		o.passengerConfirmstart(tripid, userid);
		
		response.sendRedirect(request.getContextPath() + "/user_passenger_tripinfo");
	}
	
	//乘客确认到达目的地
	@RequestMapping(value= "/user_passenger_confirmend")
	public void userPassengerConfirmend(HttpServletRequest request,HttpServletResponse response) 
			throws IOException {
		String idParameterString = request.getParameter("id");
		if(idParameterString == null || idParameterString.equals("")){
			response.sendRedirect(request.getContextPath() + "/user_passenger_tripinfo");
			return;
		}
		int tripid = Integer.parseInt(idParameterString);
		
		Pay p = new Pay();
		OrderTrip o = new OrderTrip();
		
		TripOrderInfo tripOrder = o.getTripOrder(tripid);
		double price = tripOrder.getPrice();
		int passengerid = tripOrder.getPassenger();
		int driverid = tripOrder.getDriver();
		
		int payid = p.passengerPay(tripid, passengerid, driverid, price);
		o.passengerConfirmend(tripid, passengerid, payid);
		
		response.sendRedirect(request.getContextPath() + "/user_passenger_tripinfo");
	}

}
