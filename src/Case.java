import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by pphelipo on 30/11/15.
 */
public class Case {
    protected boolean passable;
    protected int score;
    protected Image texture;
    int x,y;

    public Case(){
        passable = true;
        score = 2;
        texture =  new ImageIcon("case.png").getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        x=0;
        y=0;
    }

    public Case(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getScore(){
        return score;
    }

    public boolean isPassable(){
        return passable;
    }

    public Image getImage(){
        return texture;
    }
}
