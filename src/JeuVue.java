import javax.swing.*;
import java.awt.*;

/**
 * Created by pphelipo on 30/11/15.
 */
public class JeuVue extends JPanel{
    JeuModele modele;

    public JeuVue(){
        super();
        modele = new JeuModele();
    }

    public void paintComponent(Graphics g) {
        Case[][] grid = modele.getGrille();
        for (int i=0; i < modele.getTaille(); i++){
            for (int j=0; i < modele.getTaille(); j++){
                g.drawImage(grid[i][j].getImage(), j*16, i*16, null);
            }
        }
    }


    public static void main(String[] argv){
        JeuVue jeuVue = new JeuVue();
        JFrame window = new JFrame("DEBUG!");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(jeuVue);
        window.setContentPane(jeuVue);
    }
}
