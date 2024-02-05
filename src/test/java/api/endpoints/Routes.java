package api.endpoints;
/* 
Swagger URI --> https://petstore.swagger.io

Create user(Post) : https://petstore.swagger.io/v2/user
Get user (Get): https://petstore.swagger.io/v2/user/{username}
Update user (Put) : https://petstore.swagger.io/v2/user/{username}
Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}

*/
public class Routes {
	
	public static String base_url  ="https://petstore.swagger.io/v2";
	
	//User Model for post_url +get_url+update_url+delete_url
	
	//post_url
    public static String post_url  = base_url+"/user";
    //get_url
    public static String get_url=base_url+"/user/{username}";
    //update_url
    public static String update_url=base_url+"/user/{username}";
    //delete_url
    public static String delete_url=base_url+"/user/{username}";
    
  //Store Model Coming------
  // Pet Model Coming ------

}
