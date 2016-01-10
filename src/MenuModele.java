import java.awt.event.KeyEvent;

/**
 * Created by pphelipo on 30/11/15.
 */


public class MenuModele {
    private int joueurActuel;

    int[][] controles;

    public MenuModele(){
        joueurActuel=1;
        controles = new int[2][4];
        controles[0][0] = KeyEvent.VK_UP;
        controles[0][1] = KeyEvent.VK_DOWN;
        controles[0][2] = KeyEvent.VK_LEFT;
        controles[0][3] = KeyEvent.VK_RIGHT;
        controles[1][0] = KeyEvent.VK_Z;
        controles[1][1] = KeyEvent.VK_S;
        controles[1][2] = KeyEvent.VK_Q;
        controles[1][3] = KeyEvent.VK_D;
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
    }
}
