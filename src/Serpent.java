import java.util.ArrayList;

/**
 * Created by pphelipo on 30/11/15.
 */
public class Serpent {
    ArrayList<Mur> unSerpent;

    public Serpent(int x, int y, int dir){
        unSerpent = new ArrayList();
        unSerpent.add(new TeteSerpent(x,y,dir));

        for (int i=1; i<3;i++){
            switch (dir){
                case 0:
                    unSerpent.add(new CorpsSerpent(x-i, y, dir));
                    break;
                case 1:
                    unSerpent.add(new CorpsSerpent(x, y-i, dir));
                    break;
                case 2:
                    unSerpent.add(new CorpsSerpent(x+i, y, dir));
                    break;
                case 3:
                    unSerpent.add(new CorpsSerpent(x, y+i, dir));
                    break;
            }

        }
        switch (dir){
            case 0:
                unSerpent.add(new QueueSerpent(x-3, y, dir));
                break;
            case 1:
                unSerpent.add(new QueueSerpent(x, y-3, dir));
                break;
            case 2:
                unSerpent.add(new QueueSerpent(x+3, y, dir));
                break;
            case 3:
                unSerpent.add(new QueueSerpent(x, y+3, dir));
                break;
        }

    }

    public Serpent(int x, int y){
        this(x, y, 0);
    }

    public ArrayList<Integer[]> getCoords(){
        ArrayList<Integer[]> coords = new ArrayList<Integer[]>();
        for (Mur part : unSerpent){
            Integer[] coord = new Integer[2];
            coord[0] = part.getX();
            coord[1] = part.getY();
            coords.add(coord);
        }
        return coords;
    }

    public Mur getPartie(int x, int y){
        for (Mur p : unSerpent){
            if (p.getY() == y && p.getX() == x)
                return p;
        }
        return null;
    }
}
