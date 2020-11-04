
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Reader {

    public final static int MAX = 50;

    public static Vector[] read(int pag){

        final String PATH = String.format("Resources/vetor%d.txt",pag);

        BufferedReader bufferedReader;
        String[] text;
        double[][] vector = new double[MAX][pag];
        int helper = 0;
        Vector[] answer = new Vector[MAX];

        try{
            bufferedReader = new BufferedReader (new FileReader(PATH));
            String row;
            int i = 0;
            while((row = bufferedReader.readLine()) != null) {
                text = row.split(" ");
                for (int j = 0; j < text.length; j++) {
                    if (!text[j].isEmpty()) vector[i][j] = Double.parseDouble(text[j]);
                    helper = j;
                }
                i++;
            }

            for(int k =0;k<MAX;k++){
                answer[k] = new Vector(vector[k],helper+1,String.format("test %d",k+1));
            }
        }catch(FileNotFoundException e){
            System.out.println("Not Found");
            e.printStackTrace();
        }catch(IOException e){
            System.out.println("IOException");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("Error");
            e.printStackTrace();
        }
        finally {
            return answer;
        }

    }



}
