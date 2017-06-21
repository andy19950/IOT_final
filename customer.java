package customer;

public class customer{
	
	private int Ontologynum;
	private int Pnumber;
	private int Colddrink;
	private int Hotdrink;
	private int Purpose;
	private Desk Deskonto;

	public customer()
	{
		this.Ontologynum = 0;
		this.Colddrink = 0;
		this.Hotdrink = 0;
		this.Pnumber = 0;
		this.Purpose = 0;
		this.Deskonto = null;
	}
	
	public customer(int ontonum, int pnum, int cdrink, int hdrink, int pur, Desk desk)
	{
		this.Ontologynum = ontonum;
		this.Colddrink = cdrink;
		this.Hotdrink = hdrink;
		this.Pnumber = pnum;
		this.Purpose = pur;
		this.Deskonto = desk;
	}
	
	public Desk getDesk()
	{
		return this.Deskonto;
	}
	
	public int getpnum()
	{
		return this.Pnumber;
	}
	public void setpnum(int pnum)
	{
		this.Pnumber = pnum;
	}
	
	public int getcdrink()
	{
		return this.Colddrink;
	}
	public void setcdrink(int cnum)
	{
		this.Colddrink = cnum;
	}
	
	public int gethdrink()
	{
		return this.Hotdrink;
	}
	public void sethdrink(int hnum)
	{
		this.Hotdrink = hnum;
	}
	
	
	public int getpur()
	{
		return this.Purpose;
	}
	public void setpur(int pur)
	{
		this.Purpose = pur;
	}
	
	public void showCustomerOntology()
	{
		System.out.println("\n__________Customer Ontology "+this.Ontologynum+" __________");
		System.out.println("customer number   : " + this.Pnumber);
		System.out.println("cold drink number : " + this.Colddrink);
		System.out.println("hot drink number  : " + this.Hotdrink);
		if(this.Purpose == 1)
			System.out.println("purpose           : 聊天");
		else if(this.Purpose == 2)
			System.out.println("purpose           : 工作");
		else if(this.Purpose == 3)
			System.out.println("purpose           : 約會");
		
		//System.out.println("table ontology: ");
		//System.out.println("_________________________________________\n");
	}
}