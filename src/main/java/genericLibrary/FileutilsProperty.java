package genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileutilsProperty {
	public String readDatafromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.Filepath);
		Properties pobj=new Properties();
		pobj.load(fis);
		String Key = pobj.getProperty(key);
		return Key;
				
	}

}
