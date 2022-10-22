package core;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Config {
	
	private static Properties property;
	
	public static void loadProperty(String env) {
		try {
			String filePath =  System.getProperty("user.dir")+"//src//test//resources//config//config."+env.toLowerCase()+".properties";
			property = new Properties();
			property.load(new FileInputStream(new File(filePath)));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		if(property.containsKey(key)) {
			return property.getProperty(key);
		}
		return null;
	}
	

}
