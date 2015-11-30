import javax.swing.*;
import java.awt.*;

/**
 * Created by pphelipo on 30/11/15.
 */
public class Fruit extends Case{
    public Fruit(int typeFruit){
        super();
        this.passable=true;
        this.score+=typeFruit;
    }
}
