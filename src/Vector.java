
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

    public boolean isNotEmpty() {
        int count = 0;
        for(int i = 0; i< length; i++){
            if(vector[i] == 0) count ++;
        }
        if(count == length) return false;
        return true;
    }


    private static void moveVector(Vector vector, int position){

        double helper = vector.vector[position];
        if(position == 0){
            vector.vector[position]=helper;
            System.out.println(position);
            return;
        }
        vector.vector[position] = vector.vector[position-1];
        moveVector(vector,position-1);

    }



    public static void binaryInsertionSort (Vector vector, int length) {
        int location = 0;
        double helper;

        for (int i = 1; i < length; ++i)
        {
            int j = i;
            helper = vector.vector[i];
            location = binarySearch(vector, j,helper);
            while((j>0) && (vector.vector[j-1] > helper)){
                vector.vector[j] = vector.vector[j-1];
                j -= 1;
            }

            vector.vector[j] = helper;
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



    public static int binarySearch(Vector vector,int length,double key){

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

        return -1;
    }

    public static int binarySearchR(Vector vector, double key, int floor, int top){
        int middle = (floor+top)/2;
        if(floor>top)
            return  -1;
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
}
