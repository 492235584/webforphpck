package xie.shu.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/txt")
public class ShowTXTController {
	@RequestMapping("/show.action")
	public void showTXT(HttpServletResponse response, String filepath) throws IOException {
		System.out.println(filepath);
		File file = new File(filepath);
		BufferedReader buf = new BufferedReader(new FileReader(file));
		StringBuilder txt = new StringBuilder();
		String cacheString = null;
		try{
			while ((cacheString = buf.readLine()) != null) {
				txt.append(cacheString);
			}
		}finally{
			if(buf != null){
				buf.close();
			}
		}
		//设置编码后发送
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(txt.toString());

	}
}
