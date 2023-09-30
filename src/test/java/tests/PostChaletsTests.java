package tests;

import helpers.Methods;
import helpers.TestMethods;
import org.testng.annotations.Test;

public class PostChaletsTests {

	TestMethods testMethods = new TestMethods();

	@Test(priority = 1)
	public void postSearchChaletsApiStatusCodeTest() {

		Methods.setURL();
		testMethods.assertSearchChaletsApiStatusCodeIsTwoHundred();
	}

	@Test(priority = 2)
	public void postSearchChaletsApiResponseBodyTest_SearchId() {

		Methods.setURL();
		testMethods.assertSearchChaletsApiSearchId();
	}

	@Test(priority = 3)
	public void postSearchChaletsApiResponseBodyTest_Dates() {

		Methods.setURL();
		testMethods.assertSearchChaletsApiCheckInCheckOut();
	}
}
