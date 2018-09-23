import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Arrays;
public class FileReadingTest {

	@Test
	public void ReadingCardsFromInputForOPTest() {
		App test = new App();
		int[] result=test.getOpCards();
		int[] intArray = new int[] {0,0,0,0,0};
		
		assertFalse(Arrays.equals(result,intArray));
	}

}
