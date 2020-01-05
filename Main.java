public class Main{
	public static void main(String[] args) {
		int port = 6969;
		int block_size = 1024;
		String ip = null;
		String fileIn = null;
		String fileOut = null;
		boolean listen = false;
		boolean quit = false;
		String gap = "\n\t\t\t      ";

		ArgParser usrio = new ArgParser(args, "netdog", "A simple networking utility made with java.");

		usrio.AddOpt("-i", "--ip-addr", "ip_addr", "str","Host name or ip address.");
		usrio.AddOpt("-a", "--ip-port", "ip_port", "str","The ip and the port [IP:PORT]");
		usrio.AddOpt("-p", "--port", "port", "int", "Port number to listen or connect to.\n\t\t\t      The Default port is '6969'.\n\t\t\t      This option could be used with the [-l] for listing on a port.");

		usrio.AddOpt("-f", "--file-name", "file_name", "str","The input file.");
		usrio.AddOpt("-o", "--out-file", "out_file", "str", "The output file.");

		usrio.AddOpt("-b", "--bytes", "bytes", "int", "Read and write up to BYTES bytes at a time (default: 1024)");

		usrio.AddOpt("-l", "NONE", "NONE", "NONE", "Bind and listen for incoming connections.It must be used with the [--port=port] option");
		usrio.AddOpt("-s", "NONE", "NONE", "NONE", "Output will be print to the stdout");
		usrio.AddOpt("-q", "NONE", "NONE", "NONE", "No output will be shown.No output will be shown");
		
		usrio.parseArg();

		if ((usrio.optionalArgValue.get("port")) != null){
			try{
				port = Integer.valueOf(usrio.optionalArgValue.get("port"));
				
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		if ((usrio.optionalArgValue.get("bytes")) != null){
			try{
				block_size = Integer.valueOf(usrio.optionalArgValue.get("bytes"));
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		if ((usrio.optionalArgValue.get("file_name")) != null)
			fileIn = usrio.optionalArgValue.get("file_name");
		if ((usrio.optionalArgValue.get("out_file")) != null)
			fileOut = usrio.optionalArgValue.get("out_file");
		if ((usrio.optionalArgValue.get("ip_addr")) != null)
			ip = usrio.optionalArgValue.get("ip_addr");
		if ((usrio.optionalArgValue.get("out_file")) != null)
			ip_port = usrio.optionalArgValue.get("ip_port");


		NetHandler r = new NetHandler("127.0.0.1", 6969, "a.png", 1024);

		// for (String i: args) {
		// 	if (i.equals("s")){
		// 		NetHandler r = new NetHandler("127.0.0.1", 6969, "a.png");
		// 	}else if (i.equals("r")){
		// 		NetHandler r = new NetHandler("None", 6969, "t.png");
		// 	}
		// }
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