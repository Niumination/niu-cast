package bc;

import android.content.Context;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f810a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f812c;

    public static Context a() {
        return f811b;
    }

    public static a b() {
        if (f812c == null) {
            f812c = new a();
        }
        return f812c;
    }

    public void c(Context context) {
        Context applicationContext = context.getApplicationContext();
        f811b = applicationContext;
        ec.a.c(applicationContext);
        e.k(0);
    }
}
