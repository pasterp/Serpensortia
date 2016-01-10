import java.util.ArrayList;
import java.util.Random;

/**
 * Created by pphelipo on 30/11/15.
 */
public class JeuModele {
    private final static int NB_FRUITS = 6;

    private int taille;
    private Grille grille;
    private ArrayList<Serpent> serpents;
    private ArrayList<Fruit> fruits;

    public JeuModele(int t){
        System.out.println("Initialisation Modèle...");
        taille = t;
        grille = new Grille(taille);

        serpents = new ArrayList<Serpent>(2);
        serpents.add(new SerpentAI(5, 5, 0, taille,0));
        serpents.add(new SerpentAI(taille - 5, taille - 5, 2, taille, 1));

        fruits = new ArrayList<Fruit>();
        while(genererFruit()){
        }
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

        for (Fruit f : fruits){
            grid[f.getY()][f.getX()] = f;
        }

        for (Serpent s : serpents){
            for (Integer[] c : s.getCoords()){
                grid[c[1]%taille][c[0]%taille] = s.getPartie(c[0], c[1]);
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

    public void checkFruit(){
        for (int i=0; i<fruits.size(); i++){
            Fruit f = fruits.get(i);
            for (Serpent s : serpents){
                if (s.isAlive()){
                    int[] c = s.getHeadCoord();
                    if (c[0] == f.getX() && c[1] == f.getY()){
                        //Miam
                        s.feedMe(f.getScore());
                        if (s instanceof SerpentAI)
                            ((SerpentAI)s).getTarget(fruits, this);
                        fruits.remove(f);
                        break;
                    }
                }
            }
        }
    }

    public boolean isOver(){
        boolean over = false;
        for (Serpent s: serpents){
            if (s.isAlive())
                over = true;
        }

        if (over)
            for (Serpent s: serpents)
                System.out.println("Score : " + s.score);

        return over;
    }

    public void tournerSerpent(int serpent, int direction){
        Serpent s = serpents.get(serpent);
        if (s.isAlive()){
            switch (s.getDirection()){
                case 0:
                    switch (direction){
                        case 1:
                        case 3:
                        case 0:
                            s.changerDirection(direction);
                    }
                    break;
                case 1:
                    switch (direction){
                        case 1:
                        case 2:
                        case 0:
                            s.changerDirection(direction);
                    }
                    break;
                case 2:
                    switch (direction){
                        case 1:
                        case 2:
                        case 3:
                            s.changerDirection(direction);
                    }
                    break;
                case 3:
                    switch (direction){
                        case 3:
                        case 2:
                        case 0:
                            s.changerDirection(direction);
                    }
                    break;
            }
        }
    }

    public boolean prochainMouvement(){
        System.out.println("Nouveau tour");
        for (Serpent s: serpents){
            if (s.isAlive()) {
                if (s instanceof SerpentAI){
                    ((SerpentAI) s).autoSetDirection(this);
                }
                Case[][] g = grille.getGrid();
                int[] coord = s.getHeadCoord();
                boolean deplacementPossible = false;
                switch (s.getDirection()) {
                    case 0:
                        deplacementPossible = g[coord[0] + 1][coord[1]].isPassable() && !isSerpent(coord[0] + 1, coord[1]);
                        break;
                    case 1:
                        deplacementPossible = g[coord[0]][coord[1] + 1].isPassable() && !isSerpent(coord[0], coord[1] + 1);
                        break;
                    case 2:
                        deplacementPossible = g[coord[0] - 1][coord[1]].isPassable() && !isSerpent(coord[0] - 1, coord[1]);
                        break;
                    case 3:
                        deplacementPossible = g[coord[0]][coord[1] - 1].isPassable() && !isSerpent(coord[0], coord[1] - 1);
                        break;
                }
                if (deplacementPossible) {
                    s.avancer();
                } else {
                    s.die();
                }
            }
        }
        checkFruit(); //On mange les fruits
        return genererFruit();
    }

    public boolean genererFruit(){
        if(fruits.size()<NB_FRUITS){
            int[] coord = this.getCoordLibre();
            if(coord[0]!=0 && coord[1]!=taille-1 && coord[0]!=taille-1 && coord[1]!=0) {
                fruits.add(Fruit.randomFruit(coord[0], coord[1]));
                return true;
            }
        }
        return false;
    }

    public void reinit(){
        this.serpents.removeAll(serpents);
        this.serpents.add(new SerpentAI(5, 5, 0, taille, 0));
        this.serpents.add(new SerpentAI(taille - 5, taille - 5, 2, taille, 1));
        this.fruits.removeAll(fruits);
        while(genererFruit()){
        }
        afficherGrille();
    }

    public int getScore(int i){
        return serpents.get(i).score;
    }

    public ArrayList<Fruit> getFruits(){
        return fruits;
    }

}
