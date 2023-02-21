package SnackBar;

import Number42.Coins;

/**
 * This class implements a vendor that sells one kind
 * of items. A vendor carries out sales transactions.
 */
public class Vendor
{
    // Fields:

    private int price;
    private int stock;
    private int deposit;
    private int change;
    //make a private static double variable called totalSales that has an initial value of 0
    private static double totalSales = 0.0;


    /**
     * Constructs a Vendor
     * @param price the price of a single item in cents (int)
     * @param stock number of items to place in stock (int)
     */
    public Vendor(int price, int stock)
    {
        //You need to complete this using this. notation
        this.price = price;
        this.stock = stock;

    }

    /**
     * Sets the quantity of items in stock.
     * @param stock number of items to place in stock (int)
     */


    public void setStock(int stock)
    {
        //You need to complete this using this. notation
        this.stock = stock;
    }

    /**
     * Returns the number of items currently in stock.
     * @return number of items currently in stock (int)
     */
    public int getStock()
    {
        //complete this
        return this.stock;
    }

    /**
     * Adds a specified amount (in cents) to the
     * deposited amount.
     * @param d of cents to add to the deposit (int)
     */
    public void addMoney(int d)
    {
        //You need to complete this using mutator
        deposit += d;
    }

    /**
     * Returns the currently deposited amount (in cents).
     * @return number of cents in the current deposit (int)
     */
    public int getDeposit()
    {
        return deposit;
    }

    /**
     * Implements a sale.  If there are items in stock and
     * the deposited amount is greater than or equal to
     * the single item price, then adjusts the stock
     * and calculates and sets change and returns true;
     * otherwise refunds the whole deposit (moves it into
     * change) and returns false.
     * @return true for a successful sale, false otherwise (boolean)
     */
    public boolean makeSale()
    {
        //create the makesale method
        if(stock > 0 && deposit >= price){
            stock--;
            change += deposit - price;
            totalSales += price;
            deposit = 0;
            return true;
        }
        else {
            change += deposit;
            deposit = 0;
            return false;
        }
    }

    /**
     * Returns and zeroes out the amount of change (from
     * the last sale or refund).
     * @return number of cents in the current change (int)
     */
    public int getChange()
    {
        int c = change;
        change = 0;
        return c;
    }

    public String getChangeString()
    {
        //From Ethan: create a get method that returns the amount and type of coins that should be returned by the machine
        /*
        note that the coin class has a .getQuarters(), a .getDimes() etc etc (use the coin class!)
        */
        Coins returnChange = new Coins(change);
        int quarters = returnChange.getQuarters();
        int dimes = returnChange.getDimes();
        int nickles = returnChange.getNickles();
        int pennies = returnChange.getPennies();

        String changeString= quarters + "Q, " + dimes + "D, " + nickles + "N, " + pennies + "P";

        return changeString;
    }
    
    /**
    * Returns the total number of sales and resets the total number of sales to 0
    * Hint: use a temp variable
    *
    * @return number of sales
    */
    public static double getTotalSales()
    {
        //complete this
        double temp = totalSales;
        temp /= 100;
        totalSales = 0.0;
        return temp;
    }
}
