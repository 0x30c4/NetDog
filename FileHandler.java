import java.io.DataInputStream;
import java.io.PrintStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

public class FileHandler{
	public String fileName;
	public int byteSize;
	public double fileSize;

	public FileHandler(String fileName, int byteSize){
		File f = new File(fileName);
		if (!f.exists())
			System.err.println("[" + this.fileName + "] File doesn't exist.");
			System.exit(0);
		
		this.fileName = fileName;
		this.byteSize = byteSize;
		this.fileSize = f.length();
		System.out.println(this.fileSize);
	}

	public void fileSender(PrintStream outStream) {

		try{
			FileInputStream fin = new FileInputStream(this.fileName);
			
			byte[] b = new byte[this.byteSize];
			int noOfBytes = 0;
			
			while( (noOfBytes = fin.read(b)) != -1 ){
				outStream.write(b, 0, noOfBytes);
			}			
			fin.close();
		}catch(Exception e){
			// System.out.println(e);
		}
    }
	public void fileRecever(DataInputStream inStream){
		try{
			FileOutputStream fout = new FileOutputStream(this.fileName);
			byte[] b = new byte[this.byteSize];
			int noOfBytes = 0;
			while( (noOfBytes = inStream.read(b)) != -1 ){
				fout.write(b, 0, noOfBytes);
			}
			fout.close();
		}catch(Exception e){
			// System.out.println(e);
		}
	}

}