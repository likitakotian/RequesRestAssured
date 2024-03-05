package reques.test;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reques.response.*;
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
        for (int i = 1; i <= 3; i++) {
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

    @DisplayName("get single resource")
    @Test
    public void test_get_resource() {
        for (int i = 1; i <= 3; i++) {
            ResourceResponse regById = getResource(i);
            Assert.assertNotNull(regById.getData().getColor());
            Assert.assertNotNull(regById.getData().getYear());
            Assert.assertNotNull(regById.getData().getName());
            Assert.assertNotNull(regById.getData().getPantone_value());
            Assert.assertNotNull(regById.getSupport().getUrl());
        }
    }

    @DisplayName("get all resources")
    @Test
    public void test_get_all_resources() {
        Resources resources = getAllResources();
        Assert.assertNotNull(resources.getData().get(0).getColor());
        Assert.assertNotNull(resources.getData().get(0).getPantone_value());
        Assert.assertNotNull(resources.getData().get(0).getYear());
        Assert.assertNotNull(resources.getData().get(0).getName());
        Assert.assertNotNull(resources.getSupport().getUrl());
        Assert.assertNotNull(resources.getSupport().getText());
    }

    @DisplayName("update user")
    @Test
    public void test_update_user() {
        NewUserResponse newUserResponse = createUser();
        id = newUserResponse.getId();
        try {
            UpdateUserResponse updateUserResponse = updateUser(id);
            Assert.assertNotEquals(newUserResponse.getName(), updateUserResponse.getName(),"name updated");
            Assert.assertNotEquals(newUserResponse.getJob(), updateUserResponse.getJob(),"job updated");
            Assert.assertNotNull(updateUserResponse.getUpdatedAt());
        } catch (Exception e) {
            throw e;
        } finally {
            deleteUser(id);
        }
    }
}
