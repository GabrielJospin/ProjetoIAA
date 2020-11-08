
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
        this.name = String.format("Vector");
    }

    public void print(){
        System.out.printf("Printing %s of size %d:( ", name, length);
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



    public static void binaryInsertionSort (Vector  vector, int length) throws Exception{
        int order = 1;

        while(order<length){
            double helper = vector.vector[order];
            int location = binarySearch(vector,order,helper);
            int iteration = order;
            while((iteration>location)) {
                vector.vector[iteration] = vector.vector[iteration-1];
                iteration--;
            }
            vector.vector[location] = helper;
            order++;
        }
    }


    public static void binaryInsertionSortR(Vector vector, int position) throws Exception {
        if(position>=vector.length){
            return;
        }

        double helper = vector.vector[position];
        int location = binarySearchR(vector,helper,0,position);

        int iteration = position -1;
            while((iteration>location)) {
                vector.vector[iteration] = vector.vector[iteration-1];
                iteration--;
            }
        vector.vector[location] = helper;
        binaryInsertionSortR(vector,position+1);

    }



    public static int binarySearch(Vector vector,int length,double key) throws Exception {

        if(length == 1 && vector.vector[length] == key){
            return 0;
        }
        int middle;
        int floor = 0;
        int top = length-1;
        while(floor <= top){
            middle = (floor+top)/2;
            if (key == vector.vector[middle])
                return middle;
            if(key > vector.vector[middle])
                floor = middle+1;
            else
                top = middle - 1;
        }
        return top+1;
    }

    public static int binarySearchR(Vector vector, double key, int floor, int top) throws Exception {
        int middle = (floor+top)/2;
        if(floor>top){
            return top+1;
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

    public static void insertionSortR(Vector vector,int length){
        if(length<=1){
            return;
        }
        insertionSortR(vector,length-1);

        double last = vector.vector[length-1];
        int j = length-2;

        while(j >= 0 && vector.vector[j] > last){
            vector.vector[j+1] = vector.vector[j];
            j--;
        }

        vector.vector[j+1] = last;
    }


}