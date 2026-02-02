package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlJsonPlacseHolder {


    // DRY (Dont Repeat Ypourself)
    protected RequestSpecification specJsonPaceHolder;

    @Before
    public void setUp() {

        specJsonPaceHolder = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .build();
    }

}
