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
     * faisant dg d ́egats et possedant 
     * fl fl`eches 
     * @param dg dégats
     * @param fl nombre de flèches
     * 
     */ 
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
     * les dégats causés par l'arc lors d'un tir
     * @return dégats causés par l'arc lors d'un tir
     */    
    public int getDegats(){
        return this.degats;
    }
    /**méthode qui retourne 
     * le nombre de flèches disponibles
     * @return le nombre de flèches disponibles
     */
    public int getFleches(){
        return this.fleches;
    }

    //4.4 Autres Methodes 
    /** méthode pour recharger le nombre 
     * de flèches avec un nombre > à 0
     * @param nFleches nombre de flèches à ajouter au stock de flèches
     */
    public void recharger(int nFleches){
        if (nFleches<=0){
            this.fleches = this.fleches;
        } else {
            this.fleches += nFleches;
        }
    }
    /**méthode qui réduit le nb de flèches
     * de 1 quand une flèche est utilisée
     * @return le nombre de dégats causés par l'arc lors de son utilisation
     */
    public int utiliser(){
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
     * @return une chaine de caractère sous la forme "-arc(d:degats,f:fleches )"
     */
    public String toString() {
        return "-arc(d:" + degats + ",f:" + fleches + ")";
    }

}