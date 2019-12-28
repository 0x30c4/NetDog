import java.io.*;

public class FileHandler{
	public void file_sender(String f, PrintStream out) {
		try{
			FileInputStream fin = new FileInputStream(f);
			
			byte[] b = new byte[1024];
			int noOfBytes = 0;
			
			while( (noOfBytes = fin.read(b)) != -1 ){
				out.write(b, 0, noOfBytes);
			}
			fin.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
    }
	public void file_recever(String f, DataInputStream in){
		if (f.equals("NONE.NONE")){
			System.out.print(2);
    	}else{
			try{
				FileOutputStream fout = new FileOutputStream(f);
				byte[] b = new byte[1024];
				int noOfBytes = 0;

				while( (noOfBytes = in.read(b)) != -1 ){
					fout.write(b, 0, noOfBytes);
				}
				fout.close();
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}
}