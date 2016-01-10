import java.awt.event.KeyEvent;

/**
 * Created by pphelipo on 30/11/15.
 */

/*
Codes touches KeyListener -> getKeyCode()
Z = 90
Q = 81
S = 83
D = 68
E = 69
 */

public class MenuModele {

    private int J1keyUp;
    private int J1keyDown;
    private int J1keyLeft;
    private int J1keyRight;
    private int J2keyUp;
    private int J2keyDown;
    private int J2keyLeft;
    private int J2keyRight;

    public MenuModele(){
        J1keyUp = KeyEvent.VK_UP;
        J1keyDown = KeyEvent.VK_DOWN;
        J1keyLeft = KeyEvent.VK_LEFT;
        J1keyRight = KeyEvent.VK_RIGHT;
        J2keyUp = KeyEvent.VK_Z;
        J2keyDown = KeyEvent.VK_S;
        J2keyLeft = KeyEvent.VK_Q;
        J2keyRight = KeyEvent.VK_D;
    }

    public int getJ1keyUp() {
        return J1keyUp;
    }

    public int getJ1keyDown() {
        return J1keyDown;
    }

    public int getJ1keyLeft() {
        return J1keyLeft;
    }

    public int getJ1keyRight() {
        return J1keyRight;
    }

    public int getJ2keyUp() {
        return J2keyUp;
    }

    public int getJ2keyDown() {
        return J2keyDown;
    }

    public int getJ2keyLeft() {
        return J2keyLeft;
    }

    public int getJ2keyRight() {
        return J2keyRight;
    }
}
