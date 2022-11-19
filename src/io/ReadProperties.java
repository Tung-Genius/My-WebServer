package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	private static final String FILE_CONFIG = "\\config.properties";
	
	public static String getPost() throws IOException {
		Properties properties = new Properties();
		InputStream inputStream = null;
		
		String currentDir = System.getProperty("user.dir");
        inputStream = new FileInputStream(currentDir + FILE_CONFIG);
        properties.load(inputStream);
        String post = properties.getProperty("post");
        inputStream.close();
        return post;
	}
}
