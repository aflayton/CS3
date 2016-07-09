import java.util.Scanner;
import java.util.Arrays;

class Main
{
	public static void main(String[] args)
	{
		//data entry
		Candidate[] candidateList = new Candidate[10];

		String name, age, party, issueList, another;
		int issueNumber;
		int candidateCounter = 0;
		boolean done = false;
		while (!done)
		{
			name = getInput("Name: ");
			age = getInput("Age: ");
			party = getInput("Party: ");

			issueNumber = Integer.parseInt(getInput("Number of Issues: "));
			issueList = "";
			for (int i=1; i <= issueNumber; i++)
			{
				issueList += getInput(i+": ");
				if (i < issueNumber)
				{
					issueList += ";";
				}
			}

			candidateList[candidateCounter] = new Candidate(name,age,party,issueList);

			another = getInput("Another? (Y/N): ");
			if (another.substring(0,1).equals("N"))
			{
				done = true;
			}

			candidateCounter++;
		}

		//get rid of null references
		Candidate[] candidates = new Candidate[candidateCounter];
		for (int i = 0; i < candidateCounter; i++)
		{
			candidates[i] = candidateList[i];
		}

		//sorting
		bubbleSort(candidates);

		//menu
		System.out.println("MENU OPTIONS");
		System.out.println("1. Display the names of all candidates");
		System.out.println("2. Display all data for a candidate");
		System.out.println("3. Display the names of candidates in a party");
		System.out.println("4. Display the names of candidates with a focus on a certain issue");
		System.out.println("5. Quit the program");
		//
		getMenuOption(candidates);

	}
	public static String getInput(String prompt)
	{
		Scanner s = new Scanner(System.in);
		System.out.print(prompt);
		String input = s.nextLine().toUpperCase();
		return input;
	}
	public static void bubbleSort(Candidate[] c)
	{
		boolean unsorted = false;
		do
		{
			unsorted = false;
			for(int i = 0; i < c.length - 1; i++)
			{
				if (c[i].getName().compareTo(c[i+1].getName()) > 0)
				{
					Candidate temp = c[i];
					c[i] = c[i+1];
					c[i+1] = temp;

					unsorted = true;
				}
			}
		} while (unsorted);
	}
	public static void getMenuOption(Candidate[] c)
	{
		String input = getInput("Enter a valid menu option (1-5): ");
		if (isInteger(input))
		{
			int option = Integer.parseInt(input);
			if (1 <= option && option <= 5)
			{
				switch(option)
				{
					case 1:
						for (Candidate candidate : c)
						{
							System.out.println(candidate.getName());
						}
						break;
					case 2:
						String query = getInput("Search for whom?: ");
						searchCandidate(query, c).display();
						break;
					case 3:
						String party = getInput("Search for what party?: ");
						for (Candidate candidate : c)
						{
							if(party.equals(candidate.getParty()))
							{
								System.out.println(candidate.getName());
							}
						}
						break;
					case 4:
						String issue = getInput("Search for what issue?: ");
						for (Candidate candidate : c)
						{
							if(candidate.hasIssue(issue))
							{
								System.out.println(candidate.getName());
							}
						}
						break;
					case 5:
						String choice = getInput("Are you sure? (Y/N): ");
						if (choice.substring(0,1).equals("Y"))
						{
							System.exit(0);
						}
						else
						{
							getMenuOption(c);
						}
				}
			}
			else
			{
				getMenuOption(c);
			}
		}
		else
		{
			getMenuOption(c);
		}
		getMenuOption(c);
	}
	public static boolean isInteger(String s)
	{
		return s.matches("^-?\\d+$");
	}
	public static void displayCandidates(Candidate[] list)
	{
		for (Candidate candidate : list)
		{
			System.out.println(candidate.getName());
		}
	}
	public static Candidate searchCandidate(String query, Candidate[] list)
	{

		int low = 0;
		int high = list.length - 1;
		int mid;

		while(low <= high)
		{
			mid = (high+low)/2;

			if (list[mid].getName().compareTo(query) > 0)
			{
				high = mid - 1;
			}
			else if(list[mid].getName().compareTo(query) < 0)
			{
				low = mid + 1;
			}
			else
			{
				return list[mid];
			}
    }

		return null;
	}
}
