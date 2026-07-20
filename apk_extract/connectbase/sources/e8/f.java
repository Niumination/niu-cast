package e8;

import android.os.Looper;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class f implements pg.f {
    @Override // pg.f
    public void a(Looper looper, long j10) {
        Method methodG = cc.a.g(looper.getClass(), "setTraceTag", Long.TYPE);
        if (methodG == null) {
            return;
        }
        cc.a.j(methodG, looper, Long.valueOf(j10));
    }
}
