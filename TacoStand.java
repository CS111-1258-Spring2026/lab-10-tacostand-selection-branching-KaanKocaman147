public class TacoStand
{
	/* CONSTANT VARIABLES */
	public static final String BAR = "----------------------------------------";

	private static final double PRICE_ASADA = 2.50;
	private static final double PRICE_POLLO = 1.75;
	private static final double PRICE_LENGUA = 3.00;
	private static final double PRICE_ULTIMATE = 18.00;

	/* STATIC VARIABLES */
	private static int numAsada = 0, numPollo = 0, numLengua = 0, numUltimate = 0;
	private static double totalFunds = 0;

	/**
	 * Sets the store to zero for use in automated testing.
	 */
	public static void initialize()
	{
		numAsada = numPollo = numLengua = numUltimate = 0;
		totalFunds = 0.0;
	}

	/**
	 * Outputs taco menu
	 */
	public static void printMenu()
	{
		System.out.println("Menu options:\n" + TacoStand.BAR);
		System.out.printf("%2d. %-21s [$%5.2f]%n", 1, "Carne Asada (Steak)", PRICE_ASADA);
		System.out.printf("%2d. %-21s [$%5.2f]%n", 2, "Pollo Asado (Chicken)", PRICE_POLLO);
		System.out.printf("%2d. %-21s [$%5.2f]%n", 3, "Lengua (Beef Tongue)", PRICE_LENGUA);
		System.out.printf("%2d. %-21s [$%5.2f]%n", 4, "Ultimate Taco", PRICE_ULTIMATE);
		System.out.println(TacoStand.BAR);
	}

	/**
	 * Returns taco stand status
	 */
	public static String getStatus()
	{
		return String.format("%s%nMCC Taco Stand Status%n%s%n" +
			"%-23s$%-7.2f%n%s%n" +
			"%-23s%2d tacos%n" +
			"%-23s%2d tacos%n" +
			"%-23s%2d tacos%n" +
			"%-23s%2d tacos%n%s",
			TacoStand.BAR, TacoStand.BAR,
			"Funds Available:", TacoStand.totalFunds, TacoStand.BAR,
			"# of Asada Left:", TacoStand.numAsada,
			"# of Pollo Left:", TacoStand.numPollo,
			"# of Lengua Left:", TacoStand.numLengua,
			"# of Ultimate Left:", TacoStand.numUltimate, TacoStand.BAR);
	}

	/**
	 * Adds funds to taco stand
	 */
	public static void addTotalFunds(int funds)
	{
		TacoStand.totalFunds += funds;
	}

	/**
	 * Orders taco supplies if budget allows
	 */
	public static boolean orderSupplies(double budget)
	{
		if(budget <= TacoStand.totalFunds)
		{
			int tacosEach = (int)(Math.round(budget / 0.75 / 4));

			TacoStand.totalFunds -= budget;

			TacoStand.numAsada += tacosEach;
			TacoStand.numPollo += tacosEach;
			TacoStand.numLengua += tacosEach;
			TacoStand.numUltimate += tacosEach;

			return true;
		}

		return false;
	}

	/**
	 * Updates funds and taco inventory after an order
	 */
	public static void updateTotalFunds(int tacoOption, int numTacos)
	{
		double price = 0;

		switch(tacoOption)
		{
			case 1:
				price = PRICE_ASADA;
				numAsada -= numTacos;
				break;

			case 2:
				price = PRICE_POLLO;
				numPollo -= numTacos;
				break;

			case 3:
				price = PRICE_LENGUA;
				numLengua -= numTacos;
				break;

			case 4:
				price = PRICE_ULTIMATE;
				numUltimate -= numTacos;
				break;
		}

		totalFunds += price * numTacos;
	}

	/**
	 * Checks if enough tacos exist to fill order
	 */
	public static boolean areTacosAvailable(int tacoOption, int numTacos)
	{
		switch(tacoOption)
		{
			case 1:
				return numAsada >= numTacos;

			case 2:
				return numPollo >= numTacos;

			case 3:
				return numLengua >= numTacos;

			case 4:
				return numUltimate >= numTacos;
		}

		return false;
	}
}
