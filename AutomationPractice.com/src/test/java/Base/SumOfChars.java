package Base;

public class SumOfChars {

	public static void main(String[] args) 
	{
		  String s="123456";
	       int count=0;
	       for(int i=0;i<s.length();i++)
	       {
	           char ch=s.charAt(i);
	           count=count+Integer.parseInt(Character.toString(ch));
	           
	       }
	       System.out.println("Sum is "+count);
	       

	}

}
