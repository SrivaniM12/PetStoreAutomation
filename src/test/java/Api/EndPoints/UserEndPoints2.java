package Api.EndPoints;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import Api.PayLoad.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

public class UserEndPoints2 {
	
	
	//additional method created for getting URL's from the property file
	static ResourceBundle getURL() {
		ResourceBundle routes=ResourceBundle.getBundle("routes");//no need to give the propeties file extension or the path
		return routes;
	}
	
	
	public static Response createUser(User payload)
	{
		
		String post_url=getURL().getString("post_url");
		Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
		.post(post_url);
		return res;
	}

	public static Response readUser(String username)
	{
		String get_url=getURL().getString("get_url");
		Response res=given()
		.pathParam("userName", username)
		.when()
		.get(get_url);
		return res;
	}
	public static Response UpdateUser(String username,User payload)
	{
		String put_url=getURL().getString("put_url");
		Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.pathParam("userName",username)
		.when()
		.put(put_url);
		return res;
	}
	public static Response deleteUser(String username)
	{
		String delete_url=getURL().getString("delete_url");
		Response res=given()
		.pathParam("userName", username)
		.when()
		.delete(delete_url);
		return res;
	}
	
}
