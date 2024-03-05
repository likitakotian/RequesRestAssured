package reques.test;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reques.response.NewUserResponse;
import reques.response.UserResponse;
import reques.response.UsersResponse;
import reques.utils.Commons;

public class RequesTests extends Commons {
    protected String id;

    @DisplayName("Create a new user")
    @Test
    public void test_create_new_user() {
        NewUserResponse newUserResponse = createUser();
        id = newUserResponse.getId();
        try {
            Assert.assertNotNull(newUserResponse.getId());
            Assert.assertNotNull(newUserResponse.getName());
            Assert.assertNotNull(newUserResponse.getJob());
        } catch (Exception e) {
            throw e;
        } finally {
            deleteUser(id);
        }
    }

    @DisplayName("get a user by id")
    @Test
   public void test_get_user_by_id() {
        for (int i = 1; i <=3; i++) {
            UserResponse userById = getUser(i);
            Assert.assertNotNull(userById.getData().getId());
            Assert.assertNotNull(userById.getData().getFirst_name());
            Assert.assertNotNull(userById.getData().getLast_name());
            Assert.assertNotNull(userById.getData().getEmail());
            Assert.assertNotNull(userById.getData().getAvatar());
            Assert.assertNotNull(userById.getSupport().getText());
            Assert.assertNotNull(userById.getSupport().getUrl());
        }
    }

    @DisplayName("get all users")
    @Test
    public void test_get_all_users() {
        UsersResponse users = getAllUsers();
        Assert.assertEquals(users.getData().size(), 3);
        Assert.assertNotNull(users.getData().get(0).getId());
        Assert.assertNotNull(users.getData().get(0).getAvatar());
        Assert.assertNotNull(users.getData().get(0).getEmail());
    }
}
