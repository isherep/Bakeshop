
/**
 * This is a BakeryOrder class. 
 * The order is represented by amount of pies, cakes, and cupcake dozens and order number .
 *
 * @Iryna Sherepot (your name)
 * @7/12/18
 */
public class BakeryOrder{

    //-----------INSTANCE VARIABLES--------
    private int orderNum;
    private int pieCount;
    private int cakeCount;
    private int cupcakeDozCount;
    //-----------CONSTANTS----------
    private final double COST_OF_PIE     = 19.99;
    private final double COST_OF_CAKE    = 35.99;
    private final double COST_OF_CUP_DOZ = 23.99;
    //=================CONSTRUCTORS=========================
    /**
     * Constructor for objects of class BakeryOrder
     */
    public BakeryOrder(int orderNum){
        this(orderNum, 0, 0, 0);
    }

    /**
     * Full Constructor for objects of class BakeryOrder
     * @param orderNum the order number, comes from outside is not incremented- can't be negative 
     * @param pieCount the number of pies in order - can't be negative
     * @param cakeCount the number of cakes in order - can't be negative
     * @param cupcakeDozcupcakeDozCount the number of cupcake dozens in order -can't be negative
     */
    public BakeryOrder(int orderNum,int pieCount, int cakeCount, int cupcakeDozCount) {
        if(orderNum<0){
            throw new IllegalArgumentException("Order number cannot be negative");   
        }
        validateInput(orderNum);
        this.orderNum = orderNum;
        setPieCount(pieCount);
        setCakeCount(cakeCount);
        setCupcakeDozCount(cupcakeDozCount);
    }
    //===================ACCESSORS==========================
    /**
     * Accesses orderNum the instance variable
     * @return orderNum int the Order number
     */
    public int getOrderNumber(){
        return orderNum;
    }

    /**
     * Accesses pieCount instance variable
     * @return pieCount int the number of pies on order
     */
    public int getPieCount(){
        return pieCount;
    }

    /**
     * Accesses cakeCount instance variable
     * @return pieCount int the number of pies on order
     */
    public int getCakeCount(){
        return cakeCount;
    }

    /**
     * Accesses cupcakeDozCount instance variable
     * @return pieCount the number of cupcake dozens on order
     */
    public int getCupcakeDozenCount(){
        return cupcakeDozCount;
    }

    /**
     * Calculates total item count on order
     * @return int order's total item count
     */
    public int getItemCount(){
        return this.pieCount + this.cakeCount + this.cupcakeDozCount;
    }

    /**
     * Calculates price of the order
     * @return double the price of the order
     */
    public double getPrice(){
        return (getPieCount() * COST_OF_PIE + getCakeCount() * COST_OF_CAKE
            + getCupcakeDozenCount() * COST_OF_CUP_DOZ);
    }

    //==================MUTATORS=====================
    /**
     * Changes number of pies in order
     * Cannot change to a negative number
     */
    public void setPieCount(int pieCount){
        validateInput(pieCount);
        this.pieCount = pieCount;   
    }

    /**
     * Changes number of cakes in order
     *  Cannot change to a negative number
     */
    public void setCakeCount(int cakeCount){
        validateInput(cakeCount);
        this.cakeCount = cakeCount;   
    }

    /**
     * Changes number of cupcake dozens in order
     * Cannot change to a negative number
     * 
     */
    public void setCupcakeDozCount(int cupcakeDozCount){
        validateInput(cupcakeDozCount);
        this.cupcakeDozCount = cupcakeDozCount;   
    }
    //--==================OTHER METHODS===========================
    /**
     * Validates input is not a negative number
     */
    public void validateInput(int input){
        if(input <0){
            throw new IllegalArgumentException("Arguments must be non negative");   
        }     
    }

    /**
     * Returns a string representation of Bake Shop's instance variables.
     * @return info String represendtation instance variables
     */
    public String toString() {
        String info = "";
        info += "cakeCount: "                   + cakeCount;
        info += "\npieCount: "                  + pieCount;
        info += "\ncupcakeDozCount: "           + cupcakeDozCount;
        info += "\nTotal order item count: "    + getItemCount();
        info += "\nTotal order Price is $%5.2f" + getPrice();

        return info;
    }
}
