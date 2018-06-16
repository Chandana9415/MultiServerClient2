

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class LogServer {


	
	public static void main(String []args)
	{
		try {
			ServerSocket slog = new ServerSocket(6705);
			while(true)
			{
			Socket socket = slog.accept();
			
			InputStream in = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String int1 = br.readLine();
			String int2 = br.readLine();
                        String strUserName = br.readLine();
			int a = Integer.parseInt(int1);
			int b = Integer.parseInt(int2);
			String strCalcResult = "";
			
			if(a>b)
			{
			strCalcResult = "The result for user "+strUserName+" is "+a+ "is greater than"+b;
			}
			else if(a<b) {
				strCalcResult = "The result is user "+strUserName+ " is " +b+ " is greater than"+a;
			}
			else 
				strCalcResult = "The result is user "+strUserName+" is " +a+ "and" +b+ "are equal";
			
			System.out.println(strCalcResult);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}

