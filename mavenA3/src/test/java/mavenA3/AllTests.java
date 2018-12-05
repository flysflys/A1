package mavenA3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ HandTest.class, OneAITest.class, PlayerNumberTesting.class, WinnerTest.class })
public class AllTests {

}
