import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by mahatehotia on 06/01/16.
 */
public class Model {
    int score,meilleurScore;



        public void fichier() throws IOException {
            File fichier = new File("Best_Score");
            if (!fichier.exists()) {
                fichier.createNewFile();
                FileWriter ecrire = new FileWriter(fichier);
                ecrire.write(getScore());
                setMeilleurScore(getScore());
                ecrire.flush();
                ecrire.close();
            }
            else {
                if (score > getMeilleurScore()) {
                    FileWriter ecrire = new FileWriter(fichier);
                    ecrire.write(""+getScore());
                    ecrire.flush();
                    ecrire.close();
                }
            }

        }


    public int getScore() {
        return score;
    }

    public void setMeilleurScore(int meilleurScore) {
        this.meilleurScore = meilleurScore;
    }

    public int getMeilleurScore() {
        return meilleurScore;
    }
}
