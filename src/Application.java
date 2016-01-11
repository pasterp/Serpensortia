/**
 * Created by pphelipo on 30/11/15.
 */

public class Application{

 public static void main(String[] args) {
     MenuModele menuModele = new MenuModele();
     ModelScore modelScore = new ModelScore();
     OptionMenu optionMenu = new OptionMenu(menuModele);
     FenetreMenu f=new FenetreMenu(menuModele, optionMenu, modelScore);
     ControlLabelMenu controlLabelMenu = new ControlLabelMenu(f, menuModele,optionMenu);
     f.setControlLabelMenu(controlLabelMenu);
     MenuControlleur menuControlleur = new MenuControlleur(menuModele, optionMenu);
     f.addKeyListener(menuControlleur);
 }
}

