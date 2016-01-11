/**
 * Created by mahatehotia on 07/01/16.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class FenetreMenu extends JFrame {
    Image imageFond = Toolkit.getDefaultToolkit().getImage("./img/porte.jpg");;
    Image imageFondOpt = Toolkit.getDefaultToolkit().getImage("./img/parchemin.png");;
    Image imageTabScore = Toolkit.getDefaultToolkit().getImage("./img/tableauScore.png");;
    JMenuBar menuBar;
    JMenu mOption;
    JMenuItem iNew, iScores, iQuitter;
    JLabel jouer, score, option,credit,background,retour,jBas,jHaut,jGauche,jDroite,jPause,serpent1,serpent2,tableauScore;
    JPanel pRetour, menuJeu;
    MenuModele modelMenu;
    FondEcran fondEcran;
    JeuModele jeuModele;
    JeuControlleur jc;
    OptionMenu optionMenu;



    public FenetreMenu(MenuModele modelMenu, OptionMenu om){
        super();
        optionMenu=om;
        this.modelMenu=modelMenu;
        setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        initAttribut();
        initMenuBar();
        creerFenetre();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void initAttribut()
    {
        jouer= new JLabel(new ImageIcon("./img/jouer.png"));
        jouer.setBorder(null);
        jouer.setOpaque(false);

        score=new JLabel(new ImageIcon("./img/score.png"));
        score.setBorder(null);
        score.setOpaque(false);

        option=new JLabel(new ImageIcon("./img/option.png"));
        option.setBorder(null);
        option.setOpaque(false);

        credit=new JLabel(new ImageIcon("./img/credit.png"));
        credit.setBorder(null);
        credit.setOpaque(false);

        retour=new JLabel(new ImageIcon("./img/retour.png"));
        retour.setBorder(null);
        retour.setOpaque(false);

        serpent1=new JLabel(new ImageIcon("./img/serpentRouge.png"));
        serpent1.setBorder(null);
        serpent1.setSize(50,50);
        serpent1.setOpaque(false);

        serpent2=new JLabel(new ImageIcon("./img/serpentVert.png"));
        serpent2.setBorder(null);
        serpent2.setSize(50,50);
        serpent2.setOpaque(false);

        ImageIcon tabScore = new ImageIcon(new ImageIcon("./img/parchemin.png").getImage().getScaledInstance(300, 200,Image.SCALE_DEFAULT));
        tableauScore=new JLabel(tabScore);
        tableauScore.setBorder(null);
        tableauScore.setOpaque(false);

        jeuModele = new JeuModele(20);
        jc = new JeuControlleur(jeuModele, modelMenu);
        this.addKeyListener(jc);
    }
    public void creerFenetre()
    {
        fondEcran = new FondEcran();
        JPanel pJouer = new JPanel();
        pJouer.add(jouer);
        pJouer.setOpaque(false);

        JPanel pScore = new JPanel();
        pScore.add(score);
        pScore.setOpaque(false);

        JPanel pOption = new JPanel();
        pOption.add(option);
        pOption.setOpaque(false);

        JPanel pCredit = new JPanel();
        pCredit.add(credit);
        pCredit.setOpaque(false);

        JPanel pMenu =new JPanel(new BorderLayout());
        pMenu.add(pJouer);
        pMenu.add(pScore);
        pMenu.add(pOption);
        pMenu.add(pCredit);
        pMenu.setLayout(new BoxLayout(pMenu,BoxLayout.Y_AXIS));
        pMenu.setOpaque(false);
        fondEcran.add(pMenu,BorderLayout.CENTER);
        setJMenuBar(null);
        setContentPane(fondEcran);

    }
    public void initMenuBar()
    {
        menuBar = new JMenuBar();
        mOption = new JMenu("Options");

        iNew = new JMenuItem("Nouvelle Partie");
        iScores = new JMenuItem("Scores");

        iQuitter = new JMenuItem("Quitter");

        mOption.add(iNew);
        mOption.add(iScores);
        mOption.addSeparator();
        mOption.add(iQuitter);
        menuBar.add(mOption);

    }

    public void creerMenuBar(){
        setJMenuBar(menuBar);
    }

    public void choixJeu(){
        fondEcran = new FondEcran();
        fondEcran.setLayout(new BorderLayout());
        creerMenuBar();
        fondEcran.add(jc.getVue());
        jeuModele.reinit();
        jc.reset();
        menuJeu = new JPanel();

        menuJeu.setLayout(new BoxLayout(menuJeu,BoxLayout.Y_AXIS));
        menuJeu.add(tableauScore,BorderLayout.WEST);

        retourPage();
        menuJeu.setOpaque(false);
        menuJeu.add(pRetour);
        fondEcran.add(menuJeu,BorderLayout.WEST);
        setContentPane(fondEcran);



    }

    public void choixCredit(){
        fondEcran = new FondEcran();
        fondEcran.setLayout(new BorderLayout());
        setJMenuBar(null);
        retourPage();
        fondEcran.add(pRetour,BorderLayout.SOUTH);
        setContentPane(fondEcran);
    }

    public void choixScore() throws IOException {
        fondEcran = new FondEcran();
        fondEcran.setLayout(new BorderLayout());
        JPanel pScore = new JPanel();
        pScore.setSize(600,400);
        pScore.setBorder(BorderFactory.createLineBorder(Color.black));
        fondEcran.add(pScore);
        setJMenuBar(null);
        retourPage();
        fondEcran.add(pRetour,BorderLayout.SOUTH);
        setContentPane(fondEcran);
    }

    public void retourPage(){
        pRetour = new JPanel();
        pRetour.add(retour);
        pRetour.setOpaque(false);
    }

    public class FondEcran extends JPanel {

        public void paintComponent(Graphics g) {
            //paint background image
            super.paintComponent(g);
            g.drawImage(imageFond, 0, 0,getWidth(), getHeight(), this);

        }
    }

    public class FondEcranBouton extends JPanel {

        public void paintComponent(Graphics g) {
            //paint background image
            super.paintComponent(g);
            g.drawImage(imageFondOpt,0,0,getWidth(), getHeight(), this);

        }
    }
    public void choixOption(){
        fondEcran = new FondEcran();
        fondEcran.setLayout(new BorderLayout());

        JPanel pTout = new JPanel(new BorderLayout());


        pTout.add(serpent1, BorderLayout.WEST);

        retourPage();
        pTout.add(pRetour,BorderLayout.SOUTH);

        pTout.add(serpent2, BorderLayout.EAST);
        pTout.setOpaque(false);

        fondEcran.add(pTout);
        setContentPane(fondEcran);
    }

    public void setSerpent1(){
        fondEcran = new FondEcran();
        fondEcran.setLayout(new BorderLayout());

        optionMenu.menuModele.setJoueurActuel(1);
        optionMenu.SwitchUser();

        JPanel pTout = new JPanel(new BorderLayout());


        pTout.add(serpent1,BorderLayout.WEST);

        retourPage();
        pTout.add(pRetour,BorderLayout.SOUTH);

        pTout.add(optionMenu.fondControl);

        pTout.add(serpent2,BorderLayout.EAST);
        pTout.setOpaque(false);

        fondEcran.add(pTout);
        setContentPane(fondEcran);
    }

    public void setSerpent2(){
        fondEcran = new FondEcran();
        fondEcran.setLayout(new BorderLayout());

        JPanel pTout = new JPanel(new BorderLayout());

        pTout.add(serpent1,BorderLayout.WEST);

        retourPage();
        pTout.add(pRetour, BorderLayout.SOUTH);

        optionMenu.menuModele.setJoueurActuel(2);
        optionMenu.SwitchUser();
        pTout.add(optionMenu.fondControl);

        pTout.add(serpent2,BorderLayout.EAST);
        pTout.setOpaque(false);

        fondEcran.add(pTout);
        setContentPane(fondEcran);
    }


    public void setControlLabelMenu (MouseListener label) {
        jouer.addMouseListener(label);
        score.addMouseListener(label);
        option.addMouseListener(label);
        credit.addMouseListener(label);
        retour.addMouseListener(label);
        serpent1.addMouseListener(label);
        serpent2.addMouseListener(label);

    }

    public  void setControlMenu(ActionListener menu){
        iNew.addActionListener(menu);
        iScores.addActionListener(menu);
        iQuitter.addActionListener(menu);
    }

    public void choixMenu(int choix) throws IOException {
        if (choix==1) {
            nouvellePartie();
        } else if (choix==2){
            afficheScore();
        }else {
            quitter();
        }
    }

    public void quitter(){
        System.exit(0);
    }
    public void nouvellePartie(){
        choixJeu();
        setVisible(true);
    }

    public void afficheScore() {
        System.out.println("votre score!!");
    }
}
