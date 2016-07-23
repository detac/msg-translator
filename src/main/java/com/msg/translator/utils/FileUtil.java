package com.msg.translator.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {

	public static String read(String pathname) {
		String result = "";
		try {
			result = new String(Files.readAllBytes(Paths.get(pathname)), "UTF-8");
		} catch (IOException ex) {
			System.out.println("FileUtil.read(String filepath):String > " + ex);
		}
		return result;
	}
}
