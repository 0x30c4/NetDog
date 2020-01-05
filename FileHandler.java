import java.io.DataInputStream;
import java.io.PrintStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FileHandler{
	public void fileSender(String fileName, PrintStream outStream, int byteSize) {
		try{
			FileInputStream fin = new FileInputStream(fileName);
			
			byte[] b = new byte[byteSize];
			int noOfBytes = 0;
			
			while( (noOfBytes = fin.read(b)) != -1 ){
				outStream.write(b, 0, noOfBytes);
			}
			fin.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
    }
	public void fileRecever(String f, DataInputStream inStream, int byteSize){
		try{
			FileOutputStream fout = new FileOutputStream(f);
			byte[] b = new byte[byteSize];
			int noOfBytes = 0;
			while( (noOfBytes = inStream.read(b)) != -1 ){
				fout.write(b, 0, noOfBytes);
			}
			fout.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}