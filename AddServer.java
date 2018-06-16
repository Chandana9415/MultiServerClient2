
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AddServer {


	
	public static void main(String []args)
	{
		try {
			ServerSocket sadd = new ServerSocket(6701);
			while(true)
			{
			Socket socket = sadd.accept();
			
			InputStream in = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String int1 = br.readLine();
			String int2 = br.readLine();
                        String strUserName = br.readLine();
			int a = Integer.parseInt(int1);
			int b = Integer.parseInt(int2);
			//System.out.println("strUserName :: "+strUserName);
			//OutputStream out = socket.getOutputStream();
			//PrintWriter pr = new PrintWriter(out, true);
			String strCalcResult = "";
			strCalcResult = "The result " + strUserName+" is "+(a+b);
			
			System.out.println(strCalcResult);
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
}
