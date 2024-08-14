package app;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;


public class Main {


    public static void main(String[] args) throws NoSuchMethodException, SecurityException, InvocationTargetException, IllegalAccessException {

        int[] myArray = {1,2,3,4,5};

        Class<ArrayUtils> arrayUtilsClass = ArrayUtils.class;
        ArrayUtils arrayUtils = new ArrayUtils();
        Class<? extends ArrayUtils> cls = arrayUtils.getClass();

        Method method = arrayUtilsClass.getMethod("iterateIntArrayAndDisplay", int[].class);
        getAuthorAnnot(method);
        getMethodAnnot(method);

        Method method1 = arrayUtilsClass.getMethod("addX", int[].class, int.class);
        getAuthorAnnot(method1);
        getMethodAnnot(method1);

        Method method2 = arrayUtilsClass.getMethod("methodWithParam", int.class);
        getAuthorAnnot(method2);
        getMethodAnnot(method2);

        System.out.println("\n___ getMethods() ___");
        Method[] methods = arrayUtilsClass.getMethods();
        System.out.println("All methods " + Arrays.toString(methods));
        System.out.println("\n___ getDeclaredMethods() ___");
        methods = arrayUtilsClass.getDeclaredMethods();
        for(Method mtd : methods) {
            System.out.println("Method name - " + mtd.getName());
            System.out.println("Method parameters - " + Arrays.toString(mtd.getParameters()));
            System.out.println("Method param types - " + Arrays.toString(mtd.getParameterTypes()));
            System.out.println("Method returns - " + mtd.getReturnType());
        }

        System.out.println("\n___ call Method 1 ___");
        Method callMethod = cls.getDeclaredMethod("methodWithParam", int.class);
        callMethod.invoke(arrayUtils, 45);
        System.out.println("\n___ call Method 2 ___");
        Method callMethod2 = cls.getDeclaredMethod("iterateIntArrayAndDisplay", int[].class);
        callMethod2.invoke(arrayUtils, myArray);
    }

    static void getAuthorAnnot(AnnotatedElement element) {
        try {
            System.out.println("\nAnnotation on " +
                    element.getClass().getName());
            Annotation[] annotations = element.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Author author) {
                    System.out.println("Name: " + author.name());
                    System.out.println("Second name: " + author.secondName());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    static void getMethodAnnot(AnnotatedElement element) {
        try {
            System.out.println("\nAnnotation on " +
                    element.getClass().getName());
            Annotation[] annotations = element.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof MethodInfo methodInfo) {
                    System.out.println("Method Name: " + methodInfo.methodName());
                    System.out.println("Return Method Type: " + methodInfo.returnType());
                    System.out.println("Method description: " + methodInfo.description());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}