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

    public void getTarget(ArrayList<Fruit> fruits){
        System.out.println("Looking for a new target...");
        int distance;
        for (Fruit f: fruits){
            distance = Math.abs((f.getX() - getHeadCoord()[0]) + (f.getY() - getHeadCoord()[1]));
            if (targetDistance > distance){
                setTarget(f, distance);
            }
        }
    }

    public void setTarget(Fruit f, int d) {
        targetX = f.getX();
        targetY = f.getY();
        targetDistance = d;
        autoSetDirection();
    }

    public void autoSetDirection(){
        if (targetX > getHeadCoord()[0])
            changerDirection(0);
        else if (targetX < getHeadCoord()[0])
            changerDirection(2);
        else if (targetY > getHeadCoord()[1])
            changerDirection(1);
        else
            changerDirection(3);
    }
}
