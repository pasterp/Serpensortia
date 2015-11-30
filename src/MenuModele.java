import java.awt.event.KeyListener;

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

    private int keyUp;
    private int keyDown;
    private int keyLeft;
    private int keyRight;
    private int gridSize;
    private int keyPause;

    public MenuModele(){
        keyUp = 90;
        keyDown = 83;
        keyLeft = 81;
        keyRight = 68;
        keyPause = 69;
        gridSize = 50;
    }

    public int getKeyUp(){
        return keyUp;
    }

    public int getKeyDown(){
        return keyDown;
    }

    public int getKeyLeft(){
        return keyLeft;
    }

    public int getKeyRight(){
        return keyRight;
    }

    public void setKeyUp(int key){
        keyUp = key;
    }

    public void setKeyDown(int key) {
        keyDown = key;
    }

    public void setKeyLeft(int key){
        keyLeft = key;
    }

    public void setKeyRight(int key){
        keyRight = key;
    }

    public int getGridSize(){
        return gridSize;
    }

    public void setGridSize(int size){
        gridSize = size;
    }

    public int getKeyPause(){
        return keyPause;
    }

    public void setKeyPause(int key){
        keyPause = key;
    }
}
