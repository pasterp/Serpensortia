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
    MenuModele config;

    public JeuControlleur(JeuModele jm, MenuModele mm){
        pause = true;
        config = mm;
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

    public void reset(){
        pause = false;
        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!pause && jeuModele.isOver()){
                    jeuVue.repaint();
                    if (jeuModele.prochainMouvement()){
                        timer.setDelay((int)(timer.getDelay()*0.95));
                    }
                }else{
                    timer.stop();
                }
            }
        });
        timer.start();
    }

    public JeuVue getVue(){
        return jeuVue;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int i = keyEvent.getKeyCode();
        if (i == config.getJ1keyUp()) {
            jeuModele.tournerSerpent(0, 3);

        } else if (i == config.getJ1keyLeft()) {
            jeuModele.tournerSerpent(0, 2);

        } else if (i == config.getJ1keyDown()) {
            jeuModele.tournerSerpent(0, 1);

        } else if (i == config.getJ1keyRight()) {
            jeuModele.tournerSerpent(0, 0);

        } else if (i == config.getJ2keyUp()) {
            jeuModele.tournerSerpent(1, 3);

        } else if (i == config.getJ2keyLeft()) {
            jeuModele.tournerSerpent(1, 2);

        } else if (i == config.getJ2keyDown()) {
            jeuModele.tournerSerpent(1, 1);

        } else if (i == config.getJ2keyRight()) {
            jeuModele.tournerSerpent(1, 0);

        } else if (i == KeyEvent.VK_P) {
            pause = !pause;
            timer.start();

        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
