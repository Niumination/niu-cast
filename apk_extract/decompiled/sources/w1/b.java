package w1;

import android.util.Log;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10628a = new a();

    public static void a() {
        f10628a.getClass();
        j1.a aVar = j1.d.f5945a;
    }

    public static void b(String str) {
        f10628a.getClass();
        HashSet hashSet = a.f10627a;
        if (hashSet.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, null);
        hashSet.add(str);
    }

    public static void c(String str, Throwable th2) {
        f10628a.getClass();
        HashSet hashSet = a.f10627a;
        if (hashSet.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th2);
        hashSet.add(str);
    }
}
