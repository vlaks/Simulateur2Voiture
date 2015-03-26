package DomaineVoiture;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestVoiture {
	
	private Voiture maVoiture;
	
	@Before
	public void setUp(){
		maVoiture = new Voiture (100, 0,0,10);
	}
	
	@Test
	public void  testEvolutionXenFonctionVitesseSurUnTopSeconde() {
		
		maVoiture.miseAJourPosition();
		
		assertEquals(110, maVoiture.getX());
	}
	
	@Test
	public void testAcceleration(){
		
		maVoiture.accelerer();
		
		assertEquals(20, maVoiture.getVitesse());
	}
	
	@Test
	public void testAccelerationLimite() {
		
		maVoiture.setVitesse(100);
		maVoiture.accelerer();
		assertEquals(100, maVoiture.getVitesse());
		
	}

	@Test
	public void testChangementDeSens() {
		
		maVoiture.setDirection(0);
		maVoiture.inverserDirection();
		assertEquals(180, maVoiture.getDirection());
		
	}
	
	@Test
	public void testChangementDeSensEtEvolutionDeX() {
		
		maVoiture.setDirection(0);
		maVoiture.inverserDirection();
		maVoiture.miseAJourPosition();
		assertEquals(90, maVoiture.getX());
		
	}
	
	@Test
	public void testPositionLimiteHaute() {
		
		maVoiture.setVitesse(1000);
		maVoiture.miseAJourPosition();
		assertEquals(1000, maVoiture.getX());
		
	}
	
	@Test
	public void testPositionLimiteBasse() {
		
		maVoiture.setVitesse(1000);
		maVoiture.inverserDirection();
		maVoiture.miseAJourPosition();
		assertEquals(0, maVoiture.getX());
		
	}

    @Test
    public void  testEvolutionX2DenFonctionVitesseSurUnTopSeconde() {

        Voiture voiture2 = new Voiture(0, 0, 0, 100);
        voiture2.miseAJourPosition();

        assertEquals(100, voiture2.getX());
    }

    @Test
    public void testEvolutionY2DenFonctionVitesseSurUnTopSeconde() {
        Voiture voiture2 = new Voiture(0, 0, 90, 100);
        voiture2.miseAJourPosition();

        assertEquals(0,voiture2.getX());
        assertEquals(100, voiture2.getY());
    }

    @Test
    public void testDirection(){
        Voiture voiture2 = new Voiture(0, 0, 30, 100);
        voiture2.miseAJourPosition();

        assertEquals(86,voiture2.getX());
        assertEquals(49,voiture2.getY());
    }
	
}
