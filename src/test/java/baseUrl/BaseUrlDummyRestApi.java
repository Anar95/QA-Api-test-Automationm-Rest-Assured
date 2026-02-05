package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;


public class BaseUrlDummyRestApi {

    protected RequestSpecification specDumyApi;

    @BeforeMethod

    public void setup() {

        specDumyApi = new RequestSpecBuilder()
                .setBaseUri("https://dummy.restapiexample.com/")
                .build();



    }

}
