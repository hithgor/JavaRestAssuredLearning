import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class MealcardsTests {

    public String BASE_URL = "http://127.0.0.1:8000/";
    public String USER_LOGIN_ENDPOINT = "api/user/login/";
    public String GET_MEALCARDS_ENDPOINT = "caloriestracker/getMealCards/";
    public String SAVE_MEALCARDS_ENDPOINT = "caloriestracker/postSaveMealCards/";

    private String csrfTokenFromSetup, userSessionIdFromSetup;
    private SessionFilter sessionFilterFromSetup;

    @BeforeTest
    public void setUp() {

        RequestSpecification req = new RequestSpecBuilder().setUrlEncodingEnabled(true)
                .setBaseUri(BASE_URL)
                .addFormParam("email", "hithgor1@gmail.com")
                .addFormParam("password", "1234")
                .setContentType(ContentType.URLENC).build();
        SessionFilter sessionFilter = new SessionFilter();
        RequestSpecification res = given().spec(req).log().all().filter(sessionFilter);
        Response response = res.when().post(USER_LOGIN_ENDPOINT)
                .then().extract().response();
        String userSessionId = response.getCookie("sessionid");

        ///cutting off CSRF TOKEN for usage in testing post methods later on.
        ///String csrftoken = response.body().asString().split("csrftoken = '")[1].substring(0,64);
        String csrftoken = response.getCookie("csrftoken");
        System.out.println("===============Running test setUp===============");
        System.out.println("Status code of login request: " + response.statusCode());
        System.out.println("CSRFTOKEN saved: " + csrftoken);
        System.out.println("Session ID saved: " + userSessionId);

        csrfTokenFromSetup = csrftoken;
        userSessionIdFromSetup = userSessionId;
        sessionFilterFromSetup = sessionFilter;

    }

    @DataProvider(name = "MealcardDates")
    public Object[][] mealcardDatesList() {
        return new Object[][]{{"\"dateCreated\":\"2020-03-19\""},
                {"\"dateCreated\":\"2020-03-20\""}, {"\"dateCreated\":\"2020-03-21\""}};
    }

    @Test(dataProvider = "MealcardDates")
    public void checkMealNames(String dateCreated) {
        /*//TEST CHECKING IF AUTOMATIC NAME-APPLYING to MEALS WORKS AS INTENDED
        0 - BREAKFAST, 1 - LUNCH, 2 - DINNER using pre-created mealCards on test account//*/

        Response mealcardsDataResponse = given().filter(sessionFilterFromSetup).baseUri(BASE_URL).urlEncodingEnabled(true)
                .log().all().contentType(ContentType.JSON).cookie("csrftoken", csrfTokenFromSetup)
                .cookie("sessionid", userSessionIdFromSetup)
                .header("X-CSRFToken", csrfTokenFromSetup)
                .sessionId(userSessionIdFromSetup)
                .body("{" + dateCreated + "}")
                .when().post(GET_MEALCARDS_ENDPOINT)
                .then().extract().response();

        System.out.println("checkMealNames test responded: ");
        System.out.println("status code: " + mealcardsDataResponse.statusCode());
        JsonPath jspMealcardsData = new JsonPath(mealcardsDataResponse.asString());
        System.out.println(mealcardsDataResponse.asString());


        ///Assert that meal names follow the pattern Breakfast-Lunch-Dinner
        ArrayList<String> mealNames = new ArrayList<>();
        mealNames.add("Breakfast");
        mealNames.add("Lunch");
        mealNames.add("Dinner");
        for (int i = 0; i < mealNames.size(); i++) {
            String nameToValidate = jspMealcardsData.getString("[" + i + "].mealTitle");
            System.out.println("Checking " + nameToValidate + " against " + mealNames.get(i));
            Assert.assertEquals(nameToValidate, mealNames.get(i));
        }

    }

    @Test
    public void retrieveMealcards() {
        ////Assert retrieval of exactly 3 mealcards true for predefined data
        Response mealcardsDataResponse = given().filter(sessionFilterFromSetup).baseUri(BASE_URL).urlEncodingEnabled(true)
                .log().all().contentType(ContentType.JSON).cookie("csrftoken", csrfTokenFromSetup)
                .cookie("sessionid", userSessionIdFromSetup)
                .header("X-CSRFToken", csrfTokenFromSetup)
                .sessionId(userSessionIdFromSetup)
                .body("{\"dateCreated\":\"2020-03-20\"}")
                .when().post(GET_MEALCARDS_ENDPOINT)
                .then().extract().response();

        JsonPath jspMealcardsData = new JsonPath(mealcardsDataResponse.asString());
        int mealcardsQuantity = jspMealcardsData.getList("").size();
        Assert.assertEquals(mealcardsDataResponse.statusCode(),200);
        Assert.assertEquals(mealcardsQuantity, 3);

    }

    @Test
    public void createMealcardsOnBlankDay() {
        /*User sends request of mealCard creation success
        Given only REST API written in Django - user then has to send a blank POST request
        to remove mealCard after assertions. */

        /* Logic to uncomment when deleting mealcards endpoint works.
        Response mealcardsDataResponse = given().filter(sessionFilterFromSetup).baseUri(BASE_URL).urlEncodingEnabled(true)
                .log().all().contentType(ContentType.JSON).cookie("csrftoken", csrfTokenFromSetup)
                .cookie("sessionid", userSessionIdFromSetup)
                .header("X-CSRFToken", csrfTokenFromSetup)
                .sessionId(userSessionIdFromSetup)
                .body("{\"dateCreated\":\"2020-03-29\"}")
                .when().post(GET_MEALCARDS_ENDPOINT)
                .then().extract().response();



        if(mealcardsQuantity!=0) {
                    mealcardsDataResponse = given().filter(sessionFilterFromSetup).baseUri(BASE_URL).urlEncodingEnabled(true)
                    .log().all().contentType(ContentType.JSON).cookie("csrftoken", csrfTokenFromSetup)
                    .cookie("sessionid", userSessionIdFromSetup)
                    .header("X-CSRFToken", csrfTokenFromSetup)
                    .sessionId(userSessionIdFromSetup)
                    .body("")
                    .when().post(SAVE_MEALCARDS_ENDPOINT)
                    .then().extract().response();
        }
        JsonPath jspMealcardsData = new JsonPath(mealcardsDataResponse.asString());
        int mealcardsQuantity = jspMealcardsData.getList("").size();
        Assert.assertEquals(mealcardsDataResponse.statusCode(),200);
        Assert.assertEquals(mealcardsQuantity, 0);
        */

        Response mealcardsDataResponse = given().filter(sessionFilterFromSetup).baseUri(BASE_URL).urlEncodingEnabled(true)
                .log().all().contentType(ContentType.JSON).cookie("csrftoken", csrfTokenFromSetup)
                .cookie("sessionid", userSessionIdFromSetup)
                .header("X-CSRFToken", csrfTokenFromSetup)
                .sessionId(userSessionIdFromSetup)
                .body(files.payload.payloadMealcardCreation())
                .when().post(SAVE_MEALCARDS_ENDPOINT)
                .then().extract().response();

        JsonPath jspMealcardsData = new JsonPath(mealcardsDataResponse.asString());
        Assert.assertEquals(mealcardsDataResponse.statusCode(),302);

                 mealcardsDataResponse = given().filter(sessionFilterFromSetup).baseUri(BASE_URL).urlEncodingEnabled(true)
                .log().all().contentType(ContentType.JSON).cookie("csrftoken", csrfTokenFromSetup)
                .cookie("sessionid", userSessionIdFromSetup)
                .header("X-CSRFToken", csrfTokenFromSetup)
                .sessionId(userSessionIdFromSetup)
                .body("{\"dateCreated\":\"2020-03-29\"}")
                .when().post(GET_MEALCARDS_ENDPOINT)
                .then().extract().response();

        JsonPath jspMealcardsData1 = new JsonPath(mealcardsDataResponse.asString());
        int mealcardsQuantity = jspMealcardsData1.getList("").size();
        Assert.assertEquals(mealcardsDataResponse.statusCode(),200);
        Assert.assertEquals(mealcardsQuantity, 3);
        Assert.assertEquals(jspMealcardsData1.getInt("[1].id"), 22222222);



    }
    


}
