import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public  static void start(Class testClass) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = testClass.getDeclaredMethods();
        List<Method> list = new ArrayList();
        for (Method method: methods) {
            if(method.isAnnotationPresent(Test.class)) {
                list.add(method);
            }
        }
        list.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
            }
        });
        for (Method method: methods) {
            if(method.isAnnotationPresent(BeforeSuite.class)) {
                if(list.get(0).isAnnotationPresent(BeforeSuite.class))
                    throw new RuntimeException("BeforeSuite exception");
                list.add(0, method);
            }
            if(method.isAnnotationPresent(AfterSuite.class)) {
                if(list.get(list.size() - 1).isAnnotationPresent(AfterSuite.class))
                    throw new RuntimeException("AfterSuite exception");
                list.add(method);
            }
        }
        for (Method method: list) {
            method.invoke(null);
        }
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        start(ClassWithTestMethods.class);
    }


}
