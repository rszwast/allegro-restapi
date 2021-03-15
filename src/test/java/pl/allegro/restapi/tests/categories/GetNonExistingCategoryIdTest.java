package pl.allegro.restapi.tests.categories;

import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pl.allegro.restapi.main.pojo.errors.Error;
import pl.allegro.restapi.tests.testbases.TestBase;
import pl.allegro.restapi.main.pojo.errors.Errors;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetNonExistingCategoryIdTest extends TestBase {

    @Test
    public void givenNonExistingCategoryWhenGetCategoryThenNotFoundReturn(){
        Errors errors = given()
                .when().get(environmentConfig.salePath() + "categories/{categoryId}", "6061")
                .then().statusCode(HttpStatus.SC_NOT_FOUND).extract().as(Errors.class);

        List<Error> errorsList = errors.getErrors();
        Error error = errorsList.get(0);

        Assertions.assertThat(error.getCode()).isEqualTo("NotFoundException");

    }

}
