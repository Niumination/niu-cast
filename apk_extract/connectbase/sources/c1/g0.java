package c1;

import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.ServiceConfigurationError;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@k
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f1183a = Logger.getLogger(g0.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f0 f1184b = new b();

    public static final class b implements f0 {
        public b() {
        }

        @Override // c1.f0
        public h a(String pattern) {
            return new x(Pattern.compile(pattern));
        }

        @Override // c1.f0
        public boolean b() {
            return true;
        }

        public b(a aVar) {
        }
    }

    public static h a(String pattern) {
        pattern.getClass();
        return f1184b.a(pattern);
    }

    @gm.a
    public static String b(@gm.a String string) {
        if (j(string)) {
            return null;
        }
        return string;
    }

    public static String c(double value) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(value));
    }

    public static <T extends Enum<T>> c0<T> d(Class<T> enumClass, String value) {
        WeakReference<? extends Enum<?>> weakReference = l.a(enumClass).get(value);
        return weakReference == null ? c0.absent() : c0.of(enumClass.cast(weakReference.get()));
    }

    public static f0 e() {
        return new b();
    }

    public static void f(ServiceConfigurationError e10) {
        f1183a.log(Level.WARNING, "Error loading regex compiler, falling back to next option", (Throwable) e10);
    }

    public static String g(@gm.a String string) {
        return string == null ? "" : string;
    }

    public static boolean h() {
        return f1184b.b();
    }

    public static e i(e matcher) {
        return matcher.K();
    }

    public static boolean j(@gm.a String string) {
        return string == null || string.isEmpty();
    }
}
