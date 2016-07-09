class Candidate
{
	private String name, age, party, issueList;

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

	public void display()
	{
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
}
