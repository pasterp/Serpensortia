import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

/**
 * Created by mahatehotia on 06/01/16.
 */
public class ControlLabel implements MouseListener{
    Fenetre fenetre;
    Model model;
    JLabel jLabel1;
    public ControlLabel(Fenetre fenetre, Model model) {
        this.model = model;
        this.fenetre=fenetre;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource()== fenetre.jouer) {
            fenetre.choixJeu();
            fenetre.setVisible(true);
        }

        if (e.getSource()== fenetre.credit) {
            fenetre.choixCredit();
            fenetre.setVisible(true);
        }

        if (e.getSource()== fenetre.score) {
            try {
                fenetre.choixScore();
                fenetre.setVisible(true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getSource()== fenetre.option) {
            fenetre.choixOption();
            fenetre.setVisible(true);

        }
        if (e.getSource()==fenetre.retour){
            fenetre.creerFenetre();
            fenetre.setVisible(true);
        }

        if (e.getSource()==fenetre.serpent1){
            System.out.println("serpent1");
        }
        if (e.getSource()==fenetre.serpent2){
            System.out.println("serpent2");
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
