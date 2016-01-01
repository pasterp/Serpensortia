import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by pphelipo on 30/11/15.
 */
public class Fruit extends Case{
    public Fruit(int _x, int _y, int typeFruit, String nomFichier){
        super(_x, _y);
        this.passable=true;
        this.score=typeFruit;
        texture =  new ImageIcon(nomFichier).getImage();
    }

    public static Fruit randomFruit(int _x, int _y){
        ArrayList<String> noms = new ArrayList<String>(Arrays.asList("pomme", "poire", "cerise", "banane"));
        ArrayList<Integer> scores = new ArrayList<Integer>(Arrays.asList(25, 35, 50, 75));
        int i = new Random().nextInt(4);

        return new Fruit(_x, _y, scores.get(i), "./img/"+noms.get(i)+".png");
    }


}
