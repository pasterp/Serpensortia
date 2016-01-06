import javax.swing.*;

/**
 * Created by pphelipo on 30/11/15.
 */
public class Application {
    public static void main(String[] argv){
        JeuModele jeuModele = new JeuModele(25);
        JeuControlleur jc = new JeuControlleur(jeuModele);
        JFrame frame = new JFrame("Jeu -- v0.3 beta");
        frame.add(jc.getVue());
        frame.pack();
        frame.addKeyListener(jc);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
