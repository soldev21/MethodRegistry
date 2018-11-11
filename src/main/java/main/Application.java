package main;

import main.model.ModelA;
import main.registry.MethodRegistry;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Sherif on 11/12/2018.
 */
public class Application {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        MethodRegistry.register(ModelA.class);
        MethodRegistry.invoke("some2");
    }
}
