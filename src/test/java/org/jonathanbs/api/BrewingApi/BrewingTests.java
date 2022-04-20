package org.jonathanbs.api.BrewingApi;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;

/** Mercantil Andina Challenge **/
public class BrewingTests {
    private Logger logger = Logger.getLogger("BrewingTests");


    @Test
    public void TC_Backend_001(){
        /** Paso 1 **/
        RequestSpecification request = new RequestSpecBuilder()
                .setBaseUri("https://api.openbrewerydb.org/breweries/")
                .addQueryParam("query", "lagunitas")
                .setContentType(ContentType.JSON)
                .build();

        RequestSpecification requestSpecification = given()
                .spec(request);


        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

        Response getResponse = requestSpecification
                .when()
                .get("autocomplete")
                .then()
                .spec(responseSpecification).log().all()
                .extract().response();

        String getResponseString = getResponse.asString();
        JsonPath response1 = new JsonPath(getResponseString);
        List<Brewing> brewingList = new ArrayList<Brewing>();
        int numberResults = (response1.getInt("size()"));

        /** Paso 2  **/
        for (int i= 0; i < numberResults ; i++){
            String name = response1.getString("["+i+"].name");
            if (name.contains("Lagunitas Brewing Co")){
                Brewing br = new Brewing();
                br.setId(response1.getString("["+i+"].id"));
                br.setName(response1.getString("["+i+"].name"));
                brewingList.add(br);
            }
        }

        /** Paso 3 **/
        //logger.info("Tamaño lista => "+ brewingList.size());

        RequestSpecification request2 = new RequestSpecBuilder()
                .setBaseUri("https://api.openbrewerydb.org/")
                .setContentType(ContentType.JSON)
                .build();

        RequestSpecification requestSpecification2 = given()
                .spec(request2);


        ResponseSpecification responseSpecification2 = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

        Brewing brewingResult = new Brewing();
        for (int j=0; j < brewingList.size(); j++){
            String idBrew = brewingList.get(j).getId();
            Response getResponse2 = requestSpecification2
                    .when()
                    .get("breweries/"+idBrew)
                    .then()
                    .spec(responseSpecification2).log().all()
                    .extract().response();

            String getResponse2String = getResponse2.asString();
            JsonPath getResponse2js = new JsonPath(getResponse2String);

            String state = getResponse2js.getString("state");
            if (state.equalsIgnoreCase("California")){
                brewingResult.setId(getResponse2js.getString("id"));
                brewingResult.setName(getResponse2js.getString("name"));
                brewingResult.setBrewery_type(getResponse2js.getString("brewery_type"));
                brewingResult.setStreet(getResponse2js.getString("street"));
                brewingResult.setAddress2(getResponse2js.getString("address_2"));
                brewingResult.setAddress_3(getResponse2js.getString("address_3"));
                brewingResult.setCity(getResponse2js.getString("city"));
                brewingResult.setState(getResponse2js.getString("state"));
                brewingResult.setCountyProvince(getResponse2js.getString("country_province"));
                brewingResult.setPostal_code(getResponse2js.getString("postal_code"));
                brewingResult.setCountry(getResponse2js.getString("country"));
                brewingResult.setLongitude(Double.parseDouble(getResponse2js.getString("longitude")));
                brewingResult.setLatitude(Double.parseDouble(getResponse2js.getString("latitude")));
                brewingResult.setPhone(getResponse2js.getString("phone"));
                brewingResult.setWebsite_url(getResponse2js.getString("website_url"));
                brewingResult.setUpdated_at(getResponse2js.getString("updated_at"));
                brewingResult.setCreated_at(getResponse2js.getString("created_at"));
            }
        }

        /** Paso 4 - En este caso, el test no pasa ya que difiere el Id esperado **/
        Assert.assertEquals(brewingResult.getId(), "761");
        Assert.assertEquals(brewingResult.getName(), "Lagunitas Brewing Co");
        Assert.assertEquals(brewingResult.getStreet(), "1280 N McDowell Blvd");
        Assert.assertEquals(brewingResult.getPhone(), "7077694495");

    }
}
