package genericLibrary;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils {
	public int getRandomnum(int range)
	{
		Random ran=new Random();
		int rannum = ran.nextInt(range);
		return rannum;
	}
	public String getsysDate()
	{
		Date da = new Date();
		String date = da.toString();
		return date;
	}
	public String getSysDateformat()
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date da=new Date();
		String date = dateformat.format(da);
		return date;
	}

}
