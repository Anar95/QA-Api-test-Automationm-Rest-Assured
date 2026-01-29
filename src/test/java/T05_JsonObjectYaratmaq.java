import org.json.JSONObject;
import org.junit.Test;

public class T05_JsonObjectYaratmaq {

    @Test
    public void test02() throws  Exception {
 /*     {
                "firstname": "Mary",
                "lastname": "Brown",
                "totalprice": 514,
                "depositpaid": false,
                "bookingdates": {
                    "checkin": "2024-03-07",
                    "checkout": "2024-12-26"
        },
            "additionalneeds": "Breakfast"
        }
       */

        // Once inner object yaradılır


        /*
          "bookingdates": {
                    "checkin": "2024-03-07",
                    "checkout": "2024-12-26"
        },
        */
        JSONObject datesJsonObject = new JSONObject();  // { }
        datesJsonObject.put("checkin", "2024-03-07");
        datesJsonObject.put("checkout", "2024-12-26");


        // Sonra outer json object yaradılır. Lazım yere inner elave edilir

        JSONObject requestBody = new JSONObject();
        requestBody.put( "firstname", "Mary");
        requestBody.put( "lastname", "Brown");
        requestBody.put( "totalprice", 514);
        requestBody.put( "depositpaid", false);
        requestBody.put( "bookingdates", datesJsonObject);
        requestBody.put( "additionalneeds", "Breakfast");


        System.out.println(requestBody);





    }

}
