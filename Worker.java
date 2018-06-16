import java.io.*;
import java.net.*;
import java.util.*;
//import clientserver.AddServer;

public class Worker extends Thread
{
	Socket socket;
	Hashtable tOnlineUsers;
	Hashtable tOfflineUsers;
	String strUserName;

	
	public Worker(Socket s, Hashtable online, Hashtable offline, String userName)
	{
		socket = s;
		tOnlineUsers = online;
		tOfflineUsers = offline;
		strUserName = userName;
	}	

	
	public void run()
	{
		try
		{
			
			InputStream in = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			OutputStream out = socket.getOutputStream();
			PrintWriter pr = new PrintWriter(out, true);

			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String strAnother="", strResult="";

			while(!strAnother.equals("d"))
			{
				strResult = "";
				strAnother = br.readLine();	
				System.out.println("Client's choice " + strAnother);
				switch(strAnother.charAt(0))
				{
					case 'd':
						System.out.println("Request for disconnect.");
						break;
					case 's':		
						System.out.println("Sending Clients connected to the main server....\n");
						Enumeration e = tOnlineUsers.keys();
						while (e.hasMoreElements())
							strResult += e.nextElement() + ", ";
						pr.println(strResult);
						break;
					case 'z':
						System.out.println("The respective server would calculate the result and send it to the client\n");
						String strInt1 = br.readLine();
						String strInt2 = br.readLine();
						String strOp = br.readLine();
						int int1 = Integer.parseInt(strInt1);
						int int2 = Integer.parseInt(strInt2);
						char chOp = strOp.charAt(0);
						String strCalcResult = "";
						switch(chOp)
						{
							case '+':
								
								Socket socket = new Socket("localhost", 6701);
								out = socket.getOutputStream();
								pr = new PrintWriter(out, true);
								pr.println(strInt1);
								pr.println(strInt2);
                                                                pr.println(strUserName);
								break;
								
							case '-':
								Socket socket1 = new Socket("localhost",6702);
								out = socket1.getOutputStream();
								pr = new PrintWriter(out,true);
								pr.println(strInt1);
								pr.println(strInt2);
                                                                pr.println(strUserName);

								break;
								
							case '*':
								Socket socket2 = new Socket("localhost",6703);
								out = socket2.getOutputStream();
								pr = new PrintWriter(out,true);
								pr.println(strInt1);
								pr.println(strInt2);
                                                                pr.println(strUserName);
								break;
								
							case '/':
								Socket socket3 = new Socket("localhost",6704);
								out = socket3.getOutputStream();
								pr = new PrintWriter(out,true);
								pr.println(strInt1);
								pr.println(strInt2);
                                                                pr.println(strUserName);
								break;
								
							case '<' :
								Socket socket4 = new Socket("localhost",6705);
								out = socket4.getOutputStream();
								pr = new PrintWriter(out,true);
								pr.println(strInt1);
								pr.println(strInt2);
                                                                pr.println(strUserName);
								break;
								
							default:
								strCalcResult = "The Operator is invalid."; break;
						}
						pr.println(strCalcResult);

						break;
				}	
			}	

			
			Socket s = (Socket)tOnlineUsers.remove(strUserName);
			tOfflineUsers.put(strUserName, s);
			socket.close();

		}	
		catch(Exception e)
		{
			System.out.println("Error has occurred in Worker.");
			e.printStackTrace();
		}	

	}	

}	
