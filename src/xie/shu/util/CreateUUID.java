package xie.shu.util;

import java.util.UUID;

//生成uuid，取前10个
public class CreateUUID {
	static public String createShort(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString().substring(0, 10) + "---";
	}
	static public String createLong(){
		UUID uuid = UUID.randomUUID();
		return "--"+uuid.toString();
	}
}
