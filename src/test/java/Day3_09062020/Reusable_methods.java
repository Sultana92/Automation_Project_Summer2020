package Day3_09062020;

public class Reusable_methods {

    //custom method to add two integer values
    // void methods only executes the statement inside
    // but doesn't return anything
    public static void add(int a, int b){
        System.out.println("My result of a & b is" + (a+b));
    }// end of add method

    public static void subtraction(int a, int b){
        System.out.println("My result of a a - b is " + (a-b));
    }//end of subtract method

    public static int returnAdd(int a, int b){
        int result = a+b;
        System.out.println("My result of a & b is" + (a+b));
        return result;

    }// end of add method

}// end of java class

