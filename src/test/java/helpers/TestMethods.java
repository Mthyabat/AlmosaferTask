package helpers;

import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import utilities.DataReaderUtil;

public class TestMethods {

	Methods reusableMethods = new Methods();
	ApiRequests apiRequests = new ApiRequests();
	String stringResponse;
	ValidatableResponse objectResponse;

	public void assertGetFlightsApiStatusCodeIsTwoHundred() {

		apiRequests.getFlightsApi().then().log().all().statusCode(200);
	}

	public void assertGetFlightsApiResponseBodyNid() {

		stringResponse = apiRequests.getFlightsApi().then().log().all().extract().asString();

		String nid = reusableMethods.getValueFromResponseBody(stringResponse, "next.nid");

		Assert.assertNotNull(nid);
	}

	public void assertGetFlightsApiResponseBodyDestinations() {

		stringResponse = apiRequests.getFlightsApi().then().log().all().extract().asString();

		String actualOriginId = reusableMethods.getValueFromResponseBody(stringResponse, "request.leg[0].originId");
		String actualDestinationId = reusableMethods.getValueFromResponseBody(stringResponse,
				"request.leg[0].destinationId");

		Assert.assertEquals(DataReaderUtil.dataReader("expectedOriginID"), actualOriginId);
		Assert.assertEquals(DataReaderUtil.dataReader("expectedDestinationID"), actualDestinationId);
	}

	public void assertSearchChaletsApiStatusCodeIsTwoHundred() {

		objectResponse = apiRequests.postChaletsSearchApi().then().assertThat().statusCode(200);
	}

	public void assertSearchChaletsApiSearchId() {

		stringResponse = apiRequests.postChaletsSearchApi().then().log().all().extract().asString();
		String searchId = reusableMethods.getValueFromResponseBody(stringResponse, "searchId");
		Assert.assertNotNull(searchId);

		String searchIdExpiry = reusableMethods.getValueFromResponseBody(stringResponse, "searchIdExpiry");
		Assert.assertNotNull(searchIdExpiry);
	}

	public void assertSearchChaletsApiCheckInCheckOut() {

		stringResponse = apiRequests.postChaletsSearchApi().then().log().all().extract().asString();

		String checkIn = reusableMethods.getValueFromResponseBody(stringResponse, "checkIn");
		Assert.assertNotNull(checkIn);

		String checkOut = reusableMethods.getValueFromResponseBody(stringResponse, "checkOut");
		Assert.assertNotNull(checkOut);
	}
}
