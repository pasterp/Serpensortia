import javax.swing.*;
import java.awt.*;

/**
 * Created by pphelipo on 30/11/15.
 */
public class JeuVue extends JPanel{
    JeuModele modele;
    JLabel j1, j2;

    public JeuVue(JeuModele jm){
        super();
        modele = jm;

        System.out.println("Initialisation Vue...");

        setPreferredSize(new Dimension(modele.getTaille()*32, modele.getTaille()*32));
    }


    public void paintComponent(Graphics g) {
        Case[][] grid = modele.getGrille();
        for (int i=0; i < grid.length; i++){
            for (int j=0; j < grid.length; j++){
                g.drawImage(grid[i][j].getImage(), j * 32, i * 32, null);
            }
        }
    }
}
