package io.netty.util.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ThrowableUtil {
    private ThrowableUtil() {
    }

    @SuppressJava6Requirement(reason = "Throwable addSuppressed is only available for >= 7. Has check for < 7.")
    public static void addSuppressed(Throwable th2, Throwable th3) {
        if (haveSuppressed()) {
            th2.addSuppressed(th3);
        }
    }

    public static void addSuppressedAndClear(Throwable th2, List<Throwable> list) {
        addSuppressed(th2, list);
        list.clear();
    }

    @SuppressJava6Requirement(reason = "Throwable getSuppressed is only available for >= 7. Has check for < 7.")
    public static Throwable[] getSuppressed(Throwable th2) {
        return !haveSuppressed() ? EmptyArrays.EMPTY_THROWABLES : th2.getSuppressed();
    }

    public static boolean haveSuppressed() {
        return PlatformDependent.javaVersion() >= 7;
    }

    public static String stackTraceToString(Throwable th2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th2.printStackTrace(printStream);
        printStream.flush();
        try {
            return new String(byteArrayOutputStream.toByteArray());
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static <T extends Throwable> T unknownStackTrace(T t10, Class<?> cls, String str) {
        t10.setStackTrace(new StackTraceElement[]{new StackTraceElement(cls.getName(), str, null, -1)});
        return t10;
    }

    public static void addSuppressed(Throwable th2, List<Throwable> list) {
        Iterator<Throwable> it = list.iterator();
        while (it.hasNext()) {
            addSuppressed(th2, it.next());
        }
    }
}
