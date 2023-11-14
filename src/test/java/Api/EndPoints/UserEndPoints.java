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

public class UserEndPoints {
	
	
	
	
	public static Response createUser(User payload)
	{
		Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
		.post(Routes.Post_URL);
		return res;
	}

	public static Response readUser(String username)
	{
		Response res=given()
		.pathParam("userName", username)
		.when()
		.get(Routes.get_URL);
		return res;
	}
	public static Response UpdateUser(String username,User payload)
	{
		Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.pathParam("userName",username)
		.when()
		.put(Routes.Update_URL);
		return res;
	}
	public static Response deleteUser(String username)
	{
		Response res=given()
		.pathParam("userName", username)
		.when()
		.delete(Routes.Delete_URL);
		return res;
	}
	
}
