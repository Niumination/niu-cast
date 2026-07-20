package lm;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class p {
    @an.e
    @f1(version = "1.1")
    public static void a(@os.l Throwable th2, @os.l Throwable th3) throws IllegalAccessException, InvocationTargetException {
        kn.l0.p(th2, "<this>");
        kn.l0.p(th3, "exception");
        if (th2 != th3) {
            an.m.f417a.a(th2, th3);
        }
    }

    @os.l
    public static final StackTraceElement[] b(@os.l Throwable th2) {
        kn.l0.p(th2, "<this>");
        StackTraceElement[] stackTrace = th2.getStackTrace();
        kn.l0.m(stackTrace);
        return stackTrace;
    }

    public static /* synthetic */ void c(Throwable th2) {
    }

    @os.l
    public static final List<Throwable> d(@os.l Throwable th2) {
        kn.l0.p(th2, "<this>");
        return an.m.f417a.d(th2);
    }

    @f1(version = "1.4")
    public static /* synthetic */ void e(Throwable th2) {
    }

    @an.f
    public static final void f(Throwable th2) {
        kn.l0.p(th2, "<this>");
        th2.printStackTrace();
    }

    @an.f
    public static final void g(Throwable th2, PrintStream printStream) {
        kn.l0.p(th2, "<this>");
        kn.l0.p(printStream, "stream");
        th2.printStackTrace(printStream);
    }

    @an.f
    public static final void h(Throwable th2, PrintWriter printWriter) {
        kn.l0.p(th2, "<this>");
        kn.l0.p(printWriter, "writer");
        th2.printStackTrace(printWriter);
    }

    @f1(version = "1.4")
    @os.l
    public static final String i(@os.l Throwable th2) {
        kn.l0.p(th2, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th2.printStackTrace(printWriter);
        printWriter.flush();
        String string = stringWriter.toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }
}
