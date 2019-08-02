package proxy;

public class TestMain {
    public static void main(String[] args) {
        System.out.println(XYZ.name);
        new XYZ();
    }
}

class XYZ {
    public static String name = "luoxn28";

    static {
        System.out.println("xyz静态块");
    }

    public XYZ() {
        System.out.println("xyz构造了");
    }
}