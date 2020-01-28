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

    public NetHandler(String ip, int port, int byteSize){
        this.port = port;
        this.ip = ip;
        this.byteSize = byteSize;
	}
	public void recever(String fileName){
        DataInputStream in = null;
        ServerSocket server = null;
        FileHandler fh = new FileHandler(fileName, this.byteSize);
        try{
            server = new ServerSocket(this.port);
            System.out.println("Listening on [" + this.port + "]");
            this.socket = server.accept();
            in = new DataInputStream(new BufferedInputStream(this.socket.getInputStream()));
            if (fileName.equals("NONE"))
                fh.fileRecever(in, true);
            else
                fh.fileRecever(in, false);
            
            in.close();
            this.socket.close();
        }catch(IOException e){
            System.err.println(e);
        }
	}
	public boolean sender(String fileName){
        boolean ret = false;
        PrintStream out = null;
        FileHandler fh = new FileHandler(fileName, this.byteSize);
        try{
            this.socket = new Socket(this.ip, this.port);
            out = new PrintStream(this.socket.getOutputStream());
            out.write(new byte[this.byteSize], 0, 55);
            if (fileName.equals("NONE"))
                ret = fh.readFromPipe(out);
            else
                ret = fh.fileSender(out);

            this.socket.close();
	    }catch(UnknownHostException e){
            System.err.println(e);
            return false;
        }catch(IOException e){
            System.err.println(e);
            return false;
        }
        return ret;
    }
}