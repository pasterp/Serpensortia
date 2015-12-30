import javax.swing.*;
import java.awt.*;

/**
 * Created by mahatehotia on 30/11/15.
 */
public class QueueSerpent extends CaseOrientée {
    public QueueSerpent(int x, int y, int dir){
        super(x,y,dir);
    }

    public QueueSerpent(int x, int y) {
        this(x, y, 0);
    }
}
