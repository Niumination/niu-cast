package xj;

import java.io.PrintStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f11012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f11013b;

    static {
        h hVar;
        g gVar;
        String[] strArr = {"System.out", "stdout", "sysout"};
        String property = System.getProperty("slf4j.internal.report.stream");
        if (property != null && !property.isEmpty()) {
            int i8 = 0;
            while (true) {
                if (i8 >= 3) {
                    hVar = h.Stderr;
                    break;
                } else {
                    if (strArr[i8].equalsIgnoreCase(property)) {
                        hVar = h.Stdout;
                        break;
                    }
                    i8++;
                }
            }
        } else {
            hVar = h.Stderr;
        }
        f11012a = hVar;
        String property2 = System.getProperty("slf4j.internal.verbosity");
        if (property2 == null || property2.isEmpty()) {
            gVar = g.INFO;
        } else if (property2.equalsIgnoreCase("DEBUG")) {
            gVar = g.DEBUG;
        } else if (property2.equalsIgnoreCase("ERROR")) {
            gVar = g.ERROR;
        } else {
            gVar = property2.equalsIgnoreCase("WARN") ? g.WARN : g.INFO;
        }
        f11013b = gVar;
    }

    public static final void a(String str, Throwable th2) {
        b().println("SLF4J(E): " + str);
        b().println("SLF4J(E): Reported exception:");
        th2.printStackTrace(b());
    }

    public static PrintStream b() {
        return f11012a.ordinal() != 1 ? System.err : System.out;
    }

    public static boolean c(g gVar) {
        return gVar.levelInt >= f11013b.levelInt;
    }

    public static final void d(String str) {
        if (c(g.WARN)) {
            b().println("SLF4J(W): " + str);
        }
    }
}
