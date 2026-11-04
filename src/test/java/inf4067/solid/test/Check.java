package inf4067.solid.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/** Mini framework de test (sans dépendance externe). */
public final class Check {
    private static int passed = 0, failed = 0;

    private Check() {}

    public static void eq(String name, Object expected, Object actual) {
        boolean ok = expected == null ? actual == null : expected.equals(actual);
        report(name, ok, "attendu=<" + expected + "> obtenu=<" + actual + ">");
    }

    public static void isTrue(String name, boolean cond) {
        report(name, cond, "condition fausse");
    }

    public static void throwsEx(String name, Class<? extends Throwable> type, Runnable r) {
        try {
            r.run();
            report(name, false, "aucune exception levée");
        } catch (Throwable t) {
            report(name, type.isInstance(t), "exception inattendue: " + t);
        }
    }

    /** Capture ce qui est écrit sur System.out pendant r. */
    public static String capture(Runnable r) {
        PrintStream old = System.out;
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buf, true));
        try {
            r.run();
        } finally {
            System.setOut(old);
        }
        return buf.toString().replace("\r\n", "\n");
    }

    public static void section(String title) {
        System.out.println("\n== " + title + " ==");
    }

    private static void report(String name, boolean ok, String detail) {
        if (ok) { passed++; System.out.println("  [OK]   " + name); }
        else    { failed++; System.out.println("  [FAIL] " + name + " -> " + detail); }
    }

    public static int summary() {
        System.out.println("\nRésultat : " + passed + " réussis, " + failed + " échoués");
        return failed;
    }
}
