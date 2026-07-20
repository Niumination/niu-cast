package nl;

import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class m {
    @os.l
    public static final Throwable a(@os.l Throwable th2, @os.l um.d<?> dVar) {
        l0.p(th2, "exception");
        l0.p(dVar, "continuation");
        try {
            return l.a(th2, th2.getCause());
        } catch (Throwable unused) {
            return th2;
        }
    }
}
