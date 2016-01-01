import java.util.ArrayList;
import java.util.Random;

/**
 * Created by pphelipo on 30/11/15.
 */
public class JeuModele {
    private int taille;
    private Grille grille;
    private ArrayList<Serpent> serpents;
    private ArrayList<Fruit> fruits;

    public JeuModele(int t){
        taille = t;
        grille = new Grille(taille);
        serpents = new ArrayList<Serpent>(2);
        serpents.add(new Serpent(5, 5, 0));
        serpents.add(new Serpent(10, 5, 3));
        serpents.add(new Serpent(t-5, t-5, 2));
        serpents.add(new Serpent(t-10, t-5, 1));
        fruits = new ArrayList<Fruit>();
        int[] coord = this.getCoordLibre();
        fruits.add(Fruit.randomFruit(coord[0],coord[1]));
        coord = this.getCoordLibre();
        fruits.add(Fruit.randomFruit(coord[0],coord[1]));
        coord = this.getCoordLibre();
        fruits.add(Fruit.randomFruit(coord[0],coord[1]));
        coord = this.getCoordLibre();
        fruits.add(Fruit.randomFruit(coord[0],coord[1]));
        coord = this.getCoordLibre();
        fruits.add(Fruit.randomFruit(coord[0],coord[1]));
        coord = this.getCoordLibre();
        fruits.add(Fruit.randomFruit(coord[0],coord[1]));
        coord = this.getCoordLibre();
        fruits.add(Fruit.randomFruit(coord[0],coord[1]));
        coord = this.getCoordLibre();
        fruits.add(Fruit.randomFruit(coord[0],coord[1]));
        coord = this.getCoordLibre();
        fruits.add(Fruit.randomFruit(coord[0],coord[1]));
        coord = this.getCoordLibre();
        fruits.add(Fruit.randomFruit(coord[0],coord[1]));
        coord = this.getCoordLibre();
        fruits.add(Fruit.randomFruit(coord[0],coord[1]));
        coord = this.getCoordLibre();
        fruits.add(Fruit.randomFruit(coord[0],coord[1]));
        coord = this.getCoordLibre();
        fruits.add(Fruit.randomFruit(coord[0],coord[1]));
        coord = this.getCoordLibre();
        fruits.add(Fruit.randomFruit(coord[0],coord[1]));
        coord = this.getCoordLibre();
        fruits.add(Fruit.randomFruit(coord[0],coord[1]));
        coord = this.getCoordLibre();
        fruits.add(Fruit.randomFruit(coord[0], coord[1]));
        afficherGrille();

    }

    public void afficherGrille(){
        Case[][] grid = grille.getGrid();
        for (int i=0; i<taille; i++){
            for (int j=0; j<taille; j++){
                boolean found=false;
                for (Serpent s : serpents){
                    //Parcourir les coordonnées du corps du serpent
                    for(Integer[] c : s.getCoords()){
                        if (j == c[0] && i == c[1]){
                            System.out.print('$');
                            found=true;
                        }
                    }
                }
                for (Fruit f : fruits){
                    if (f.getX() == j && f.getY() == i && !found){
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
        for (int i=0; i<taille; i++){
            for (int j=0; j<taille; j++){
                boolean found = false;
                for (Serpent s : serpents){
                    for(Integer[] c : s.getCoords()){
                        if (j == c[0] && i == c[1]){
                            grid[i][j] = s.getPartie(j,i);
                            found = false;
                        }
                    }
                }
                if (!found) {
                    for (Fruit f : fruits) {
                        if (f.getX() == j && f.getY() == i) {
                            grid[i][j] = f;
                        }
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
        }while(!grille.getGrid()[coord[0]][coord[1]].isPassable()||isSerpent(coord[0], coord[1]));
        return coord;
    }

    public boolean isSerpent(int x, int y){
        for (Serpent s : serpents)
            for (Integer[] c : s.getCoords()){
                if (x == c[0] && y == c[1])
                    return true;
            }
        return false;
    }

    public boolean isOver(){
        return false;
    }

    public static void main(String[] argv){
        JeuModele jeuModele = new JeuModele(15);
        jeuModele.afficherGrille();
    }
}
