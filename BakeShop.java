
/**
 * This class creates a BakeShop and allows to sublit BakeryOrder to the BakeShop
 *
 * @author Iryna Sherepot
 * @version 7/19/18
 */
public class BakeShop
{
    // instance variables 
    private int     bakerCount;
    private int     pieCount;
    private int     cakeCount;
    private int     cupcakeDozCount;
    private int     orderCount;
    private int     itemCount ;
    private double  totalSales;
    private double  orderPrice;   
    private BakeryOrder oneOrder;
    //constants
    private static final int  EACH_BAKER_CAPACITY = 25;
    
    //==============CONSTRUCTORS===============
    /**
     * Constructor for objects of class BakeShop
     */
    public BakeShop()
    {
        this(0);
    }

    /** Full constructor for class BakeShop.
     * 
     * @param The number of bakers in a shop- must be non-negative
     */
    public BakeShop(int bakerCount) {
        if(bakerCount < 0){
            throw new IllegalArgumentException("Number of bakers has to be non-negative");   
        }
        this.bakerCount = bakerCount;
    }

    //===================ACCESSORS==========================

    /**
     * This methods access bakerCount fiels to show the number of bakers in a shop
     *
     * @return the number of bakers in a shop
     */

    public int getBakerCount() {
        return bakerCount;
    }

    /**
     * Accesses pieCount fiels to show the number of pies 
     *
     * @return number of pies processed by the shop
     */
    public int getPiesOnOrderCount(){
        return this.pieCount;
    }

    /**
     * Accesses cakeCount field to show the number of cakes processed 
     *
     * @return number of cakes processed by the shop
     */
    public int getCakesOnOrderCount(){
        return this.cakeCount;
    }

    /**
     * Accesses cupcakeDozCount field to show the number of dozen cupcakes processdd 
     *
     * @return number of cupcake dozens processed by the shop
     */
    public int getCupcakeDozOnOrderCount(){
        return this.cupcakeDozCount;
    }

    /**
     * Accesses orderCount field to show the number of orders processdd 
     *
     * @return number of orders dozens processed by the shop
     */
    public int getOrderCount(){
        return this.orderCount;
    }

    /**
     * Accesses totalSales field to show the total sales of the shop after processed orders
     *
     * @return the total amount of sales of all orders processed
     */
    public double getTotalSales(){
        return this.totalSales;
    }   

    /**
     * Calculates average order price for all orders
     * If no orders, returns 0 evarage price
     * @return double The average price of processed orders in a shop.
     */
    public double getAvgOrderPrice(){
        if(getOrderCount() == 0){
            return 0;
        }else{
            return (double)(getTotalSales() / getOrderCount());
        }
    }
    //===================OTHER METHODS============================================
    /**
     * This method submits BakeryOrder to the Shop
     * It maintains the items counts, order count, order price and total sales 
     * Bakeshop will reject order if order puts shop over capacity
     * @param The BakeryOrder
     * @return The price of the order just processed.
     */
    public double submitOrder(BakeryOrder OneOrder) {
        if((OneOrder.getItemCount() + this.itemCount) > EACH_BAKER_CAPACITY * getBakerCount()){
            throw new IllegalArgumentException("Order puts bakery over it's capacity");
        }
        this.pieCount           += OneOrder.getPieCount();
        this.cakeCount          += OneOrder.getCakeCount();
        this.cupcakeDozCount    += OneOrder.getCupcakeDozenCount();
        this.totalSales         += OneOrder.getPrice();
        this.orderPrice          = OneOrder.getPrice(); 
        this.itemCount          += OneOrder.getItemCount();
        this.orderCount         ++;

        return this.orderPrice;
    }

    /**
     * Increases number of bakers by one
     */
    public void hireOneBaker(){
        this.bakerCount += 1;
    }

    /**
     * Decreases number of bakers by one
     * Cannot fire more bakers than bakery has
     */
    public void fireOneBaker() {
        if(bakerCount == 0){
            throw new IllegalArgumentException("You can't fire more bakers than you have");   
        }
        this.bakerCount -= 1;
    }

    /**
     * Returns a string representation of Bake Shop's instance variables.
     * @return info String represendtation instance variables
     */
    public String toString() {
        String info = "";
        info += "cake On Order Count: "   + this.cakeCount;
        info += "\npie On: "              + this.pieCount;
        info += "\ncupcakeDozCount: "     + this.cupcakeDozCount;
        info += "\nOrderTotal is :"       + this.orderPrice;
        info += "\nTotal Sales are $%5.2f"+ this.totalSales;
        info += "\nItem Count is :"       + this.itemCount;
        info += "\nBaker Count is: "      + this.bakerCount;
        info += "\nOrderCount is:"        + this.orderCount;

        return info;
    }
}
