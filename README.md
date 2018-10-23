# Bakeshop
This represents a bakery. 

1. Objective
This
isn’t a complete working system with a user interface; it’s just a chance to create classes, then
instantiate and test them. Project creates two supplier classes that interact with each other (through a “has
a” relationship).

2. Classes to Create - Here are UML Class Diagrams
BakeryOrder

(you figure out the private data needed)
+BakeryOrder(orderNum : Integer)
+BakeryOrder(orderNum : Integer,
pieCount : Integer, cakeCount : Integer,
cupcakeDozCount: Integer)
+getOrderNumber() : Integer
+getPieCount() : Integer
+getCakeCount() : Integer
+getCupcakeDozCount() : Integer
+getItemCount() : Integer
+getPrice() : Double
+toString() : String
+setPieCount(pieCount : Integer)
+setCakeCount(cakeCount : Integer)
+setCupcakeDozCount(cupcakeDozCount : Integer)

BakeShop

(you figure out the private data needed)
+BakeShop()
+BakeShop(bakerCount : Integer)
+getPiesOnOrderCount() : Integer
+getCakesOnOrderCount() : Integer
+getCupcakeDozOnOrderCount() : Integer
+getOrderCount() : Integer
+getTotalSales() : Double
+getAvgOrderPrice() : Double
+getBakerCount() : Integer
+toString() : String
+hireOneBaker()
+fireOneBaker()
+submitOrder(oneOrder : BakeryOrder) :
Double

3 Constraints and Assumptions
3.1 General
• Create no static methods in the production (non-test) classes.
• Mark each instance variable and each method as either public or private; follow the UML where
it gives guidance and make smart decisions where it doesn’t.
• Use the exact method names shown. Look carefully at the parameter data types and the return
data types; they give you clues.
• The toString functions should do their best to summarize the state of the object instance in
questions; include newlines in the strings to make the result displayable and attractive.
• Create JUnit unit tests for each object’s methods. Since there is no UI, this is the way to ensure
that any future clients of your code are getting exactly what they expect.
3.2 BakeryOrder
• You aren’t responsible for incrementing order numbers to make them sequential; assume they
are generated in some other system. The order number is supplied to the BakeryOrder via the
constructor, as noted in the UML Class Diagram.
• Pies cost $19.99, cakes $35.99, and cupcakes $23.99 a dozen.
• There are no flavor choices available; all pies, cakes, and cupcakes are the same.
3.3 BakeShop
• BakeShop’s submitOrder maintains the appropriate counts and totals and returns the price of the
order just processed. We aren’t storing these orders; handle what’s needed at submit time.
• BakeShop’s getAvgOrderPrice calculates the average order price, returning 0 if no orders exist.
• If you fire a baker, you don’t need to worry about the existing order workload; you’ll simply not
accept any more orders that day (preconditions will take care of that) if you’re shorthanded.

3.4 Preconditions
Throw an IllegalArgumentException if any of these preconditions are violated:
• Orders can’t be submitted if they exceed bakery capacity; each baker can handle no more than
25 items, a total of pies, cakes, and cupcake dozens.
• The number of pies, cakes, and cupcake dozens passed as arguments must be non-negative.
• Order numbers must be non-negative integers.
• You try to fire more bakers than you currently have employed.
• A BakeShop is instantiated with a negative number of bakers

5 Testing
Your test code needs to test everything (or nearly everything, the specific
results of toString aside) your object can do. Don’t forget to test constructors and
preconditions. 
