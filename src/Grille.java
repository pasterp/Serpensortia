/**
 * Created by pphelipo on 30/11/15.
 */
public class Grille {
    private Case[][] grid;
    private int taille;

    public Grille(int t){ //TODO : Make me rectangle
        this.grid = new Case[t][t];
        taille = t;
        for(int i=0; i<t; i++){
            for(int j=0; j<t; j++) {
                if(j==0 || i==0 || i==t-1 || j==t-1){//TODO: Let me pass
                    if( i == taille/2 || j == taille/2){
                        grid[i][j] = new Case();
                    }
                    else {
                        grid[i][j] = new Mur();
                    }
                }
                else {
                    grid[i][j]=new Case();
                }
            }
        }
    }

    public Case[][] getGrid(){
        Case[][] grille =  new Case[taille][taille];
        for(int i=0; i<taille; i++){
            for(int j=0; j<taille; j++) {
                grille[i][j] = grid[i][j];
            }
        }
        return grille;
    }

}
