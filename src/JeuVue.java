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
        j1 = new JLabel("Score J1 : "+jm.getScore(0));
        j1.setForeground(Color.WHITE);
        j2 = new JLabel("Score J2 : "+jm.getScore(1));
        j2.setForeground(Color.WHITE);

        setPreferredSize(new Dimension(modele.getTaille()*32, modele.getTaille()*32));
        add(j1);
        add(j2);
    }


    public void paintComponent(Graphics g) {
        j1.setText("Score J1 : " + modele.getScore(0));
        j2.setText("Score J2 : "+modele.getScore(1));
        Case[][] grid = modele.getGrille();
        for (int i=0; i < grid.length; i++){
            for (int j=0; j < grid.length; j++){
                g.drawImage(grid[i][j].getImage(), j * 32, i * 32, null);
            }
        }
    }
}
