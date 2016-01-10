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
        if (keyAEcouter != -1){
            modele.setControles(keyAEcouter, KeyEvent.getExtendedKeyCodeForChar(e.getKeyChar()));
            keyAEcouter = -1;
            optionMenu.refresh();
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
            optionMenu.up.setText("<Appuyer>");
            keyAEcouter = 0;

        }else if (mouseEvent.getSource() == optionMenu.down){
            optionMenu.down.setText("<Appuyer>");
            keyAEcouter = 1;

        }else if (mouseEvent.getSource() == optionMenu.left){
            optionMenu.left.setText("<Appuyer>");
            keyAEcouter = 2;
        }else if (mouseEvent.getSource() == optionMenu.right){
            optionMenu.right.setText("<Appuyer>");
            keyAEcouter = 3;
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