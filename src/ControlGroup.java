/**
 * Created by pphelipo on 04/12/15.
 */
public class ControlGroup {
    Model model;
    Fenetre fenetre;

    public ControlGroup(Model m){
        model = m;
        fenetre = new Fenetre(model);
        ControlButton cb = new ControlButton(model, fenetre);

        fenetre.setVisible(true);

    }
}
