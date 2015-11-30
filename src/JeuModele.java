import java.util.ArrayList;

/**
 * Created by pphelipo on 30/11/15.
 */
public class JeuModele {
    private final int taille = 50;
    private Grille grille;
    private ArrayList<Serpent> serpents;
    private ArrayList<Fruit> fruits;

    public JeuModele(){
        grille = new Grille(50);
        serpents = new ArrayList<Serpent>(2);
        fruits = new ArrayList<Fruit>();
    }

    public boolean isOver(){
        return false;
    }

    public static void main(String[] argv){
        System.out.println(""+Fruit.randomFruit().getScore());
    }
}
