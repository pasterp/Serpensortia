import javax.swing.*;
import java.awt.*;

/**
 * Created by pascal on 28/12/15.
 */
public class CaseOrientée extends Mur {
    protected int direction;
    Image[] images;

    public CaseOrientée(int x, int y, int dir){
        super();
        direction = dir;
        this.x=x;
        this.y=y;
        images= new Image[4];
        images[0] = new ImageIcon("./img/error.png").getImage();
        images[1] = new ImageIcon("./img/error.png").getImage();
        images[2] = new ImageIcon("./img/error.png").getImage();
        images[3] = new ImageIcon("./img/error.png").getImage();
    }

    public void setDroite(ImageIcon i){
        images[0]=i.getImage();
    }

    public void setBas(ImageIcon i){
        images[1]=i.getImage();
    }

    public void setGauche(ImageIcon i){
        images[2]=i.getImage();
    }

    public void setHaut(ImageIcon i){
        images[3]=i.getImage();
    }

    @Override
    public Image getImage() {
        if (direction == 0){
            return images[0];
        }
        else if (direction == 1) {
            return images[1];
        }
        else if (direction == 2){
            return images[2];
        }
        else if (direction == 3){
            return images[3];
        }else{
            throw(new RuntimeException("Direction invalide"));
        }
    }
}
