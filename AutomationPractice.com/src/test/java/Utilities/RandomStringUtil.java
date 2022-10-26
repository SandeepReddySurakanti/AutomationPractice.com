package Utilities;

import net.bytebuddy.utility.RandomString;

public class RandomStringUtil
{
	public static String getRandomString(int count)
	{
		String string=RandomString.make(count);
		return string;
		
	}
	

}
