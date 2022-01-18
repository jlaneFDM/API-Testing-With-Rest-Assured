package training;

import io.restassured.response.ValidatableResponse;
import models.Product;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTests {
    @Test
    public void getCategories(){
        /*Rest Assured uses a given/when/then structure*/
        String endPoint = "http://localhost/api_testing/product/read.php";
        ValidatableResponse response  = given().when().get(endPoint).then();
        response.log().body();
    }
    @Test
    public void getProduct(){
        String endpoint = "http://localhost/api_testing/product/read_one.php";

        var response = given()
                .queryParam("id", 19)
                .when().get(endpoint)
                .then()
                .assertThat()
                .statusCode(200)
                .body("id", equalTo("19"))
                .body("name", equalTo("Sweatband"))
                .body("description", equalTo("Genuine polyester sweatband from the Andes"))
                .body("price", equalTo("7.00"))
                .body("category_id", equalTo("3"))
                .body("category_name", equalTo("Active Wear - Unisex"));

        response.log().body();
    }
    @Test
    public void createProduct(){
        String endpoint = "http://localhost/api_testing/product/create.php";

        String body = """
                {
                "name": "Water Bottle",
                "description": "Blue water bottle. Holds 64 ounces",
                "price": 12,
                "category_id": 3
                }
                """;

        ValidatableResponse response = given().body(body).when().post(endpoint).then();
        response.log().body();
    }
    @Test
    public void updateProduct(){
        String endpoint = "http://localhost/api_testing/product/update.php";

        String body = """
                {"id": 19,
                 "name":
                 "description": "Blue water bottle. Holds 64 ounces",
                 "price": 15,
                 "category_id": 3
                }
                """;

        ValidatableResponse response = given().body(body).when().put(endpoint).then();
        response.log().body();
    }
    @Test
    public void deleteProduct(){
        String endpoint = "http://localhost/api_testing/product/delete.php";

        String body = """
                {
                "id": 19
                }
                """;
        ValidatableResponse response = given().body(body).when().delete(endpoint).then();
        response.log().body();
    }

    @Test
    public void createSerializedProduct(){
        String endpoint = "http://localhost/api_testing/product/create.php";
        //using POST constructor
        Product product = new Product(
                "Water Bottle",
                "Blue water bottle. Holds 64 ounces",
                12,
                3);

        ValidatableResponse response = given().body(product).when().post(endpoint).then();
        response.log().body();
    }

    @Test
    public void createSweatband(){
        String endpoint = "http://localhost/api_testing/product/create.php";
        //Post constructor
        Product product = new Product(
                "Sweatband",
                "Genuine polyester sweatband from the Andes",
                6,
                3);

        ValidatableResponse response = given().body(product).when().post(endpoint).then();
        response.log().body();
    }

    @Test
    public void updateSweatband(){
        String endpoint = "http://localhost/api_testing/product/update.php";
        //using PUT constructor
        Product product = new Product(
                19,
                "Sweatband",
                "Genuine polyester sweatband from the Andes.",
                7,
                3);

        ValidatableResponse response = given().body(product).when().post(endpoint).then();
        response.log().body();
    }
}
