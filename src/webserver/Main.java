package webserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import io.ReadFile;
import io.ReadProperties;
import views.ControView;

public class Main {
	private static int PORT;
	static PrintWriter logFile;
	static String logger;
	
	public static void main( String[] args ) throws IOException, InterruptedException {
		PORT = Integer.parseInt(ReadProperties.getPost());
		ServerSocket serverConnect = new ServerSocket( PORT );
		System.out.println( "Server started.\nListening for connections on port : " + PORT + " ...\n" );
		new ControView("Màn hình controller");
		logFile = new PrintWriter( new FileOutputStream( "log.txt"));
		while(true) {
			Socket socket = serverConnect.accept();
			ClientManager t = new ClientManager(socket);
			t.start();
		}
	}
	
	
}




