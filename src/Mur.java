import javax.swing.*;
import java.awt.*;

/**
 * Created by pphelipo on 30/11/15.
 */
public class Mur extends Case{
    public Mur(){
        super();
        this.passable = false;
        texture =  new ImageIcon("./img/mur.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT);
    }
}
