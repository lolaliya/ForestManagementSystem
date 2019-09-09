package com.fms.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExValidation 
{
	Pattern pattern;
	Matcher matcher;

	// \\d+ matches the digits
	public boolean integerRegEx(String value)
	{
		Pattern pattern = Pattern.compile("\\d+"); 
		Matcher matcher = pattern.matcher(value);
		boolean b = matcher.matches();
		return b;


	}


	public boolean stringRegEx(String value)
	{ 
		boolean b = false; 
		Pattern pattern = Pattern.compile("^[A-Za-z]*$");
		Matcher matcher = pattern.matcher(value);
		 b = matcher.matches();
		return b;
	}



	public boolean emailRegEx(String value)
	{
		Pattern pattern = Pattern.compile("\\w+\\@\\w+\\.\\w+");
       Matcher matcher = pattern.matcher(value);
		boolean b = matcher.matches();
		return b;
	}

}
