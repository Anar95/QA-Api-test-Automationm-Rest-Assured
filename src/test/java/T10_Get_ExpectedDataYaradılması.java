import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.*; // ulduz qoyuruq ki hamısnı qebul edsin

import static io.restassured.RestAssured.given;

public class T10_Get_ExpectedDataYaradılması {


                /*
     https://jsonplaceholder.typicode.com/posts/22 urlne bir Get request yolladıgımızda
     dönen response bodysinin asagıda verilen ile eyni oldugunu
     test edin

     Response body:
 {
  "userId": 3,
  "id": 22,
  "title": "dolor sint quo a velit explicabo quia nam",
  "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
}
     */

    @Test
    public  void  test10(){


        //1 Endpoint yarad ve request body yarad

        String url = "https://jsonplaceholder.typicode.com/posts/22";

        // 2 Expected data yarad

        JSONObject expectedData = new JSONObject();
        expectedData.put("userId", 3);
        expectedData.put("id", 22);
        expectedData.put("title", "dolor sint quo a velit explicabo quia nam");
        expectedData.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        // 3 request gonder qayıdan responsu yadda saxla

        Response response = given().when().get(url);

        // 4 Assertion
     /*
        response
                .then()
                .assertThat()
                .body("userId",equalTo(3),
                        "id", equalTo(22),
                        "title",equalTo("dolor sint quo a velit explicabo quia nam"));
*/

        JsonPath responseJsonPath = response.jsonPath();

        Assert.assertEquals(expectedData.get("userId"), responseJsonPath.get("userId"));
        Assert.assertEquals(expectedData.get("id"), responseJsonPath.get("id"));
        Assert.assertEquals(expectedData.get("title"), responseJsonPath.get("title"));
        Assert.assertEquals(expectedData.get("body"), responseJsonPath.get("body"));







    }

}
