package com.teamb.mth.util;

import java.io.UnsupportedEncodingException;

public class CheckDataBytes 
{
	public static boolean checkUnderBytes(String inputData, int maxBytes) 
			throws UnsupportedEncodingException
	{
		byte[] contentBytes = inputData.getBytes("utf-8");
		if(contentBytes.length > maxBytes) { return false; }
		
		return true;
	}
}
