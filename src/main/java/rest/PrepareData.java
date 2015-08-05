package rest;

import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PrepareData {
    public static void addShirtToBag(String jsessionId, Map cookies){
        given()
                .auth().none().sessionId(jsessionId).cookies(cookies)
                .contentType("application/json").cookie("JSESSIONID=" + jsessionId)
                .baseUri("http://www.marksandspencer.com")
                .expect().statusCode(200).body("basketSize", equalTo(1))
        .when()
                .post("/AjaxOrderItemAddCmd?catEntryId_1=3704037&catalogId=10051&colour=Denim&langId=-24&maxPurchaseQuantity=&productCode=3704004&quantity_1=1&size=6DUMMY&storeId=10151")
        .then()
                .log().all();
    }
}