 package com.java.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidation 
{
	public boolean integerRegEx(String value)
	{
		boolean valid = false;
		Pattern pat = Pattern.compile("\\d+");
		Matcher mat = pat.matcher(value);
		valid = mat.matches();
		return valid;	
	}

	public boolean stringRegEx(String value)
	{
		boolean valid = false;
		Pattern pat = Pattern.compile("^[A-Za-z]*$");
		Matcher mat = pat.matcher(value);
		valid = mat.matches();
		return valid;

	}

	public boolean emailRegEx(String value) {
		boolean valid = false;
		Pattern pat = Pattern.compile("\\w+\\@\\w+\\.\\w+");
		Matcher mat = pat.matcher(value);
		valid = mat.matches();
		return valid;
	}
	
	public boolean passwordRegEx(String value)
	{
		boolean valid = false;
		if(value.length()<4|| value.length()>8)
			return valid;
		Pattern pat = Pattern.compile("\\S+");
		Matcher mat = pat.matcher(value);
		valid = mat.matches();
		return valid;
	}
	
	public boolean telephoneRegEx(String value) {
		boolean valid = false;
		if(value.length()<10 || value.length()>10)
			return valid;
		Pattern pat = Pattern.compile("\\d+");
		Matcher mat = pat.matcher(value);
		valid = mat.matches();
		return valid;
	}

}
