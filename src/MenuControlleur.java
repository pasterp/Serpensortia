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
        optionMenu.setKeyListener(this);
        optionMenu.setActionListener(this);
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
    }

    public void setGridSize(int size){
        modele.setGridSize(size);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == optionMenu.up){
            System.out.println("Appuyez sur la touche pour HAUT");
            setKeyUp();
        }else if (e.getSource() == optionMenu.down){
            System.out.println("Appuyez sur la touche pour BAS");
            setKeyDown();
        }else if (e.getSource() == optionMenu.left){
            System.out.println("Appuyez sur la touche pour GAUCHE");
            setKeyLeft();
        }else if (e.getSource() == optionMenu.right){
            System.out.println("Appuyez sur la touche pour DROITE");
            setKeyRight();
        }/*else if (e.getSource() == optionMenu.listeTaille){
            setGridSize((Integer) optionMenu.listeTaille.getSelectedItem());
        }*/
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