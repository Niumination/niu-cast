package li;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q0 f7481a;

    static {
        String property;
        q0 q0Var;
        int i8 = qi.y.f9172a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null ? Boolean.parseBoolean(property) : false) {
            v0 v0Var = v0.f7498a;
            CoroutineContext.Element element = qi.r.f9163a;
            mi.c cVar = ((mi.c) element).f8096d;
            q0Var = !(element instanceof q0) ? m0.f7477j : (q0) element;
        } else {
            q0Var = m0.f7477j;
        }
        f7481a = q0Var;
    }
}
