import java.util.ArrayList;
import java.util.Random;

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
        int[] coord = this.getCoordLibre();
        fruits.add(Fruit.randomFruit(coord[0],coord[1]));
    }

    public void afficherGrille(){
        Case[][] grid = grille.getGrid();
        for (int i=0; i<50; i++){
            for (int j=0; j<50; j++){
                boolean found=false;
                for (Fruit f : fruits){
                    if (f.getX() == j && f.getY() == i){
                        System.out.print("*");
                        found=true;
                    }
                }
                if (!found)
                    System.out.print((grid[i][j].isPassable()) ? '.' : '#');
            }
            System.out.println();
        }
    }

    public int getTaille(){
        return taille;
    }
    public Case[][] getGrille(){
        Case[][] grid = grille.getGrid();
        for (int i=0; i<50; i++){
            for (int j=0; j<50; j++){
                boolean found=false;
                for (Fruit f : fruits){
                    if (f.getX() == j && f.getY() == i){
                        grid[i][j] = f;
                        found=true;
                    }
                }
            }
        }
        return grid;
    }

    public int[] getCoordLibre(){
        int[] coord = new int[2];
        do {
            coord[0] = new Random().nextInt(taille);
            coord[1] = new Random().nextInt(taille);
        }while(!grille.getGrid()[coord[0]][coord[1]].isPassable());
        return coord;
    }

    public boolean isOver(){
        return false;
    }

    public static void main(String[] argv){
        JeuModele jeuModele = new JeuModele();
        jeuModele.afficherGrille();
    }
}
