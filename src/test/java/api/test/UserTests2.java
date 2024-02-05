package api.test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {
	
	Faker faker;
	User userPayload;
	public Logger logger;
	@BeforeClass
	public void setupData()
	{
		faker=new Faker();
		userPayload=new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
				logger= LogManager.getLogger(this.getClass());
				
				logger.debug("debugging.....");
				
	}
	
	@Test(priority=1)
	public void testPostUser()
	{	logger.info("********** Creating user  ***************");
		Response response=UserEndPoints2.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("********** Created user  ***************");	
	}
	
	@Test(priority=2)
	public void testGetUserByName()
	{	logger.info("********** Getting user Info ***************");
		Response response = UserEndPoints2.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("********** Getting user Info ***************");
			
	}
	@Test(priority=3)
	public void testUpdateUserByName() {
		
		logger.info("********** testUpdate UserByName ***************");
		
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndPoints2.updateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	
		logger.info("********** testUpdated UserByName ***************");
		
		Response responseAfterUpdate1 = UserEndPoints2.readUser(this.userPayload.getUsername());
		Assert.assertEquals(responseAfterUpdate1.getStatusCode(),200);
	}
	@Test(priority=4)
	public void testDeleteUserByName() {
		logger.info("********** test Delete User By Name ***************");
		
		Response response = UserEndPoints2.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info("********** test Deleted User By Name ***************");
	}

}
