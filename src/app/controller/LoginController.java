package app.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import app.entity.UserInfo;
import app.logic.User;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/")
	public void index(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String path = request.getContextPath();
		response.sendRedirect(path + "/login");
	}
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request,Model model){
		return "user_login";
	}
	
	@RequestMapping(value = "/userLoginCheck")
	public void loginCheck(HttpServletRequest request,HttpServletResponse response) 
			throws IOException{
		
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		String path = request.getContextPath();
		
		if(phone.equals("") || pwd.equals("")){
			response.sendRedirect(path + "/login?info=MissPhone");
		}
		
		User user = new User();
		
		if(user.checkUserLogin(phone, pwd)){
			UserInfo userInfo = user.userLogin(phone, pwd);
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(86400);
			session.setAttribute("userid", userInfo.getId());
			session.setAttribute("userphone", phone);
			session.setAttribute("usertype", userInfo.getType());
			if(userInfo.getType() == 0){
				response.sendRedirect(path + "/user_passenger");
			}else{
				response.sendRedirect(path + "/user_driver");
			}
		}
		else{
			response.sendRedirect(path + "/login?info=Error");
		}
		
	}
	
	@RequestMapping(value="/user_loginout")
	public void loginOut(HttpServletRequest request,HttpServletResponse response) 
			throws IOException{
		String path = request.getContextPath();
		HttpSession session = request.getSession();
		
		session.removeAttribute("userid");
		session.invalidate();
		
		response.sendRedirect(path + "/login");
	}
}
