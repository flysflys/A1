import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FlushTest.class, FOAKTest.class, FullHouseTest.class, NoHandsTest.class, PairTest.class,
		RoyalFlushTest.class, StraightFlushTest.class, StraightTest.class, TOAKTest.class, TwoPairTest.class })
public class HandsTest {

}
