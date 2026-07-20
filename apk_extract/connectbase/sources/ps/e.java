package ps;

import org.slf4j.IMarkerFactory;
import org.slf4j.impl.StaticMarkerBinder;
import rs.m;

/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IMarkerFactory f13347a;

    static {
        try {
            f13347a = a();
        } catch (Exception e10) {
            m.d("Unexpected failure while binding MarkerFactory", e10);
        } catch (NoClassDefFoundError unused) {
            f13347a = new rs.c();
        }
    }

    public static IMarkerFactory a() throws NoClassDefFoundError {
        try {
            return StaticMarkerBinder.getSingleton().getMarkerFactory();
        } catch (NoSuchMethodError unused) {
            return StaticMarkerBinder.SINGLETON.getMarkerFactory();
        }
    }

    public static d b(String str) {
        return f13347a.c(str);
    }

    public static IMarkerFactory c() {
        return f13347a;
    }

    public static d d(String str) {
        return f13347a.a(str);
    }
}
