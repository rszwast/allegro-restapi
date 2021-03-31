package pl.allegro.restapi.authentication;

import static io.restassured.RestAssured.given;
import static pl.allegro.restapi.authentication.ClientCredentials.CLIENT_ID;
import static pl.allegro.restapi.authentication.ClientCredentials.CLIENT_SECRET;
import static pl.allegro.restapi.properties.EnvironmentManager.getEnvironmentConfig;

public class Authentication {

    private Authentication(){}

    public static String getAccessToken() {
                return
                    given()
                        .formParam("grant_type", "client_credentials")
                        .auth().preemptive().basic(CLIENT_ID, CLIENT_SECRET)
                        .contentType("application/x-www-form-urlencoded")
                    .when()
                        .post(getEnvironmentConfig().tokenUri())
                    .then()
                        .extract()
                        .jsonPath().getString("access_token");
    }

}
