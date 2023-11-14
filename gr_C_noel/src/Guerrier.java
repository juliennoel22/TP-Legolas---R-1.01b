public class Guerrier{
    private String nom;
    private int pv; //jamasi négatif
    private Arc arc; //null si le guerrier n'a pas d'arc

    /** un constructeur avec un parametre qui construit
     * un guerrier avec un nom
     * @param pNom nom du guerrier
    */
    public Guerrier(String pNom){
        this.nom = pNom;
        this.pv = 10;
        this.arc = null;
    }
    /** un constructeur avec deux parametres qui construit
     * un guerrier avec un nom et un nombre de points de vie
     * @param pNom nom du guerrier
     * @param p Pvs du guerrier
    */
    public Guerrier(String pNom, int p){
        this.nom = pNom;
        if (p>=1){
            this.pv=p;
        } else {
            this.pv = 1;
        }
        this.arc = null;
    }
    /**
     * méthode qui retourne le nombre de PV
     * @return les PVs du Guerrier
     * @
     */
    public int getPv(){
        return this.pv;
    }
    /**
     * méthode qui retourne l'arc du guerrier
     * @return l'arc du guerrier
     */
    public Arc getArc(){
        return this.arc;
    }
    /**
     * méthode qui retourne le nom du guerrier
     * @return le nom du guerrier
     */
    public String getNom(){
        return this.nom;
    }
    
    /**
     * méthode qui retourne un booléen si le guerrier est blessée
     * @return un booléen si le guerrier est blessée
     */
    public boolean etreBlesse(){
        if (this.pv == 0) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * méthode qui fait subir un certain nombre de dégats au guerrier
     * @param degat degats que subit le guerrier
     */
    public void subirDegat (int degat){
        if (degat>0){
            this.pv -= degat;
            if (this.pv<0){
                this.pv = 0;
            }
        }
        else {
         this.pv = this.pv;   
        }
    }
    /**
     * méthode qui fait prendre un arc au guerrier
     * @param arc arc pris
     * @return booleen si l arc a ete pris
     */
    public boolean prendreArc (Arc arc){
        if (this.pv > 0) {
            if (this.arc == null){
                this.arc = arc;
                return true;
            }
            else  {
                this.arc = this.arc;
                return false;
            }
        } else {
            return false;
        }
    }
    /**
     * méthode qui retourne l'arc que pose le guerrier  
     * @return l'arc que pose le guerrier  
     */
    public Arc poserArc(){
        if (this.pv > 0) {
            if (this.arc == null){
                return null;
            }
            else {
                Arc arc_pose = this.arc;
                this.arc = null;
                return arc_pose;

            }
        } else{
            return null;
        }
    }
    /**
     * méthode qui retourne un booléen pour savoir si le guerrier a attaque ou non, selon 
     * certains paramètres ou l'identité de sa victime 
     * @param victime victime de l'attaque de guerrier
     * @return boolen si le guerrier a attaque  
     */
    public boolean attaquer (Guerrier victime){
        if (this.pv > 0){
            if (this.arc == null){
                return false;
            } else {
                int degats = this.arc.utiliser();
                if (degats > 0){
                    victime.subirDegat(degats);
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }
    /**
     * méthode qui retourne le nom et les Pvs du guerrier si il n'a pas d'arc
     * et retroune son nom, ses pvs et le nom de son arc si il en a un 
     * @return nom du guerrier, ses pvs et son arc s il en a un  
     */
    public String toString(){
        if (this.arc == null){
            return this.nom+"("+this.pv+")";
        } else {
            return this.nom + "(" + this.pv + ")" + this.arc.toString();
        }

    }
}