import javax.swing.*;
import java.awt.*;

/**
 * Created by lorchie on 30/11/15.
 */
public class OptionMenu extends JFrame {
    //public JComboBox<Integer> listeTaille;

    public JButton up;
    public JButton down;
    public JButton left;
    public JButton right;
    public JButton pause;
    public JPanel ptout;
    JLabel jHaut,jBas,jGauche,jDroite,jPause;
    MenuModele menuModele;
    Image imgControl = Toolkit.getDefaultToolkit().getImage("./img/parchemin.png");;
    FondControl fondControl;
    Font font;

    public JButton retour;

    public OptionMenu(MenuModele m){
        this.menuModele=m;
        initAttributO();
        addWidgetO();
        creerWidgetO();
    }

    public void initAttributO() {
        font = new Font("ARIAL",Font.BOLD,20);

        jHaut = new JLabel("Haut :");
        jHaut.setFont(font);

        jBas = new JLabel("Bas :");
        jBas.setFont(font);

        jDroite = new JLabel("Droite :");
        jDroite.setFont(font);

        jGauche = new JLabel("Gauche :");
        jGauche.setFont(font);

        jPause = new JLabel("Pause : ");
        jPause.setFont(font);
    }

    public void addWidgetO() {
        //listeTaille= new JComboBox<Integer>(new Integer[]{25,75,100});
        up=new JButton("haut");
        down=new JButton("bas");
        left=new JButton("gauche");
        right=new JButton("droite");
        pause=new JButton("Pause");
        retour=new JButton("Retour");
    }

    public class FondControl extends JPanel {

        public void paintComponent(Graphics g) {
            //paint background image
            super.paintComponent(g);
            g.drawImage(imgControl, 0, 0,getWidth(), getHeight(), this);

        }
    }

    public void creerWidgetO(){
        fondControl = new FondControl();
        fondControl.setOpaque(false);

        /*JPanel p2=new JPanel();
        p2.add(new JLabel("Taille :"));
        p2.add(listeTaille);*/


        JPanel p3=new JPanel();
        p3.add(jHaut);

        p3.add(up);
        p3.setBorder(BorderFactory.createEmptyBorder(100, 100, 20,90));
        p3.setOpaque(false);


        JPanel p4=new JPanel();
        p4.add(jBas);
        p4.add(down);
        p4.setBorder(BorderFactory.createEmptyBorder(0, 100, 20,90));
        p4.setOpaque(false);

        JPanel p5=new JPanel();
        p5.add(jGauche);
        p5.add(left);
        p5.setBorder(BorderFactory.createEmptyBorder(0, 100, 20,90));
        p5.setOpaque(false);

        JPanel p6=new JPanel();
        p6.add(jDroite);
        p6.add(right);
        p6.setBorder(BorderFactory.createEmptyBorder(0, 100, 20,90));
        p6.setOpaque(false);

        JPanel p7=new JPanel();
        p7.add(jPause);
        p7.add(pause);
        p7.setBorder(BorderFactory.createEmptyBorder(0, 100, 20,90));
        p7.setOpaque(false);

        ptout=new JPanel();
        ptout.setLayout(new BoxLayout(ptout,BoxLayout.Y_AXIS));
        /*ptout.add(p2);*/
        ptout.add(p3);
        ptout.add(p4);
        ptout.add(p5);
        ptout.add(p6);
        ptout.add(p7);
        ptout.setOpaque(false);
        fondControl.add(ptout);
    }

    public void setActionListener(MenuControlleur al){
        System.out.println("Listener ajouté!");
        this.addKeyListener(al);
        up.addActionListener(al);
        down.addActionListener(al);
        left.addActionListener(al);
        right.addActionListener(al);
        pause.addActionListener(al);
        retour.addActionListener(al);
    }

}







