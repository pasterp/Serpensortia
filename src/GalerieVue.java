import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by pphelipo on 04/12/15.
 */
public class GalerieVue extends JPanel{
    ModelGalerie modelGalerie;
    JLabel photo;
    JButton play;
    JProgressBar progDiapo;

    public GalerieVue(ModelGalerie m){
        super();
        modelGalerie = m;
        initWidgets();
        addWidgets();
    }

    private void initWidgets() {
        photo = new JLabel(new ImageIcon(modelGalerie.getImage().getImage().getScaledInstance(500, 500, BufferedImage.SCALE_DEFAULT)));
        play = new JButton("play");

        progDiapo = new JProgressBar(0, modelGalerie.getSize()-1);
        progDiapo.setValue(modelGalerie.getIndex());
    }

    private void addWidgets() {

        JPanel miseEnpage = new JPanel();
        miseEnpage.setLayout(new BoxLayout(miseEnpage, BoxLayout.Y_AXIS));
        miseEnpage.add(new JPanel(new FlowLayout(FlowLayout.CENTER)).add(photo));
        JPanel centerBut = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel boutons = new JPanel();
        boutons.setLayout(new BoxLayout(boutons, BoxLayout.X_AXIS));
        boutons.add(play);
        centerBut.add(boutons);
        miseEnpage.add(centerBut);
        miseEnpage.add(progDiapo);
        add(miseEnpage);
    }


    public void changePhotoDiapo(){
        photo.setIcon(new ImageIcon(modelGalerie.getImage().getImage().getScaledInstance(500, 500, BufferedImage.SCALE_FAST)));
        progDiapo.setValue(modelGalerie.getIndex());
    }


    public void addButtonListener(ControlButtonGalerie cb){
        play.addActionListener(cb);
    }
}
