public class Main{
	public static void main(String[] args) {
		int port = 6969;
		String ip = null;
		String file = null;
		boolean listen = false;
		boolean quit = false;
		
		ArgParser usrio = new ArgParser(args, "netdog", "????");
		
		usrio.AddOpt("-i", "--ip-addr", "ip_addr", "str","Host name or ip address.");
		usrio.AddOpt("-p", "--port", "port", "int", "Port number to listen or connect to.The Default port is '6969'.");
		usrio.AddOpt("-f", "--file-name", "file_name", "str","The input file.");
		usrio.AddOpt("-s", "--file-names", "fisle_name", "str","The input file.");
		// usrio.AddOpt("-o", "--output-file", "output_file", "str", "The output file.");
		
		usrio.AddOpt("-r", "NONE", "NONE", "NONE", "The output file.");

		usrio.AddOpt("-l", "NONE", "NONE", "NONE", "Bind and listen for incoming connections.It must be used with the [--port=port] option");
		usrio.AddOpt("-q", "NONE", "NONE", "NONE", "No output will be shown.");
		
		// usrio.AddOpt("NONE", "NONE", "file", "str","help menu!!");
		
		usrio.parseArg();

				
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