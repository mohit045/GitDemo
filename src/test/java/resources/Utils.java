package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {

	public static RequestSpecification req;
	ResponseSpecification responsespec;
	Response response;

	public RequestSpecification requestSpecification() throws IOException {
		if (req == null) {
			PrintStream stream = new PrintStream(new FileOutputStream("logging.txt"));
			req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURI")).addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(stream))
					.addFilter(ResponseLoggingFilter.logResponseTo(stream))
					.addHeader("Content-Type", "application/json").build();
			return req;
		}
		return req;
	}

	public static String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\bench\\frame-10-11\\RestAPIAutomation\\src\\test\\java\\resources\\global.properties");
		prop.load(file);
		return prop.getProperty(key);
	}

//	public ResponseSpecification responseSpecification() {
//		responsespec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
//		return responsespec;
//
//	}
	
	public String getJsonPath(Response res,String key) {
		String resp = res.asString();
		JsonPath js = new JsonPath(resp);
		System.out.println(js.get(key));
		return js.get(key);
		
		
		
	}

}
