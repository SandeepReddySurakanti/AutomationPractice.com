package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.PublicKey;
import java.util.Properties;

import com.github.dockerjava.api.command.PullImageCmd;

public class ConfigUtil 
{
	static Properties properties;
	static FileInputStream  fileInputStream ;
	
	static{
		try {
			fileInputStream=new FileInputStream("./config.properties");
			properties=new Properties();
			properties.load(fileInputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	public static String getBaseURL()
	{
		System.out.println("base url is : -->"+properties.getProperty("baseurl"));
		return properties.getProperty("baseurl");
	}
	public static String getBowser()
	{
		System.out.println("base browser is : -->"+properties.getProperty("browser"));

		return properties.getProperty("browser");
	}

}
