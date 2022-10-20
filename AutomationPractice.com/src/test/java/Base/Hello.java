package Base;

import org.apache.commons.lang3.text.translate.NumericEntityEscaper;

public class Hello {

	public static void main(String[] args) {
		//99,95,91
		System.out.println("prog started");
		int count=1;
		for(int i=100;i>0;i--)
		{
			if(!(i%2==0) )
			{
				if(count==1)
				{
				System.out.println("numer is :"+i);
				count++;
				}
				else {
					count=1;
			}
			
			}
		}

	}

}
