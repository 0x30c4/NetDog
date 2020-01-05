import java.io.DataInputStream;
import java.io.PrintStream;
import java.io.BufferedInputStream;
import java.io.IOException;

import java.net.UnknownHostException;
import java.net.ServerSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class NetHandler{
	private Socket socket = null;
    private String fileName;
    private int byteSize;

    public NetHandler(String ip, int port, String fileName, int byteSize){
        this.fileName = fileName;
        this.byteSize = byteSize;
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
            fh.fileRecever(this.fileName, in, this.byteSize);
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
            fh.fileSender(this.fileName, out, this.byteSize);
            this.socket.close();
	   }catch(UnknownHostException e){
        System.out.println(e);
       }catch(IOException e){
        System.out.println(e);
       }
    }
}