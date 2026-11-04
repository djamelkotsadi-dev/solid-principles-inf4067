package inf4067.solid.test;

public class AllTests {
    public static void main(String[] args) {
        SrpTest.run();
        OcpTest.run();
        LspTest.run();
        IspTest.run();
        DipTest.run();
        System.exit(Check.summary() == 0 ? 0 : 1);
    }
}
