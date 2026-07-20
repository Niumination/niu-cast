package z0;

import android.util.Log;
import java.util.HashSet;
import java.util.Set;
import n0.m;

/* JADX INFO: loaded from: classes.dex */
public class c implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f21748a = new HashSet();

    @Override // n0.m
    public void a(String str) {
        b(str, null);
    }

    @Override // n0.m
    public void b(String str, Throwable th2) {
        Set<String> set = f21748a;
        if (set.contains(str)) {
            return;
        }
        Log.w(n0.e.f10922b, str, th2);
        set.add(str);
    }

    @Override // n0.m
    public void debug(String str) {
        debug(str, null);
    }

    @Override // n0.m
    public void error(String str, Throwable th2) {
        if (n0.e.f10921a) {
            Log.d(n0.e.f10922b, str, th2);
        }
    }

    @Override // n0.m
    public void debug(String str, Throwable th2) {
        if (n0.e.f10921a) {
            Log.d(n0.e.f10922b, str, th2);
        }
    }
}
