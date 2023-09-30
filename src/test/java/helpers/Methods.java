package helpers;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utilities.DataReaderUtil;

public class Methods {

	public String getValueFromResponseBody(String response, String key) {

		JsonPath js = new JsonPath(response);
		return js.getString(key);
	}

	public static void setURL() {

		RestAssured.baseURI = DataReaderUtil.dataReader("url");
	}
}
