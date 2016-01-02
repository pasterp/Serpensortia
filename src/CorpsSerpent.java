import javax.swing.*;
import java.awt.*;

/**
 * Created by mahatehotia on 30/11/15.
 */
public class CorpsSerpent extends CaseOrientée {
    public CorpsSerpent(int x, int y, int dir){
        super(x, y, dir);
        setBas(new ImageIcon("./img/corps.png"));
        setDroite(new ImageIcon("./img/corps.png"));
        setGauche(new ImageIcon("./img/corps.png"));
        setHaut(new ImageIcon("./img/corps.png"));
    }

    public CorpsSerpent(int x, int y){
        this(x, y, 0);
    }

    public CorpsSerpent(CorpsSerpent corpsSerpent) {
        this(corpsSerpent.getX(), corpsSerpent.getY(), corpsSerpent.direction);
    }
}
