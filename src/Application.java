/**
 * Created by pphelipo on 30/11/15.
 */

public class Application{

 public static void main(String[] args) {
     MenuModele menuModele = new MenuModele();
     ModelScore modelScore = new ModelScore();

     OptionMenu optionMenu = new OptionMenu(menuModele);
     MenuControlleur menuControlleur = new MenuControlleur(menuModele, optionMenu);

     FenetreMenu f=new FenetreMenu(menuModele, optionMenu, modelScore);
     ControlMenu controlMenu=new ControlMenu(f);
     ControlLabelMenu controlLabelMenu = new ControlLabelMenu(f, menuModele,optionMenu);

     f.setControlLabelMenu(controlLabelMenu);
     f.addKeyListener(menuControlleur);
 }
}

