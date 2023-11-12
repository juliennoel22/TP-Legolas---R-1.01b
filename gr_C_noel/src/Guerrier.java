public class Guerrier{
    private String nom;
    private int pv; //jamasi négatif
    private Arc arc; //null si le guerrier n'a pas d'arc


    public Guerrier(String pNom){
        this.nom = pNom;
        this.pv = 10;
        this.arc = null;
    }
    public Guerrier(String pNom, int p){
        this.nom = pNom;
        if (p>=1){
            this.pv=p;
        } else {
            this.pv = 1;
        }
        this.arc = null;
    }
    public int getPv(){
        return this.pv;
    }
    public Arc getArc(){
        return this.arc;
    }
    public String getNom(){
        return this.nom;
    }
    
    
    public boolean etreBlesse(){
        if (this.pv == 0) {
            return true;
        } else {
            return false;
        }
    }
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
    public String toString(){
        if (this.arc == null){
            return this.nom+"("+this.pv+")";
        } else {
            return this.nom + "(" + this.pv + ")-" + this.arc.toString();
        }

    }
}