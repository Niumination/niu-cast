package k4;

import java.io.Closeable;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8929a = "CloseableUtils";

    public static void a(Collection<Closeable> collection) {
        if (collection == null || collection.size() <= 0) {
            return;
        }
        for (Closeable closeable : collection) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e10) {
                    m.d(f8929a, e10);
                }
            }
        }
    }

    public static void b(Closeable... closeableArr) {
        if (closeableArr == null || closeableArr.length <= 0) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e10) {
                    m.d(f8929a, e10);
                }
            }
        }
    }

    public static void c(Closeable... closeableArr) {
        if (closeableArr == null || closeableArr.length <= 0) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e10) {
                    m.d(f8929a, e10);
                }
            }
        }
    }

    public static boolean d(Closeable... closeableArr) {
        if (closeableArr == null || closeableArr.length <= 0) {
            return true;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception unused) {
                    return false;
                }
            }
        }
        return true;
    }
}
