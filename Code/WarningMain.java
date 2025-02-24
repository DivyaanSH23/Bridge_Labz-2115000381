import java.util.ArrayList;

class UncheckedWarningExample {
    @SuppressWarnings("unchecked")
    public void createList() {
        ArrayList list = new ArrayList();
        list.add("Unchecked warning suppressed");
        System.out.println(list.get(0));
    }
}

public class WarningMain {
    public static void main(String[] args) {
        UncheckedWarningExample example = new UncheckedWarningExample();
        example.createList();
    }
}
