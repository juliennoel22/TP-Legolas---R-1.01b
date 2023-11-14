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
	 * test du constructeur avec 1 paramètre
	 */
	public void  test_ConstructeurPARAM(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto");

		// verifications
		assertEquals("Le nom du guerrier doit être Toto", "Toto", guerrier.getNom());
		assertEquals("Les Pvs du gerrier doivent être égal à 10", 10, guerrier.getPv());
		assertEquals("Le guerrier ne doit pas avoir d'arc", null, guerrier.getArc());
	}

	/**
	 * test du constructeur avec 2 paramètres
	 * quand p est inférieur à 1
	 */
	public void  test_ConstructeurPARAMS_pinf(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto", -7);

		// verifications
		assertEquals("Le nom du guerrier doit être Toto", "Toto", guerrier.getNom());
		assertEquals("Les Pvs du gerrier doivent être égal à 1", 1, guerrier.getPv());
		assertEquals("Le guerrier ne doit pas avoir d'arc", null, guerrier.getArc());
	}

	/**
	 * test du constructeur avec 2 paramètres corrects
	 */
	public void  test_ConstructeurPARAMSOK(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto", 7);

		// verifications
		assertEquals("Le nom du guerrier doit être Toto", "Toto", guerrier.getNom());
		assertEquals("Les Pvs du gerrier doivent être égal à 7", 7, guerrier.getPv());
		assertEquals("Le guerrier ne doit pas avoir d'arc", null, guerrier.getArc());
	}

	

	/**
	 * Test de la méthode etreBlesse de Guerrier 
	 * quand les Pvs sont égaux à 0
	 */
	public void  test_EtreBlesse_PVZERO(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto",1);
		guerrier.subirDegat(1) ;

		// verifications
		assertEquals("le guerrier doit être blessé", true, guerrier.etreBlesse());
	}

	/**
	 * Test de la méthode etreBlesse de Guerrier 
	 * quand les Pvs ne sont pas égaux à 0
	 */
	public void  test_EtreBlesse_PVPASZERO(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto",1);

		// verifications
		assertEquals("le guerrier ne doit pas être blessé", false, guerrier.etreBlesse());
	}

	/**
	 * Test de la méthode subirDegat de Guerrier 
	 * si les dégats causés sont supérieurs à 0
	 * et que les Pvs  sont négatifs
	 */
	public void  test_SubirDegats_SUP_NEG(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto",1);

		// methode testee
		guerrier.subirDegat(2);

		// verifications
		assertEquals("le guerrier ne doit pas être blessé", 0, guerrier.getPv());
	}

	/**
	 * Test de la méthode subirDegat de Guerrier 
	 * si les dégats causés sont supérieurs à 0
	 * et que les Pvs positifs
	 */
	public void  test_SubirDegats_SUP_POS(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto",3);

		// methode testee
		guerrier.subirDegat(2);

		// verifications
		assertEquals("le guerrier ne doit pas être blessé", 1, guerrier.getPv());
	}

	/**
	 * Test de la méthode subirDegat de Guerrier 
	 * si les dégats causés sont inférieurs ou égaux à 0
	 */
	public void  test_SubirDegats_INF(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto",7);

		// methode testee
		guerrier.subirDegat(-10);

		// verifications
		assertEquals("le guerrier ne doit pas être blessé", 7, guerrier.getPv());
	}



	/**
	 * Test de la méthode prendreArc de Guerrier 
	 * si les Pvs sont supérieurs à 0
	 * et que le guerrier n'a pas d'arc
	 */
	public void  test_prendreArc_SansArc(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto");
		Arc arc = new Arc(3,5);

		// verifications
		assertEquals("le guerrier doit pouvoir prendre l'arc", true, guerrier.prendreArc(arc));
	}

	/**
	 * Test de la méthode prendreArc de Guerrier 
	 * si les Pvs sont supérieurs à 0
	 * et que le guerrier a déjà un arc
	 */
	public void  test_prendreArc_AvecArc(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto");
		Arc arc = new Arc(3,5);
		guerrier.prendreArc(arc);

		// verifications
		assertEquals("le guerrier à déjà un arc", false, guerrier.prendreArc(arc));
	}

	/**
	 * Test de la méthode prendreArc de Guerrier 
	 * si les Pvs inférieurs ou égaux à 0
	 */
	public void  test_prendreArc_PVNEG(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto",1);
		guerrier.subirDegat(10);
		Arc arc = new Arc(3,5);

		// verifications
		assertEquals("le guerrier à des Pvs inférieurs ou égaux à 0", false, guerrier.prendreArc(arc));
	}
		
	





	/**
	 * Test de la méthode poserArc de Guerrier 
	 * si les Pvs sont supérieurs à 0
	 * et que le guerrier n'a pas d'arc
	 */
	public void  test_poserArc_SansArc(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto");

		// verifications
		assertEquals("le guerrier ne doit pas avoir d'arc à poser", null, guerrier.poserArc());
	}

	/**
	 * Test de la méthode poserArc de Guerrier 
	 * si les Pvs sont supérieurs à 0
	 * et que le guerrier a déjà un arc
	 */
	public void  test_poserArc_AvecArc(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto");
		Arc arc = new Arc(3,5);
		guerrier.prendreArc(arc);

		// verifications
		assertEquals("le guerrier doit poser l'arc"+arc, arc, guerrier.poserArc());
		assertEquals("le guerrier ne doit plus avoir d'arc", null, guerrier.getArc());

	}

	/**
	 * Test de la méthode prendreArc de Guerrier 
	 * si les Pvs inférieurs ou égaux à 0
	 */
	public void  test_poserArc_PVNEG(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto",1);
		guerrier.subirDegat(10);

		// verifications
		assertEquals("le guerrier à des Pvs inférieurs ou égaux à 0, il ne peut pas poser d'arc", null, guerrier.poserArc());
	}



	/**
	 * Test de la méthode attaquer de Guerrier 
	 * si ses Pvs sont supérieurs à 0
	 * et que le guerrier n'a pas d'arc
	 */
	public void  test_attaquer_SansArc(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto");
		Guerrier victime = new Guerrier("Jean");

		// verifications
		assertEquals("le guerrier ne doit pas pouvoir attaquer la victime, il n'a pas d'arc", false, guerrier.attaquer(victime));
	}

	/**
	 * Test de la méthode poserArc de Guerrier 
	 * si les Pvs sont supérieurs à 0
	 * et que le guerrier a un arc
	 * et que l'arc fait plus de 0 dégats
	 */
	public void  test_attaquer_AvecArc(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto");
		Guerrier victime = new Guerrier("Jean");
		Arc arc = new Arc(3,5);
		guerrier.prendreArc(arc);

		// verifications
		assertEquals("le guerrier doit pouvoir attaquer la victime, il possède un arc qui fait plus de 0 dégats", true, guerrier.attaquer(victime));

	}

	/**
	 * Test de la méthode poserArc de Guerrier 
	 * si les Pvs sont supérieurs à 0
	 * et que le guerrier a un arc
	 * et que l'arc ne fait pas de dégats
	 */
	public void  test_attaquer_AvecArcSansDegats(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto");
		Guerrier victime = new Guerrier("Jean");
		Arc arc = new Arc(0,5);
		guerrier.prendreArc(arc);

		// verifications
		assertEquals("le guerrier ne doit pas pouvoir attaquer la victime, il possède un arc qui ne fait pas de dégats", false, guerrier.attaquer(victime));

	}

	/**
	 * Test de la méthode prendreArc de Guerrier 
	 * si les Pvs inférieurs ou égaux à 0
	 */
	public void  test_attaquer_PVNEG(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto",1);
		Guerrier victime = new Guerrier("Jean");

		guerrier.subirDegat(10);

		// verifications
		assertEquals("le guerrier à des Pvs inférieurs ou égaux à 0, il ne peut pas attaquer", false, guerrier.attaquer(victime));
	}








	/**
	 * Test de la méthode toString de Guerrier 
	 * si il n'a pas d'arc
	 */
	public void test_toString_PASARC(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto",1);

		// verifications
		assertEquals("le guerrier n'a pas ce nombre de PV ou n'a pas le bon nom", "Toto(1)", guerrier.toString());
	}


	/**
	 * Test de la méthode toString de Guerrier 
	 * si il a un arc
	 */
	public void test_toString_ARC(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("Toto",1);
		Arc arc = new Arc(3,5);
		guerrier.prendreArc(arc);


		// verifications
		assertEquals("le guerrier n'a pas ce nombre de PV ou n'a pas le bon nom ou l'arc n'a pas ce nombre de flèches ou il n'infliges pas ce nombre de dégats", "Toto(1)-arc(d:3,f:5)", guerrier.toString());
	}


}
