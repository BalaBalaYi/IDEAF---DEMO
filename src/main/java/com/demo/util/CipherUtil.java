package com.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CipherUtil {

	private static Logger logger = LoggerFactory.getLogger(CipherUtil.class);

//	//JbossPasswordDecode加密
//	public static String JbossPasswordEncode(String str){
//		
//		String encodeStr = null;
//		try {
//			encodeStr = new String(SecureIdentityLoginModule.encode(str));
//		} catch (Exception e) {
//			logger.error("JbossPasswordDecode加密发生异常", e);
//		}
//		return encodeStr; 
//	}
//	
//	//JbossPasswordDecode加密
//	public static String JbossPasswordDecode(String str){
//		
//		String decodeStr = null;
//		try {
//			decodeStr = new String(SecureIdentityLoginModule.decode(str));
//		} catch (Exception e) {
//			logger.error("JbossPasswordDecode解密发生异常", e);
//		}
//		return decodeStr; 
//	}
//	
//	public static void main(String[] args) {
//		System.out.println("Encoded:" + CipherUtil.JbossPasswordEncode("test"));
//		System.out.println("Decoded:" + CipherUtil.JbossPasswordDecode(""));
//	}
	
}
