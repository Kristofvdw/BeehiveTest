package BeehiveTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Kristof on 20/01/2017.
 */
public class testNgTest {
    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
    }

    @Test(groups = { "fast" })
    public void aFastTest() {
        System.out.println("Fast test");
    }

    @Test(groups = { "slow" })
    public void aSlowTest() {
        System.out.println("Slow test");
    }

}
