import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

/**
 * Created by mahatehotia on 06/01/16.
 */
public class ControlLabelMenu implements MouseListener{
    FenetreMenu fenetreMenu;
    MenuModele modelMenu;
    OptionMenu optionMenu;
    MenuModele menuModele;
    public ControlLabelMenu(FenetreMenu fenetreMenu, MenuModele modelMenu, OptionMenu optionMenu) {
        this.modelMenu = modelMenu;
        this.fenetreMenu=fenetreMenu;
        this.optionMenu=optionMenu;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource()== fenetreMenu.jouer) {
            fenetreMenu.choixIa();
            fenetreMenu.setVisible(true);
        }

        if (e.getSource()==fenetreMenu.avecIa){
            fenetreMenu.choixJeuIa();
            fenetreMenu.setVisible(true);
        }

        if (e.getSource()==fenetreMenu.sansIa){
            fenetreMenu.choixJeuSsIa();
            fenetreMenu.setVisible(true);
        }
        if (e.getSource()==fenetreMenu.multi){
            fenetreMenu.choixMulti();
            fenetreMenu.setVisible(true);
        }

        if (e.getSource()== fenetreMenu.credit) {
            fenetreMenu.choixCredit();
            fenetreMenu.setVisible(true);
        }

        if (e.getSource()== fenetreMenu.score) {
            try {
                fenetreMenu.choixScore();
                fenetreMenu.setVisible(true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getSource()== fenetreMenu.option) {
            fenetreMenu.choixOption();
            fenetreMenu.setVisible(true);

        }
        if (e.getSource()==fenetreMenu.retour){
            fenetreMenu.creerFenetre();
            fenetreMenu.jc.pause=true;
            fenetreMenu.setVisible(true);
        }

        if (e.getSource()==fenetreMenu.serpent1){
            fenetreMenu.setSerpent1();
            fenetreMenu.setVisible(true);

        }
        if (e.getSource()==fenetreMenu.serpent2){
            fenetreMenu.setSerpent2();
            fenetreMenu.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
