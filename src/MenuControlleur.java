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
    }

    public void setKeyUp() {
        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                modele.setKeyUp(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        };
        menuVue.setKeyListener(kl);
    }

    public void setKeyDown(){
        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                modele.setKeyDown(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        };
        menuVue.setKeyListener(kl);
    }

    public void setKeyRight(){
        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                modele.setKeyRight(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        };
        menuVue.setKeyListener(kl);
    }

    public void setKeyLeft(){
        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                modele.setKeyLeft(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        };
        menuVue.setKeyListener(kl);
    }

    public void setKeyPause(){
        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                modele.setKeyPause(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        };
        menuVue.setKeyListener(kl);
    }

    public void setGridSize(int size){
        modele.setGridSize(size);
    }
}
