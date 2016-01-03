import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by pphelipo on 30/11/15.
 */
public class JeuControlleur implements KeyListener {
    JeuModele jeuModele;
    JeuVue jeuVue;

    public JeuControlleur(JeuModele jm){
        jeuModele = jm;
        jeuVue = new JeuVue(jm);
        System.out.println("Initialisation Controlleur...");
    }

    public JeuVue getVue(){
        return jeuVue;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_UP:
                jeuModele.tournerSerpent(0, 3);
                break;
            case KeyEvent.VK_LEFT:
                jeuModele.tournerSerpent(0, 2);
                break;
            case KeyEvent.VK_DOWN:
                jeuModele.tournerSerpent(0, 1);
                break;
            case KeyEvent.VK_RIGHT:
                jeuModele.tournerSerpent(0, 0);
                break;
            case KeyEvent.VK_R:
                System.out.println("Prochain mouvement forcé");
                jeuModele.prochainMouvement();
                jeuVue.repaint();
                break;
        }
        jeuModele.prochainMouvement();
        jeuVue.repaint();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
