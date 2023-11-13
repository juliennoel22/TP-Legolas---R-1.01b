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
	/**
	 * test constructeur avec paramètres
	 * quand le nombre de degats et de 
	 * fleches sont negatifs
	 */
	public void test_ContructeurPARAM_NEGATIF() {
		// preparation des donnees
		Arc arc = new Arc(-2,-3);

		// verifications
		assertEquals("arc doit toujours faire 0 degats", 0, arc.getDegats());
		assertEquals("arc doit avoir 0 fleches", 0, arc.getFleches());
	}

	/**
	 * test constructeur avec paramètres
	 * quand le nombre de degats est negatif 
	 * et que le nombre de fleches est positif
	 */
	public void test_ContructeurPARAM_NEGATIF_POSITIF() {
		// preparation des donnees
		Arc arc = new Arc(-2,3);

		// verifications
		assertEquals("arc doit toujours faire 0 degats", 0, arc.getDegats());
		assertEquals("arc doit avoir 3 fleches", 3, arc.getFleches());
	}

	/**
	 * test constructeur avec paramètres
	 * quand le nombre de degats est positif 
	 * et que le nombre de fleches est negatif
	 */
	public void test_ContructeurPARAM_POSITIF_NEGATIF() {
		// preparation des donnees
		Arc arc = new Arc(6,-3);

		// verifications
		assertEquals("arc doit toujours faire 6 degats", 6, arc.getDegats());
		assertEquals("arc doit avoir 0 fleches", 0, arc.getFleches());
	}

	/**
	 * test constructeur avec paramètres
	 * quand le nombre de degats est positif 
	 * et que le nombre de fleches est positif
	 */
	public void test_ContructeuPARAM_POSITIF() {
		// preparation des donnees
		Arc arc = new Arc(4,5);

		// verifications
		assertEquals("arc doit toujours faire 4 degats", 4, arc.getDegats());
		assertEquals("arc doit avoir 5 fleches", 5, arc.getFleches());
	}

	/**
	 * test du constructeur sans paramètres
	 */
	public void test_ConstructeurNOPARAM() {
		// preparation des donnees
		Arc arc = new Arc();

		// verifications
		assertEquals("arc doit toujours faire 5 degats", 5, arc.getDegats());
		assertEquals("arc doit avoir 3 fleches", 3, arc.getFleches());
	}

	
	// recharger l'arc : 
	// - nb fleches <= 0
	// - nb fleches > 0
	// ON TESTE POUR FLECHES = 0 ??????

	/**
	 * test de la méthode recharger
	 * quand l'arc est recharge avec 
	 * un nombre de fleches negatif 
	 */
	public void test_RechargerNEGATIF() {
		// preparation des donnees
		Arc arc = new Arc(3,5);

		// methode testee
		arc.recharger(-2);

		// verifications
		assertEquals("arc doit toujours faire 3 degats", 3, arc.getDegats());
		assertEquals("arc doit toujours avoir 5 fleches", 5, arc.getFleches());
	}
	/**
	 * test de la méthode recharger
	 * quand l'arc est rechargé correctement (fleches > 0)
	 */
	public void test_RechargerOK() {
		// preparation des donnees
		Arc arc = new Arc(3,5);

		// methode testee
		arc.recharger(2);

		// verifications
		assertEquals("arc doit toujours faire 3 degats", 3, arc.getDegats());
		assertEquals("arc doit avoir 7 fleches", 7, arc.getFleches());
	}


	
	// utiliser l'arc :
	// - fleches > 0
	// - fleches <= 0
	/**
	 * test de la méthode utiliser
	 * quand le nombre de flche est strictement 
	 * supérieur à 0
	 */
	public void test_UtiliserOK() {
		// preparation des donnees
		Arc arc = new Arc(3,5);

		// methode testee
		arc.utiliser();

		// verifications
		assertEquals("arc doit toujours faire 3 degats", 3, arc.getDegats());
		assertEquals("arc doit toujours avoir 4 fleches", 4, arc.getFleches());
	}
	/**
	 * test de la méthode utiliser 
	 * quand le nombre de fleches est
	 * inférieur ou égal à 0
	 */
	public void test_UtiliserNEGATIF() {
		// preparation des donnees
		Arc arc = new Arc(3,-1);

		// methode testee
		arc.utiliser();

		// verifications
		assertEquals("arc doit toujours avoir 0 fleches", 0, arc.getFleches());
	}
	/**
	 * test de la méthode toString 
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