package pl.allegro.restapi.tests.categories;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pl.allegro.restapi.tests.testbases.TestBase;

import static io.restassured.RestAssured.given;

public class GetCategoriesTest extends TestBase {

    @Test
    public void givenCategoriesWhenGetCategoriesThenReturnListOfAllCategories() {
        Response response = given()
                .when().get(environmentConfig.salePath() + "/categories")
                .then().extract().response();

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
    }


}
