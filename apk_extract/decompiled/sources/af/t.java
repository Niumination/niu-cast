package af;

import java.text.MessageFormat;
import java.util.logging.Level;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends ze.i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v f582d;
    public final k2 e;

    public t(v vVar, k2 k2Var) {
        this.f582d = vVar;
        v8.i(k2Var, "time");
        this.e = k2Var;
    }

    public static Level v(ze.h hVar) {
        int i8 = s.f561a[hVar.ordinal()];
        if (i8 == 1 || i8 == 2) {
            return Level.FINE;
        }
        return i8 != 3 ? Level.FINEST : Level.FINER;
    }

    @Override // ze.i
    public final void f(ze.h hVar, String str) {
        ze.l0 l0Var;
        v vVar = this.f582d;
        ze.r0 r0Var = vVar.f627b;
        Level levelV = v(hVar);
        if (v.f625c.isLoggable(levelV)) {
            v.a(r0Var, levelV, str);
        }
        if (!u(hVar) || hVar == ze.h.DEBUG) {
            return;
        }
        int i8 = s.f561a[hVar.ordinal()];
        if (i8 != 1) {
            l0Var = i8 != 2 ? ze.l0.CT_INFO : ze.l0.CT_WARNING;
        } else {
            l0Var = ze.l0.CT_ERROR;
        }
        ze.l0 l0Var2 = l0Var;
        long jG = this.e.g();
        v8.i(str, "description");
        v8.i(l0Var2, "severity");
        new ze.m0(str, l0Var2, jG, null);
        synchronized (vVar.f626a) {
        }
    }

    @Override // ze.i
    public final void g(ze.h hVar, String str, Object... objArr) {
        f(hVar, (u(hVar) || v.f625c.isLoggable(v(hVar))) ? MessageFormat.format(str, objArr) : null);
    }

    public final boolean u(ze.h hVar) {
        if (hVar != ze.h.DEBUG) {
            synchronized (this.f582d.f626a) {
            }
        }
        return false;
    }
}
