import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class T13_GetSoftAssertleExpectedDataTesti {




    /*
http://dummy.restapiexample.com/api/v1/employee/3 urline
bir GET Request sorgu gondererken
qayıdan Responsun asagıdaki kimi oldugun test edin


Response Body

{
  "status": "success",
  "data": {
    "id": 3,
    "employee_name": "Ashton Cox",
    "employee_salary": 86000,
    "employee_age": 66,
    "profile_image": ""
  },
  "message": "Successfully! Record has been fetched."
}


 */

    @Test
    public void testGetSoftAssertleExpectedDataTesti() {

        // Hard Assert Junitde oyrendik
        //  Assert.assertEquals();
        // Assert.assertTrue();
        // Assert.assertFalse();

        // Soft Assert ise (verification)
        // Hard asseertden ferqli olaraq her hansı bir assertde xeta olsa test dayanmır davam edir


        // 1 endpoınt ve request body yarat

        String url = "http://dummy.restapiexample.com/api/v1/employee/3";

        // 2 expected data yarad

        JSONObject expectedData = new JSONObject();
        JSONObject dataJsonObject = new JSONObject();


        dataJsonObject.put("id", 3);
        dataJsonObject.put("employee_name", "Ashton Cox");
        dataJsonObject.put("employee_salary", "860000");
        dataJsonObject.put("employee_age", "680");
        dataJsonObject.put("profile_image", "");

        expectedData.put("status", "success");
        expectedData.put("data", dataJsonObject);
        expectedData.put( "message", "Successfully! Record has been fetched.");

        //3 request gonder qayıdan responsu yadda saxla

        Response response = given().when().get(url);

        JsonPath responseJsonPath = response.jsonPath();

        // 4 Assertion soft Assert ile edirik

        // Birinci addım SoftAssert objecti yaradılmalıdır : SoftAssert softAssert = new SoftAssert();
        // Ikıncı addım İstediyimiz verificationları yazırıq:softAssert.assertEquals()
        // Üçüncü addım ise SoftAssertion bütün logların gormek isteyirikse :  softAssert.assertAll();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseJsonPath.get("status"), expectedData.get("status"));
        softAssert.assertEquals(responseJsonPath.get("message"), expectedData.get("message"));

        softAssert.assertEquals(responseJsonPath.get("data.id"),
                expectedData.getJSONObject("data").get("id"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_name"),
                expectedData.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_salary"),
                expectedData.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_age"),
                expectedData.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(responseJsonPath.get("data.profile_image"),
                expectedData.getJSONObject("data").get("profile_image"));


        softAssert.assertAll();


    }
}
