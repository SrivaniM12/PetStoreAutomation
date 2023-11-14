package Api.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Api.EndPoints.UserEndPoints;
import Api.PayLoad.User;
import Api.Utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)//not reading the values from excel..showing null
	public void testPostUser(String userId,String userName,String fname,String lname,String useremail,String pwd, String ph) {
		
		User userPayload=new User();
		
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);

		Response res= UserEndPoints.createUser(userPayload);
		
		Assert.assertEquals(res.statusCode(), 200);
		
	}
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String userName) {

		Response res= UserEndPoints.deleteUser(userName);
		
		Assert.assertEquals(res.statusCode(), 200);
		
	}
}
