package af;

import java.text.MessageFormat;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
public final class e2 extends ze.i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ze.r0 f229d;

    @Override // ze.i
    public final void f(ze.h hVar, String str) {
        ze.r0 r0Var = this.f229d;
        Level levelV = t.v(hVar);
        if (v.f625c.isLoggable(levelV)) {
            v.a(r0Var, levelV, str);
        }
    }

    @Override // ze.i
    public final void g(ze.h hVar, String str, Object... objArr) {
        ze.r0 r0Var = this.f229d;
        Level levelV = t.v(hVar);
        if (v.f625c.isLoggable(levelV)) {
            v.a(r0Var, levelV, MessageFormat.format(str, objArr));
        }
    }
}
