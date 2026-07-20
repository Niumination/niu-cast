package af;

import androidx.core.app.NotificationCompat;
import java.io.EOFException;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends h {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h6 f153h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f154i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d0 f155j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ze.b0 f156k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f157l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f158m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f159n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f160o;
    public boolean p;

    public b(int i8, h6 h6Var, l6 l6Var) {
        super(i8, h6Var, l6Var);
        this.f156k = ze.b0.f11324d;
        this.f157l = false;
        this.f153h = h6Var;
    }

    @Override // af.h
    public final j6 m() {
        return this.f155j;
    }

    public final void p(ze.q2 q2Var, c0 c0Var, ze.p1 p1Var) {
        if (this.f154i) {
            return;
        }
        this.f154i = true;
        this.f153h.b(q2Var);
        this.f155j.l(q2Var, c0Var, p1Var);
        if (this.f303c != null) {
            q2Var.e();
        }
    }

    public final void q(ze.p1 p1Var) throws EOFException {
        v8.n(!this.f160o, "Received headers on closed stream");
        for (ze.n nVar : this.f153h.f312a) {
            nVar.b();
        }
        ze.o oVar = ze.o.f11387b;
        String str = (String) p1Var.c(l1.e);
        if (str != null) {
            ze.a0 a0Var = (ze.a0) this.f156k.f11325a.get(str);
            ze.o oVar2 = a0Var != null ? a0Var.f11319a : null;
            if (oVar2 == null) {
                ((cf.m) this).j(new ze.s2(ze.q2.f11410m.h("Can't find decompressor for ".concat(str))));
                return;
            } else if (oVar2 != oVar) {
                this.f301a.k(oVar2);
            }
        }
        this.f155j.i(p1Var);
    }

    public final void r(ze.q2 q2Var, c0 c0Var, boolean z2, ze.p1 p1Var) {
        v8.i(q2Var, NotificationCompat.CATEGORY_STATUS);
        if (!this.f160o || z2) {
            this.f160o = true;
            this.p = q2Var.e();
            synchronized (this.f302b) {
                this.f305g = true;
            }
            if (this.f157l) {
                this.f158m = null;
                p(q2Var, c0Var, p1Var);
            } else {
                this.f158m = new a(0, this, q2Var, c0Var, p1Var);
                i(z2);
            }
        }
    }

    public final void s(ze.q2 q2Var, ze.p1 p1Var, boolean z2) {
        r(q2Var, c0.PROCESSED, z2, p1Var);
    }
}
