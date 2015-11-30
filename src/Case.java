import java.awt.*;

/**
 * Created by pphelipo on 30/11/15.
 */
public class Case {
    private boolean passable;
    private int score;
    Image texture;

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
