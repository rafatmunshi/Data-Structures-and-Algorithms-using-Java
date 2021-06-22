package ds;

import java.util.Stack;

public class StringRotated {
//clockwise- skilllync illlyncsk
//anticlockwise- skilllync ncskillly

	static boolean isRotated(String str1, String str2, int n) {
		if(str1.length()!=str2.length())
			return false;
		int len=str2.length();
		String clockRot=str2.substring(n)+str2.substring(0, n);
		String anticlockRot=str2.substring(len-n, len)+str2.substring(0, len-n);
		
		return(str1.equals(clockRot) || str1.equals(anticlockRot));				
	}
	public static void main(String []args)
	{
		String str1="skilllync";
		String str2="yncskilll";
		int n=3;
		System.out.println(isRotated(str1,str2, n)?"Yes":"No");		
		}
	}

