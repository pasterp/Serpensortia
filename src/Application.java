import javax.swing.*;

/**
 * Created by pphelipo on 30/11/15.
 */

public class Application extends JPanel {

 public static void main(String[] args) {
     MenuModele modelMenu = new MenuModele();
     MenuModele menuModele = new MenuModele();
     FenetreMenu f=new FenetreMenu(modelMenu);
     OptionMenu optionMenu = new OptionMenu(menuModele);
     ControlLabelMenu controlLabelMenu = new ControlLabelMenu(f, modelMenu,optionMenu);
     f.setControlLabelMenu(controlLabelMenu);
     MenuControlleur menuControlleur = new MenuControlleur(optionMenu);
     optionMenu.setActionListener(menuControlleur);
 }
}

