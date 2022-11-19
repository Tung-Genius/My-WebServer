package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadFile {
	public static String readFile(String path) throws IOException {
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String s;
		String content = "";
		while((s = br.readLine()) != null){
			content = content + s + "\n";
		}
		fr.close();
		return content;
	}
	
	public static void saveFile(String content, String path) throws IOException {
		FileWriter fw = new FileWriter(path);
		fw.write(content);
		fw.flush();
		fw.close();
	}
}
