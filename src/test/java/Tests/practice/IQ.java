package Tests.practice;

public class IQ {
    public static void main(String[] args) {
        String projectdir=System.getProperty("user.dir");
        System.out.println("user.dir: "+System.getProperty("user.dir"));
        System.out.println("Hello property : "
                + System.getProperty("Hello", "Geeks"));

        System.out.println("Property-property :"
                + System.getProperty("giliz","Property"));
    }
}
