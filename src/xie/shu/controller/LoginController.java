package xie.shu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xie.shu.po.History;
import xie.shu.po.User;
import xie.shu.service.CheckService;
import xie.shu.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private CheckService checkService;

	//用户登入
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
			session.setAttribute("department", u.getDepartment());
		}else{
			//登入失败
			response.getWriter()
			.write("0");
		}
		
	}

	@RequestMapping("/logout.action")
	public String login(HttpSession session) throws Exception {
		session.invalidate();
		return "checkpage";
	}
	
	//页面初始显示
	@RequestMapping("/loginshow.action")
	public String loginShow(HttpServletRequest request,HttpSession session) throws Exception {
		//默认显示前五条信息
		List<History> list = new ArrayList<History>();
		//获取userid
		int userId = (Integer)session.getAttribute("userId");
		list = checkService.showList(0, userId);
		//从session中取出userid查询数据库
		int count = checkService.getCount(userId);
		//记录总行数
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		
		return "checkpage";
		
	}
	
	//用户注册
	@RequestMapping("/register.action")
	public String register(HttpSession session, User user){
		//插入并返回插入后的数据（包括自增字段和默认字段）
		User u = loginService.register(user);
		//保存session
		session.setAttribute("userId", u.getUserId());
		session.setAttribute("name", u.getName());
		session.setAttribute("department", u.getDepartment());
		
		return "forward:/login/loginshow.action";
	}
	
}
