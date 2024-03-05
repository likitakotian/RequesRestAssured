package reques.clients;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import reques.request.UpdateUserData;
import reques.request.UserData;
import reques.utils.TestUtil;


import static io.restassured.RestAssured.given;
import static reques.utils.GlabalVariable.BASE_URL;

public class RequesClients {
    public Response createUser(javax.ws.rs.core.Response.StatusType status, UserData userData) {
        Response response = TestUtil.waitForExpectedStatusCode(() -> given().contentType(ContentType.JSON).with().log().all().body(userData).when().post(BASE_URL+"/api/users"), status);
        return response;
    }

    public Response getUser(javax.ws.rs.core.Response.StatusType status, Number id) {
        Response response = TestUtil.waitForExpectedStatusCode(() -> given().contentType(ContentType.JSON).with().log().all().when().get(BASE_URL+"/api/users/" + id), status);
        return response;
    }

    public Response getUsers(javax.ws.rs.core.Response.StatusType status, Number page, Number perPage) {
        Response response = TestUtil.waitForExpectedStatusCode(() -> given().contentType(ContentType.JSON).with().log().all().when().get(BASE_URL+"/api/users?page=" + page + "&per_page=" + perPage), status);
        return response;
    }

    public Response getResources(javax.ws.rs.core.Response.StatusType status) {
        Response response = TestUtil.waitForExpectedStatusCode(() -> given().contentType(ContentType.JSON).with().log().all().when().get(BASE_URL+"/api/unknown"), status);
        return response;
    }

    public Response getResource(javax.ws.rs.core.Response.StatusType status, Number id) {
        Response response = TestUtil.waitForExpectedStatusCode(() -> given().contentType(ContentType.JSON).with().log().all().when().get(BASE_URL+"/api/unknown/" + id), status);
        return response;
    }

    public Response updateUser(javax.ws.rs.core.Response.StatusType status, UpdateUserData userData, Number id) {
        Response response = TestUtil.waitForExpectedStatusCode(() -> given().contentType(ContentType.JSON).with().log().all().body(userData).when().put(BASE_URL+"/users/" + id), status);
        return response;
    }

    public Response updateUsers(javax.ws.rs.core.Response.StatusType status, UpdateUserData userData, Number id) {
        Response response = TestUtil.waitForExpectedStatusCode(() -> given().contentType(ContentType.JSON).with().log().all().body(userData).when().patch(BASE_URL+"/users/" + id), status);
        return response;
    }

    public Response deleteUser(javax.ws.rs.core.Response.StatusType status, String id) {
        Response response = TestUtil.waitForExpectedStatusCode(() -> given().contentType(ContentType.JSON).with().log().all().when().delete(BASE_URL+"/api/users/" + id), status);
        return response;
    }

    public Response registerUser(javax.ws.rs.core.Response.StatusType status, String email, String password) {
        Response response = TestUtil.waitForExpectedStatusCode(() -> given().contentType(ContentType.JSON).body("{\n" + "    \"email\": \"" + email + "\",\n" + "    \"password\": \"" + password + "\"\n" + "}").with().log().all().when().post(BASE_URL+"/api/register"), status);
        return response;
    }

    public Response loginUser(javax.ws.rs.core.Response.StatusType status, String email, String password) {
        Response response = TestUtil.waitForExpectedStatusCode(() -> given().contentType(ContentType.JSON).with().log().all().body("{\n" + "    \"email\": \"" + email + "\",\n" + "    \"password\": \"" + password + "\"\n" + "}").when().post(BASE_URL+"/api/login"), status);
        return response;
    }

    public  Response getDelayedResponse(javax.ws.rs.core.Response.StatusType status, Number delay) {
        Response response = TestUtil.waitForExpectedStatusCode(() -> given().contentType(ContentType.JSON).with().log().all().when().get(BASE_URL+"/api/users?delay=" + delay), status);
        return response;
    }
}
