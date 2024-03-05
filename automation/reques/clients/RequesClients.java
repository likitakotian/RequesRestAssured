package reques.clients;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import reques.request.Register;
import reques.request.UpdateUserData;
import reques.request.UserData;
import reques.utils.TestUtil;


import static io.restassured.RestAssured.given;
import static reques.utils.GlabalVariable.BASE_URL;

public class RequesClients {
    public Response createUser(javax.ws.rs.core.Response.StatusType status, UserData userData, String path) {
        Response response = TestUtil.waitForExpectedStatusCode(() -> given().contentType(ContentType.JSON).with().log().all().body(userData).when().post(BASE_URL + "/api/users"), status);
        if (path != null) {
            response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(path));
        }
        return response;
    }

    public Response getUser(javax.ws.rs.core.Response.StatusType status, Number id, String path) {
        Response response = TestUtil.waitForExpectedStatusCode(() -> given().contentType(ContentType.JSON).with().log().all().when().get(BASE_URL + "/api/users/" + id), status);
        if (path != null) {
            response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(path));
        }
        return response;
    }

    public Response getUsers(javax.ws.rs.core.Response.StatusType status, Number page, Number perPage, String path) {
        Response response = TestUtil.waitForExpectedStatusCode(() -> given().contentType(ContentType.JSON).with().log().all().when().get(BASE_URL + "/api/users?page=" + page + "&per_page=" + perPage), status);
        if (path != null) {
            response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(path));
        }
        return response;
    }

    public Response getResources(javax.ws.rs.core.Response.StatusType status, String path) {
        Response response = TestUtil.waitForExpectedStatusCode(() -> given().contentType(ContentType.JSON).with().log().all().when().get(BASE_URL + "/api/unknown"), status);
        if (path != null) {
            response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(path));
        }
        return response;
    }

    public Response getResource(javax.ws.rs.core.Response.StatusType status, Number id, String path) {
        Response response = TestUtil.waitForExpectedStatusCode(() -> given().contentType(ContentType.JSON).with().log().all().when().get(BASE_URL + "/api/unknown/" + id), status);
        if (path != null) {
            response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(path));
        }
        return response;
    }

    public Response updateUser(javax.ws.rs.core.Response.StatusType status, UpdateUserData userData, String id, String path) {
        Response response = TestUtil.waitForExpectedStatusCode(() -> given().contentType(ContentType.JSON).with().log().all().body(userData).when().put(BASE_URL + "/api/users/" + id), status);
        if (path != null) {
            response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(path));
        }
        return response;
    }

    public Response updateUsers(javax.ws.rs.core.Response.StatusType status, UpdateUserData userData, Number id, String path) {
        Response response = TestUtil.waitForExpectedStatusCode(() -> given().contentType(ContentType.JSON).with().log().all().body(userData).when().patch(BASE_URL + "/api/users/" + id), status);
        if (path != null) {
            response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(path));
        }
        return response;
    }

    public Response deleteUser(javax.ws.rs.core.Response.StatusType status, String id) {
        Response response = TestUtil.waitForExpectedStatusCode(() -> given().contentType(ContentType.JSON).with().log().all().when().delete(BASE_URL + "/api/users/" + id), status);
        return response;
    }

    public Response registerUser(javax.ws.rs.core.Response.StatusType status, Register payload,String email, String path) {
        Response response = TestUtil.waitForExpectedStatusCode(() -> given().contentType(ContentType.JSON).body(payload).with().log().all().when().post(BASE_URL + "/api/register"), status);
        if (path != null) {
            response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(path));
        }
        return response;
    }

    public Response loginUser(javax.ws.rs.core.Response.StatusType status, Register payload,String email, String path) {
        Response response = TestUtil.waitForExpectedStatusCode(() -> given().contentType(ContentType.JSON).with().log().all().body(payload).when().post(BASE_URL + "/api/login"), status);
        if (path != null) {
            response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(path));
        }
        return response;
    }

    public Response getDelayedResponse(javax.ws.rs.core.Response.StatusType status, Number delay, String path) {
        Response response = TestUtil.waitForExpectedStatusCode(() -> given().contentType(ContentType.JSON).with().log().all().when().get(BASE_URL + "/api/users?delay=" + delay), status);
        if (path != null) {
            response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(path));
        }
        return response;
    }
}
