import javax.swing.*;
import java.awt.*;

/**
 * Created by pphelipo on 30/11/15.
 */
public class Mur extends Case{
    public Mur(){
        super();
        this.passable = false;
        texture =  new ImageIcon("mur.png").getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
    }
}
