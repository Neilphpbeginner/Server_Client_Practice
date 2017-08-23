import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextArea jta	=	new JTextArea();

	public static void main(String[] args) {
	
		new Main();
	
	
	}
	
	public Main(){
		
		setLayout(new BorderLayout());
		add(new JScrollPane(jta), BorderLayout.CENTER);
			setTitle("Server");
			setSize(300,300);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			ServerSocket		server	=	new ServerSocket(8000);
			jta.append("Server started at " + new Date() + '\n');
			Socket 				socket	=	server.accept();
			DataInputStream 	in		=	new DataInputStream(socket.getInputStream());
			DataOutputStream 	out		=	new DataOutputStream(socket.getOutputStream());
			
			while(true){
				double raduis	=	in.readDouble();
				double area		=	raduis * raduis * Math.PI;
				
					out.writeDouble(area);
					jta.append("Radius received from client: " + raduis + '\n');
					jta.append("Area found: " + area + '\n');
				
			}
		
	} catch (IOException ex) {
		// TODO: handle exception
			System.out.println(ex);
	}

	}

}
