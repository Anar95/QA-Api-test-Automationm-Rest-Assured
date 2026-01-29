import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;


import static org.hamcrest.Matchers.*; // ulduz qoyuruq ki hamısnı qebul edsin
import static io.restassured.RestAssured.given;

public class T08_Get_BodyTekrarından_Qurtulma {


    /*
    https://restful-booker.herokuapp.com/booking/10 urlne
    bır GET request gonderdıgımızde donen Rsponse un
     status codunun 200,
    ve content type nın applıcatıon/json
   ve response bodysındekı
   "firstaname"in, "Mary",
    ve  "lastname"in, "Brown",
    ve  "totalprice"in, 1000 den kiçik olduğunu,
    ve  "depositepaid"in, true,
    ve  "additionalneeds"in, boş buraxılmadığını,
   olduğunu test edin

    */

    @Test
    public void testGet_Body_Testi() {
        //1 enpoint ve request bopdyni hazırla

        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2 expected data hazırla

        // 3 request gonder donen cavabı yadda saxla

        Response response = given().when().get(url);

        // 4 Assertion
        response.prettyPrint();
/*
        response
                .then()
                .assertThat()

                .statusCode(200)
                .contentType(ContentType.JSON)

                .body("firstname", Matchers.equalTo("Mary"))
                .body("lastname",Matchers.equalTo("Smith"))
                .body("totalprice",Matchers.lessThan(1000))
                .body("depositpaid",Matchers.notNullValue());

*/


        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("Mary"),
                        "lastname",equalTo("Smith"),
                        "totalprice", lessThan(1000),
                        "depositpaid", notNullValue());

    }


}
