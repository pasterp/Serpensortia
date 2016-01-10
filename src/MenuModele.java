import java.awt.event.KeyEvent;
import java.io.*;

/**
 * Created by pphelipo on 30/11/15.
 */


public class MenuModele {
    private int joueurActuel;

    int[][] controles;

    public MenuModele(){
        joueurActuel=1;
        controles = new int[2][4];

        loadFromFile();
    }

    public void saveToFile(){
        File file = new File("controls.dat");

        try{
            DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

            for (int[] control : controles){
                for(int c : control){
                    System.out.println(c);
                    outputStream.writeInt(c);
                }
            }

            outputStream.flush();
            outputStream.close();
        }catch (IOException e){
            System.out.println("Impossible d'enregistrer les touches");
        }
    }

    public void loadFromFile(){
        File file = new File("controls.dat");
        try{
            if (file.exists()){
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));

            for (int i = 0; i < controles.length; i++){
                for(int j=0; j < controles[i].length; j++){
                    controles[i][j] = dataInputStream.readInt();
                }
            }

            dataInputStream.close();}else{throw new IOException();}
        }catch (IOException e){
            System.out.println("Controles par défaut");
            controles[0][0] = KeyEvent.VK_UP;
            controles[0][1] = KeyEvent.VK_DOWN;
            controles[0][2] = KeyEvent.VK_LEFT;
            controles[0][3] = KeyEvent.VK_RIGHT;
            controles[1][0] = KeyEvent.VK_Z;
            controles[1][1] = KeyEvent.VK_S;
            controles[1][2] = KeyEvent.VK_Q;
            controles[1][3] = KeyEvent.VK_D;
            saveToFile();
        }
    }

    public int getJ1keyUp() {
        return controles[0][0];
    }

    public void setJoueurActuel(int joueurActuel) {
        this.joueurActuel = joueurActuel;
    }

    public int getJ1keyDown() {
        return controles[0][1];
    }

    public int getJ1keyLeft() {
        return controles[0][2];
    }

    public int getJ1keyRight() {
        return controles[0][3];
    }

    public int getJ2keyUp() {
        return controles[1][0];
    }

    public int getJ2keyDown() {
        return controles[1][1];
    }

    public int getJ2keyLeft() {
        return controles[1][2];
    }

    public int getJ2keyRight() {
        return controles[1][3];
    }

    public int getJoueurActuel() {
        return joueurActuel;
    }

    public void setControles(int key, int value){
        controles[joueurActuel-1][key] = value;
        saveToFile();
    }
}
