public class Tester {
    public static void main(String[] args) {

        final int TESTEFOR = 5;

        long start = System.currentTimeMillis();
        Reader reader = new Reader();
        Vector[] test = reader.read(TESTEFOR);
        long readTime = System.currentTimeMillis() - start;

        for(int i = 0; i<test.length;i++){
            if(test[i].isNotEmpty())
                test[i].print();
        }

        long firstPrintTime = System.currentTimeMillis() - readTime;

        for(int i = 0; i <test.length; i++){
            try{
                test[i].binaryInsertionSort(test[i],test[i].length);

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        long insertionSortMediumTime = (System.currentTimeMillis() - firstPrintTime);

        for(int i = 0; i<test.length;i++){
            if(test[i].isNotEmpty())
                test[i].print();
        }

        long secondPrintTime = System.currentTimeMillis() - insertionSortMediumTime;

        for(int i = 0; i < test.length;i++){
            if(test[i].isNotEmpty())
                try{
                    System.out.print(Vector.binarySearch(test[i],test[i].length,test[i].vector[i%TESTEFOR]));
                }catch (Exception e){
                    System.out.print(-1);
                }

        }

        System.out.println();

        long binarySearchMediumTime = System.currentTimeMillis() - secondPrintTime;

        for(int i = 0; i<test.length;i++){
            if(test[i].isNotEmpty())try{
                Vector.binarySearchR(test[i],test[i].vector[i%TESTEFOR],0,test[i].length-1);

            }catch (Exception e){
                System.out.print(-1);
            }

        }


        long binarySearchMediumTimeR = System.currentTimeMillis() - binarySearchMediumTime;


        System.out.printf("\nRead delay: %d ms \n" , readTime);
        System.out.printf("binary delay: %d ms " , insertionSortMediumTime);
        System.out.printf("binarySerarch delay: %d ms \n" , binarySearchMediumTime);
        System.out.printf("binarySerarchR delay: %d ms \n" , binarySearchMediumTimeR);


    }


}

