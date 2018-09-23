import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Arrays;
public class FileReadingTest {

	@Test
	public void ReadingCardsFromInputTest() {
		App test = new App();
		int[] result=test.getOpCards();
		int[] result2=test.getAIPCards();
		int[] intArray = new int[] {0,0,0,0,0};
		assertFalse(Arrays.equals(result,intArray));
		assertFalse(Arrays.equals(result2,intArray));
	}
	
}
