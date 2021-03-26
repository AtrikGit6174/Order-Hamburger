public class Hamburger 
{
    private String bread;
    private int meat= 1;
    private int lettuce= 0;
    private int tomato= 0;
    private int carrots= 0;
    private int cheese= 0;
    private double basePrice= PriceBread() + PriceMeat();
    private double extraPrice= 0.0;
     
    public Hamburger()
    {

    }

    public Hamburger (int lettuce, int tomato, int carrots, int cheese)
    {
    	this ("Basic", 1, lettuce, tomato, carrots, cheese);
    } 

    public Hamburger (String bread, int meat, int lettuce, int tomato, int carrots, int cheese)
    {
    	this.bread= bread;
    	this.meat= meat;
    	this.lettuce= lettuce;
    	this.tomato= tomato;
    	this.carrots= carrots;
    	this.cheese= cheese;
        this.setExtraPrice();
    }

    public void printPrice()
    {
        System.out.println("Base price= " + this.basePrice + "\nExtra Price= " + this.extraPrice + "\nTotal price= " + (this.basePrice + this.extraPrice));
    }

    public double getPrice()
    {
        return (this.basePrice + this.extraPrice);
    }

    public double getExtraPrice() 
    {
        return extraPrice;
    }
     
    public void setExtraPrice() 
    {
        this.extraPrice= PriceLettuce()*lettuce + PriceTomato()*tomato + PriceCarrots()*carrots + PriceCheese()*cheese;
    }
    
    public double getBasePrice() 
    {
        return basePrice;
    }
     
    public int getCheese() 
    {
        return cheese;
    }
     
    public int getCarrots() 
    {
        return carrots;
    }
     
    public int getTomato() 
    {
        return tomato;
    }
     
    public int getLettuce() 
    {
        return lettuce;
    }

    //all these functions return the price of the items.
    public double PriceCheese() 
    {
        return 4.00;
    }
     
    public double PriceCarrots() 
    {
        return 3.00;
    }
     
    public double PriceTomato() 
    {
        return 1.00;
    }
     
    public double PriceLettuce() 
    {
        return 1.00;
    }
     
    public double PriceMeat()
    {
        return 10.00;
    }
    public double PriceBread() 
    {
        return 4.00;
    }
     
}
