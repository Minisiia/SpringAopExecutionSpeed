package execution_speed.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
@Aspect
public class MyLogger {
    private static long time;
    private static Set<Object> set;
    private static Map<String, Object> map;

    public MyLogger() {
    }

    public MyLogger(long time, Set<Object> set, Map<String, Object> map) {
        MyLogger.time = time;
        MyLogger.set = set;
        MyLogger.map = map;
    }

    public static long getTime() {
        return time;
    }

    public static Set<Object> getSet() {
        return set;
    }


    public static Map<String, Object> getMap() {
        return map;
    }


    @Pointcut("@annotation(execution_speed.annotations.ShowTime))")
    private void showTime() {
    }

    @Pointcut("@annotation(execution_speed.annotations.ShowResult)")
    private void showResult() {
    }

    @Around("showTime()")
    public Object watchTime(ProceedingJoinPoint joinpoint) {
        long start = System.currentTimeMillis();
        Object output = null;
        try {
            output = joinpoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        time = System.currentTimeMillis() - start;
        return output;
    }

    @AfterReturning(pointcut = "showResult()", returning = "obj")
    public void print(Object obj) {
        if (obj instanceof Set) {
            set = (Set) obj;
        } else if (obj instanceof Map) {
            map = (Map) obj;
        }
    }

}
