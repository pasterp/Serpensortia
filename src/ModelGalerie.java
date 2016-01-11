import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by pphelipo on 04/12/15.
 */
public class ModelGalerie {
    private ArrayList<ImageIcon> images;
    ArrayList<String> paths;

    public int getIndex() {
        return index_courant;
    }

    public ImageIcon getImage(){
        return images.get(index_courant);
    }

    public int getSize(){
        return images.size();
    }

    public void setIndex(int index_courant) {
        if (index_courant < 0 ||index_courant >= images.size()){
            index_courant = images.size()-1;
        }
        this.index_courant = index_courant;
    }

    private int index_courant;

    public ModelGalerie(){
        index_courant=0;

        //On initialise les images
        images = new ArrayList<ImageIcon>();
        File folder = new File("./misc/");
        paths = new ArrayList<>();

        for (File f : folder.listFiles()){
            if (f.isFile() && (f.getName().contains(".png") || f.getName().contains(".jpg") || f.getName().contains(".gif"))){
                //on a bien une image on l'ouvre et on l'ajoute dans notre liste
                images.add(new ImageIcon("./misc/"+f.getName()));
                paths.add("./misc/"+f.getName());
            }
        }
    }

    public String getPath() {
        return paths.get(index_courant);
    }
}
