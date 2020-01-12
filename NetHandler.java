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
    private String ip;
    private int byteSize;
    private int port;

    public NetHandler(String ip, int port, String fileName, int byteSize){
        this.port = port;
        this.ip = ip;
        this.fileName = fileName;
        this.byteSize = byteSize;
        if (this.fileName.equals("NONE"))
            this.printTheData();

        if (ip.equals("NONE")){
            this.recever();
        }else{
        	this.sender();
        }
	}

    public void printTheData(){
        DataInputStream in = null;
        ServerSocket server = null;
        try{
            server = new ServerSocket(this.port);
            System.out.println("Listening on [" + this.port + "]");
            this.socket = server.accept();
            in = new DataInputStream(new BufferedInputStream(this.socket.getInputStream()));
            byte[] b = new byte[this.byteSize];
            int noOfBytes = 0;
            try{
                while ((noOfBytes = in.read(b)) != -1 ) {
                    System.out.write(b, 0, noOfBytes);
                    System.out.write(noOfBytes);
                }
            }catch(IOException e){
                System.err.println(e);
            }
            in.close();
            this.socket.close();
        }catch(IOException e){
            System.err.println(e);
        }        
        System.exit(0);
    }

	public void recever(){
        DataInputStream in = null;
        ServerSocket server = null;
        FileHandler fh = new FileHandler(this.fileName, this.byteSize);
        try{
            server = new ServerSocket(this.port);
            System.out.println("Listening on [" + this.port + "]");
            this.socket = server.accept();
            in = new DataInputStream(new BufferedInputStream(this.socket.getInputStream()));
            fh.fileRecever(in);
            in.close();
            this.socket.close();
        }catch(IOException e){
            System.err.println(e);
        }
        System.exit(0);
	}
	public void sender(){
        PrintStream out = null;
        FileHandler fh = new FileHandler(this.fileName, this.byteSize);
        try{
            this.socket = new Socket(this.ip, this.port);
            out = new PrintStream(this.socket.getOutputStream());
            fh.fileSender(out);
            this.socket.close();
	   }catch(UnknownHostException e){
        System.err.println(e);
       }catch(IOException e){
        System.err.println(e);
       }
       System.exit(0);
    }
}