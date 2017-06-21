/*compile: javac -encoding utf8 -d . test.java customer.java Desk.java*/

package customer;

import java.util.ArrayList;
import java.util.Scanner;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedReader;

public class test
{
	private static ArrayList<customer> customer_record = new ArrayList<customer>();
	private static ArrayList<Desk> now_desk = new ArrayList<Desk>();
 	private static String address = "192.168.84.116";
	private static int port = 9487;
	private static int Customerontologynum = 0;
	
	private static double c_similarity= -1;
	private static int choose_customer_onto = 0;
	
	private static double d_similarity= -1;
	private static int choose_desk_onto = 0;
	
	private static String data = "";

	public static void initial_ontology()
	{
		Desk initial = new Desk(false, 28, 40, 4, 4, true);
		customer_record.add(new customer(customer_record.size()+1, 1,0,1,2, initial));// work
		
		initial = new Desk(false, 27, 30, 3, 4, false);	
		customer_record.add(new customer(customer_record.size()+1, 4,2,2,1, initial));// chat
		
		initial = new Desk(false, 26, 30, 3, 4, false);	
		customer_record.add(new customer(customer_record.size()+1, 8,4,0,3, initial));// meal
		
		initial = new Desk(false, 29, 20, 5, 4, true);	
		customer_record.add(new customer(customer_record.size()+1, 2,0,2,2, initial));// work
		
		initial = new Desk(false, 27, 10, 2, 4, true);	
		customer_record.add(new customer(customer_record.size()+1, 2,1,1,1, initial));//chat
		
	}
	
	public static double compare_customer_ontology(customer today, customer previous)
	{
		double pd = Math.abs(today.getpnum()-previous.getpnum());
		double cdd = Math.abs(today.getcdrink()-previous.getcdrink());
		double hdd = Math.abs(today.gethdrink()-previous.gethdrink());
		double purd;
		
		if(pd <= 4)
			pd = 0.4-0.10*pd;
		else 
			pd =0;
		
		if(cdd <= 1)
			cdd = 0.1-0.05*cdd;
		else 
			cdd=0;
		
		if(hdd <= 1)
			hdd = 0.1-0.05*hdd;
		else 
			hdd=0;
		
		if(today.getpur() == previous.getpur())
			purd = 0.4;
		else if ((today.getpur() == 1 && previous.getpur() ==3)||(today.getpur() == 3 && previous.getpur() ==1))
			purd = 0.2;
		else purd = 0.1;
		double temp  = pd + cdd + hdd + purd;
		System.out.println("similarity: "+ String.format("%.1f",temp)+ "\n\n");
		return temp;
	}
	
	public static double compare_desk_ontology(Desk pre, Desk now)
	{
		if(now.getState() == true)
		{
			System.out.println("This seat is FULL!!!!");
			return -1;
		}
		else 
		{
			double td = Math.abs(pre.getTemperature() - now.getTemperature());
			double hd = Math.abs(pre.getHeight() - now.getHeight());
			double bd = Math.abs(pre.getBright() - now.getBright());
			double sd;
			if(td == 0)td = 0.2;
			else if(td == 1)td = 0.1;
			else if(td == 2)td = 0.05;
			else td =0;
			
			if(hd == 0) hd = 0.3;
			else if (hd == 10) hd =0.2;
			else if (hd == 20) hd = 0.1;
			else hd =0;
			
			if(bd == 0)bd = 0.25;
			else if(bd == 1) bd = 0.15;
			else if(bd == 2) bd = 0.05;
			else bd = 0;
			
			if(pre.getSocket() == true && now.getSocket() == true)
				sd = 0.25;
			else if(pre.getSocket() == true && now.getSocket() == false)
				sd = 0.05;
			else sd = 0.15;
			double temp = td + hd + bd + sd;
			System.out.println("Seat similarity: "+ String.format("%.1f",(temp)));
			return temp; 
		}
	}
	
	public static void create_SocketClient()
	{
	
		Socket client = new Socket();
		InetSocketAddress isa = new InetSocketAddress(address, port);
		try
		{
			client.connect(isa, 1000);
			BufferedInputStream in = new BufferedInputStream(client.getInputStream());
			//BufferedOutputStream out = new BufferedOutputStream(client.getOutputStream());
			//out.write("Send from client".getBytes());
			//out.flush();
			//out.close();
			//System.out.println("Send finish");
			byte[] b = new byte[1024]; 
			//String data = "";
            int length;
            
			while ((length = in.read(b)) > 0)// <=0的話就是結束了
            {
                data += new String(b, 0, length);
            } 
            System.out.println("我取得的值:" + data);
			
			
			in.close();
			client.close();
			client = null;
		}
		catch(java.io.IOException e)
		{
			System.out.println("IOException: "+ e.toString());
		}
	}
	
	public static void main(String[] args)
	{
		//ArrayList<customer> customer_record = new ArrayList<customer>();
		initial_ontology();
		/*customer aaa = new customer(++Customerontologynum, 8,5,9,1);
		System.out.println(aaa.getcdrink()+" cold drink");
		aaa.showCustomerOntology();
		customer bbb = new customer(++Customerontologynum, 1,2,3,4);
		bbb.showCustomerOntology();*/
		
	    Scanner scanner = new Scanner(System.in);
		System.out.println("請依序輸入今日用餐資料:");
		System.out.println("今日用餐人數:");
		int people = scanner.nextInt();
		System.out.println("冷飲數量:");
		int cold = scanner.nextInt();
		System.out.println("熱飲數量:");
		int hot = scanner.nextInt();
		System.out.println("用餐目的: 1.聊天 2. 工作 3.約會:");
		int purpose = scanner.nextInt();
		System.out.println("#############################");
		System.out.println("# Today's customer ontology #");
		System.out.println("#############################");
		customer today = new customer(0,people, cold, hot, purpose, new Desk());
		today.showCustomerOntology();

		System.out.println("##############################");
		System.out.println("# Previous customer ontology #");
		System.out.println("##############################");

		for (int i = 0;i < customer_record.size(); i++)
		{
			customer_record.get(i).showCustomerOntology();
			double temp_similarity = compare_customer_ontology(today, customer_record.get(i));
			if(temp_similarity >= c_similarity)
			{
				c_similarity = temp_similarity;
				choose_customer_onto = i;
			}
		}
		
		System.out.println("Highest customer similarity: " +c_similarity + " at customer ontology " + (choose_customer_onto+1));
		
		create_SocketClient();
		// data = "false,27,0,0,4,true\ntrue,26,10,4,4,false\nfalse,27,10,2,4,true\ntrue,27,30,2,4,false\nfalse,27,40,0,4,true\n";
		
		String[] token = data.split(",|\n");
		
		//字串處理from gscl
		for(int i = 0; i < 30; i+=6)
		{
			boolean state_temp,socket_temp;
			int temp_temp;
			int height_temp;
			int bright_temp;
			
			if(token[i].equals("true"))state_temp = true;
				else state_temp = false;
			temp_temp = Integer.parseInt(token[i+1]);
			height_temp = Integer.parseInt(token[i+2]);
			bright_temp = Integer.parseInt(token[i+3]);
			if(token[i+5].equals("true"))socket_temp = true;
				else socket_temp = false;
			now_desk.add(new Desk(state_temp, temp_temp, height_temp, bright_temp, 4, socket_temp));
		}
		
		
		System.out.println("##############################");
		System.out.println("#       Now seat state       #");
		System.out.println("##############################");
		
		for(int i = 0; i < now_desk.size(); i++)
		{
			now_desk.get(i).showDeskOntology();
			double temp_similarity = compare_desk_ontology(customer_record.get(choose_customer_onto).getDesk(), now_desk.get(i));
			if(temp_similarity >= d_similarity)
			{
				d_similarity = temp_similarity;
				choose_desk_onto = i;
			}
		}
		if(d_similarity == -1)System.out.println("Sorry, there is no seat for you");
		else 
		{	
			System.out.println("\n\nHighest seat similarity: " +d_similarity + " at seat " + (choose_desk_onto+1));
			System.out.println("Please have your seat and wish you have a nice day");
		}
	}
}