import javax.swing.*;
import java.awt.event.*;

/**
 * Created by pphelipo on 04/12/15.
 */
public class ControlButtonGalerie implements ActionListener{
    ModelGalerie m;
    GalerieVue f;
    Boolean diapoOn;
    private Timer timer;

    public ControlButtonGalerie(ModelGalerie modelGalerie, GalerieVue galerieVue){
        m = modelGalerie;
        f = galerieVue;
        f.addButtonListener(this);
        diapoOn = false;
        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (diapoOn && m.getIndex()<m.getSize()){
                    m.setIndex(m.getIndex()+1);
                    f.changePhotoDiapo();
                }else{
                    timer.stop();
                }
            }
        });
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == f.play){
            if (diapoOn){
                diapoOn = false;
                f.play.setText("Diaporama");
                timer.stop();
            }else {
                diapoOn = true;
                f.play.setText("Pause");
                timer.start();
            }
        }
    }
}
