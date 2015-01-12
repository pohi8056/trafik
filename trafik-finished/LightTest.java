import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 */

/**
 * @author SPIDAHSTOBE
 *
 */
public class LightTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link Light#Light(int, int)}.
	 */
	@Test
	public void testLight() {
		Light light = new Light(12,13);
		assertTrue(light.period == 12 && light.green == 13);
	}

	/**
	 * Test method for {@link Light#step()}.
	 */
	@Test
	public void testStep() {
		Light light = new Light(2,2);
		light.step();
		assertTrue(light.time == 1);
		light.step();
		assertTrue(light.time == 0);
	}

	/**
	 * Test method for {@link Light#isGreen()}.
	 */
	@Test
	public void testIsGreen() {
		Light light = new Light(5,2);
		assertTrue(light.isGreen());
		light.step();
		light.step();
		assertFalse(light.isGreen());
	}

       

}
