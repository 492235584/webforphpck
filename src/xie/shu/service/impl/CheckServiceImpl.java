package xie.shu.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import manage.Service;
//import manage.Service;
import xie.shu.service.CheckService;

public class CheckServiceImpl implements CheckService{

	@Override
	public void docheck(String inputPath, String outputPath) {
		//创建保存的文件夹
		File doc = new File(outputPath);
		doc.mkdir();
		//调用接口处理
		Service checkservice = new Service();
		try {
			System.out.println("-----------------------------------------------------------------");
			checkservice.checkDirectory(inputPath, outputPath, 1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
}
