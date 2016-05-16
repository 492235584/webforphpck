package xie.shu.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import xie.shu.po.History;
import xie.shu.service.CheckService;
import xie.shu.util.CreateUUID;
import xie.shu.util.ZipUtil;

@Controller
@RequestMapping("/check")
public class CheckController {

	@Autowired
	private CheckService checkService;

	// 处理上传文件
	@RequestMapping("/docheck.action")
	public void checkUploadFile(MultipartFile checkfile, HttpSession session)
			throws Exception {

		// 进行文件上传
		if (checkfile != null && checkfile.getOriginalFilename() != null
				&& checkfile.getOriginalFilename().length() > 0) {
			// 指定文件保存位置
			Calendar rightNow = Calendar.getInstance();// getInstance返回一个Calendar对象，并由当前时间初始化
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd"); // 日期格式化格式
			String date = format.format(rightNow.getTime()); // 取得当前时间，并格式化成相应格式
			SimpleDateFormat sformat = new SimpleDateFormat("yyyyMMddhhmmss"); // 日期格式化格式
			String sdate = sformat.format(rightNow.getTime()); // 取得当前时间，并格式化成相应格式
			String filePath = "E:\\phpcheckfile\\upload\\" + date;
			String downloadPath = "E:\\phpcheckfile\\download\\" + date;
			// 上传文件原始名称
			String originalFilename = checkfile.getOriginalFilename();
			// 创建上传的文件夹
			File updoc = new File(filePath);
			if(!updoc.exists()){
				updoc.mkdir();
			}
			// 创建保存的文件夹
			File downdoc = new File(downloadPath);
			if(!downdoc.exists()){
				downdoc.mkdir();
			}
			// 上传文件的全限定名
			String uuid = CreateUUID.createShort();
			String phpFilePath = filePath + "\\" + uuid + originalFilename;
			// 处理后文件的全限定名（提供下载）
			String txtFilePath = downloadPath + "\\"
					+ uuid + originalFilename.replace(".php", ".txt");
			// 将内存中的文件写入磁盘
			File file = new File(phpFilePath);
			checkfile.transferTo(file);
			// 产生一条history ---add1.1
			History history = new History();
			history.setUserId((int) session.getAttribute("userId"));
			history.setName(originalFilename);
			history.setPath(txtFilePath);
			history.setCreatetime(sformat.parse(sdate));
			// 调用service处理上传的文件 ---change1.1 
			checkService.docheck(phpFilePath, txtFilePath, history);
		}
	}
	
	// 下载  @RequestBody byte[]bytes获取请求体
	@RequestMapping("/download.action")
	public void download(HttpServletResponse response, String filename, String checkfiles) throws IOException {
		//将得到的字符串切分为数组
		System.out.println("---------------"+checkfiles);
		String[] mycheckfiles = checkfiles.split(",");
		//设置压缩路径
		String zipPath = "E:\\phpcheckfile\\cache\\" + CreateUUID.createLong() + ".zip";
		//压缩文件
		ZipUtil.zipFiles(mycheckfiles, zipPath);
		//下载
		InputStream in = null;
		OutputStream out = null;
		try {
			out = response.getOutputStream();
			File zip = new File(zipPath);
			//要下载的文件流
			response.setHeader("Content-Disposition", "attachment; filename="+zipPath);  
	        response.setContentType("application/octet-stream; charset=utf-8");  
	        out.write(FileUtils.readFileToByteArray(zip)); 
			out.flush();
		} finally {
			if(in != null){
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

	@RequestMapping("/showlist.action")
	public String showDownloadList(HttpServletRequest request, int pagenum,
			HttpSession session) throws IOException {
		// 获取初始页面行数
		int num = (pagenum - 1) * 5;
		List<History> list = new ArrayList<History>();
		//获取userid
		int userId = (Integer) session.getAttribute("userId");
		// 从数据库取出数据
		list = checkService.showList(num, userId);
		// 记录总行数量
		int count = checkService.getCount(userId);
		request.setAttribute("list", list);
		request.setAttribute("count", count);

		return "checkpage";
	}
	
	
}
