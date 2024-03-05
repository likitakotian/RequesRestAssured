package reques.utils;

import io.restassured.response.Response;
import org.junit.Assert;
import reques.clients.RequesClients;
import reques.request.UpdateUserData;
import reques.request.UserData;
import reques.response.*;

import static javax.ws.rs.core.Response.Status.*;

public class Commons {

    UserData userData;
    UpdateUserData updateUserData;

    protected NewUserResponse createUser() {
        RequesClients requesClients = new RequesClients();
        userData = UserData.builder().build();
        Response response = requesClients.createUser(CREATED, userData, "reques/utils/jsonSchema/createUser.json");
        NewUserResponse newUserResponse = response.as(NewUserResponse.class);
        Assert.assertNotNull(newUserResponse.getId());
        org.junit.Assert.assertNotNull(newUserResponse.getId());
        System.out.println("User created");
        return newUserResponse;
    }

    protected void deleteUser(String id) {
        RequesClients requesClients = new RequesClients();
        Response response = requesClients.deleteUser(NO_CONTENT, id);
        Assert.assertEquals(response.getStatusCode(), 204);
        System.out.println("User deleted");
    }

    protected UserResponse getUser(Number id) {
        RequesClients requesClients = new RequesClients();
        Response response = requesClients.getUser(OK, id, "reques/utils/jsonSchema/getSingleUser.json");
        UserResponse user = response.as(UserResponse.class);
        System.out.println("User retrieved");
        return user;
    }

    protected UsersResponse getAllUsers() {
        RequesClients requesClients = new RequesClients();
        Response response = requesClients.getUsers(OK, 1, 3, "reques/utils/jsonSchema/getAllUsers.json");
        UsersResponse users = response.as(UsersResponse.class);
        System.out.println("Users retrieved");
        return users;
    }

    protected ResourceResponse getResource(Number id) {
        RequesClients requesClients = new RequesClients();
        Response response = requesClients.getResource(OK, id, null);
        ResourceResponse resource = response.as(ResourceResponse.class);
        System.out.println("Resource retrieved");
        return resource;
    }

    protected Resources getAllResources() {
        RequesClients requesClients = new RequesClients();
        Response response = requesClients.getResources(OK,  "reques/utils/jsonSchema/getAllResources.json");
        Resources resources = response.as(Resources.class);
        System.out.println("Resources retrieved");
        return resources;
    }

    protected UpdateUserResponse  updateUser(String id) {
        RequesClients requesClients = new RequesClients();
        updateUserData = updateUserData.builder().build();
        Response response = requesClients.updateUser(OK,updateUserData,id, "reques/utils/jsonSchema/updateUser.json");
        UpdateUserResponse user = response.as(UpdateUserResponse.class);
        System.out.println("User updated");
        return user;
    }
}
