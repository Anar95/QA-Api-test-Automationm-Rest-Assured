import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class T01_GetRequest_ResponsBodyYazmaq {

@Test
public void get01() {


    // https://restful-booker.herokuapp.com/booking/10 urline
    //bir GET request gönderin.Dönen respopnsu yazdırın

    //  1 Step Request body ve endpoint hazırlanması

   String url = "https://restful-booker.herokuapp.com/booking/10";

    // 2 Step Expected data hazırla

    // 3 Step Request gönder dönen responsu saxla

    Response response = given().when().get(url);
        response.prettyPrint();


    }

}
