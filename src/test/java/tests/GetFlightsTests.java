package tests;

import helpers.Methods;
import helpers.TestMethods;
import org.testng.annotations.Test;

public class GetFlightsTests {

	TestMethods testMethods = new TestMethods();

	@Test(priority = 1)
	public void getFlightApiStatusCodeTest() {

		Methods.setURL();
		testMethods.assertGetFlightsApiStatusCodeIsTwoHundred();
	}

	@Test(priority = 2)
	public void getFlightApiResponseBodyTest_Nid() {

		Methods.setURL();
		testMethods.assertGetFlightsApiResponseBodyNid();
	}

	@Test(priority = 3)
	public void getFlightApiResponseBodyTest_Destinations() {

		Methods.setURL();
		testMethods.assertGetFlightsApiResponseBodyDestinations();
	}
}
