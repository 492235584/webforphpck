package xie.shu.service.impl;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import manage.Service;

import org.springframework.beans.factory.annotation.Autowired;

import xie.shu.mapper.HistoryMapper;
import xie.shu.po.History;
import xie.shu.po.HistoryExample;
//import manage.Service;
import xie.shu.service.CheckService;

public class CheckServiceImpl implements CheckService{

	@Autowired
	private HistoryMapper historyMaqqer;
	
	//处理文件，并插入一条history记录
	@Override
	public void docheck(String inputPath, String outputPath, History history) {
	
		//调用phpcheck接口处理
		Service checkservice = new Service();
		try {
			checkservice.checkFile(inputPath, outputPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			//发生错误直接停止程序运行
			return;
		}
		
		//将新处理的数据插入history表
		historyMaqqer.insert(history);
		
	}

	@Override
	public List<History> showList(int num, int userId) {
		//存储信息的list
		List<History> list = new ArrayList<History>();
		//查询
		list = historyMaqqer.selectbylimitnum(num, userId);
		System.out.println("------------------------------------");
		System.out.println(list.size());
		
		return list;
	}

	@Override
	//根据userId获得条目总数
	public int getCount(int userId) {
		
		HistoryExample example = new HistoryExample();
		example.or()
		.andUserIdEqualTo(userId);
		int count = historyMaqqer.countByExample(example);
		
		return count;
	}
	
	
	
}
