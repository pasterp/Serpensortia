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
    protected int x,y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Case(){
        this(0,0);
    }

    public Case(int x, int y){
        passable = true;
        score = 2;
        texture =  new ImageIcon("./img/case.png").getImage();
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

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
