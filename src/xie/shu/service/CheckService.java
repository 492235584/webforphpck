package xie.shu.service;

import java.util.List;

import xie.shu.po.History;

public interface CheckService {
	//执行代码检测并保存相应文件
	void docheck(String inputPath, String outputPath, History history);
	//获取最多5条信息
	List<History> showList(int num);
	//获取history总数
	int getCount(int userId);
}
