public class Arc{
    private int degats;
    private int fleches;

    //
    /**
     * Constructeur sans parametre
     * qui construit un arc par defaut 
     * (avec 5 degats et 3 fleches)
     */
    public Arc(){
        this.degats=5;
        this.fleches=3;
    }


    /**un constructeur avec deux 
     * parametres entiers dg et fl qui 
     * construit un arc
     * faisant dg degats et possedant 
     * fl fleches 
     * @param dg degats
     * @param fl nombre de fleches
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
    /**methode qui retourne
     * les degats causes par l'arc lors d'un tir
     * @return degats causes par l'arc lors d'un tir
     */    
    public int getDegats(){
        return this.degats;
    }
    /**methode qui retourne 
     * le nombre de fleches disponibles
     * @return le nombre de fleches disponibles
     */
    public int getFleches(){
        return this.fleches;
    }

    //4.4 Autres Methodes 
    /** methode pour recharger le nombre 
     * de fleches avec un nombre > a 0
     * @param nFleches nombre de fleches a ajouter au stock de fleches
     */
    public void recharger(int nFleches){
        if (nFleches<=0){
            this.fleches = this.fleches;
        } else {
            this.fleches += nFleches;
            
        }
    }
    /**methode qui reduit le nb de fleches
     * de 1 quand une fleche est utilisee
     * @return le nombre de degats causes par l'arc lors de son utilisation
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
    /**methode qui retourne un message sous la 
     * forme suivante :
     * "-arc(d:degats,f:fleches )"
     * @return une chaine de caractere sous la forme "-arc(d:degats,f:fleches )"
     */
    public String toString() {
        return "-arc(d:" + degats + ",f:" + fleches + ")";
    }

}
