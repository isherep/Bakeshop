
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BakeryOrderTest.
 *
 * @author  Iryna Sherepot
 * @version 7/12/18
 */
public class BakeryOrderTest{
    /**
     * Default constructor for test class BakeryOrderTest
     */
    public BakeryOrderTest(){
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
        BakeryOrder testOrder = new BakeryOrder(1, 5, 6, 7);
        assertEquals(1,     testOrder.getOrderNumber());
        assertEquals(5,     testOrder.getPieCount());
        assertEquals(6,     testOrder.getCakeCount());
        assertEquals(7,     testOrder.getCupcakeDozenCount());
        assertEquals(483.82,testOrder.getPrice(),2);

    }

    /**
     * Tests mutators
     */
    @Test
    public void testSetMethods(){
        BakeryOrder testOrder = new BakeryOrder(1, 5, 6, 7);
        testOrder.setCakeCount(7);
        assertEquals(1,     testOrder.getOrderNumber());
        assertEquals(5,     testOrder.getPieCount());
        assertEquals(7,     testOrder.getCakeCount());
        assertEquals(7,     testOrder.getCupcakeDozenCount());
        assertEquals(519.81,testOrder.getPrice(),2);

        testOrder.setPieCount(1);
        assertEquals(1,     testOrder.getPieCount());
        assertEquals(7,     testOrder.getCakeCount());
        assertEquals(7,     testOrder.getCupcakeDozenCount());
        assertEquals(439.85,testOrder.getPrice(), 2);
    }

    /**
    * Tests exeption when negative piecount is passed to constructor
    */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegPieType() {
        BakeryOrder testOrder = new BakeryOrder(1, -3, 4, 5);
    }

    /**
    * Tests exeption when negative cake count is passed to constructor
    */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegCakeType() {
        BakeryOrder testOrder = new BakeryOrder(1, 3, -4, 5);
    }

    /**
    * Tests exeption when negative cupcake count is passed to constructor
    */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegCupType() {
        BakeryOrder testOrder = new BakeryOrder(1, 3, 4,-55);
    }

    /**
    * Tests exeption when negative order number is passed to constructor
    */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegOrderType() {
        BakeryOrder testOrder = new BakeryOrder(-1, 3, 4, 55);
    }

    /**
     * Tests getPrice() method
     */
    @Test
    public void testGetPrice(){
        BakeryOrder testOrder = new BakeryOrder(1, 1, 1, 1);
        assertEquals(79.97, testOrder.getPrice(), 2);
    }

    /**
    * Test validateInput() method
    */
    @Test(expected = IllegalArgumentException.class) 
    public void testValidatePiesCakesCupcakes(){
        BakeryOrder testOrder = new BakeryOrder(1, 1, 1,1); 
        testOrder.validateInput(-1);
        testOrder.validateInput(-1);
        testOrder.validateInput(-1);
        testOrder.validateInput(-1);
    }
}

