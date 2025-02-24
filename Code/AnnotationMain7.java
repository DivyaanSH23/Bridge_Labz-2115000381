import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface RoleAllowed {
    String value();
}

class SecureService {
    @RoleAllowed("ADMIN")
    public void performAdminTask() {
        System.out.println("Admin task executed successfully");
    }
}

class UserSession {
    private String userRole;

    public UserSession(String userRole) {
        this.userRole = userRole;
    }

    public void invokeIfAuthorized(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            RoleAllowed annotation = method.getAnnotation(RoleAllowed.class);
            if (annotation != null && !annotation.value().equals(userRole)) {
                System.out.println("Access Denied!");
                return;
            }
            method.invoke(obj);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

public class AnnotationMain7 {
    public static void main(String[] args) {
        SecureService service = new SecureService();
        UserSession adminUser = new UserSession("ADMIN");
        UserSession guestUser = new UserSession("GUEST");
        
        adminUser.invokeIfAuthorized(service, "performAdminTask");
        guestUser.invokeIfAuthorized(service, "performAdminTask");
    }
}
