package main.registry;

import main.model.MyMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Created by Sherif on 11/12/2018.
 */
public class MethodRegistry {

    private static Map<String,MyMethod> registry;

    static {
        registry = new TreeMap<String, MyMethod>();
    }

    public static void register(Class<?> clazz){
        if (Objects.isNull(clazz)) throw new RuntimeException("Class mustn't be null");
        String name;
        Object o = getNewInstance(clazz);
        for (Method m:clazz.getDeclaredMethods()){
            name = m.getName();
            m.setAccessible(true);
            if (registry.containsKey(name)) throw new RuntimeException("Duplicate method name: "+name);
            registry.put(name,new MyMethod(m,o));
        }
    }

    private static Object getNewInstance(Class<?> clazz){
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static MyMethod get(String name){
        return registry.get(name);
    }

    public static void invoke(String name){
        get(name).invoke();
    }


    public static Map getRegistry(){
        return registry;
    }
}
