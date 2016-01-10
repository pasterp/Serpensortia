import java.awt.event.*;

/**
 * Created by pphelipo on 30/11/15.
 */
public class MenuControlleur implements KeyListener, MouseListener {

    MenuModele modele;
    OptionMenu optionMenu;
    int keyAEcouter;

    public MenuControlleur(MenuModele mm, OptionMenu oVue){
        modele = mm;
        optionMenu = oVue;
        optionMenu.setActionListener(this);
        keyAEcouter = -1;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("key pressed //"+keyAEcouter);
        if (keyAEcouter != -1){
            System.out.println("On demande à set la touche "+keyAEcouter+" du joueur "+modele.getJoueurActuel());
            modele.setControles(keyAEcouter, e.getKeyCode());
            System.out.println(""+e.getKeyCode()+" "+KeyEvent.getKeyText(e.getKeyCode()));
            keyAEcouter = -1;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == optionMenu.up){
            System.out.println("Appuyez sur la touche pour HAUT");
            optionMenu.up.setText("<>");
            keyAEcouter = 0;

        }else if (mouseEvent.getSource() == optionMenu.down){
            System.out.println("Appuyez sur la touche pour BAS");

        }else if (mouseEvent.getSource() == optionMenu.left){
            System.out.println("Appuyez sur la touche pour GAUCHE");

        }else if (mouseEvent.getSource() == optionMenu.right){
            System.out.println("Appuyez sur la touche pour DROITE");

        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}