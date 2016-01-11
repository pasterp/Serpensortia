import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by lorchie on 30/11/15.
 */

public class OptionMenu extends JFrame {
    //public JComboBox<Integer> listeTaille;

    public JLabel up;
    public JLabel down;
    public JLabel left;
    public JLabel right;
    public JPanel ptout;
    JLabel user,jHaut,jBas,jGauche,jDroite,jPause;
    MenuModele menuModele;
    Image imgControl = Toolkit.getDefaultToolkit().getImage("./img/parchemin.png");;
    FondControl fondControl;
    Font font;

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

        Border border = BorderFactory.createEtchedBorder(Color.BLUE, Color.CYAN);

        up=new JLabel();
        up.setBorder(border);
        down=new JLabel();
        down.setBorder(border);
        left=new JLabel();
        left.setBorder(border);
        right=new JLabel();
        right.setBorder(border);
    }

    public void addWidgetO() {
        up.setText(KeyEvent.getKeyText(menuModele.getJ1keyUp()));
        down.setText(KeyEvent.getKeyText(menuModele.getJ1keyDown()));
        left.setText(KeyEvent.getKeyText(menuModele.getJ1keyLeft()));
        right.setText(KeyEvent.getKeyText(menuModele.getJ1keyRight()));
    }

    public void addWidget1() {
        up.setText(KeyEvent.getKeyText(menuModele.getJ2keyUp()));
        down.setText(KeyEvent.getKeyText(menuModele.getJ2keyDown()));
        left.setText(KeyEvent.getKeyText(menuModele.getJ2keyLeft()));
        right.setText(KeyEvent.getKeyText(menuModele.getJ2keyRight()));
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


        JPanel p2=new JPanel();
        user = new JLabel("Joueur n°" + menuModele.getJoueurActuel());
        user.setFont(font);
        p2.add(user);
        p2.setBorder(BorderFactory.createEmptyBorder(100, 100, 20, 90));
        p2.setOpaque(false);

        JPanel p3=new JPanel();
        p3.add(jHaut);

        p3.add(up);
        p3.setBorder(BorderFactory.createEmptyBorder(100, 100, 20, 90));
        p3.setOpaque(false);


        JPanel p4=new JPanel();
        p4.add(jBas);
        p4.add(down);
        p4.setBorder(BorderFactory.createEmptyBorder(0, 100, 20, 90));
        p4.setOpaque(false);

        JPanel p5=new JPanel();
        p5.add(jGauche);
        p5.add(left);
        p5.setBorder(BorderFactory.createEmptyBorder(0, 100, 20, 90));
        p5.setOpaque(false);

        JPanel p6=new JPanel();
        p6.add(jDroite);
        p6.add(right);
        p6.setBorder(BorderFactory.createEmptyBorder(0, 100, 20, 90));
        p6.setOpaque(false);

        ptout=new JPanel();
        ptout.setLayout(new BoxLayout(ptout, BoxLayout.Y_AXIS));
        ptout.add(p2);
        ptout.add(p3);
        ptout.add(p4);
        ptout.add(p5);
        ptout.add(p6);
        ptout.setOpaque(false);
        fondControl.add(ptout);
    }

    public void SwitchUser(){
        removeAll();
        if (menuModele.getJoueurActuel()==1){
            addWidgetO();
        }else{
            addWidget1();
        }
        creerWidgetO();
    }

    public void refresh(){
        if (menuModele.getJoueurActuel() == 1){
            addWidgetO();
        }else{
            addWidget1();
        }
    }

    public void setActionListener(MenuControlleur al){
        System.out.println("Listener ajouté!");
        this.addKeyListener(al);
        up.addMouseListener(al);
        down.addMouseListener(al);
        left.addMouseListener(al);
        right.addMouseListener(al);
    }

}







