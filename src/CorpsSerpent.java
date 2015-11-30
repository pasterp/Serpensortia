import javax.swing.*;
import java.awt.*;

/**
 * Created by mahatehotia on 30/11/15.
 */
public class CorpsSerpent extends Mur {
    private int dirX,dirY;
    public CorpsSerpent(int dirX,int dirY){
            super();
            this.dirX=dirX;
            this.dirY=dirY;
            if (getDirX()==1){
                texture= new ImageIcon("corpsdroite.png").getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
            }
            else if (getDirX()==-1) {
                texture = new ImageIcon("corpsgauche.png").getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
            }
            else if (getDirY()==1){
                texture= new ImageIcon("corpshaut.png").getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
            }
            else {
                texture= new ImageIcon("corpsbas.png").getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
            }
        }

        public int getDirX(){
            return this.dirX;
        }
        public int getDirY() {
            return this.dirY;
        }
}
