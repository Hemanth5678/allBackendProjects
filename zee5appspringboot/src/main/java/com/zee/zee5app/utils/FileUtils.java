package com.zee.zee5app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class FileUtils {

	public byte[] readFile(File file) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(file); 
		
		byte[] allBytes = new byte[(int) file.length()];
		fileInputStream.read(allBytes);
		return allBytes;
	}
	
	public String writeFile(byte[] allBytes, String fileName) throws IOException{
		
		FileOutputStream fileOutputStream = null;
		fileOutputStream = new FileOutputStream("C:\\Movies\\movieStore\\"+fileName); 
	
		fileOutputStream.write(allBytes);
		
		if(fileOutputStream!=null)
			return "success";
		return "failure";
	}
	
}
