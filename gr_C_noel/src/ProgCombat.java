public class ProgCombat{
    public static void main(String[] args){

        //q1
        Guerrier legolas = new Guerrier("Legolas",4);
        System.out.println("____________________");
        System.out.println("____________________");
        System.out.println("____________________");

        System.out.println("creation du guerrier Legolas : "+legolas);
        System.out.println();
        
        //q2
        Guerrier orc = new Guerrier("Ugluk",3);
        System.out.println("creation du guerrier Ugluk : "+orc);
        System.out.println();
        
        //q3
        legolas.attaquer(orc);
        System.out.println("Legolas attaque Ugluk, Legolas n a fait aucun degats car il n a pas d arme, Ugluk n a pas perdu de vie : "+orc);
        System.out.println();
        //q4
        Arc arcElfique = new Arc(2,1);
        System.out.println("Nouvel arc cree : "+arcElfique);
        System.out.println();

        //q5
        legolas.prendreArc(arcElfique);
        System.out.println("Legolas prends l arc suivant : "+legolas.toString());
        System.out.println();

        //q6
        legolas.attaquer(orc);
        System.out.println("Legolas attaque Ugluk : " +orc);
        System.out.println();
        //q7
        legolas.attaquer(orc);
        System.out.println(legolas);
        System.out.println("Legolas attaque Ugluck mais il n a plus de fleche, Ugluck ne pert pas de vie : "+orc);
        System.out.println();

        //q8
        Arc orcArc = new Arc(5,3);
        System.out.println("Nouvel arc cree : "+orcArc);

        orc.prendreArc(orcArc);
        System.out.println("Ugluck prend un l arc suivant : "+orc.toString());
        System.out.println();

        //q9
        orc.attaquer(legolas);
        System.out.println("Ugluck attaque Legolas, il prends 5 degats : "+legolas);
        System.out.println();

        //q10
        Guerrier arwen = new Guerrier("Arwen",10);
        System.out.println("nouveau guerrier cree : "+arwen);
        System.out.println();

        //q11
        arwen.prendreArc(arcElfique);
        System.out.println("Arwen prends l arc suivant : "+arwen.toString());
        System.out.println();

        //q12
        arcElfique.recharger(1);
        System.out.println("l arc elfique est recharge avec une fleche : "+arwen.toString());
        System.out.println();
        
        //q13
        arwen.attaquer(orc);
        System.out.println("Arwen attaque Ugluck, il prends 2 degats et il est blesse : "+orc);
        System.out.println();

        //q14
        orc.attaquer(arwen);
        System.out.println("Ugluck attaque Arwen, mais il est blesse, Arwen ne recoit aucun degats : "+arwen);
        System.out.println();
        System.out.println();
        System.out.println("Ugluk est blesse et son attaque echoue, il s effondre, terrasse !! (grande fete chez les elfes !!)");




    }
}
