package ps;

import java.io.Closeable;
import java.util.Map;
import org.slf4j.impl.StaticMDCBinder;
import org.slf4j.spi.MDCAdapter;
import rs.i;
import rs.m;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13343a = "http://www.slf4j.org/codes.html#null_MDCA";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13344b = "http://www.slf4j.org/codes.html#no_static_mdc_binder";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static MDCAdapter f13345c;

    public static class b implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f13346a;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            c.h(this.f13346a);
        }

        public b(String str) {
            this.f13346a = str;
        }
    }

    static {
        try {
            f13345c = a();
        } catch (Exception e10) {
            m.d("MDC binding unsuccessful.", e10);
        } catch (NoClassDefFoundError e11) {
            f13345c = new i();
            String message = e11.getMessage();
            if (message == null || !message.contains("StaticMDCBinder")) {
                throw e11;
            }
            m.c("Failed to load class \"org.slf4j.impl.StaticMDCBinder\".");
            m.c("Defaulting to no-operation MDCAdapter implementation.");
            m.c("See http://www.slf4j.org/codes.html#no_static_mdc_binder for further details.");
        }
    }

    public static MDCAdapter a() throws NoClassDefFoundError {
        try {
            return StaticMDCBinder.getSingleton().getMDCA();
        } catch (NoSuchMethodError unused) {
            return StaticMDCBinder.SINGLETON.getMDCA();
        }
    }

    public static void b() {
        MDCAdapter mDCAdapter = f13345c;
        if (mDCAdapter == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        mDCAdapter.clear();
    }

    public static String c(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        MDCAdapter mDCAdapter = f13345c;
        if (mDCAdapter != null) {
            return mDCAdapter.get(str);
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    public static Map<String, String> d() {
        MDCAdapter mDCAdapter = f13345c;
        if (mDCAdapter != null) {
            return mDCAdapter.b();
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    public static MDCAdapter e() {
        return f13345c;
    }

    public static void f(String str, String str2) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        MDCAdapter mDCAdapter = f13345c;
        if (mDCAdapter == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        mDCAdapter.a(str, str2);
    }

    public static b g(String str, String str2) throws IllegalArgumentException {
        f(str, str2);
        return new b(str);
    }

    public static void h(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        MDCAdapter mDCAdapter = f13345c;
        if (mDCAdapter == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        mDCAdapter.remove(str);
    }

    public static void i(Map<String, String> map) {
        MDCAdapter mDCAdapter = f13345c;
        if (mDCAdapter == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        mDCAdapter.c(map);
    }
}
