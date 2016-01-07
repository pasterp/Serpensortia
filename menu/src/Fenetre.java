import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Fenetre extends JFrame {
    Image imageFond = Toolkit.getDefaultToolkit().getImage("/home/mahatehotia/Documents/menu/porte.jpg");;
    Image imageFondOpt = Toolkit.getDefaultToolkit().getImage("/home/mahatehotia/Documents/menu/parchemin.png");;
    JMenuBar menuBar;
    JMenu mOption;
    JMenuItem iNew, iScores;
    JLabel jouer, score, option,credit,background,retour,jBas,jHaut,jGauche,jDroite,jPause,serpent1,serpent2;
    JPanel pRetour;
    Model model;
    FondEcran fondEcran;
    FondEcranBouton fondEcranBouton;
    JButton bHaut,bBas,bGauche,bDroite,bPause;

    public Fenetre(Model model){
        super();
        this.model=model;
        setSize(800,500);
        initAttribut();
        creerFenetre();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void initAttribut()
    {
        jouer= new JLabel(new ImageIcon("/home/mahatehotia/Documents/menu/jouer.png"));
        jouer.setBorder(null);
        jouer.setOpaque(false);

        score=new JLabel(new ImageIcon("/home/mahatehotia/Documents/menu/score.png"));
        score.setBorder(null);
        score.setOpaque(false);

        option=new JLabel(new ImageIcon("/home/mahatehotia/Documents/menu/option.png"));
        option.setBorder(null);
        option.setOpaque(false);

        credit=new JLabel(new ImageIcon("/home/mahatehotia/Documents/menu/credit.png"));
        credit.setBorder(null);
        credit.setOpaque(false);

        retour=new JLabel(new ImageIcon("/home/mahatehotia/Documents/menu/retour.png"));
        retour.setBorder(null);
        retour.setOpaque(false);

        serpent1=new JLabel(new ImageIcon("/home/mahatehotia/Documents/menu/serpentRouge.png"));
        serpent1.setBorder(null);
        serpent1.setOpaque(false);

        serpent2=new JLabel(new ImageIcon("/home/mahatehotia/Documents/menu/serpentVert.png"));
        serpent2.setBorder(null);
        serpent2.setOpaque(false);

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
    public void creerMenuBar()
    {
        menuBar = new JMenuBar();
        mOption = new JMenu("Options");

        iNew = new JMenuItem("Nouvelle Partie");

        mOption.add(iNew);
        iScores = new JMenuItem("Scores");
        mOption.add(iScores);

        menuBar.add(mOption);
        setJMenuBar(menuBar);

    }

    public void choixJeu(){
        fondEcran = new FondEcran();
        fondEcran.setLayout(new BorderLayout());
        creerMenuBar();
        retourPage();
        fondEcran.add(pRetour,BorderLayout.WEST);

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
        model.fichier();
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


        pTout.add(serpent1,BorderLayout.WEST);

        retourPage();
        pTout.add(pRetour,BorderLayout.SOUTH);

        pTout.add(serpent2,BorderLayout.EAST);
        pTout.setOpaque(false);

        fondEcran.add(pTout);
        setContentPane(fondEcran);
    }

    public void initControlBouton(){
        choixOption();
        fondEcranBouton = new FondEcranBouton();
        fondEcranBouton.setLayout(new BorderLayout());
        fondEcranBouton.setOpaque(false);
        initFenetreOpt();
        JPanel pOpt = new JPanel();
        pOpt.setLayout(new BoxLayout(pOpt,BoxLayout.Y_AXIS));

        pOpt.add(jBas);
        pOpt.add(bBas);

        pOpt.add(jHaut);
        pOpt.add(bHaut);

        pOpt.add(jGauche);
        pOpt.add(bGauche);

        pOpt.add(jDroite);
        pOpt.add(bDroite);

        pOpt.add(jPause);
        pOpt.add(bPause);

        pOpt.setOpaque(false);

        fondEcranBouton.add(pOpt,BorderLayout.CENTER);
    }

    public void setControlLabel(MouseListener label) {
        jouer.addMouseListener(label);
        score.addMouseListener(label);
        option.addMouseListener(label);
        credit.addMouseListener(label);
        retour.addMouseListener(label);
        serpent1.addMouseListener(label);
        serpent2.addMouseListener(label);

    }

    public void initFenetreOpt(){
        jBas= new JLabel("Bas");
        bBas = new JButton();

        jHaut= new JLabel("Haut");
        bHaut = new JButton();

        jGauche= new JLabel("Gauche");
        bGauche = new JButton();

        jDroite= new JLabel("Droite");
        bDroite = new JButton();

        jPause = new JLabel("Pause");
        bPause = new JButton();

    }
}