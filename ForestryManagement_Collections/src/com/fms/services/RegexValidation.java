package com.fms.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidation 
{
	Pattern pattern;
	Matcher matcher;
	public boolean integerRegEx(String value)
	{
		Pattern pattern = Pattern.compile("\\d+"); 
		Matcher matcher = pattern.matcher(value);
		boolean b = matcher.matches();
		return b;


	}

	public boolean stringRegEx(String value)
	{
		pattern = Pattern.compile("[A-Za-z]{1,25}\\s[A-Za-z]{1,25}");
		matcher = pattern.matcher(value);
		boolean b = matcher.matches();
		return b;
	}

	public boolean emailRegEx(String value)
	{
		pattern = Pattern.compile("\\w+\\@\\w+\\.\\w+");
		matcher = pattern.matcher(value);
		boolean b = matcher.matches();
		return b;
	}

}
