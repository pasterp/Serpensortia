import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by pphelipo on 30/11/15.
 */
public class MenuControlleur{

    MenuModele modele;
    MenuVue menuVue;


    public MenuControlleur(MenuVue vue){
        modele = new MenuModele();
        menuVue = vue;
        menuVue.setKeyListener(this);
    }

    public void setKeys(){
        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
    }
}
