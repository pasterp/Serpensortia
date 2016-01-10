import javax.swing.*;

/**
 * Created by pphelipo on 30/11/15.
 */
/**

public class Application {

    public static void main(String[] argv) {
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
     */
public class Application extends JPanel {

 public static void main(String[] args) {
 ModelMenu modelMenu = new ModelMenu();
  MenuModele menuModele = new MenuModele();
 FenetreMenu f=new FenetreMenu(modelMenu);
 OptionMenu optionMenu = new OptionMenu(menuModele);
 ControlLabelMenu controlLabelMenu = new ControlLabelMenu(f, modelMenu,optionMenu);
 f.setControlLabelMenu(controlLabelMenu);
 }
 }

