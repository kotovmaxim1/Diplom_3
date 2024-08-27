package util;

import io.restassured.response.Response;

public class UserApi extends RequestSpec {

    public Response deleteUserRequest(String accessToken){
        return doDeleteRequest(URL.USER_API, accessToken);
    }
}
