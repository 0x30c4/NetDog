import java.io.*;
import java.net.*;

public class NetHandler{
	private Socket socket = null;
    private String file_name;

    public NetHandler(String ip, int port, String file_name){
        this.file_name = file_name;
        if (ip.equals("None")){
            this.recever(port);
        }else{
        	this.sender(ip, port);
        }
	}
	public void recever(int port){
        DataInputStream in = null;
        ServerSocket server = null;
        FileHandler fh = new FileHandler();
        try{
            server = new ServerSocket(port);
            System.out.println("Waiting....");
            this.socket = server.accept();
            in = new DataInputStream(new BufferedInputStream(this.socket.getInputStream()));
            fh.file_recever(this.file_name, in);
            in.close();
            this.socket.close();
        }catch(IOException e){
            System.out.println(e);
        }
	}
	public void sender(String ip, int port){
        PrintStream out = null;
        FileHandler fh = new FileHandler();
        try{
            this.socket = new Socket(ip, port);
            out = new PrintStream(this.socket.getOutputStream());
            // out.println("hello");
            fh.file_sender(this.file_name, out);
            this.socket.close();
	   }catch(UnknownHostException e){
        System.out.println(e);
       }catch(IOException e){
        System.out.println(e);
       }
    }
}