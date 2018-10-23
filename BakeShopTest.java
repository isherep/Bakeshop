
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BakeShopTest.
 *
 * @author  Iryna Sherepot
 * @version 7/23/18
 */
public class BakeShopTest{

    /**
     * Default constructor for test class BakeShopTest
     */
    public BakeShopTest(){
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown(){
    }

    /**
     * Tests full constructor
     */
    @Test
    public void testFullConstructor(){
        //first test
        BakeryOrder testOrder   = new BakeryOrder(1,6,1,10);
        BakeShop testShop       = new BakeShop(24);
        assertEquals(24,     testShop.getBakerCount());
        assertEquals(395.83, testShop.submitOrder(testOrder),2);
        assertEquals(1,      testShop.getOrderCount()); 
        assertEquals(6,      testShop.getPiesOnOrderCount());
        assertEquals(1,      testShop.getCakesOnOrderCount());
        assertEquals(10,     testShop.getCupcakeDozOnOrderCount());
        assertEquals(395.83, testShop.getTotalSales(),2);
        assertEquals(395.83, testShop.getAvgOrderPrice(), 2);
        //second test
        BakeryOrder test1Order = new BakeryOrder(2,50,100,29);
        assertEquals(24,      testShop.getBakerCount());
        assertEquals(5294.24, testShop.submitOrder(test1Order),2);
        assertEquals(2,       testShop.getOrderCount()); 
        assertEquals(56,      testShop.getPiesOnOrderCount());
        assertEquals(101,     testShop.getCakesOnOrderCount());
        assertEquals(39,      testShop.getCupcakeDozOnOrderCount());
        assertEquals(5690.07, testShop.getTotalSales(), 2);
        assertEquals(2845.02, testShop.getAvgOrderPrice(), 2);
    } 

    /**
    * Tests constructor negative agrgument precondition
    */
    @Test(expected = IllegalArgumentException.class) 
    public void testConstructorNegType(){
        BakeShop testShop = new BakeShop(-5);
    }

    /**
     * Tests capacity limits.
     */
    @Test
    public void tesClosetoCapacity() {
        BakeShop testShop       = new BakeShop(1);
        BakeryOrder testOrder   = new BakeryOrder(1, 25,0,0);
        assertEquals(499.75,testShop.submitOrder(testOrder),2);
        assertEquals(1,     testShop.getOrderCount()); 
        assertEquals(25,    testShop.getPiesOnOrderCount());
        assertEquals(0,     testShop.getCakesOnOrderCount());
        assertEquals(0,     testShop.getCupcakeDozOnOrderCount());
        assertEquals(499.75,testShop.getTotalSales(),2);
    }

    /**
    * Tests precondition if order over capacity
    */
    @Test(expected = IllegalArgumentException.class)
    public void testSubmitOverCapacity (){
        BakeryOrder testOrder   = new BakeryOrder(1,200,200,201);
        BakeShop testShop       = new BakeShop(24);
        assertEquals(15994.00, testShop.submitOrder(testOrder),2);
    }

    /**
    * Tests prEcodition of firing more bakers than bakery has.
    */
    @Test(expected = IllegalArgumentException.class)
    public void testFireTooManyBaker(){
        BakeShop testShop = new BakeShop(0);
        testShop.fireOneBaker();
    }

    /**
     * Test hireOneBaker() and fireOneBaker() methods
     */
    @Test
    public void testHireFireBaker(){
        BakeShop testShop = new BakeShop(1);
        testShop.fireOneBaker();
        assertEquals(0, testShop.getBakerCount());
        testShop.hireOneBaker();
        assertEquals(1, testShop.getBakerCount());
    }
}