package proxy;

class Base1 { }
class Derived extends Base1 { }

public class Main1 {
    public static void main(String[] args) {
        Base1 base = new Derived();
        if (base instanceof Derived) {
            // 这里可以向下转换了
            System.out.println("ok");
        }
        else {
            System.out.println("not ok");
        }
    }
}