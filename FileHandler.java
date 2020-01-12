import java.io.DataInputStream;
import java.io.PrintStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

import java.nio.ByteBuffer;

public class FileHandler{
	public String fileName;
	public int byteSize;
	public double fileSize;

	public FileHandler(String fileName, int byteSize){
		File f = new File(fileName);
		if (!f.exists()){
			System.err.println("[" + this.fileName + "] File doesn't exist.");
			System.exit(0);
		}
		
		this.fileName = fileName;
		this.byteSize = byteSize;
		this.fileSize = f.length();
		System.out.println(this.fileSize);
	}
	public void fileSender(PrintStream outStream) {

		try{
			FileInputStream fin = new FileInputStream(this.fileName);
			
			byte output = (byte) this.fileSize;
			// outStream.write(b, 0, noOfBytes);

			byte[] b = new byte[this.byteSize];
			int noOfBytes = 0;
			String d = new Double(this.fileSize).toString();
			// noOfBytes = this.toByteArray(this.fileSize);

			// System.out.println(this.toByteArray(this.fileSize));
			// System.out.println(this.toDouble(this.toByteArray(this.fileSize)));
			outStream.write(d.getBytes());
			while( (noOfBytes = fin.read(b)) != -1 ){
				outStream.write(b, 0, noOfBytes);
			}			
			fin.close();
		}catch(Exception e){
			System.err.println(e);
		}
    }
	public void fileRecever(DataInputStream inStream){
		try{
			FileOutputStream fout = new FileOutputStream(this.fileName);
			byte[] b = new byte[this.byteSize];
			int noOfBytes = 0;
			System.out.println(inStream.readUTF(8));
			while( (noOfBytes = inStream.read(b)) != -1 ){
				fout.write(b, 0, noOfBytes);
			}
			fout.close();
		}catch(Exception e){
			System.err.println(e);
		}
	}

}