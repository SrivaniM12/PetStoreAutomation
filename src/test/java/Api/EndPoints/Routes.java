package Api.EndPoints;

/* Swagger URI :https://petstore.swagger.io
 * baseUrl:https://petstore.swagger.io/v2
 * post: https://petstore.swagger.io/v2/user
 * get :https://petstore.swagger.io/v2/user/{username}
 * put :https://petstore.swagger.io/v2/user/{username}
 * delete: https://petstore.swagger.io/v2/user/{username}
 */
public class Routes {

	public static String base_URL="https://petstore.swagger.io/v2/";
	public static String Post_URL=base_URL+"user";
	public static String get_URL=base_URL+"user/{userName}";
	public static String Update_URL=base_URL+"user/{userName}";
	public static String Delete_URL=base_URL+"user/{userName}";	
}
