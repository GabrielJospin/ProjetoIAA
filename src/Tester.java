import java.util.Scanner;

public class Tester {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {



        System.out.println("Welcome to IAA Work");
        System.out.println("Chose the test that you want:");
        System.out.println("1- Insertion Sort");
        System.out.println("2- Recursive Insertion Sort");
        System.out.println("3- Binary Insertion Sort");
        System.out.println("4- Recursive Binary Insertion Sort");
        System.out.println("5- FullHouse (Don't choice this for now)");

        int tester = input.nextInt();

        switch (tester){
            case 1:
                InsertionTest();
                break;
            case 2:
                RecursiveInsertionTest();
                break;
            case 3:
                BinaryTest();
                break;
            case 4:
                RecursiveBinaryTest();
                break;
            case 5:
                InsertionTest();
                RecursiveInsertionTest();
                BinaryTest();
                RecursiveBinaryTest();
                break;
            default:
                throw new Exception("Error: Not found the test that choice ");
        }



    }

    private static int SelectArchive() throws Exception{
        System.out.println("insert the archive's name to read");
        System.out.println("available archives:");
        System.out.println("vetor5.txt");
        System.out.println("vetor10.txt");
        System.out.println("vetor50.txt");
        System.out.println("vetor100.txt");
        System.out.println("vetor500.txt");
        System.out.println("vetor1000.txt");
        System.out.println("vetor5000.txt");
        System.out.println("vetor10000.txt");
        String arq = input.next();
        int i = -1;
        switch (arq){
            case "vetor5.txt":
                i = 0;
                break;
            case "vetor10.txt":
                i = 1;
                break;
            case "vetor50.txt":
                i = 2;
                break;
            case "vetor100.txt":
                i = 3;
                break;
            case "vetor500.txt":
                i = 4;
                break;
            case "vetor1000.txt":
                i = 5;
                break;
            case "vetor5000.txt":
                i = 6;
                break;
            case "vetor10000.txt":
                i = 7;
                break;
            default:
                throw new Exception("archive not found");
        }
        return i;
    }


    private static void InsertionTest() throws Exception {
        int i = SelectArchive();
        final Reader reader = new Reader();
        final int TESTEFOR[] = {5,10,50,100,500,1000,5000,10000} ;

        Vector[] test = reader.read(TESTEFOR[i]);

        long timeIn = System.nanoTime();

        for(int j = 0; j <test.length; j++) {
            try {
                //test[j].print();
                //System.out.println();
                test[j].insertionSort(test[j], test[j].length);
                //test[j].print();
                //System.out.println();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        long timeOut = System.nanoTime();

        System.out.printf("For %d arrays, the system delay %d  \n ",TESTEFOR[i],(timeOut-timeIn)/50);





    }


    private static void RecursiveInsertionTest() throws Exception {
        int i = SelectArchive();

        final Reader reader = new Reader();
        final int TESTEFOR[] = {5,10,50,100,500,1000,5000,10000} ;

        Vector[] test = reader.read(TESTEFOR[i]);

        long timeIn = System.nanoTime();

        for(int j = 0; j <test.length; j++) {
            try {
                //test[j].print();
                //System.out.println();
                test[j].insertionSortR(test[j], test[j].length);
                //test[j].print();
                //System.out.println();

            }catch (StackOverflowError e) {
                System.out.println("Stack Over flow");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        long timeOut = System.nanoTime();

        System.out.printf("For %d arrays, the system delay %d nanoseconds \n",TESTEFOR[i],(timeOut-timeIn)/50);





    }


    private static void BinaryTest() throws Exception {
        int i = SelectArchive();

        final Reader reader = new Reader();
        final int TESTEFOR[] = {5,10,50,100,500,1000,5000,10000} ;

        Vector[] test = reader.read(TESTEFOR[i]);

        long timeIn = System.nanoTime();

        for(int j = 0; j <test.length; j++) {
            try {
                //test[j].print();
                //System.out.println();
                test[j].binaryInsertionSort(test[j], test[j].length);
                //test[j].print();
                //System.out.println();

            } catch (Exception e) {
               e.printStackTrace();
            }
        }

        long timeOut = System.nanoTime();

        System.out.printf("For %d arrays, the system delay %d nanoseconds \n",TESTEFOR[i],(timeOut-timeIn)/50);




    }


    private static void RecursiveBinaryTest() throws Exception {
        int i = SelectArchive();

        final Reader reader = new Reader();
        final int TESTEFOR[] = {5,10,50,100,500,1000,5000,10000} ;

        Vector[] test = reader.read(TESTEFOR[i]);

        long timeIn = System.nanoTime();

        for(int j = 0; j <test.length; j++) {
            try {
                //test[j].print();
                //System.out.println();
                test[j].binaryInsertionSortR(test[49], 1);

            } catch (StackOverflowError e) {
                System.out.println("Stack Over flow");
            }catch (Exception e){
                e.printStackTrace();
            }finally{
                //test[j].print();
                //System.out.println();
            }



        }
        long timeOut = System.nanoTime();
        System.out.printf("For %d arrays, the system delay %d nanoseconds \n",TESTEFOR[i],(timeOut-timeIn)/50);





    }


}

