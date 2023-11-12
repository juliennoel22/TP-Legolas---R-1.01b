import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;

/******************
 * test classe Arc
 *******************/
public class TestArc {

	/**
	 * methode de lancement des tests
	 */
	public static void main(String[] args) {
		lancer(new TestArc(), args);
	}

	/**
	 * verifieque les méthodes sont bien appelée
	 */
	public void test_arc_methodes() {
		Arc arc = new Arc(3,5);
		assertEquals("ordre parametres est mauvais",3,arc.getDegats());
		assertEquals("ordre parametres est mauvais",5,arc.getFleches());
		
		arc.recharger(5);
		int dg = arc.utiliser();
		String s = arc.toString();
	}

	// recharger l'arc : 
	// - nb fleches > 0
	// - nb fleches <= 0
	// ON TESTE POUR FLECHES = 0 ??????

	/**
	 * quand l'arc est recharge correctement (fleches >= 0)
	 */
	public void test_recharger_OK() {
		// preparation des donnees
		Arc arc = new Arc(3,5);

		// methode testee
		arc.recharger(2);

		// verifications
		assertEquals("arc doit toujours faire 3 degats", 3, arc.getDegats());
		assertEquals("arc doit avoir 7 fleches", 7, arc.getFleches());
	}

	/**
	 * quand l'arc est recharge avec un nombre de fleches negatif 
	 */
	public void test_recharger_negatif() {
		// preparation des donnees
		Arc arc = new Arc(3,5);

		// methode testee
		arc.recharger(-2);

		// verifications
		assertEquals("arc doit toujours faire 3 degats", 3, arc.getDegats());
		assertEquals("arc doit toujours avoir 5 fleches", 5, arc.getFleches());
	}

	
	// utiliser l'arc :
	// - fleches > 0
	// - fleches <= 0
	/**
	 * quand l'arc utlise une flèche
	 */
	public void test_utiliser_OK() {
		// preparation des donnees
		Arc arc = new Arc(3,5);

		// methode testee
		arc.utiliser();

		// verifications
		assertEquals("arc doit toujours faire 3 degats", 3, arc.getDegats());
		assertEquals("arc doit toujours avoir 4 fleches", 4, arc.getFleches());
	}
	/**
	 * quand utiliser prend un nb négatif ou nul pour fleches
	 */
	public void test_utiliser_negatif() {
		// preparation des donnees
		Arc arc = new Arc(3,0);

		// methode testee
		arc.utiliser();

		// verifications
		assertEquals("arc doit toujours avoir 0 fleches", 0, arc.getFleches());
	}
	/**
	 * test méthode toString 
	 */
	public void test_toString() {
		// preparation des donnees
		Arc arc = new Arc(3,5);

		// methode testee
		arc.toString();

		// verifications
		assertEquals("la chaine doit être écrite correctement","-arc(d:3,f:5)", arc.toString());
	}
}