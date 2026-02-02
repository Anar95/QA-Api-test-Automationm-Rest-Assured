import baseUrl.BaseUrlJsonPlacseHolder;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class T15_Get_TestDataClassIsledilmesi  extends BaseUrlJsonPlacseHolder {
      /*
  https://jsonplaceholder.typicode.com/posts/44 bir Get sorgusu gonder
  asagdakı bodyle eynı oldugun test ed

  Expected data

  {
  "userId": 5,
  "id": 44,
  "title": "optio dolor molestias sit",
  "body": "temporibus est consectetur dolore\net libero debitis vel velit laboriosam quia\nipsum quibusdam qui itaque fuga rem aut\nea et iure quam sed maxime ut distinctio quae"
}
   */


    @Test
    public void test1() throws  Exception {

        //1 Request body ve url uyarad
        specJsonPaceHolder.pathParams("pp1","posts","pp2","44");

        // 2 expected data yarad

        JSONObject expectedData = TestDataJsonPlaceHolder.responseBodyYaradır44();

        // 3 request gonder donen respponsu yadda saxla

        Response response = given()
                .spec(specJsonPaceHolder)
                .when()
                .get("/{pp1}/{pp2}");

        // 4 Assertıon

        Assert.assertEquals(TestDataJsonPlaceHolder.ugurluSorguStatusCodu, response.getStatusCode());

        Assert.assertEquals(expectedData.get("userId"),response.jsonPath().getInt("userId"));
        Assert.assertEquals(expectedData.get("id"),response.jsonPath().getInt("id"));
        Assert.assertEquals(expectedData.get("title"),response.jsonPath().getString("title"));
        Assert.assertEquals(expectedData.get("body"),response.jsonPath().getString("body"));

    }




}
