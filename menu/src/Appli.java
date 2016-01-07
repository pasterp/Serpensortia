import java.awt.*;

import javax.swing.*;

public class Appli extends JPanel {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        Model model = new Model();
        Fenetre f=new Fenetre(model);
        ControlLabel controlLabel = new ControlLabel(f, model);
        f.setControlLabel(controlLabel);
    }


}