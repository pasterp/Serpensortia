import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by pphelipo on 30/11/15.
 */
public class MenuControlleur implements KeyListener, ActionListener{

    MenuModele modele;
    OptionMenu optionMenu;

    public MenuControlleur(OptionMenu oVue){
        modele = new MenuModele();
        optionMenu = oVue;
        optionMenu.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("rigenroireng");
        if (e.getSource() == optionMenu.up){
            System.out.println("Appuyez sur la touche pour HAUT");

        }else if (e.getSource() == optionMenu.down){
            System.out.println("Appuyez sur la touche pour BAS");

        }else if (e.getSource() == optionMenu.left){
            System.out.println("Appuyez sur la touche pour GAUCHE");

        }else if (e.getSource() == optionMenu.right){
            System.out.println("Appuyez sur la touche pour DROITE");

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}