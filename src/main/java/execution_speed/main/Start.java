package execution_speed.main;

import execution_speed.annotations.ShowResult;
import execution_speed.annotations.ShowTime;
import execution_speed.logging.MyLogger;
import execution_speed.objects.FileManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * Вивести швидкість виконання лише тих методів, які позначені @ShowTime.
 * Вивести результати в консоль тільки для тих методів, які позначені @ShowResult.
 * Самостійно створити @ShowTime та @ShowResult.
 */

public class Start {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        FileManager fileManager = new FileManager();
        Class<?> clazz = fileManager.getClass();
        System.out.println((char) 27 + "[34m" + "Methods annotated with @ShowTime: " + (char) 27 + "[38m");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ShowTime.class)) {
                fileManager = (FileManager) context.getBean("fileManager");
                method.invoke(fileManager, "c:\\Windows\\");
                System.out.println("Method name: " + method.getName() + " time: " + MyLogger.getTime() + " ms");
            }
        }
        System.out.println((char) 27 + "[34m" + "Methods annotated with @ShowResult: " + (char) 27 + "[38m");
        for (Method method : methods) {
            if (method.isAnnotationPresent(ShowResult.class)) {
                fileManager = (FileManager) context.getBean("fileManager");
                method.invoke(fileManager, "c:\\Windows\\");
                if (method.getReturnType().equals(Set.class)) {
                    System.out.println("Method name: " + method.getName() + ", set: " + MyLogger.getSet());
                } else
                    System.out.println("Method name: " + method.getName() + ", map: " + MyLogger.getMap());
            }
        }
    }
}
