import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Greeting {
    String sayHello(String name);
}

class GreetingImpl implements Greeting {
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}

class LoggingProxyHandler implements InvocationHandler {
    private final Object target;

    public LoggingProxyHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Executing method: " + method.getName());
        return method.invoke(target, args);
    }
}

public class Dino {
    public static void main(String[] args) {
        Greeting greeting = new GreetingImpl();
        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
            Greeting.class.getClassLoader(),
            new Class[]{Greeting.class},
            new LoggingProxyHandler(greeting)
        );
        
        System.out.println(proxyInstance.sayHello("John"));
    }
}
