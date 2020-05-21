import files.payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumValidation {

	@Test
	public void sumOfCourses()
	{
		int sum = 0;
		int copies = 0;
		JsonPath js = new JsonPath(payload.CoursePrice());
		int coursesLength = js.getInt("courses.size()");

		for(int i=0;i<coursesLength; i++) {
			int sumPenis= js.getInt("courses["+i+"].price");
			int copiesPenis=  js.getInt("courses["+i+"].copies");
			sum = sum + (sumPenis*copiesPenis);
	}
		int predictedSum = js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, predictedSum);
		
	}
}
