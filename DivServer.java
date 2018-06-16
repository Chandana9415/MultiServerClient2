

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class DivServer {


	
	public static void main(String []args)
	{
		try {
			ServerSocket sdiv = new ServerSocket(6704);
			while(true)
			{
			Socket socket = sdiv.accept();
			
			InputStream in = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String int1 = br.readLine();
			String int2 = br.readLine();
                        String strUserName = br.readLine();
			int a = Integer.parseInt(int1);
			int b = Integer.parseInt(int2);
		
			String strCalcResult = "";
			strCalcResult = "The result for user "+strUserName+" is "+(a/b);
			
			System.out.println(strCalcResult);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}

