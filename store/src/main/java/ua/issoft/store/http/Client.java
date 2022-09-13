package ua.issoft.store.http;

import com.google.gson.Gson;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import ua.issoft.domain.Product;
import ua.issoft.store.Store;

import static io.restassured.RestAssured.given;

public class Client {
    @SneakyThrows
    public void printCategory() {
        String responseBody = given().auth()
                .basic("admin", "password")
                .when()
                .get("/categories")
                .body()
                .asString();
        System.out.println(responseBody);
    }

    @SneakyThrows
    public void addRandProductToOrder() {
        Store store = Store.getInstance();
        boolean isAnyProductPresent = store.getCategorySet().stream().findAny().get().getProductSet().stream().findAny().isPresent();
        boolean isAnyCategoryPresent = store.getCategorySet().stream().findAny().isPresent();
        if(isAnyCategoryPresent && isAnyProductPresent){
        Product randomProduct = store.getCategorySet().stream().findAny().get().getProductSet().stream().findAny().get();
        Gson gson = new Gson();
        String stringJson = gson.toJson(randomProduct);
        Response response = given().auth()
                .basic("admin", "password")
                .header("Content-type", "application/json")
                .and()
                .body(stringJson)
                .when()
                .post("/cart")
                .then()
                .extract().response();
        System.out.println(response.asString());
    }
    }
}
