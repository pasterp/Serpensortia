import java.awt.*;

/**
 * Created by pphelipo on 30/11/15.
 */
public class Case {
    protected boolean passable;
    protected int score;
    protected Image texture;

    public Case(){

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
