import java.io.*;
import java.net.*;
import java.util.Hashtable;

public class Server
{
	public static void main(String []args)
	{
		try
		{
			
			ServerSocket ss = new ServerSocket(6700);
			//ServerSocket sadd = new ServerSocket(6701);
			//ServerSocket smin = new ServerSocket(6702);
			

			
			Hashtable tOnlineUsers = new Hashtable(10);
			Hashtable tOfflineUsers = new Hashtable(10);

			while(true)
			{
				Socket socket = ss.accept();	
				System.out.println("client connected.");

				
				InputStream in = socket.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				OutputStream out = socket.getOutputStream();
				PrintWriter pr = new PrintWriter(out, true);

				
				String strUserName = br.readLine();
				System.out.println("Username: " + strUserName + "\n");
				tOnlineUsers.put(strUserName, socket);

				
				Worker w = new Worker(socket, tOnlineUsers, tOfflineUsers, strUserName);
				w.start();
			}	

		}	
		catch(Exception e)
		{
			System.out.println("An unexpected error has occurred.");
			e.printStackTrace();
		}	

	}	
}	
