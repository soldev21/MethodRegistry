package main.model;

import java.lang.reflect.Method;

/**
 * Created by Sherif on 11/12/2018.
 */
public class MyMethod {
    private Method method;
    private Object object;

    public MyMethod() {
    }

    public MyMethod(Method method, Object o) {
        setMethod(method);
        setObject(o);
    }

    public void invoke() {
        try {
            method.invoke(object, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
