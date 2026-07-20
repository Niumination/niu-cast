package q3;

import tj.x;
import u2.l;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f8950a = new k();

    public g() {
    }

    public final boolean a(Exception exc) {
        k kVar = this.f8950a;
        kVar.getClass();
        l.f(exc, "Exception must not be null");
        synchronized (kVar.f8957a) {
            try {
                if (kVar.f8959c) {
                    return false;
                }
                kVar.f8959c = true;
                kVar.f = exc;
                kVar.f8958b.l(kVar);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public g(o5.c cVar) {
        se.e eVar = new se.e(this, 16);
        cVar.getClass();
        x xVar = new x(eVar);
        d2.h hVar = h.f8951a;
        k kVar = (k) cVar.f8405a;
        kVar.getClass();
        kVar.f8958b.k(new i(hVar, xVar));
        kVar.j();
    }
}
