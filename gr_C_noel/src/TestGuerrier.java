//import libtest.Test;

import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;


/**
 * classe de test qui permet de verifier que la classe Arc
 * fonctionne correctement
 */
public class TestGuerrier {

	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestGuerrier(), args);
	}

	/**
	 * test des methodes de guerrier
	 */
	// @Test
	public void test_guerrier_methodes() {
		Guerrier guerrier = new Guerrier("Toto",10);
		int pv = guerrier.getPv();
		Arc arc = guerrier.getArc();
		String nom = guerrier.getNom();

		boolean b = guerrier.etreBlesse();
		guerrier.subirDegat(1);

		Arc arcN =new Arc();
		boolean resPrendre = guerrier.prendreArc(arcN);
		Arc resPoser =guerrier.poserArc();

		Guerrier victime = new Guerrier("vict");
		boolean resAttaque = guerrier.attaquer(victime);

		String guerrierS = guerrier.toString();
	}
	/**
	 * Test getPv
	 */
	public void  test_getPv(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto",10);

		// methode testee
		guerrier.getPv();

		// verifications
		assertEquals("ca doit retourner 10pv", 10, guerrier.getPv());
	}
	/**
	 * Test getArc quand le guerrier n'a pas d'arc
	 */
	public void  test_getArc_null(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto");

		// methode testee
		guerrier.getArc();

		// verifications
		assertEquals("le guerrier ne doit aps avoir d'arc", null, guerrier.getArc());
	}
	/**
	 * Test getArc quand le guerrier a un arc
	 */
	public void  test_getArc(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto");
		Arc arc = new Arc(3,5);
		guerrier.prendreArc(arc);

		// methode testee
		guerrier.getArc();

		// verifications
		assertEquals("le guerrier doit avoir un arc avec 5 de dégats et 3 fleches", arc, guerrier.getArc());
	}
	/**
	 * Test getNom
	 */
	public void  test_getNom(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto");

		// methode testee
		guerrier.getNom();

		// verifications
		assertEquals("le guerrier doit avoir le nom de Toto", "Toto", guerrier.getNom());
	}

	/**
	 * Test de la méthode etreBlesse de Guerrier
	 */
	public void  test_etreBlesse(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto");

		// methode testee
		guerrier.etreBlesse();

		// verifications
		assertEquals("le guerrier doit être blessé", false, guerrier.etreBlesse());
	}
	/**
	 * Test de la méthode prendreArc quand le guerrier a pv > 0 et qu'il n'a pas d'arc
	 */
	public void  test_prendreArc_SansArc(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto");
		Arc arc = new Arc(3,5);

		// methode testee
		guerrier.prendreArc(arc);

		// verifications
		assertEquals("le guerrier doit pourvoir prendre l'arc", true, guerrier.prendreArc(arc));
	}
}
