import javax.swing.*;
import java.awt.*;

/**
 * Created by pphelipo on 30/11/15.
 */
public class JeuVue extends JPanel{
    JeuModele modele;

    public JeuVue(){
        super();
        modele = new JeuModele(15);
        setPreferredSize(new Dimension(modele.getTaille()*32, modele.getTaille()*32));
    }


    public void paintComponent(Graphics g) {
        Case[][] grid = modele.getGrille();
        for (int i=0; i < grid.length; i++){
            for (int j=0; j < grid.length; j++){
                g.drawImage(grid[i][j].getImage(), j * 32, i * 32, null);
                g.drawRect(i * 32, j * 32, 32, 32);
            }
        }
//        g.drawImage(new ImageIcon("./img/snake_head_up.png").getImage().getScaledInstance(32,32,Image.SCALE_FAST), 1, 1, null);
    }


    public static void main(String[] argv){
        JeuVue jeuVue = new JeuVue();
        JFrame window = new JFrame("DEBUG!");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(jeuVue);
        window.setContentPane(jeuVue);
        window.pack();
        window.setVisible(true);
        window.repaint();
    }
}
