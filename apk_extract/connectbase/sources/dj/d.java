package dj;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Handler f3705a = new Handler(Looper.getMainLooper());
    }

    public static Handler a() {
        return a.f3705a;
    }
}
