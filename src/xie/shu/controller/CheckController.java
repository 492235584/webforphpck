package xie.shu.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import xie.shu.po.History;
import xie.shu.service.CheckService;

@Controller
public class CheckController {
	
	@Autowired
	private CheckService checkService;
	//处理上传文件
	@RequestMapping("/docheck.action")
	public String checkUploadFile(MultipartFile checkfile, HttpSession session)throws Exception{
		
		//进行文件上传
		if(checkfile!=null && checkfile.getOriginalFilename()!=null && checkfile.getOriginalFilename().length()>0){
			//指定文件保存位置
			Calendar rightNow = Calendar.getInstance();//getInstance返回一个Calendar对象，并由当前时间初始化
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");    //日期格式化格式
			String date = format.format(rightNow.getTime()); //取得当前时间，并格式化成相应格式   
			SimpleDateFormat sformat = new SimpleDateFormat("yyyyMMddhhmmss");    //日期格式化格式
			String sdate = sformat.format(rightNow.getTime()); //取得当前时间，并格式化成相应格式   
			String filePath = "E:\\phpcheckfile\\upload\\" + date;
			String downloadPath = "E:\\phpcheckfile\\download\\" + date;
			//上传文件原始名称
			String originalFilename = checkfile.getOriginalFilename();
			//指定要保存的文件
			File doc = new File(filePath);
			doc.mkdir();//创建文件夹
			//上传文件的全限定名
			String phpFilePath = filePath+"//"+originalFilename;
			//处理后文件的全限定名（提供下载）
			String txtFilePath = downloadPath+"//"+originalFilename.replace(".php", ".txt");
			//将内存中的文件写入磁盘
			File file = new File(phpFilePath);
			checkfile.transferTo(file);
			//产生一条history ---add1.1
			History history = new History();
			history.setUserId((int)session.getAttribute("userId"));
			history.setName((String)session.getAttribute("name"));
			history.setPath(txtFilePath);
			history.setCreatetime(sformat.parse(sdate));
			//调用service处理上传的文件 ---change1.1
			checkService.docheck(phpFilePath, txtFilePath, history);
		}
		
		return "checkpage.jsp";
	}
	
	@RequestMapping("/download.action")  
	public void download(HttpServletResponse res) throws IOException {  
	    OutputStream os = res.getOutputStream();  
	    try {  
	        res.reset();  
	        res.setHeader("Content-Disposition", "attachment; filename=dict.txt");  
	        res.setContentType("application/octet-stream; charset=utf-8");  
	        os.write(FileUtils.readFileToByteArray(new File("D:\\left.txt")));  
	        os.flush();  
	    } finally {  
	        if (os != null) {  
	            os.close();  
	        }  
	    }  
	}  
}
