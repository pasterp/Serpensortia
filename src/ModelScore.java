    import java.io.*;

    /**
     * Created by mahatehotia on 06/01/16.
     */
    public class ModelScore {
        int scores[];
        File scoreF;
        DataInputStream fichier;

        public ModelScore() {
            scores = new int[3];
            loadScores();

        }

        public void loadScores() {
                scoreF = new File("scores.dat");
                try {
                    //on lit les scores (3 entiers)
                    fichier = new DataInputStream(new BufferedInputStream(new FileInputStream(scoreF)));
                    for (int i = 0; i < 3; i++) {
                        scores[i] = fichier.readInt();
                    }
                } catch (IOException e) {
                    System.out.println("Attention : les scores n'ont pas pu être chargés !");
                    //on met à zéro les trois scores si on a pas pu les charger
                    for (int i = 0; i < 3; i++) {
                        scores[i] = 0;
                    }
                }
            }
        public void writeScores(){
            File scoreF =new File("scores.dat");
            try{
                //on ecrit les 3 scores
                DataOutputStream fichier = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(scoreF)));
                for (int s: scores) {
                    fichier.writeInt(s);
                }
                fichier.flush();
                fichier.close();
            }catch(IOException e){
                //Impossible d'enregistrer les scores
                System.out.println("Attention : les scores n'ont pas pu être sauvegardés !");
            }
        }
        public  void submitScore(int tmp){
            for (int j=0; j<3; j++){
                if (tmp > scores[j]){
                    int t = scores[j];
                    scores[j] = tmp;
                    tmp = t;
                }
            }
            writeScores();
        }

        public int getScore(int i){
            return scores[i];
        }
    }
