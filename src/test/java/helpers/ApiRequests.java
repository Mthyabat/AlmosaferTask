package helpers;

import io.restassured.response.Response;
import org.testng.internal.collections.Pair;
import utilities.ApiPayloads;
import utilities.DataReaderUtil;

import static io.restassured.RestAssured.given;

public class ApiRequests {

	Response response;
	DateHelper datehelper = new DateHelper();
	Pair<String, String> randomDatePairs = datehelper.getTwoRandomDates();
	Pair<String, String> randomConsecutiveDatePairs = datehelper.getTwoRandomConsecutiveDates();
	ApiPayloads apiPayloads = new ApiPayloads();

	public Response getFlightsApi() {

		return response = given().when().log().all()
				.queryParam("query",
						DataReaderUtil.dataReader("expectedOriginID") + "-" + DataReaderUtil.dataReader("expectedDestinationID")
								+ "/" + randomDatePairs.first() + "/" + randomDatePairs.second() + "/"
								+ DataReaderUtil.dataReader("cabinType") + "/" + DataReaderUtil.dataReader("passengers"))
				.get(DataReaderUtil.dataReader("searchFlightsApiResource"));
	}

	public Response postChaletsSearchApi() {

		return response = given().log().all().header("content-type", DataReaderUtil.dataReader("contentType"))
				.header("token", DataReaderUtil.dataReader("token")).header("accept", DataReaderUtil.dataReader("accept"))
				.body(apiPayloads.postChaletsSearchRequestBodyApi(randomConsecutiveDatePairs.first(),
						randomConsecutiveDatePairs.second()))
				.when().post(DataReaderUtil.dataReader("searchChaletsApiResoure"));
	}
}
