package com.testng.scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonTest extends Generic{

	/**
	 * Amazon workflow
	 * 1. User Registration
	 * 2. Login
	 * 3. Search Product
	 * 4. AddToCart
	 * 5. Checkout
	 * 6. Place Order
	 * 7. ViewRecipt
	 * 8. Cancel Order
	 * 9. Refunds Confirmation
	 * 10. Logout
	 */

    /**
	 *  @BeforeSuite: The annotated method will be run before all tests in this suite have run.
	
	    @AfterSuite: The annotated method will be run after all tests in this suite have run.
		
		@BeforeTest: The annotated method will be run before any test method belonging to the classes inside the <test> tag is run.
		
		@AfterTest: The annotated method will be run after all the test methods belonging to the classes inside the <test> tag have run.
		
		@BeforeGroups: The list of groups that this configuration method will run before. This method is guaranteed to run shortly before the first test method that belongs to any of these groups is invoked.
		
		@AfterGroups: The list of groups that this configuration method will run after. This method is guaranteed to run shortly after the last test method that belongs to any of these groups is invoked.
		
		@BeforeClass: The annotated method will be run before the first test method in the current class is invoked.
		
		@AfterClass: The annotated method will be run after all the test methods in the current class have been run.
		
		@BeforeMethod: The annotated method will be run before each test method.
		
		@AfterMethod: The annotated method will be run after each test method.
	*/
	@BeforeTest
	public void login() {
		System.out.println("Login");
	}
	
	@BeforeClass
	public void searchProduct() {
		System.out.println("Product Search");
	}
	
	@BeforeMethod
	public void verifyProductQuantity() {
		System.out.println("Verified product..!");
	}
	
	@AfterMethod
	public void verifyProductPrice() {
		System.out.println("Verified product price based on quantity..!");
	}
	
	@Test(priority = -1)
	public void addtoCart() {
		System.out.println("Product is Added to Cart");
	}
	
	@Test(priority = 2)
	public void checkout() {
		System.out.println("Product is CheckedOut");
	}
	
	@Test(dependsOnMethods = {"checkout"})
	public void placeOrder() {
		System.out.println("Order placed successfully..!");
	}
	
	@Test(dependsOnMethods = {"placeOrder"} )
	public void checkReceipt() {
		System.out.println("Receipt is generated");
	}
			
	@AfterClass
	public void cancelOrder() {
		System.out.println("Order is Canceled");
	}
	
	@AfterTest
	public void refund() {
		System.out.println("Refund Complete");
	}
	
}
