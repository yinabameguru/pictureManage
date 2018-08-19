package com.jza.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class Base64Util {
	
	public static String encode(String msg){
		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("md5");
			byte[] b=md.digest(msg.getBytes());
			BASE64Encoder encoder=new BASE64Encoder();
			return encoder.encode(b);			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
