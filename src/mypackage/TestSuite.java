package mypackage;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   NegativeTests.class,
   PositiveTests.class
})
public class TestSuite {

}
