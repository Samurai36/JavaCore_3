import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class MainTest {

    public static void main(String[] args) {

        Class testCLassClass = MyTestClass.class;
        Object objTest = null;
        try {
            objTest = testCLassClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        ArrayList<Method> methodArray = new ArrayList<>();
        Method afterMethod = null;
        Method beforeMethod = null;
        for (Method declaredMethod : testCLassClass.getDeclaredMethods()) {
            if (declaredMethod.isAnnotationPresent(Test.class)) {
                methodArray.add(declaredMethod);
            }
            if (declaredMethod.isAnnotationPresent(AfterSuite.class)) {
                if (afterMethod == null) {
                    afterMethod = declaredMethod;
                } else
                    throw new RuntimeException("Метод с аннотацией @AfterSuite должен присутствовать в единственном экземпляре");
            }
            if (declaredMethod.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeMethod == null) {
                    beforeMethod = declaredMethod;
                } else
                    throw new RuntimeException("Метод с аннотацией @BeforeSuite должен присутствовать в единственном экземпляре");
            }
            methodArray.sort(new Comparator<Method>() {
                @Override
                public int compare(Method o1, Method o2) {
                    return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
                }
            });

        }

        try {

            if (beforeMethod != null) {
                beforeMethod.invoke(objTest);
            }

            for (Method o : methodArray) {
                o.invoke(objTest);
            }

            if (afterMethod != null) {
                afterMethod.invoke(objTest);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
