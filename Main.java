public class Main{
	private int PORT = 6969; 
	private int BLOCK_SIZE = 1024;
	private	String IP = "NONE";
	private	String FILE_IN = "NONE";
	private	String FILE_OUT = "NONE";
	private	String LOG_FILE = "NONE";
	private	boolean LISTEN = false;

	public void CliMode(String[] args){
		String gap = "\n\t\t\t      ";

		ArgParser usrio = new ArgParser(args, "netdog", "A simple networking utility made with java.\nTo use Graphical Interface gave no argument.");

		usrio.AddOpt("-i", "--ip-addr", "ip_addr", "str","Host name or ip address.");
		usrio.AddOpt("-a", "--ip-port", "ip:port", "str","The ip and the port [IP:PORT]");
		usrio.AddOpt("-p", "--port", "port", "int", "Port number to listen or connect to.\n\t\t\t      The Default port is '6969'.\n\t\t\t      This option could be used with the [-l] for listing on a port.");

		usrio.AddOpt("-f", "--file-name", "file_name", "str","The input file.");
		usrio.AddOpt("-o", "--out-file", "out_file", "str", "The output file.");
		usrio.AddOpt("-L", "--log", "log_file", "str", "It redirect all the out put to a log file.");

		usrio.AddOpt("-b", "--bytes", "bytes", "int", "Read and write up to BYTES bytes at a time (default: 1024)");

		// usrio.AddOpt("-g", "NONE", "NONE", "NONE", "For the 'Graphical Interface'.");
		usrio.AddOpt("-l", "NONE", "NONE", "NONE", "Bind and listen for incoming connections.It must be used with the [--port=port] option");
		
		usrio.parseArg();

		if ((usrio.optionalArgValue.get("port")) != null){
			try{
				this.PORT = Integer.valueOf(usrio.optionalArgValue.get("port"));
			}catch(Exception e){
				System.out.println("Value Error: [" + usrio.optionalArgValue.get("port") + "] is not an Integer.");
				System.exit(0);
			}
		}
		if (usrio.optionalArgValue.get("bytes") != null){
			try{
				this.BLOCK_SIZE = Integer.valueOf(usrio.optionalArgValue.get("bytes"));
			}catch(Exception e){
				System.out.println("Value Error: [" + usrio.optionalArgValue.get("bytes") + "] is not an Integer.");
				System.exit(0);
			}
		}
		if (usrio.optionalArgValue.get("file_name") != null)
			this.FILE_IN = usrio.optionalArgValue.get("file_name");
		if (usrio.optionalArgValue.get("out_file") != null)
			this.FILE_OUT = usrio.optionalArgValue.get("out_file");
		if (usrio.optionalArgValue.get("ip_addr") != null)
			this.IP = usrio.optionalArgValue.get("ip_addr");
		if (usrio.optionalArgValue.get("log_file") != null)
			this.LOG_FILE = usrio.optionalArgValue.get("log_file");
		if (usrio.optionalArgValue.get("ip:port") != null){
			this.IP = usrio.optionalArgValue.get("ip:port").split(":", 0)[0];
			try{
				this.PORT = Integer.valueOf(usrio.optionalArgValue.get("ip_port").split(":", 0)[1]);
			}catch(Exception e){
				System.out.println("Value Error: [" + usrio.optionalArgValue.get("ip_port").split(":", 0)[1] + "] is not an Integer.");
				System.exit(0);
			}
		}

		if (usrio.optionalArg.get("l") != null)
			this.LISTEN = true;
	}

	public void GuiMode(){
		System.out.println("GUI");
	}

	public static void main(String[] args) {
		Main MainProgram = new Main();
		if (args.length != 0)
			MainProgram.CliMode(args);
		else
			MainProgram.GuiMode();

		System.out.println("port \t\t" + MainProgram.PORT);
		System.out.println("ip \t\t" + MainProgram.IP);
		System.out.println("block size \t" + MainProgram.BLOCK_SIZE);
		System.out.println("file in \t" + MainProgram.FILE_IN);
		System.out.println("file out \t" + MainProgram.FILE_OUT);
		System.out.println("file out \t" + MainProgram.LOG_FILE);

		System.out.println("listen \t\t" + MainProgram.LISTEN);
		if (MainProgram.LISTEN && MainProgram.IP.equals("NONE") &&
				MainProgram.FILE_OUT.equals("NONE")){
			NetHandler r = new NetHandler(MainProgram.IP, MainProgram.PORT, MainProgram.FILE_OUT, MainProgram.BLOCK_SIZE);
		}else if (){

		}
 	
		// System.out.write()
	}
}


	/*
	int decimalExample = Integer.valueOf("20"); 
	float f = Float.parseFloat(decimal);
	double d = Double.parseDouble(str)
	
	optionalArgValue
	positionalArgument
	e.getMessage()
	*/