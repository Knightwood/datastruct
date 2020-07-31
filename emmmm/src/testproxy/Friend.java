package testproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Friend implements InvocationHandler {
    private Object object;

    public Friend(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("shoping")){
            System.out.println("准备购物 " + method.getName());
            method.invoke(object, args);
            System.out.println("购物完成 " + method.getName());
        }
        if (method.getName().equals("travel")){
            System.out.println("准备旅游 " + method.getName());
            method.invoke(object, args);
            System.out.println("购物旅游 " + method.getName());
        }

        return null;
    }
}
