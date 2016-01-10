import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by pphelipo on 30/11/15.
 */
public class JeuControlleur implements KeyListener {
    JeuModele jeuModele;
    JeuVue jeuVue;
    boolean pause;
    private Timer timer;

    public JeuControlleur(JeuModele jm){
        pause = true;
        jeuModele = jm;
        jeuVue = new JeuVue(jm);
        System.out.println("Initialisation Controlleur...");

        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!pause){
                    jeuVue.repaint();
                    if (jeuModele.prochainMouvement()){
                        timer.setDelay((int)(timer.getDelay()*0.95));
                    }
                }else{
                    timer.stop();
                }
            }
        });
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
            case KeyEvent.VK_Z:
                jeuModele.tournerSerpent(1, 3);
                break;
            case KeyEvent.VK_Q:
                jeuModele.tournerSerpent(1, 2);
                break;
            case KeyEvent.VK_S:
                jeuModele.tournerSerpent(1, 1);
                break;
            case KeyEvent.VK_D:
                jeuModele.tournerSerpent(1, 0);
                break;
            case KeyEvent.VK_P:
                pause = !pause;
                timer.start();
                break;
            case KeyEvent.VK_R:
                System.out.println("Prochain mouvement forcé");
                jeuModele.prochainMouvement();
                jeuVue.repaint();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
