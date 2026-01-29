import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class T12_PostExpected_Data_ve_JsonPathAssertion {



/*

https://restful-booker.herokuapp.com/booking urline asagıdaki body"ye sahib bir POST
request gonderdikde donen response"un id xaric asagıdakı kimi olduugnu test edin

Request body
{
    "firstname": "Anar",
    "lastname": "Abbas",
    "totalprice": 626,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2025-03-16",
        "checkout": "2025-03-20"
    }
    "additionalneeds": "Breakfast"
}


Response body
{
  "bookingid": 24,
  "booking": {
    "firstname": "Anar",
    "lastname": "Abbas",
    "totalprice": 626,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2025-03-16",
        "checkout": "2025-03-20"
    },
    "additionalneeds": "Breakfast"
  }

}
 */

    @Test
    public void postExpected_Data_ve_JsonPathAssertion() {

        //1 endpoint ve request body yarad

        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject requestBody = new JSONObject();

        JSONObject rezTarixiJsonObj = new JSONObject();

        rezTarixiJsonObj.put("checkin", "2025-03-16");
        rezTarixiJsonObj.put("checkout", "2025-03-20");

        requestBody.put("firstname", "Anar");
        requestBody.put("lastname", "Abbas");
        requestBody.put("totalprice", 626);
        requestBody.put("depositpaid", true);
        requestBody.put("bookingdates", rezTarixiJsonObj);
        requestBody.put("additionalneeds", "Breakfast");

        //2 expected data yarad

        JSONObject expectedData = new JSONObject();
        expectedData.put("bookingid", 24);
        expectedData.put("booking", requestBody);

        //3 request gönder dönen respons bodyni yadda saxla

        Response response = given()
                .contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .post(url);

        // 4 Assertion
        JsonPath responseJsonPath = response.jsonPath();


        Assert.assertEquals(expectedData.getJSONObject("booking").get("firstname"), responseJsonPath.get("booking.firstname"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("lastname"), responseJsonPath.get("booking.lastname"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("totalprice"), responseJsonPath.get("booking.totalprice"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("depositpaid"), responseJsonPath.get("booking.depositpaid"));
        Assert.assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"), responseJsonPath.get("booking.additionalneeds"));

        Assert.assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"), responseJsonPath.get("booking.bookingdates.checkin"));
        Assert.assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"), responseJsonPath.get("booking.bookingdates.checkout"));








    }





}
