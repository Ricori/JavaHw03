package app.controller;

import java.io.IOException;
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
public class DriverController {

	@RequestMapping(value = "/user_driver")
	public String userDriver(HttpServletRequest request,Model model){
		HttpSession seesion = request.getSession();
		Integer userid = (Integer) seesion.getAttribute("userid");
		
		//可接单行程
		PublishTrip p = new PublishTrip();
		ArrayList<TripInfo> nyacTripOrders = p.serachNyacTripOrder(1);
		model.addAttribute("nyacTripOrders",nyacTripOrders);
		
		//进行中行程
		OrderTrip o = new OrderTrip();
		ArrayList<TripOrderInfo> tripingOrders = o.searchTripingOrder(userid,1);
		model.addAttribute("tripingOrders",tripingOrders);
		
		//已完成行程
		ArrayList<TripOrderInfo> endTripOrders = o.serachEndTripOrder(userid,1,1);
		model.addAttribute("endTripOrders",endTripOrders);
		
		return "user_driver";
	}
	
	@RequestMapping(value = "/user_driver_wallet")
	public String userDriverWallet(HttpServletRequest request,Model model){
		Integer userid = (Integer) request.getSession().getAttribute("userid");
		Pay pay = new Pay();
		ArrayList<PayInfo> payInfos = pay.searchDriverPay(userid);
		model.addAttribute("payInfos",payInfos);
		return "user_driver_wallet";
	}
	
	@RequestMapping(value = "/user_driver_me")
	public String userDriverMe(HttpServletRequest request,Model model){
		Integer userid = (Integer) request.getSession().getAttribute("userid");
		User u = new User();
		UserInfo user = u.getUser(userid);
		model.addAttribute("user",user);
		return "user_driver_me";
	}
	
	//司机确认接单
	@RequestMapping(value= "/user_driver_confirmpulishTrip")
	public void userDriverConfirmstart(HttpServletRequest request,HttpServletResponse response) 
			throws IOException{
		
		String idParameterString = request.getParameter("id");
		if(idParameterString == null || idParameterString.equals("")){
			response.sendRedirect(request.getContextPath() + "/user_driver");
			return;
		}
		HttpSession session = request.getSession();
		
		int publishid = Integer.parseInt(idParameterString);
		
		PublishTrip p = new PublishTrip();
		int driverid = (Integer)session.getAttribute("userid");
		p.setPulishDriverid(publishid, driverid);
		TripInfo tripInfo = p.getTripInfo(publishid);
		OrderTrip o = new OrderTrip();
		o.confirmPulishTrip(tripInfo);
		
		response.sendRedirect(request.getContextPath() + "/user_driver");
	}
	
	//司机确认到达约定地点
	@RequestMapping(value= "/user_driver_confirmstart")
	public void userPassengerConfirmstart(HttpServletRequest request,HttpServletResponse response) 
			throws IOException {
		String idParameterString = request.getParameter("id");
		if(idParameterString == null || idParameterString.equals("")){
			response.sendRedirect(request.getContextPath() + "/user_driver");
			return;
		}
		int tripid = Integer.parseInt(idParameterString);
		Integer driverid = (Integer) request.getSession().getAttribute("userid");
		OrderTrip o = new OrderTrip();
		o.driverConfirmstart(tripid, driverid);
		
		response.sendRedirect(request.getContextPath() + "/user_driver");
	}
	
	//司机确认到达目的地
	@RequestMapping(value= "/user_driver_confirmend")
	public void userPassengerConfirmend(HttpServletRequest request,HttpServletResponse response) 
			throws IOException {
		String idParameterString = request.getParameter("id");
		if(idParameterString == null || idParameterString.equals("")){
			response.sendRedirect(request.getContextPath() + "/user_driver");
			return;
		}
		int tripid = Integer.parseInt(idParameterString);
		Integer driverid = (Integer) request.getSession().getAttribute("userid");
		OrderTrip o = new OrderTrip();
		o.driverConfirmend(tripid, driverid);
		
		response.sendRedirect(request.getContextPath() + "/user_driver");
	}
}
