import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

class DIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    public <T> T getInstance(Class<T> clazz) throws Exception {
        if (instances.containsKey(clazz)) {
            return clazz.cast(instances.get(clazz));
        }
        Constructor<T> constructor = clazz.getDeclaredConstructor();
        T instance = constructor.newInstance();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                field.set(instance, getInstance(field.getType()));
            }
        }
        instances.put(clazz, instance);
        return instance;
    }
}

class Service {}

class Client {
    @Inject
    private Service service;

    public Service getService() {
        return service;
    }
}

public class DinoReflec {
    public static void main(String[] args) throws Exception {
        DIContainer container = new DIContainer();
        Client client = container.getInstance(Client.class);
        System.out.println(client.getService() != null ? "Dependency Injected" : "Injection Failed");
    }
}
