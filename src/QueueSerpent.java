import javax.swing.*;
import java.awt.*;

/**
 * Created by mahatehotia on 30/11/15.
 */
public class QueueSerpent extends CaseOrientée {
    public QueueSerpent(int x, int y, int dir){
        super(x,y,dir);
        setHaut(new ImageIcon("./img/snake_queue_up.png"));
        setDroite(new ImageIcon("./img/snake_queue_right.png"));
        setBas(new ImageIcon("./img/snake_queue_down.png"));
        setGauche(new ImageIcon("./img/snake_queue_left.png"));
    }

    public QueueSerpent(int x, int y) {
        this(x, y, 0);
    }
}
