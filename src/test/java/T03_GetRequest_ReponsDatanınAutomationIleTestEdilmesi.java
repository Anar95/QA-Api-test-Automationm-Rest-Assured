import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class T03_GetRequest_ReponsDatanınAutomationIleTestEdilmesi {

    /* https://restful-booker.herokuapp.com/booking/10 urline
bir GET request gönderin.Dönen respopnsun status codunu 200,
ve content type nın application/json;
charset=utf-8;
ve server isimli Headerin deyerinin Heroku ve status line HTTP/1.1 200 ok
ve respons vaxdının 5 sn den az oldugunu manual olaraq test edin

 */

    @Test
    public void test02(){

// 1 endpoint ve request body hazırla
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2 expected data yarad

        //3 Request gonder qayıdan responsu yadda saxla

        Response response = given().when().get(url);

        response.prettyPrint();

        // 4 Assertion

        response

                .then() // responsu alır
                .assertThat() // asserThat ile bunu assert edir
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server", "Heroku")
                .statusLine("HTTP/1.1 200 OK") // moterıze ıcındekı dataların hamısı exoe4cted datadır
                .time(lessThan(5000L)); //cavab 5000 milli saniyeden az olmalıdır









    }
}
