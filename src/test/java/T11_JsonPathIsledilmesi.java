import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class T11_JsonPathIsledilmesi {

    /*

  {
    "firstName": "John",
    "lastName": "doe",
    "address": {
      "streetAddress": "naist street",
      "city": "Nara",
      "postalCode": "630-0192"
    },
    "age": 26,
    "phoneNumbers": [
      {
        "number": "0123-4567-8888",
        "type": "iPhone"
      },
      {
        "number": "0123-4567-8910",
        "type": "home"
      }
    ]
  }

     */

    @Test
    public void t09_JsonPathIsledilmesi(){

        JSONObject personalInfoJsonObj  = new JSONObject();

        JSONObject adressJsonObj  = new JSONObject();

        JSONArray phoneJsonObj  = new JSONArray();
        JSONObject cibTelefonuJsonObj  = new JSONObject();
        JSONObject evTelefonuJsonObj  = new JSONObject();

        adressJsonObj.put("streetAddress","naist street");
        adressJsonObj.put("city", "Nara");
        adressJsonObj.put("postalCode", "630-0192");

        cibTelefonuJsonObj.put("number", "0123-4567-8888");
        cibTelefonuJsonObj.put("type", "iPhone");

        evTelefonuJsonObj.put("number", "0123-4567-8910");
        evTelefonuJsonObj.put("type", "home");

        phoneJsonObj.put(cibTelefonuJsonObj);
        phoneJsonObj.put(evTelefonuJsonObj);


        personalInfoJsonObj.put("firstName", "John");
        personalInfoJsonObj.put("lastName", "doe");
        personalInfoJsonObj.put("age", 26);
        personalInfoJsonObj.put("address",adressJsonObj);
        personalInfoJsonObj.put( "phoneNumbers", phoneJsonObj);


        System.out.println(personalInfoJsonObj);


        System.out.println("FirstName: " + personalInfoJsonObj.get("firstName") );

        System.out.println("Küçe adı: " + personalInfoJsonObj.getJSONObject("address").get("streetAddress"));
        System.out.println(" Cib telefon nömresi: " +   personalInfoJsonObj.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));


    }

}
