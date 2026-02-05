import Pojo.EmployeeResponse;
import baseUrl.BaseUrlDummyRestApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import  static org.testng.Assert.assertEquals;


import static io.restassured.RestAssured.given;


public class T17_Pojo_Class extends BaseUrlDummyRestApi {

// Pojo class nedir?
    //Plain Old Java Object
    // Yalnız private fieldler
    // Getter/ setter metodlar
    // Constructor var

    //Serialization ve Deserialization

    // Json -> Java Objecte(Deserialization)
   /* {
        "status": "succes",
        "data":{
             "id": 3,
             "name": "Anar"
      }
    }
    */
    //Bu json Pojo ile Java obyectine cevrilir


@Test

    public void testGetEmployePojo(){

// Endpoint: https://dummy.restapiexample.com/api/v1/employee/3
// get sorgusu gonderek

// 1 request body ve url hazırla

    specDumyApi.pathParams("pp1","api","pp2","v1", "pp3","employee","pp4","3");

    // 2 expected data yarad

    // 3 Request gonder responsu yadda saxla

    Response response = given().spec(specDumyApi).when().get("{pp1}/{pp2}/{pp3}/{pp4}");

    response.prettyPrint();


    // 4 Assertion

    EmployeeResponse employeeResponse = response.as(EmployeeResponse.class);

    assertEquals(response.statusCode(),200);

    assertEquals(employeeResponse.getStatus(),"success");
    assertEquals(employeeResponse.getMessage(), "Successfully! Record has been fetched.");

    assertEquals(employeeResponse.getData().getId(),3);
    assertEquals(employeeResponse.getData().getEmployee_name(),"Anar Abbas");
    assertEquals(employeeResponse.getData().getEmployee_salary(),8600);
    assertEquals(employeeResponse.getData().getEmployee_age(),19);
    assertEquals(employeeResponse.getData().getProfile_image(),"");





}



}