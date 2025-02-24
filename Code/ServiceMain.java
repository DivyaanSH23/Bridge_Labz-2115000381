class OutdatedService {
    @Deprecated
    public void oldFeature() {
        System.out.println("This feature is deprecated");
    }

    public void newFeature() {
        System.out.println("This is the new feature");
    }
}

public class ServiceMain {
    public static void main(String[] args) {
        OutdatedService service = new OutdatedService();
        service.oldFeature();
        service.newFeature();
    }
}
