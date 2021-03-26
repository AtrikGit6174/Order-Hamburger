public class Deluxe extends Hamburger
{
	private int chips= 1;
	private int drinks= 1;
	private double price= super.getBasePrice() + PriceChips() + PriceDrinks();

	public Deluxe ()
	{
		super ("Basic", 1, 0, 0, 0, 0); 
	}

	@Override
	public double getPrice()
	{
		return (price);
	}
	@Override
	public void printPrice()
    {
        System.out.println("Total price= " + getPrice());
    }

    //all these functions return the price of the items.
    public double PriceChips()
    {
    	return 5.00;
    }

    public double PriceDrinks()
    { 
    	return 10.00;
    }
}
