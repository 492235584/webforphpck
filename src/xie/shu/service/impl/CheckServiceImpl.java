package xie.shu.service.impl;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import manage.Service;
import xie.shu.mapper.HistoryMapper;
import xie.shu.po.History;
//import manage.Service;
import xie.shu.service.CheckService;

public class CheckServiceImpl implements CheckService{

	@Autowired
	private HistoryMapper historyMaqqer;
	
	//处理文件，并插入一条history记录
	@Override
	public void docheck(String inputPath, String outputPath, History history) {
		//创建保存的文件夹
		File doc = new File(outputPath);
		doc.mkdir();
		//调用phpcheck接口处理
		Service checkservice = new Service();
		try {
			System.out.println("-----------------------------------------------------------------");
			checkservice.checkFile(inputPath, outputPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			//发生错误直接停止程序运行
			return;
		}
		
		//将新处理的数据插入history表
		historyMaqqer.insert(history);
		
	}
	
}
