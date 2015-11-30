/**
 * Created by pphelipo on 30/11/15.
 */
public class Grille {
    private Case[][] grid;

    public Grille(int t){
        this.grid = new Case[t][t];
        for(int i=0; i<t; i++){
            for(int j=0; j<t; j++) {
                if(j==0 || i==0 || i==t-1 || j==t-1){
                    grid[i][j] = new Mur();
                }
                else {
                    grid[i][j]=new Case();
                }
            }
        }
    }

    public Case[][] getGrid(){
        return grid;
    }

}
