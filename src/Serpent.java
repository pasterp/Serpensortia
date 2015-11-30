import java.util.ArrayList;

/**
 * Created by pphelipo on 30/11/15.
 */
public class Serpent {
    ArrayList<Mur> unSerpent;
    public int dirX,dirY;


    public Serpent(){
        super();
        unSerpent = new ArrayList();
        dirX=1;
        dirY=0;
        Mur tete= new TeteSerpent(dirX,dirY);
        unSerpent.add(0,tete);

        for (int corps=1; corps<3;corps++){
            Mur corpsSerpent=new CorpsSerpent(dirX,dirY);
            unSerpent.add(corps, corpsSerpent);
        }
        Mur queueSerpent = new QueueSerpent(dirX,dirY);
        unSerpent.add(unSerpent.size(),queueSerpent);
    }
}
