package Base;

public class SeperationOfChars {

	public static void main(String[] args) 
	{
		String str="987654321sandeep";
		String even="";
		String odd="";
		String name="";

		for(int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);
			if(Character.isDigit(ch))
			{
				int x=Integer.parseInt(Character.toString(ch));
				if(x%2==0)
				{
					even=even+Character.toString(ch);
				}
				else
					odd=odd+Character.toString(ch);
			}
			else
			{
				name=name+Character.toString(ch);
			}



		}

	}

}
