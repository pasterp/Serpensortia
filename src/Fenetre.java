import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by pphelipo on 04/12/15.
 */
public class Fenetre extends JPanel{
    Model model;
    JLabel photo;
    JButton play;
    JProgressBar progDiapo;

    public Fenetre(Model m){
        super();
        model = m;
        initWidgets();
        addWidgets();
    }

    private void initWidgets() {
        photo = new JLabel(new ImageIcon(model.getImage().getImage().getScaledInstance(600, 600, BufferedImage.SCALE_DEFAULT)));
        play = new JButton("play");

        progDiapo = new JProgressBar(0, model.getSize()-1);
        progDiapo.setValue(model.getIndex());
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

    public void paintComponent(Graphics g) {
        //paint background image
        super.paintComponent(g);
        g.drawImage(model.getImage().getImage(), 0, 0, 300, 300, this);
    }


    public void changePhotoDiapo(){
        //photo.setIcon(new ImageIcon(model.getImage().getImage().getScaledInstance(600, 600, BufferedImage.SCALE_FAST)));
        progDiapo.setValue(model.getIndex());
    }


    public void addButtonListener(ControlButton cb){
        play.addActionListener(cb);
    }
}
