import javax.swing.*;
import java.awt.event.KeyListener;

/**
 * Created by pphelipo on 30/11/15.
 */
public class MenuVue extends JFrame{
    JButton Jouer;
    JButton Score;
    JButton Option;
    JButton Credit;

    public MenuVue(){
        addWidget();
        initAttribut();
        creerWidget();
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initAttribut() {

    }

    private void addWidget() {
    }

    private void creerWidget() {
    }

    public void setKeyListener(KeyListener kl){
        this.addKeyListener(kl);
    }
}
