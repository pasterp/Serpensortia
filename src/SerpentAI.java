import java.util.ArrayList;

public class SerpentAI extends Serpent {

    private int targetX;
    private int targetY;
    private int targetDistance;

    public SerpentAI(int x, int y, int dir, int t) {
        super(x, y, dir, t);
        targetX = 0;
        targetDistance = 0;
        targetDistance = 99;

    }

    public void getTarget(ArrayList<Fruit> fruits, JeuModele jm){
        int distance;
        for (Fruit f: fruits){
            distance = Math.abs((f.getX() - getHeadCoord()[0]) + (f.getY() - getHeadCoord()[1]));
            if (targetDistance > distance){
                setTarget(f, distance, jm);
                System.out.println("Target selected - x: " + targetX + ", y: " + targetY + " - Distance: " + targetDistance);
            }
        }
    }

    public void setTarget(Fruit f, int d, JeuModele jm) {
        targetX = f.getX();
        targetY = f.getY();
        targetDistance = d;
        autoSetDirection(jm);
    }

    public void autoSetDirection(JeuModele jm){
        if (!(jm.getGrille()[targetX][targetY] instanceof Fruit)){
            getTarget(jm.getFruits(), jm);
        }
        if (targetX > getHeadCoord()[0] && jm.getGrille()[getHeadCoord()[0] + 1][getHeadCoord()[1]].isPassable()
                && !jm.isSerpent(getHeadCoord()[0] + 1, getHeadCoord()[1]))
            changerDirection(0);
        else if (targetX < getHeadCoord()[0] && jm.getGrille()[getHeadCoord()[0] - 1][getHeadCoord()[1]].isPassable()
                && !jm.isSerpent(getHeadCoord()[0] - 1, getHeadCoord()[1]))
            changerDirection(2);
        else if (targetY > getHeadCoord()[1] && jm.getGrille()[getHeadCoord()[0]][getHeadCoord()[1] + 1].isPassable()
                && !jm.isSerpent(getHeadCoord()[0], getHeadCoord()[1] + 1))
            changerDirection(1);
        else if (targetY <  getHeadCoord()[1] && jm.getGrille()[getHeadCoord()[0]][getHeadCoord()[1] - 1].isPassable()
                && !jm.isSerpent(getHeadCoord()[0], getHeadCoord()[1] - 1))
            changerDirection(3);
        System.out.println("Actual Target: " + targetX + ", " + targetY);
    }

    public void feedMe(int scores){
        super.feedMe(scores);
        resetTarget();
    }

    private void resetTarget() {
        targetX = 0;
        targetY = 0;
        targetDistance = 99;
    }

    @Override
    public void avancer() {
        super.avancer();
        targetDistance = Math.abs((targetX - getHeadCoord()[0]) + (targetY - getHeadCoord()[1]));
    }
}
