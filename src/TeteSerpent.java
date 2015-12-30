import javax.swing.*;
import java.awt.*;

/**
 * Created by mahatehotia on 30/11/15.
 */
public class TeteSerpent extends CaseOrientée {
    public TeteSerpent(int x, int y, int dir){
        super(x, y, dir);
        setBas(new ImageIcon("./img/snake_head_down.png"));
        setHaut(new ImageIcon("./img/snake_head_up.png"));
        setGauche(new ImageIcon("./img/snake_head_left.png"));
        setDroite(new ImageIcon("./img/snake_head_right.png"));
    }
    public TeteSerpent(int x, int y){
        this(x, y, 0);
    }
}
