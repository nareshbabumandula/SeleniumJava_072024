package com.testng.scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonTest {

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


	@BeforeSuite
	public void UserRegistration() {
		System.out.println("Registration");
	}
	
	@BeforeTest
	public void Login() {
		System.out.println("Login");
	}
	
	@BeforeClass
	public void SearchProduct() {
		System.out.println("Product Search");
	}
	
	@Test
	public void AddtoCart() {
		System.out.println("Product is Added to Cart");
	}
	
	@Test
	public void Checkout() {
		System.out.println("Product is CheckedOut");
	}
	
	@Test
	public void PlaceOrder() {
		System.out.println("Order placed successfully..!");
	}
	
	@Test
	public void ViewReceipt() {
		System.out.println("Receipt is generated");
	}
	
	@AfterClass
	public void CancelOrder() {
		System.out.println("Order is Canceled");
	}
	
	@AfterTest
	public void Refund() {
		System.out.println("Refund Complete");
	}
	
	@AfterSuite
	void logout() {
		System.out.println("Logged out successfully..!");
	}

}
