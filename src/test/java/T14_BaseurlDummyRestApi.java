import baseUrl.BaseUrlJsonPlacseHolder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class T14_BaseurlDummyRestApi  extends BaseUrlJsonPlacseHolder {

     /*


//Class içinde 2 Test metodu yaradıb ve asagıdakı testlerı edin
//1- https://jsonplaceholder.typicode.com/posts endpointine GET
// request gonderin donen responsu status kodun 200 oldugunu ve 100 data oldugun test edin
//2- https://jsonplaceholder.typicode.com/posts/44 endpointine GET
//request gonderin donen responsu status kodun 200 oldugunu
//ve "title" deyerinin "optio dolor molestias sit" oldugun test edın,
*/

    @Test
    public void testStatusCodeandSize() {
        // 1 endpoınt ve request body yarad,
        specJsonPaceHolder.pathParams("pp1","posts");

        // 2 expected data yarad

        // 3 request gonder respons bodyni  yadda saxla
        Response response = given().when()
                .spec(specJsonPaceHolder).get("/{pp1}");
        // 4 Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title", Matchers.hasSize(100));
    }

    @Test
    public  void testStatusCodeandTitle(){

        /*
        //2- https://jsonplaceholder.typicode.com/posts/44 endpointine GET
//request gonderin donen responsu status kodun 200 oldugunu
//ve "title" deyerinin "optio dolor molestias sit" oldugun test edın,
*/


        // 1 endpoınt request body yarad
        specJsonPaceHolder.pathParams("pp1","posts","pp2", 44);

        // 2 expected data yarad

        // 3 Request gonder resppjnsu yadda saxla

        Response response = given().when()
                .spec(specJsonPaceHolder).get("/{pp1}/{pp2}");

        // 4 Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title", Matchers.equalTo("optio dolor molestias sit"));
    }


}
