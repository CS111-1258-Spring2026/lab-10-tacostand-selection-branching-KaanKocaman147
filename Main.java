// PARTNER NAME:
// PARTNER NAME: KAAN KOCAMAN 
// CS111 SECTION #: 1258
// DATE: 3/13/26

public class Main
{

	/**
	 * ALGORITHM:
	 * - Add total funds to taco stand
	 * - Order supplies
	 * - Print status of stand (when it opens)
	 * - Print welcome message
	 * - Take customer order
	 * - Print status of stand (when its closed)
	 */
	public static void main(String[] args)
	{
		//DECLARATION + INITIALIZATION SECTION
		TacoStand.initialize();

		//INPUT + CALCULATION + OUTPUT SECTION
		TacoStand.addTotalFunds(20);
		TacoStand.orderSupplies(15);

		System.out.println("OPENING UP THE STAND...");
		System.out.println(TacoStand.getStatus() + "\n\n");

		Main.printWelcome();
		System.out.println("\n");
		
		Main.takeOrder();

		System.out.println("--------CART IS CLOSED---------\n\n" + TacoStand.getStatus());
	}

	/**
	 * Outputs welcome message to start program that user sees
	 */
	public static void printWelcome()
	{
		UtilityBelt.printCentered(50, "Welcome to MCC Taco Stand!");
		UtilityBelt.printCentered(50, "┈┈┈┈╭╯╭╯╭╯┈┈┈┈┈");
		UtilityBelt.printCentered(50, "┈┈┈╱▔▔▔▔▔╲▔╲┈┈┈");
		UtilityBelt.printCentered(50, "┈┈╱┈╭╮┈╭╮┈╲╮╲┈┈");
		UtilityBelt.printCentered(50, "┈┈▏┈▂▂▂▂▂┈▕╮▕┈┈");
		UtilityBelt.printCentered(50, "┈┈▏┈╲▂▂▂╱┈▕╮▕┈┈");
		UtilityBelt.printCentered(50, "┈┈╲▂▂▂▂▂▂▂▂╲╱┈┈");
	}

	/**
	 * Prints menu and prompts user for input for kind of taco and number in order.
	 * If tacos are available, update funds and confirm order, otherwise show error.
	 */
	public static void takeOrder()
	{
		int option, numTacosOrdered;

		TacoStand.printMenu();
		option = UtilityBelt.readInt("Enter choice> ", 1, 4);
		numTacosOrdered = UtilityBelt.readInt("Enter number of tacos you want> ", 1, 50);

		if(TacoStand.areTacosAvailable(option, numTacosOrdered))
		{
			TacoStand.updateTotalFunds(option, numTacosOrdered);
			Main.printConfirmation(numTacosOrdered);
		}
		else
		{
			System.out.println("We don't have that many tacos, sorry! Try again :(");
		}
	}

	/**
	 * Prints confirmation message depending on number of tacos ordered
	 */
	public static void printConfirmation(int numTacos)
{
	System.out.println("Here you go, buen provecho!");

	for(int i = 0; i < numTacos; i++)
	{
		System.out.print("🌮");
	}

	System.out.println("\n");
}

}