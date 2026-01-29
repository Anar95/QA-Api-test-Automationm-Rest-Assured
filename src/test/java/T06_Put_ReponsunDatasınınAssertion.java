import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class T06_Put_ReponsunDatasınınAssertion {

      /*
https://jsonplaceholder.typicode.com/posts/70 urlne
asagıdakı Json fortmatındakı body ile bir PUT request gonderdigimizde

{

"title": "Anar",
"body": "Salamlar",
"userId": 10,
"id":70
}

donen Responsenun,
status codunun 200,
content type: application/json; charset=utf-8,
ve Server isimli Headerin deyerinin cloudflare,
ve status Linenin  HTTP/1.1 200 OK
 */


    @Test
    public void test01 (){

        // 1 urli ve request bodyni hazırla

        String url = "https://jsonplaceholder.typicode.com/posts/70";
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "Anar");
        requestBody.put("body", "Salamlar");
        requestBody.put("userId", 10);
        requestBody.put("id",70);


        // 2 expected body yaradılır

        // 3 request gönder dönan cavabı yadda saxla
        Response response = given()
                .contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .put(url);
     // 4 Assertion

        response.prettyPrint();

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server",  "cloudflare")
                .statusLine("HTTP/1.1 200 OK");


    }

}
