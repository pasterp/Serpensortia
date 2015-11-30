import javax.swing.*;
import java.awt.*;

/**
 * Created by mahatehotia on 30/11/15.
 */
public class TeteSerpent extends Mur {
    private int dirX,dirY;
    public TeteSerpent(int dirX,int dirY){
        super();
        this.dirX=dirX;
        this.dirY=dirY;
        if (getDirX()==1){
            texture= new ImageIcon("tetedroite.png").getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        }
        else if (getDirX()==-1) {
            texture = new ImageIcon("tetegauche.png").getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        }
        else if (getDirY()==1){
            texture= new ImageIcon("tetehaut.png").getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        }
        else {
            texture= new ImageIcon("tetebas.png").getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        }
    }

    public int getDirX(){
        return this.dirX;
    }
    public int getDirY(){
        return this.dirY;
    }
}
