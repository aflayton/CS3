import java.util.Scanner;

class Candidate extends Element
{
	private String name, age, party, issueList;
	
	public Candidate()
	{
		this.name = "";
		this.age = "";
		this.party = "";
		this. issueList = "";
	}
	
	public Candidate(String name, String age, String party, String issueList)
	{
		this.name = name;
		this.age = age;
		this.party = party;
		this.issueList = issueList;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getAge()
	{
		return this.age;
	}
	
	public String getParty()
	{
		return this.party;
	}
	
	public String getIssueList()
	{
		return this.issueList;
	}
	
	/*
	public boolean hasIssue(String issue)
	{
		String[] issues;
		
		issues = issueList.split("[;]");
		
		for (String i : issues)
		{
			if(i.equals(issue))
			{
				return true;
			}
		}
		return false;
	}
	*/
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
		//String name, age, party, issueList;
		this.name = getInput("Name: ");
		this.age = getInput("Age: ");
		this.party = getInput("Party: ");
		this.issueList = "";
		int issueNumber = Integer.parseInt(getInput("Number of Issues: "));
		for (int i=1; i <= issueNumber; i++)
		{
			this.issueList += getInput(i+": ");
			if (i < issueNumber)
			{
				this.issueList += ";";
			}
		}
	}
	
	public void display()
	{
		System.out.println("Name: " + this.name);
		System.out.println("Age: " + this.age);
		System.out.println("Party: " + this.party);
		System.out.println("Important Issues: ");
		String issues[];
		issues = this.issueList.split("[;]");
		for (String issue : issues)
		{
			System.out.println("\t"+issue);
		}
	}
	
	public boolean equals(Element otherCandidate)
	{
		return name.equals(((Candidate) otherCandidate).name);
	}
	
	public Element clone()
	{
		Candidate theClone = new Candidate();
        theClone.name = name;
		theClone.age = age;
        theClone.party = party;
		theClone.issueList = issueList;
        return theClone;
	}
	
	public void setName(String newName)
	{
		this.name = newName;
	}
	
	public void setAge(String newAge)
	{
		this.age = newAge;
	}
	
	public void setParty(String newParty)
	{
		this.party = newParty;
	}
	
	public void setIssueList(String newIssueList)
	{
		this.issueList = newIssueList;
	}
	
}