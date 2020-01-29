package com.netdog.java.utils;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.nio.ByteBuffer;

public class FileHandler{
	public String fileName;
	public int byteSize;
	public double fileSize;

	public FileHandler(String fileName, int byteSize){
		File f = new File(fileName);
		if (!f.exists() && !fileName.equals("NONE")){
			System.err.println("[" + this.fileName + "] File doesn't exist.");
			System.exit(0);
		}		
		this.fileName = fileName;
		this.byteSize = byteSize;
		this.fileSize = f.length();

	}
	public boolean fileSender(PrintStream outStream) {
		try{
			FileInputStream fin = new FileInputStream(this.fileName);

			byte[] b = new byte[this.byteSize];
			int noOfBytes = 0;
			while( (noOfBytes = fin.read(b)) != -1 ){
				outStream.write(b, 0, noOfBytes);
			}			
			fin.close();
			return true;
		}catch(Exception e){
			System.err.println(e);
			return false;
		}
    }
	public void fileRecever(DataInputStream inStream, boolean printOrNot){
		try{
			FileOutputStream fout = new FileOutputStream(this.fileName);
			byte[] b = new byte[this.byteSize];
			int noOfBytes = 0;
			while( (noOfBytes = inStream.read(b)) != -1 ){
				if (printOrNot)
					System.out.write(b, 0, noOfBytes);
				else
					fout.write(b, 0, noOfBytes);
			}
			fout.close();
		}catch(Exception e){
			System.err.println(e);
		}
	}

	public boolean readFromPipe(PrintStream outStream){
		try{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        if (!br.ready()){
	        	return false;
	        }
			byte[] b = new byte[this.byteSize];
	        int noOfBytes = 0;
	        while((noOfBytes = br.read()) != -1){
				outStream.print((char)noOfBytes);
	        }
	        br.close();
	        return true;
		}catch (IOException e){
			System.err.println(e);
			return false;
		}
	}
}