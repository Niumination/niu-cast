package cf;

import af.a4;
import af.d6;
import af.h6;
import af.i1;
import af.k2;
import af.l6;
import af.z3;
import k3.v8;
import ze.q2;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends d6 implements z3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a4 f1486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h6 f1487d;
    public boolean e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a0 f1488g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final tj.w f1489h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l6 f1490i;

    public b0(a0 a0Var, ze.b bVar, String str, h6 h6Var, l6 l6Var) {
        mg.a0 a0Var2 = new mg.a0();
        this.f1487d = h6Var;
        this.f1486c = new a4(this, a0Var2, h6Var);
        this.f1489h = new tj.w(this, 5);
        this.f1488g = a0Var;
        v8.i(bVar, "transportAttrs");
        v8.i(l6Var, "transportTracer");
        this.f1490i = l6Var;
    }

    public final void h(q2 q2Var) {
        tj.w wVar = this.f1489h;
        wVar.getClass();
        ph.b.d();
        try {
            synchronized (((b0) wVar.f10262b).f1488g.f1476s) {
                a0 a0Var = ((b0) wVar.f10262b).f1488g;
                ef.a aVar = ef.a.CANCEL;
                if (!a0Var.f1477t) {
                    a0Var.f1477t = true;
                    e eVar = a0Var.f1479w;
                    int i8 = a0Var.q;
                    eVar.f(i8, aVar);
                    a0Var.f(q2Var);
                    a0Var.p.l(i8, true);
                }
            }
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @Override // af.i6
    public final boolean isReady() {
        return v().l();
    }

    @Override // af.z3
    public final void l(j0 j0Var, boolean z2, boolean z3, int i8) {
        if (j0Var == null) {
            return;
        }
        if (z2) {
            z3 = false;
        }
        tj.w wVar = this.f1489h;
        wVar.getClass();
        ph.b.d();
        try {
            qj.f fVar = j0Var.f1569a;
            int i9 = (int) fVar.f9195b;
            if (i9 > 0) {
                af.h hVarV = ((b0) wVar.f10262b).v();
                synchronized (hVarV.f302b) {
                    hVarV.e += i9;
                }
            }
            synchronized (((b0) wVar.f10262b).f1488g.f1476s) {
                a0 a0Var = ((b0) wVar.f10262b).f1488g;
                if (!a0Var.f1477t) {
                    a0Var.f1480x.a(false, a0Var.f1482z, fVar, z3);
                }
                l6 l6Var = ((b0) wVar.f10262b).f1490i;
                if (i8 == 0) {
                    l6Var.getClass();
                } else {
                    ((k2) l6Var.f446b).g();
                }
            }
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @Override // af.d6
    public final i1 o() {
        return this.f1486c;
    }

    @Override // af.d6
    public final af.h v() {
        return this.f1488g;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0095 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x(ze.q2 r4, ze.p1 r5) {
        /*
            r3 = this;
            java.lang.String r0 = "status"
            k3.v8.i(r4, r0)
            java.lang.String r0 = "trailers"
            k3.v8.i(r5, r0)
            boolean r0 = r3.e
            if (r0 != 0) goto La1
            r0 = 1
            r3.e = r0
            af.i1 r1 = r3.o()
            af.a4 r1 = (af.a4) r1
            r1.close()
            ze.n1 r1 = ze.v0.f11452b
            r5.a(r1)
            ze.n1 r2 = ze.v0.f11451a
            r5.a(r2)
            r5.f(r1, r4)
            java.lang.String r1 = r4.f11414b
            if (r1 == 0) goto L2e
            r5.f(r2, r1)
        L2e:
            cf.a0 r1 = r3.f1488g
            ze.q2 r2 = r1.f1474o
            if (r2 != 0) goto L35
            goto L36
        L35:
            r0 = 0
        L36:
            java.lang.String r2 = "closedStatus can only be set once"
            k3.v8.n(r0, r2)
            r1.f1474o = r4
            tj.w r4 = r3.f1489h
            boolean r3 = r3.f
            r4.getClass()
            ph.b.d()
            if (r3 != 0) goto L4e
            java.util.ArrayList r3 = cf.f.b(r5)     // Catch: java.lang.Throwable -> L95
            goto L69
        L4e:
            ef.d r3 = cf.f.f1525a     // Catch: java.lang.Throwable -> L95
            ze.k1 r3 = af.l1.f417j     // Catch: java.lang.Throwable -> L95
            r5.a(r3)     // Catch: java.lang.Throwable -> L95
            ze.k1 r3 = af.l1.f418k     // Catch: java.lang.Throwable -> L95
            r5.a(r3)     // Catch: java.lang.Throwable -> L95
            ze.k1 r3 = af.l1.f419l     // Catch: java.lang.Throwable -> L95
            r5.a(r3)     // Catch: java.lang.Throwable -> L95
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L95
            int r0 = r5.f11400b     // Catch: java.lang.Throwable -> L95
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L95
            cf.f.a(r3, r5)     // Catch: java.lang.Throwable -> L95
        L69:
            java.lang.Object r5 = r4.f10262b     // Catch: java.lang.Throwable -> L95
            cf.b0 r5 = (cf.b0) r5     // Catch: java.lang.Throwable -> L95
            cf.a0 r5 = r5.f1488g     // Catch: java.lang.Throwable -> L95
            java.lang.Object r5 = r5.f1476s     // Catch: java.lang.Throwable -> L95
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L95
            java.lang.Object r4 = r4.f10262b     // Catch: java.lang.Throwable -> L92
            cf.b0 r4 = (cf.b0) r4     // Catch: java.lang.Throwable -> L92
            cf.a0 r4 = r4.f1488g     // Catch: java.lang.Throwable -> L92
            r4.getClass()     // Catch: java.lang.Throwable -> L92
            a0.e r0 = new a0.e     // Catch: java.lang.Throwable -> L92
            r1 = 2
            r0.<init>(r1, r4, r3)     // Catch: java.lang.Throwable -> L92
            cf.o0 r3 = r4.f1480x     // Catch: java.lang.Throwable -> L92
            cf.l0 r4 = r4.f1482z     // Catch: java.lang.Throwable -> L92
            r3.getClass()     // Catch: java.lang.Throwable -> L92
            cf.o0.c(r4, r0)     // Catch: java.lang.Throwable -> L92
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L92
            ph.a r3 = ph.b.f8887a
            r3.getClass()
            goto La1
        L92:
            r3 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L92
            throw r3     // Catch: java.lang.Throwable -> L95
        L95:
            r3 = move-exception
            ph.a r4 = ph.b.f8887a     // Catch: java.lang.Throwable -> L9c
            r4.getClass()     // Catch: java.lang.Throwable -> L9c
            goto La0
        L9c:
            r4 = move-exception
            r3.addSuppressed(r4)
        La0:
            throw r3
        La1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cf.b0.x(ze.q2, ze.p1):void");
    }
}
