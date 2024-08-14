package app;

import java.util.concurrent.atomic.AtomicInteger;
public class ArrayUtils {

    @Author(name = "Yuliia", secondName = "Deineka")
    @MethodInfo(methodName = "iterateIntArrayAndDisplay", description = "Loop through all the elements in an array")
   public void iterateIntArrayAndDisplay (int[] arr) {
       AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int j : arr) {
            System.out.println(atomicInteger.incrementAndGet() + ") " + "value is " + j);
        }
   }

    @Author(name = "Danylo")
    @MethodInfo(methodName = "addX", returnType = "Integer[]")
    public int[] addX(int[] array, int x) {
        int i;

        // create a new array of a bigger size (+ one element)
        int[] newArray = new int[array.length + 1];

        // insert the elements from the old array into the new one
        for (i = 0; i < array.length; i++)
            newArray[i] = array[i];

        newArray[array.length] = x;
        return newArray;
    }

    @Author()
    @MethodInfo()
    public void methodWithParam(int num) {
        System.out.println("The number is " + num);
    }

}
