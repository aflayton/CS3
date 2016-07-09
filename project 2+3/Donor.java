import java.util.Scanner;

class Donor extends Element
{
	private String name, location;
	private double amount;
	
	public Donor()
	{
		this.name = "";
		this.location = "";
		this.amount = 0.0;
	}
	
	public Donor(String name, String location, double amount)
	{
		this.name = name;
		this.location = location;
		this.amount = amount;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getLocation()
	{
		return this.location;
	}
	
	public double getAmount()
	{
		return this.amount;
	}
	
	/*
	public static String getInput(String prompt)
	{
		Scanner s = new Scanner(System.in);
		System.out.print(prompt);
		String input = s.nextLine().toUpperCase();
		return input;
	}
	*/
	
	public void readIn()
	{
		this.name = getInput("Name: ");
		this.location = getInput("Location: ");
		this.amount = Double.parseDouble(getInput("Amount: "));
	}
	
	public void display()
	{
		System.out.println("Name: " + this.name);
		System.out.println("Location: " + this.location);
		System.out.println("Amount: " + this.amount);
	}
	
	public boolean equals(Element otherDonor)
	{
		return name.equals(((Donor) otherDonor).name);
	}
	
	public Element clone()
	{
		Donor theClone = new Donor();
        theClone.name = name;
		theClone.location = location;
		theClone.amount = amount;
        return theClone;
	}
	
	public void setName(String newName)
	{
		this.name = newName;
	}
	
	public void setLocation(String newLocation)
	{
		this.location = newLocation;
	}
	
	public void setAmount(double newAmount)
	{
		this.amount = newAmount;
	}
}