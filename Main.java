import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
    {
    	//Initialisations

			new Helper().detailsAll();
	    	Scanner sc= new Scanner (System.in);
	    	System.out.println("Enter number of standard burgers.");
	    	int n1= sc.nextInt();
	    	Hamburger standard[]= new Hamburger[n1];
	    	System.out.println("Enter number of healthy burgers.");
	    	int n2= sc.nextInt();
	    	Healthy healthy[]= new Healthy[n2];
	    	System.out.println("Enter number of deluxe burgers.");
	    	int n3= sc.nextInt();

	    	double totalPrice= 0.0;

    	if (n1>0)
    	{
    		new Helper().detailsStandard();
			System.out.println("If you want all hamburgers of same additionals, enter 1, else 0.");
			int allSame= sc.nextInt();

			for (int i=0; i<n1; i++)
			{
				if (i>0)
				{
					if (allSame==0)
					{
						System.out.println("Same additionals as previous? Enter 1 for Yes, 0 for No.");
						int check= sc.nextInt();
						if (check==1)
						{
							standard[i]= standard[i-1];
							standard[i].printPrice();
							continue;
						}
					}

					else
					{
						standard[i]=standard[0];
						standard[i].printPrice();
						continue;
					}
				}

				System.out.println("Enter 1 for lettuce, 0 for without.");
				int lettuce= sc.nextInt();
				System.out.println("Enter 1 for tomato, 0 for without.");
				int tomato= sc.nextInt();
				System.out.println("Enter 1 for carrots, 0 for without.");
				int carrots= sc.nextInt();
				System.out.println("Enter 1 for cheese, 0 for without.");
				int cheese= sc.nextInt();

				standard[i]= new Hamburger(lettuce, tomato, carrots, cheese);
				standard[i].printPrice();
				System.out.println("If you want to reset the present hamburger, enter 1, else 0.");
				int reset= sc.nextInt();
				if (reset==1)
					i--;
			}

			for (int i=0; i<n1; i++)
				totalPrice+= standard[i].getPrice();
    	}

    	if (n2>0)
    	{
    		new Helper().detailsHealthy();
			System.out.println("If you want all hamburgers of same additionals, enter 1, else 0.");
			int allSame= sc.nextInt();

			for (int i=0; i<n2; i++)
			{
				if (i>0)
				{
					if (allSame==0)
					{
						System.out.println("Same additionals as previous? Enter 1 for Yes, 0 for No.");
						int check= sc.nextInt();
						if (check==1)
						{
							healthy[i]= healthy[i-1];
							healthy[i].printPrice();
							continue;
						}
					}

					else
					{
						healthy[i]=healthy[0];
						healthy[i].printPrice();
						continue;
					}
				}

				System.out.println("Enter 1 for lettuce, 0 for without.");
				int lettuce= sc.nextInt();
				System.out.println("Enter 1 for tomato, 0 for without.");
				int tomato= sc.nextInt();
				System.out.println("Enter 1 for carrots, 0 for without.");
				int carrots= sc.nextInt();
				System.out.println("Enter 1 for cheese, 0 for without.");
				int cheese= sc.nextInt();
				System.out.println("Enter 1 for cucumber, 0 for without.");
				int cucumber= sc.nextInt();
				System.out.println("Enter 1 for extra meat, 0 for without.");
				int extraMeat= sc.nextInt();
				
				healthy[i]= new Healthy(lettuce, tomato, carrots, cheese, cucumber, extraMeat);
				healthy[i].printPrice();
				System.out.println("If you want to reset the present hamburger, enter 1, else 0.");
				int reset= sc.nextInt();
				if (reset==1)
					i--;
			}

			for (int i=0; i<n2; i++)
				totalPrice+= healthy[i].getPrice();	
		}

		if (n3>0)
		{
			new Helper().detailsDeluxe();
			System.out.println("You have bought " + n3 + " deluxe hamburgers.");
			totalPrice+= (n3 * new Deluxe().getPrice());
		}

		bill(standard, n1, healthy, n2, n3, totalPrice);
    }

    public static void bill (Hamburger standard[], int n1, Healthy healthy[], int n2, int n3, double totalPrice)
	{
		System.out.println("\t\t\tBILL\n");
		System.out.println("\tItems\t\t\tQuantity\t\t\tPrice");
		
		if (n1!=0)
		{
			System.out.println("\n\tSTANDARD\t\t\t" + n1);

			for (int i=0; i<n1; i++)
			{
				System.out.println("\tStandard Hamburger " + (i+1) + "\t\t\t\t" + standard[i].getBasePrice());
				
				if (standard[i].getExtraPrice() != 0.0) 
				{
					System.out.println("\t\tAdditionals");

					if(standard[i].getCheese() == 1)
						System.out.println("\t\tCheese\t\t\t\t\t\t\t" + standard[i].PriceCheese());
					if(standard[i].getCarrots() == 1)
						System.out.println("\t\tCarrots\t\t\t\t\t\t\t" + standard[i].PriceCarrots());
					if(standard[i].getTomato() == 1)
						System.out.println("\t\tTomato\t\t\t\t\t\t\t" + standard[i].PriceTomato());
				    if(standard[i].getLettuce() == 1)
						System.out.println("\t\tLettuce\t\t\t\t\t\t\t" + standard[i].PriceLettuce());
					System.out.println("\t\t\t\t\t\t\t\t\t\t" + standard[i].getPrice());
				}
			}
		}

		if (n2!=0)
		{
			System.out.println("\n\tHEALTHY\t\t\t" + n2);

			for (int i=0; i<n2; i++)
			{
				System.out.println("\tHealthy Hamburger " + (i+1) + "\t\t\t\t\t" + healthy[i].getBasePrice());
				
				if (healthy[i].getExtraPrice() != 0.0) 
				{
					System.out.println("\t\tAdditionals");

					if(healthy[i].getCheese() == 1)
						System.out.println("\t\tCheese\t\t\t\t\t\t\t" + healthy[i].PriceCheese());
					if(healthy[i].getCarrots() == 1)
						System.out.println("\t\tCarrots\t\t\t\t\t\t\t" + healthy[i].PriceCarrots());
					if(healthy[i].getTomato() == 1)
						System.out.println("\t\tTomato\t\t\t\t\t\t\t" + healthy[i].PriceTomato());
				    if(healthy[i].getLettuce() == 1)
						System.out.println("\t\tLettuce\t\t\t\t\t\t\t" + healthy[i].PriceLettuce());
					if(healthy[i].getCucumber() == 1)
						System.out.println("\t\tCucumber\t\t\t\t\t" + healthy[i].PriceCucumber());
					if(healthy[i].getEgg() == 1)
						System.out.println("\t\tEgg\t\t\t\t" + healthy[i].PriceEgg());
					System.out.println("\t\t\t\t\t\t\t\t\t" + healthy[i].getPrice());
				}
			}
		}

		if (n3!=0)
		{
			System.out.println("\n\tDELUXE\t\t\t" + n3 + "\t\t\t" + (n3 * new Deluxe().getPrice()));
		}

		System.out.println("\tTOTAL BURGERS= " + (n1+n2+n3));
		System.out.println("\tTOTAL PRICE= " + totalPrice);
	}
}

class Helper
{	
	Hamburger dummy_ham= new Hamburger();
	Healthy dummy_healthy= new Healthy();
	Deluxe dummy_deluxe= new Deluxe();

	public void detailsAll()
	{
		detailsStandard();
		detailsHealthy();
		detailsDeluxe();
	}
	public void detailsStandard ()
	{
		System.out.println("Standard Hamburger contains basic bread roll and a single slice of meat.");
		System.out.println("Base price is " + dummy_ham.getBasePrice() + "(Bread is " + dummy_ham.PriceBread() + ", meat is " + dummy_ham.PriceMeat() + ")");
		System.out.println("Additionals include lettuce("+ dummy_ham.PriceLettuce()+ "), tomato(" + dummy_ham.PriceTomato() + "), carrots(" + dummy_ham.PriceCarrots() + ") and cheese(" + dummy_ham.PriceCheese() + ").");
	}

	public void detailsHealthy()
	{
		System.out.println("Healthy Hamburger contains Brown rye bread roll and a single slice of meat.");
		System.out.println("Base price is " + dummy_healthy.getBasePrice() + " (Bread is " + dummy_healthy.PriceBread() + ", meat is " + dummy_healthy.PriceMeat() + ")");
		System.out.println("Additionals include lettuce("+ dummy_ham.PriceLettuce()+ "), tomato(" + dummy_ham.PriceTomato() + "), carrots(" + dummy_ham.PriceCarrots() + "), cheese(" + dummy_ham.PriceCheese() + "), cucumber(" + dummy_healthy.PriceCucumber() + ") and egg (" + dummy_healthy.PriceEgg() + "). ");
	}
	
	public void detailsDeluxe()
	{
		System.out.println("Deluxe hamburger comes with Standard Hamburger containing basic bread roll and a single slice of meat, along with chips and drinks.");
		System.out.println("Standard Hamburger contains basic bread roll and a single slice of meat.");
		System.out.println("Base price of standard hamburger is " + dummy_ham.getBasePrice() + "(Bread is " + dummy_ham.PriceBread() + ", meat is " + dummy_ham.PriceMeat() + ")");
		System.out.println("Total Deluxe hamburger price is " + dummy_deluxe.getPrice() + " (Bread is " + dummy_ham.PriceBread() + ", meat is " + dummy_ham.PriceMeat() + ", along with chips (" + dummy_deluxe.PriceChips() + ") and drinks (" + dummy_deluxe.PriceDrinks() + ")." );
	}
}	