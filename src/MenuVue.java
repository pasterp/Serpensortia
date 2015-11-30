import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 * Created by pphelipo on 30/11/15.
 */
public class MenuVue extends JFrame{
    JButton Jouer;
    JButton Score;
    JButton Option;
    JButton Credit;

    public MenuVue(){
        addWidget();
        initAttribut();
        creerWidget();
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initAttribut() {

    }

    private void addWidget() {
        Jouer=new JButton("Jouer");
        Score=new JButton("Score");
        Option=new JButton("Option");
        Credit=new JButton("Credit");
    }

    private void creerWidget() {

        JPanel p1=new JPanel();
        p1.add(new JLabel("SerpenSorita"));

        JPanel p2=new JPanel();
        p2.add(Jouer);

        JPanel p3=new JPanel();
        p3.add(Score);

        JPanel p4=new JPanel();
        p4.add(Option);

        JPanel p5=new JPanel();
        p5.add(Credit);

        JPanel ptout=new JPanel();
        ptout.add(p1);
        ptout.add(p2);
        ptout.add(p3);
        ptout.add(p4);
        ptout.add(p5);
        setContentPane(ptout);
    }

    public void setKeyListener(KeyListener kl){
        this.addKeyListener(kl);
    }

    public void setActionListener(ActionListener al){
        Jouer.addActionListener(al);
        Score.addActionListener(al);
        Option.addActionListener(al);
        Credit.addActionListener(al);
    }
}
