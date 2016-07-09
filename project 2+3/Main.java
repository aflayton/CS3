import java.util.Scanner;

class Main
{
	public static void main(String[] args) throws CannotRemoveException, CannotRetrieveException, DuplicateObjectException, FullSetException
	{
		ElementSet elements = new ElementSet();
		boolean done = false;
		
		while (!done)
		{
			Candidate c;
			Donor d;
			String input;
			
			int menuChoice = getMenuChoice();
			switch (menuChoice)
			{
				case 1: //add Candidate
					c = new Candidate();
					c.readIn();
					try
					{
						elements.add(c);
					}
					catch (FullSetException e)
					{
						System.out.println("FullSetException thrown.");
					}
					catch (DuplicateObjectException e)
					{
						System.out.println("DuplicateObjectException thrown.");
						System.out.println("That Candidate is already in the set.");
					}
					break;
				case 2: //add Donor
					d = new Donor();
					d.readIn();
					try
					{
						elements.add(d);
					}
					catch (FullSetException e)
					{
						System.out.println("FullSetException thrown.");
					}
					catch (DuplicateObjectException e)
					{
						System.out.println("DuplicateObjectException thrown.");
						System.out.println("That Donor is already in the set.");
					}
					break;
				case 3:
					for (int i = 0; i < elements.size(); i++)
					{
						Element anElement = elements.getCurrent();
						if (anElement.getClassName().equals("Candidate"))
						{
							c = (Candidate) anElement;
							System.out.println(c.getName());
						}
					}
					break;
				case 4:
					for (int i = 0; i < elements.size(); i++)
					{
						Element anElement = elements.getCurrent();
						if (anElement.getClassName().equals("Donor"))
						{
							d = (Donor) anElement;
							System.out.println(d.getName());
						}
					}
					break;
				case 5: //display Candidate
					input = getInput("Display who?: ");
					c = new Candidate();
					c.setName(input);
					try
					{
						elements.retrieveAnObject(c).display();
					}
					catch(CannotRetrieveException e)
					{
						System.out.println("CannotRetrieveException thrown.");
						System.out.println("The Candidate you specified is not in the set.");
					}
					break;
				case 6: //display Donor
					input = getInput("Display who?: ");
					d = new Donor();
					d.setName(input);
					try
					{
						elements.retrieveAnObject(d).display();
					}
					catch(CannotRetrieveException e)
					{
						System.out.println("CannotRetrieveException thrown.");
						System.out.println("The Donor you specified is not in the set.");
					}
					break;
				case 7: //remove Candidate
					input = getInput("Remove who?: ");
					c = new Candidate();
					c.setName(input);
					try
					{
						elements.removeAnObject(c);
					}
					catch(CannotRemoveException e)
					{
						System.out.println("CannotRemoveException thrown.");
						System.out.println("The Candidate you specified is not in the set.");
					}
					break;
				case 8: //remove Donor
					input = getInput("Remove who?: ");
					d = new Donor();
					d.setName(input);
					try
					{
						elements.removeAnObject(d);
					}
					catch(CannotRemoveException e)
					{
						System.out.println("CannotRemoveException thrown.");
						System.out.println("The Donor you specified is not in the set.");
					}
					break;
				case 9:
					String choice = getInput("Are you sure? (Y/N): ");
					if (choice.substring(0,1).equals("Y"))
					{
						done = true;
					}
					break;
			}
		}
		
	}
	public static int getMenuChoice()
	{
		//display menu
		System.out.println("Menu Options");
		System.out.println("1 - add candidate");
		System.out.println("2 - add donor");
		System.out.println("3 - display all candidates' names");
		System.out.println("4 - display all donors' names");
		System.out.println("5 - display candidate data");
		System.out.println("6 - display donor data");
		System.out.println("7 - remove candidate");
		System.out.println("8 - remove donor");
		System.out.println("9 - quit");
		//get user input
		while (true)
		{
			String input = getInput("Select a valid menu choice: ");
			if (isInteger(input))
			{
				int option = Integer.parseInt(input);
				if (option >= 1 && option <= 9)
				{
					return option;
				}
			}
		}
	}
	public static boolean isInteger(String s) 
	{
		return s.matches("^-?\\d+$");
	}
	public static String getInput(String prompt)
	{
		Scanner s = new Scanner(System.in);
		System.out.print(prompt);
		String input = s.nextLine().toUpperCase();
		return input;
	} 
}