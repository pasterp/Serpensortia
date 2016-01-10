import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by mahatehotia on 07/01/16.
 */
    public class ControlMenu implements ActionListener {
        FenetreMenu fenetreMenu;

    public ControlMenu(FenetreMenu fenetreMenu){
        this.fenetreMenu=fenetreMenu;
        fenetreMenu.setControlMenu(this);

    }
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == fenetreMenu.iNew){
                try {
                    fenetreMenu.choixMenu(1);
                } catch (IOException e1){
                    e1.printStackTrace();
                }
            } else {
                try {
                    fenetreMenu.choixMenu(2);
                } catch (IOException e1){
                    e1.printStackTrace();
                }
            }
        }
    }


