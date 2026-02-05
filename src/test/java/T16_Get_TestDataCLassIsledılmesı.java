import baseUrl.BaseUrlDummyRestApi;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.json.JSONObject;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testData.TestDataDummyRestApi;
import testData.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class T16_Get_TestDataCLassIsledılmesı extends BaseUrlDummyRestApi {





        /*
Ssenari 1 Kompleks JSON – GET request testi
Endpoint: https://dummy.restapiexample.com/api/v1/employee/3

Expected Data:

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



Ssenari 2: JSONArray olan JSON – GET request testi ılk ıkı ıstıfadecını qarsılasdır

Endpoint: https://dummy.restapiexample.com/api/v1/employees

Expected Data:

{
  "data": [
    {
      "id": 1,
      "employee_name": "Tiger Nixon"
    },
    {
      "id": 2,
      "employee_name": "Garrett Winters"
    }
  ]
}

         */


   @Test
     public  void testKompleksJson(){
        //1 url ve request body yarad
        // /api/v1/employee/3
       specDumyApi.pathParams("pp1","api","pp2","v1", "pp3","employee","pp4","3");

    // 2 Expected data yarad

        JSONObject expectedData = TestDataDummyRestApi.dynamicJsonYarad(
                "succes",
                3,
                "Ashton Cox",
                5500,
                66,
                "Successfully! Record has been fetched.");

        // 3request gonder responsu yadda saxla
        Response response = given().spec(specDumyApi).when().get("{pp1}/{pp2}/{pp3}/{pp4}");

        JSONObject actualData = new JSONObject(response.asString());


        // 4 Assertion

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.statusCode(),TestDataDummyRestApi.ugurluSorguStatusKodu, "Status code ferqlidir");

        softAssert.assertEquals(actualData.getString("status"),expectedData.getString("status"), "Status gözlenenden ferqlidir");
        softAssert.assertEquals(actualData.getString("message"),expectedData.getString("message"), "Message gözlenenden ferqlidir");


        JSONObject expectedInner = expectedData.getJSONObject("data");
        JSONObject actualInner = actualData.getJSONObject("data");

       softAssert.assertEquals(actualInner.getInt("id"),expectedInner.getInt("id"), "Id  gözlenenden ferqlidir");
       softAssert.assertEquals(actualInner.getString("employee_name"),expectedInner.getString("employee_name"), "Name  gözlenenden ferqlidir");
       softAssert.assertEquals(actualInner.getInt("employee_salary"),expectedInner.getInt("employee_salary"), "Salary gözlenenden ferqlidir");
       softAssert.assertEquals(actualInner.getInt("employee_age"),expectedInner.getInt("employee_age"), "Age gözlenenden ferqlidir");


       softAssert.assertAll(); // Butun assertleri yoxlayır ve sehvleri gosterır

   }
}
