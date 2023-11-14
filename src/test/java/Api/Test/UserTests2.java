package Api.Test;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Api.EndPoints.UserEndPoints;
import Api.EndPoints.UserEndPoints2;
import Api.PayLoad.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserTests2 {
	Faker faker;
	User userPayload;
	public Logger logger;
	
	@BeforeClass
	public void setupData() {
		faker=new Faker();
		userPayload =new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger=LogManager.getLogger(this.getClass());
	}

	
	@Test(priority=1)
	public void testCreateUser() {
		logger.info("************Creating user******************");
		Response res= UserEndPoints2.createUser(userPayload);
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
		logger.info("************new  user created******************");
	}

	@Test(priority=2)
	public void testgetUserbyName() {
		logger.info("************Reading  user info******************");
		Response res= UserEndPoints2.readUser(this.userPayload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
		
	}
	

	@Test(priority=3)
	public void testUpdateUserbyName() {
		logger.info("************updating user******************");
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		
		Response res= UserEndPoints2.UpdateUser(this.userPayload.getUsername(),userPayload);
		res.then().log().body().statusCode(200);
		Assert.assertEquals(res.statusCode(), 200);
		//printing after the update
		
		Response resafterUpdate= UserEndPoints2.readUser(this.userPayload.getUsername());
		res.then().log().all();
		Assert.assertEquals(resafterUpdate.statusCode(), 200);
		logger.info("************After updating userinfo******************");
	}
	

	@Test(priority=4)
	public void testDeleteUserbyName() {
		
		Response res= UserEndPoints2.deleteUser(this.userPayload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
		logger.info("************Successfully deleted  user by username******************");
		
	}
	
}
