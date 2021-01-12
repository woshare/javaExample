package com.example.lean.util;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class ProxyUtils {

	public static void generatClassFile(Class clazz,String proxyName){
		byte[] classFile= ProxyGenerator.generateProxyClass(proxyName,clazz.getInterfaces());
		String path=clazz.getResource(".").getPath();
		System.out.println(path);
		FileOutputStream out=null;
		try {
			out=new FileOutputStream(path+proxyName+".class");
			out.write(classFile);
			out.flush();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			try{
				out.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
