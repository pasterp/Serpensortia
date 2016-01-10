import java.util.ArrayList;

public class SerpentAI extends Serpent {

    private int targetX;
    private int targetY;
    private double targetDistance;
    private int numeroSerpent;

    public SerpentAI(int x, int y, int dir, int t, int n) {
        super(x, y, dir, t);
        targetX = 0;
        targetY = 0;
        targetDistance = 99;
        numeroSerpent=n;

    }

    public void getTarget(ArrayList<Fruit> fruits, JeuModele jm){
        double distance;
        targetDistance=999.0;
        for (Fruit f: fruits){
            distance = Math.sqrt( Math.pow(f.getX() - getHeadCoord()[0], 2) + Math.pow(f.getY() - getHeadCoord()[1], 2));
            if (targetDistance > distance && distance != 0){
                setTarget(f, distance, jm);
                System.out.println("Target selected - x: " + targetX + ", y: " + targetY + " - Distance: " + targetDistance);
            }
        }
    }

    public void setTarget(Fruit f, double d, JeuModele jm) {
        targetX = f.getX();
        targetY = f.getY();
        targetDistance = d;
    }

    public void autoSetDirection(JeuModele jm){

        int[] coord = getHeadCoord();
        Case[][] g = jm.getGrille();

        if (coord[0] == targetX && coord[1]==targetY ||!(g[targetY][targetX] instanceof Fruit)){
            System.out.println("On a mangé un fruit bro || Notre cible a été mangé");
            getTarget(jm.getFruits(), jm);
        }
        //System.out.println("\t Coord : x: "+coord[0]+" y:"+coord[1]+"  ---> "+g[coord[1]][coord[0]]);

        if (targetX > coord[0]){
            if (!g[coord[1]][coord[0]+1].isPassable()){
                jm.tournerSerpent(numeroSerpent,1);
                jm.tournerSerpent(numeroSerpent,3);
                System.out.println("                                                      Test -("+(coord[0]+1)+","+coord[1]+")-->"+g[coord[1]][coord[0]+1]);
            }else{
                jm.tournerSerpent(numeroSerpent,0);
            }
        }else
        if (targetX < coord[0]){
            if (!g[coord[1]][coord[0]-1].isPassable()){
                jm.tournerSerpent(numeroSerpent,1);
                jm.tournerSerpent(numeroSerpent,3);
                System.out.println("                                                      Test -("+(coord[0]-1)+","+coord[1]+")-->"+g[coord[1]][coord[0]-1]);
            }else{
                jm.tournerSerpent(numeroSerpent,2);
            }
        }else
        if (targetY < coord[1]){
            if (!g[coord[1]-1][coord[0]].isPassable()){
                jm.tournerSerpent(numeroSerpent,0);
                jm.tournerSerpent(numeroSerpent,2);
                System.out.println("                                                      Test -("+(coord[0])+","+(coord[1]-1)+")-->"+g[coord[1]-1][coord[0]]);
            }else{
                jm.tournerSerpent(numeroSerpent,3);
            }
        }else
        if (targetY > coord[1]){
            if (!g[coord[1]+1][coord[0]].isPassable()){
                jm.tournerSerpent(numeroSerpent,0);
                jm.tournerSerpent(numeroSerpent,1);
                System.out.println("                                                      Test -("+(coord[0])+","+(coord[1]+1)+")-->"+g[coord[1]+1][coord[0]]);
            }else{
                jm.tournerSerpent(numeroSerpent,1);
            }
        }


//        if (targetX > getHeadCoord()[0] && jm.getGrille()[getHeadCoord()[0] + 1][getHeadCoord()[1]].isPassable()
//                && !jm.isSerpent(getHeadCoord()[0] + 1, getHeadCoord()[1]))
//            changerDirection(0);
//        else if (targetX < getHeadCoord()[0] && jm.getGrille()[getHeadCoord()[0] - 1][getHeadCoord()[1]].isPassable()
//                && !jm.isSerpent(getHeadCoord()[0] - 1, getHeadCoord()[1]))
//            changerDirection(2);
//        else if (targetY > getHeadCoord()[1] && jm.getGrille()[getHeadCoord()[0]][getHeadCoord()[1] + 1].isPassable()
//                && !jm.isSerpent(getHeadCoord()[0], getHeadCoord()[1] + 1))
//            changerDirection(1);
//        else if (targetY <  getHeadCoord()[1] && jm.getGrille()[getHeadCoord()[0]][getHeadCoord()[1] - 1].isPassable()
//                && !jm.isSerpent(getHeadCoord()[0], getHeadCoord()[1] - 1))
//            changerDirection(3);
    }
}
