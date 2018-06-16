import java.io.*;
import java.net.*;
import java.util.Hashtable;

public class Client
{

	public static void main(String []args)
	{
		
		int port=6700;			
		String strPort="",		
			   ip="",			
			   strUserName="";	

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		
		try
		{
			System.out.println("Distributed systems project 2018 Spring quarter");
			System.out.print("Press enter to continue\n");
			ip = input.readLine();
			if (ip.equals(""))
				ip = "localhost";	

			//System.out.print("Port Number: ");
			strPort = input.readLine();
			if (strPort.equals(""))
				port = 6700;			
			else
				port = Integer.parseInt(strPort);

			
			strUserName = "Chandana";
			do
			{
				System.out.print("Enter your Name: ");
				strUserName = input.readLine();
			}
			while (strUserName.equals(""));	


						Socket socket = new Socket(ip, port);

			
			
			String strAnother = "z",	
				   strInt1 = "45",		
				   strInt2 = "2",		
				   strOp = "-",			
				   strResult="";
			

			InputStream in = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			OutputStream out = socket.getOutputStream();
			PrintWriter pr = new PrintWriter(out, true);

			
			pr.println(strUserName);

			
			while (strAnother.charAt(0) != 'd')
			{
				
				System.out.println("\n\nEnter (d) to disconnect from the main server.\n" +
					"      (s) to see other clients connected to the main server.\n" +
					"      any other key to solve any Mathematical Operations(add, subtract, multiply, divide or logical op).  ");
				strAnother = input.readLine();
				if (strAnother.equals(""))
					strAnother = "z";
				switch(strAnother.charAt(0))
				{
					case 'd':
						pr.println("d");
						break;
					case 's':	
						pr.println("s");	
						strResult = br.readLine();
						System.out.println(strResult);
						break;
					default:	
						pr.println("z");
						
						System.out.print("Enter First Number: ");
						strInt1 = input.readLine();
						if (strInt1.equals(""))
							strInt1 = "45";

						
						System.out.print("Enter Second Number: ");
						strInt2 = input.readLine();
						if (strInt2.equals(""))
							strInt2 = "2";

						
						System.out.print("Enter Operator: ");
						strOp = input.readLine();
						if (strOp.equals(""))
							strOp = "-";

						
						pr.println(strInt1);
						pr.println(strInt2);
						pr.println(strOp);
						

						
						strResult = br.readLine();
					
						System.out.println(strResult);
						
						break;
				}	
			}	

			
			socket.close();

		}	
		catch(Exception e)
		{
			System.out.println("An error has occurred.");
			e.printStackTrace();
			System.exit(0);
			
		}	

	}	
}	