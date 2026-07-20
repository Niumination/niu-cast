package e3;

import android.content.Context;
import o5.c;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f4672b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f4673a;

    static {
        a aVar = new a();
        aVar.f4673a = null;
        f4672b = aVar;
    }

    public static c a(Context context) {
        c cVar;
        a aVar = f4672b;
        synchronized (aVar) {
            try {
                if (aVar.f4673a == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    aVar.f4673a = new c(context);
                }
                cVar = aVar.f4673a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cVar;
    }
}
