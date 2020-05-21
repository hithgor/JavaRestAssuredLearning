package files;

public class payload {

    public static String TestJsonPractice() {
        return "{\n" +
                "  \"store\": {\n" +
                "    \"book\": [\n" +
                "      {\n" +
                "        \"category\": \"reference\",\n" +
                "        \"author\": \"Nigel Rees\",\n" +
                "        \"title\": \"Sayings of the Century\",\n" +
                "        \"price\": 8.95\n" +
                "      },\n" +
                "      {\n" +
                "        \"category\": \"fiction\",\n" +
                "        \"author\": \"Evelyn Waugh\",\n" +
                "        \"title\": \"Sword of Honour\",\n" +
                "        \"price\": 12.99\n" +
                "      },\n" +
                "      {\n" +
                "        \"category\": \"fiction\",\n" +
                "        \"author\": \"Herman Melville\",\n" +
                "        \"title\": \"Moby Dick\",\n" +
                "        \"isbn\": \"0-553-21311-3\",\n" +
                "        \"price\": 8.99\n" +
                "      },\n" +
                "      {\n" +
                "        \"category\": \"fiction\",\n" +
                "        \"author\": \"J. R. R. Tolkien\",\n" +
                "        \"title\": \"The Lord of the Rings\",\n" +
                "        \"isbn\": \"0-395-19395-8\",\n" +
                "        \"price\": 22.99\n" +
                "      }\n" +
                "    ],\n" +
                "    \"bicycle\": {\n" +
                "      \"color\": \"red\",\n" +
                "      \"price\": 19.95\n" +
                "    }\n" +
                "  }\n" +
                "}";
    }


    public static String AddPlace() {
        return "{\r\n" +
                "  \"location\": {\r\n" +
                "    \"lat\": -38.383494,\r\n" +
                "    \"lng\": 33.427362\r\n" +
                "  },\r\n" +
                "  \"accuracy\": 50,\r\n" +
                "  \"name\": \"Rahul Shetty Academy\",\r\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\r\n" +
                "  \"address\": \"29, side layout, cohen 09\",\r\n" +
                "  \"types\": [\r\n" +
                "    \"shoe park\",\r\n" +
                "    \"shop\"\r\n" +
                "  ],\r\n" +
                "  \"website\": \"http://rahulshettyacademy.com\",\r\n" +
                "  \"language\": \"French-IN\"\r\n" +
                "}\r\n" +
                "";


    }

    public static String CoursePrice() {

        return "{\r\n" +
                "  \"dashboard\": {\r\n" +
                "    \"purchaseAmount\": 1162,\r\n" +
                "    \"website\": \"rahulshettyacademy.com\"\r\n" +
                "  },\r\n" +
                "  \"courses\": [\r\n" +
                "    {\r\n" +
                "      \"title\": \"Selenium Python\",\r\n" +
                "      \"price\": 50,\r\n" +
                "      \"copies\": 6\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"Cypress\",\r\n" +
                "      \"price\": 40,\r\n" +
                "      \"copies\": 4\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"RPA\",\r\n" +
                "      \"price\": 45,\r\n" +
                "      \"copies\": 10\r\n" +
                "    },\r\n" +
                "     {\r\n" +
                "      \"title\": \"Appium\",\r\n" +
                "      \"price\": 36,\r\n" +
                "      \"copies\": 7\r\n" +
                "    }\r\n" +
                "    \r\n" +
                "    \r\n" +
                "    \r\n" +
                "  ]\r\n" +
                "}\r\n" +
                "";


    }

    public static String payloadDateCreated() {
        return "{\"dateCreated\":\"2020-03-29\"}";
    }
    public static String payloadMealcardCreation() {
        ///Payload viable to create 3 mealcards on 29-03-2020 day of test account
        return "[\n" +
                "  {\n" +
                "    \"id\": 11111111,\n" +
                "    \"user\": \"\",\n" +
                "    \"dateCreated\": \"2020-03-29\",\n" +
                "    \"number\": 0,\n" +
                "    \"mealTitle\": \"Breakfast\",\n" +
                "    \"namesCalories\": [\n" +
                "      {\n" +
                "        \"name\": \"Egg, whole, boiled or poached\",\n" +
                "        \"energy\": 275\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Honey loaf\",\n" +
                "        \"energy\": 122\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 22222222,\n" +
                "    \"user\": \"\",\n" +
                "    \"dateCreated\": \"2020-03-29\",\n" +
                "    \"number\": 1,\n" +
                "    \"mealTitle\": \"Lunch\",\n" +
                "    \"namesCalories\": [\n" +
                "      {\n" +
                "        \"name\": \"Pancakes, with fruit\",\n" +
                "        \"energy\": 389\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Strawberries, raw\",\n" +
                "        \"energy\": 110\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 33333333,\n" +
                "    \"user\": \"\",\n" +
                "    \"dateCreated\": \"2020-03-29\",\n" +
                "    \"number\": 2,\n" +
                "    \"mealTitle\": \"Dinner\",\n" +
                "    \"namesCalories\": [\n" +
                "      {\n" +
                "        \"name\": \"ALOHA MIX\",\n" +
                "        \"energy\": 515\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";
    }


}
