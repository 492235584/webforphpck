package xie.shu.service;

import xie.shu.po.History;

public interface CheckService {
	void docheck(String inputPath, String outputPath, History history);
}
