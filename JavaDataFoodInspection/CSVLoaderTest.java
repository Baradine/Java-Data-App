import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CSVLoaderTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CSVLoaderTest
{
    /**
     * Default constructor for test class CSVLoaderTest
     */
    public CSVLoaderTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void rowCountTest()
    {
        CSVLoader csv = new CSVLoader();
        assertEquals(12798, csv.CountRows("testDONOTEDIT"));
    }
    
    @Test
    public void checkCSVTest()
    {
        CSVLoader csv = new CSVLoader();
        assertEquals("MON AMI GABI", csv.Load("testDONOTEDIT").data[19][1]);
    }
}

