import files.payload;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import pojo.Book;


public class ComplexJsonParse2 {


    public static void main(String[] args) {
        ////PARSING JSON AS POJO OBJECT////
        Book jpMorgan = new JsonPath(payload.TestJsonPractice()).using(JsonPathConfig.jsonPathConfig()).getObject("store.book[0]", Book.class);
        String penisBook = jpMorgan.author;



    }
}
