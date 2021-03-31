package pl.allegro.restapi.categories;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pl.allegro.restapi.testbases.TestBase;

import static io.restassured.RestAssured.given;
import static pl.allegro.restapi.properties.EndpointManager.getEndpointConfig;

public class GetCategoriesTest extends TestBase {

    @Test
    public void givenCategoriesWhenGetCategoriesThenReturnListOfAllCategories() {
        Response response = given()
                .when()
                    .get(getEndpointConfig().getAllCategoriesPath())
                .then()
                    .extract().response();

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
    }

}
