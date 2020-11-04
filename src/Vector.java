import javax.swing.plaf.synth.SynthEditorPaneUI;

public class Vector {
    int length;
    double vector[];
    String name;

    Vector(double[] vector, int length, String name){
        this.length = length;
        this.name = name;
        this.vector = vector;
    }

    Vector(double[] vector, int length){
        this.length = length;
        this.vector = vector;
        this.name = String.format("Vetor de %d", vector.length);
    }

    public void print(){
        System.out.printf("Imprimindo %s de tamanho %d:( ", name, length);
        for(int i = 0; i < length; i++){
                System.out.printf("%.2f; " , vector[i]);
        }
        System.out.println(")");

    }
    public void print(int stop){
        System.out.printf("Imprimindo %s de tamanho %d:( ", name, stop);
        for(int i = 0; i < stop; i++){
            System.out.printf("%.2f; " , vector[i]);
        }
        System.out.println(")");

    }

    public boolean isNotEmpty() {
        int count = 0;
        for(int i = 0; i< length; i++){
            if(vector[i] == 0) count ++;
        }
        if(count == length) return false;
        return true;
    }


    public static void binaryInsertionSort (Vector vector, int length) throws Exception{
        int order = 1;

        while(order<length){
            double helper = vector.vector[order-1];
            int location = binarySearch(vector,order,helper);
            if(helper != vector.vector[location]){
                String error = String.format(" the object %f is different to %f in %d ", helper, vector.vector[location],location);
                throw new Exception(error);
            }

            int iteration = order-1;
            if(vector.vector[location]>vector.vector[location+1]){
                while((iteration>= 0) && vector.vector[iteration+1]<=vector.vector[iteration]){
                    double aux = vector.vector[iteration];
                    vector.vector[iteration] = vector.vector[iteration+1];
                    vector.vector[iteration+1] = aux;
                    iteration--;
                }
            }
            order++;
        }
    }


    public static void binaryInsertionSortR(Vector vector, int position){
        if(position == 0)
            return;
        int j = position-1;
        double helper = vector.vector[j];
        while((j>0) && (vector.vector[j-1] > helper)){
            vector.vector[j] = vector.vector[j-1];
            j -= 1;
        }
        vector.vector[j] = helper;
        binaryInsertionSortR(vector,j);
    }



    public static int binarySearch(Vector vector,int length,double key) throws Exception {

        if(length == 1 && vector.vector[length] == key){
            return 0;
        }

        int floor = 0;
        int top = length-1;

        while(floor <= top){
            int middle = (floor+top)/2;
            if (key == vector.vector[middle])
                return middle;
            if(key > vector.vector[middle])
                floor = middle+1;
            else
                top = middle - 1;
        }
        String error = String.format("Error: Not found %f in vector",key);
        throw new Exception(error);
    }

    public static int binarySearchR(Vector vector, double key, int floor, int top) throws Exception {
        int middle = (floor+top)/2;
        if(floor>top){
            String error = String.format("Error: Not found %f in vector",key);
            throw new Exception(error);
        }
        if(key == vector.vector[middle])
            return middle;
        if(key > vector.vector[middle])
            return binarySearchR( vector,  key,  middle+1,  top);
        else
            return binarySearchR( vector,  key,  floor,  middle-1);

    }

    public static void insertionSort(Vector Vector,int length){
        for(int i =0; i<length; i++){

            double helper = Vector.vector[i];
            int j = i;

            while((j>0) && (Vector.vector[j-1] > helper)){
                Vector.vector[j] = Vector.vector[j-1];
                j -= 1;
            }

            Vector.vector[j] = helper;

        }
    }

    public static void insertionSort(Vector vector){

    }


}