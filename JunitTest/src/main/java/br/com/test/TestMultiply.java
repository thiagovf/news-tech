package br.com.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMultiply {
	
	@BeforeClass 
	public static void beforeAllTestsMethod() {
		System.out.println("[beforeAllTestsMethod] :: Executes the method once, before the start of all tests. " +
				"This can be used to perform time intensive activities, for example to connect to a database. " +
				"Methods annotated with this annotation need to be defined as static to work with JUnit.\n");
	}

	@Before 
	public void beforeEachTestMethod () {
		System.out.println("[beforeEachTestMethod] :: Executes the method before each test. This method can prepare the test environment " +
				"(e.g. read input data, initialize the class).\n");
	}
	
	@Test
	public void testMultiply() {

	   // MyClass is tested
	   MyClass tester = new MyClass();
	   
	   // Check if multiply(10,5) returns 50
	   assertEquals("10 x 5 must be 50", 50, tester.multiply(10, 5));

	 }
	
	@Test
	public void testDivision() {

	   // MyClass is tested
	   MyClass tester = new MyClass();
	   
	   // Check if multiply(10,5) returns 50
	   assertEquals("10 / 5 must be 2", 2, tester.division(10, 5));

	 }

	@After
	public void afterTestMethod() {
		System.out.println("[afterTestMethod] :: Executes the method after each test. This method can cleanup the test environment " +
				"(e.g. delete temporary data, restore defaults). It can also save memory by cleaning up expensive " +
				"memory structures.\n");
	}
	
	@AfterClass 
	public static void afterAllTestsMethods(){
		System.out.println("[afterAllTestsMethods] :: Executes the method once, after all tests have have been finished. This can be used to " +
				"perform clean-up activities, for example to disconnect from a database. Methods annotated with this " +
				"annotation need to be defined as static to work with JUnit.\n");
	}

}
