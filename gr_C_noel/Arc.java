public class Arc{
    private int degats;
    private int fleches;

    //
    /**
     * Constructeur sans paramètre
     * qui construit un arc par défaut 
     * (avec 5 dégats et 3 flèches)
     */
    public Arc(){
        this.degats=5;
        this.fleches=3;
    }

    /**un constructeur avec deux 
     * param`etres entiers dg et fl qui 
     * construit un arc
     * faisant dg d ́egats et poss ́edant 
     * fl fl`eches */ 
    public Arc(int dg, int fl){
        if (dg < 0) {
            this.degats = 0;
        } else {
            this.degats=dg;
        }
        if (fl<0) {
            this.fleches = 0;
        } else {
        this.fleches=fl;
        }
    }
    /**métohde qui retourne
     * les dégats */    
    public int getDegats(){
        return degats;
    }
    /**méthode qui retourne 
     * le nombre de flèches
     */
    public int getFleches(){
        return fleches;
    }

    //4.4 Autres Methodes 
    /** méthode pour recharger le nombre 
     * de flèches avec un nombre > à 0
     *  */
    public void recharger(int nFleches){
        if (nFleches>0){
            this.fleches += nFleches;
        }
    }
    /**méthode qui réduit le nb de flèches
     * de 1 quand uen flèche est utilisée
     */
    public int utiliser{
        if (fleches>0){
        this.fleches -= 1;
        return degats;
        }
        else{
            return 0;
        }
    }
    /**méthode qui retourne un message sous la 
     * forme suivante :
     * "-arc(d:degats,f:fleches )"
     */
    public char toString{
        return "-arc(d:"+ degats+",f:"+ fleches")";
    }

    //4.5 Tests
    


}