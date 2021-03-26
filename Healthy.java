public class Healthy extends Hamburger
{
	private int cucumber= 0;
	private int egg= 0;
	private double basePrice= PriceBread() + super.PriceMeat();
	private double extraPriceHealthy= 0.0;
	 
	public Healthy()
	{
		super();
	}

	public Healthy (int lettuce, int tomato, int carrots, int cheese, int cucumber, int egg)
	{
		this ("Brown rye", 1, lettuce, tomato, carrots, cheese, cucumber, egg);
	}

	public Healthy (String bread, int meat, int lettuce, int tomato, int carrots, int cheese, int cucumber, int egg)
	{
		super (bread, meat, lettuce, tomato, carrots, cheese);
		this.cucumber= cucumber;
		this.egg= egg;
		this.setExtraPriceHealthy();
	}

	@Override
	public void printPrice()
    {
        System.out.println("Base price= " + this.basePrice + "\nExtra Price= " + this.extraPriceHealthy + "\nTotal price= " + getPrice());
    } 

	@Override
	public double getPrice()
	{
		return (this.basePrice + this.extraPriceHealthy);
	}

	public double getExtraPriceHealthy() 
	{
	    return extraPriceHealthy;
	}
	
	public void setExtraPriceHealthy() 
	{
	    this.extraPriceHealthy = super.getExtraPrice() + PriceCucumber()*cucumber + PriceEgg()*egg;
	}

	public double getBasePrice() 
	{
	    return basePrice;
	}	

	public int getCucumber()
	{
		return cucumber;
	}

	public int getEgg()
	{
		return egg;
	}

	//all these functions return the price of the items.
	@Override
	public double PriceBread() 
	{
	    return 5.00;
	}
	
	public double PriceEgg() 
	{
	 return 10.00;
	}

	public double PriceCucumber() 
	{
	    return 1.00;
	}	
}
