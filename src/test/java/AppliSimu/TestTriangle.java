package AppliSimu;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTriangle {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testConversionMetresPixelsX() {
		
		IHMVoiture monTriangle = new IHMVoiture();
		
		int xPixels = monTriangle.calculerPositionPixels(110);
		
		assertEquals(55, xPixels);
	}

    @Test
    public void testConversionMetresPixelsY() {
        IHMVoiture monTriangle2 = new IHMVoiture();

        int yPixels = monTriangle2.calculerPositionPixels(100);

        assertEquals(50, yPixels);
    }


}
