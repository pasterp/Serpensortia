import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 * Created by lorchie on 30/11/15.
 */
public class OptionMenu extends JFrame {
    public JComboBox<Integer> listeTaille;

    public JButton up;
    public JButton down;
    public JButton left;
    public JButton right;
    public JButton pause;

    public JButton retour;

    public OptionMenu(MenuModele m){
        initAttributO();
        addWidgetO();
        creerWidgetO();
        pack();
        setVisible(true);
    }

    private void initAttributO() {

    }

    private void addWidgetO() {
        listeTaille= new JComboBox<Integer>(new Integer[]{25,75,100});
        up=new JButton("haut");
        down=new JButton("bas");
        left=new JButton("gauche");
        right=new JButton("droite");
        pause=new JButton("Pause");
        retour=new JButton("Retour");
    }


    private void creerWidgetO(){

        JPanel p1=new JPanel();
        p1.add(new JLabel("OPTION "));

        JPanel p2=new JPanel();
        p2.add(new JLabel("Taille :"));
        p2.add(listeTaille);

        JPanel p3=new JPanel();
        p3.add(new JLabel("Haut :"));
        p3.add(up);

        JPanel p4=new JPanel();
        p4.add(new JLabel("Bas :"));
        p4.add(down);

        JPanel p5=new JPanel();
        p5.add(new JLabel("Gauche :"));
        p5.add(left);

        JPanel p6=new JPanel();
        p6.add(new JLabel("Droite :"));
        p6.add(right);

        JPanel p7=new JPanel();
        p7.add(new JLabel("Pause :"));
        p7.add(pause);

        JPanel p8=new JPanel();
        p8.add(retour);

        JPanel ptout=new JPanel();
        ptout.setLayout(new BoxLayout(ptout,BoxLayout.Y_AXIS));
        ptout.add(p1);
        ptout.add(p2);
        ptout.add(p3);
        ptout.add(p4);
        ptout.add(p5);
        ptout.add(p6);
        ptout.add(p7);
        ptout.add(p8);
        setContentPane(ptout);
    }

    public void setKeyListener(KeyListener kl){
        this.addKeyListener(kl);
    }


}







