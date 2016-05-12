package xie.shu.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xie.shu.po.User;
import xie.shu.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	//参数自动注入
	@RequestMapping("/login.action")
	public void login(Model model,User user, HttpServletResponse response, HttpSession session) throws Exception {
		//调用service
		User u = loginService.Login(user);
		//返回Ajax结果
		if(u != null){
			//成功
			response.getWriter()
			.write("1");
			//保存会话
			session.setAttribute("userId", u.getUserId());
			session.setAttribute("name", u.getName());
			System.out.println(u.getName());
			session.setAttribute("department", u.getDepartment());
		}else{
			//登入失败
			response.getWriter()
			.write("0");
		}
		
	}

	@RequestMapping("/logout.action")
	public String login() throws Exception {
		return null;
	}
	
}
