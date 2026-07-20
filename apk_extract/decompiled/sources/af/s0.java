package af;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class s0 implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d0 f563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b0 f564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ze.q2 f565d;
    public w0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f566g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f567h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i4 f569j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ze.n[] f571l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ t0 f572m;
    public List e = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f568i = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ze.y f570k = ze.y.i();

    public s0(t0 t0Var, i4 i4Var, ze.n[] nVarArr) {
        this.f572m = t0Var;
        this.f569j = i4Var;
        this.f571l = nVarArr;
    }

    @Override // af.i6
    public final void a(ze.o oVar) {
        v8.n(this.f563b == null, "May only be called before start");
        this.f568i.add(new e(7, this, oVar));
    }

    @Override // af.b0
    public final void b(int i8) {
        v8.n(this.f563b == null, "May only be called before start");
        this.f568i.add(new u0(this, i8, 2));
    }

    @Override // af.b0
    public final void c(d0 d0Var) {
        ze.q2 q2Var;
        boolean z2;
        v8.i(d0Var, "listener");
        v8.n(this.f563b == null, "already started");
        synchronized (this) {
            try {
                q2Var = this.f565d;
                z2 = this.f562a;
                if (!z2) {
                    w0 w0Var = new w0(d0Var);
                    this.f = w0Var;
                    d0Var = w0Var;
                }
                this.f563b = d0Var;
                this.f566g = System.nanoTime();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (q2Var != null) {
            d0Var.l(q2Var, c0.PROCESSED, new ze.p1());
        } else if (z2) {
            o(d0Var);
        }
    }

    @Override // af.b0
    public final void d(ze.b0 b0Var) {
        v8.n(this.f563b == null, "May only be called before start");
        v8.i(b0Var, "decompressorRegistry");
        this.f568i.add(new e(8, this, b0Var));
    }

    @Override // af.i6
    public final void e(int i8) {
        v8.n(this.f563b != null, "May only be called after start");
        if (this.f562a) {
            this.f564c.e(i8);
        } else {
            l(new u0(this, i8, 0));
        }
    }

    @Override // af.b0
    public final void f(int i8) {
        v8.n(this.f563b == null, "May only be called before start");
        this.f568i.add(new u0(this, i8, 1));
    }

    @Override // af.i6
    public final void flush() {
        v8.n(this.f563b != null, "May only be called after start");
        if (this.f562a) {
            this.f564c.flush();
        } else {
            l(new v0(this, 2));
        }
    }

    @Override // af.i6
    public final void g() {
        v8.n(this.f563b == null, "May only be called before start");
        this.f568i.add(new v0(this, 0));
    }

    @Override // af.b0
    public final void h(ze.q2 q2Var) {
        boolean z2 = false;
        boolean z3 = true;
        v8.n(this.f563b != null, "May only be called after start");
        v8.i(q2Var, "reason");
        synchronized (this) {
            try {
                b0 b0Var = this.f564c;
                if (b0Var == null) {
                    b4 b4Var = b4.f185a;
                    if (b0Var != null) {
                        z3 = false;
                    }
                    v8.l("realStream already set to %s", z3, b0Var);
                    this.f564c = b4Var;
                    this.f567h = System.nanoTime();
                    this.f565d = q2Var;
                } else {
                    z2 = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z2) {
            l(new e(11, this, q2Var));
        } else {
            n();
            for (ze.n nVar : this.f571l) {
                nVar.m(q2Var);
            }
            this.f563b.l(q2Var, c0.PROCESSED, new ze.p1());
        }
        synchronized (this.f572m.f584b) {
            try {
                t0 t0Var = this.f572m;
                if (t0Var.f587g != null) {
                    boolean zRemove = t0Var.f589i.remove(this);
                    if (!this.f572m.e() && zRemove) {
                        t0 t0Var2 = this.f572m;
                        t0Var2.f586d.b(t0Var2.f);
                        t0 t0Var3 = this.f572m;
                        if (t0Var3.f590j != null) {
                            t0Var3.f586d.b(t0Var3.f587g);
                            this.f572m.f587g = null;
                        }
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        this.f572m.f586d.a();
    }

    @Override // af.i6
    public final void i(gf.a aVar) {
        v8.n(this.f563b != null, "May only be called after start");
        if (this.f562a) {
            this.f564c.i(aVar);
        } else {
            l(new e(10, this, aVar));
        }
    }

    @Override // af.i6
    public final boolean isReady() {
        if (this.f562a) {
            return this.f564c.isReady();
        }
        return false;
    }

    @Override // af.b0
    public final void j(t1 t1Var) {
        if (Boolean.TRUE.equals(this.f569j.f333a.f)) {
            t1Var.f594b.add("wait_for_ready");
        }
        synchronized (this) {
            try {
                if (this.f563b == null) {
                    return;
                }
                if (this.f564c != null) {
                    t1Var.a(Long.valueOf(this.f567h - this.f566g), "buffered_nanos");
                    this.f564c.j(t1Var);
                } else {
                    t1Var.a(Long.valueOf(System.nanoTime() - this.f566g), "buffered_nanos");
                    t1Var.f594b.add("waiting_for_connection");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // af.b0
    public final void k() {
        v8.n(this.f563b != null, "May only be called after start");
        l(new v0(this, 3));
    }

    public final void l(Runnable runnable) {
        v8.n(this.f563b != null, "May only be called after start");
        synchronized (this) {
            try {
                if (this.f562a) {
                    runnable.run();
                } else {
                    this.e.add(runnable);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // af.b0
    public final void m(ze.z zVar) {
        v8.n(this.f563b == null, "May only be called before start");
        this.f568i.add(new e(9, this, zVar));
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0031 A[Catch: all -> 0x002f, TryCatch #1 {all -> 0x002f, blocks: (B:11:0x001f, B:13:0x0029, B:14:0x002d, B:18:0x0031, B:19:0x0037), top: B:41:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:23:0x0042 A[LOOP:3: B:21:0x003c->B:23:0x0042, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:27:0x0053 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x001f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x0029 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:
    
        if (r0.hasNext() == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0065, code lost:
    
        ((java.lang.Runnable) r0.next()).run();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n() {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L5:
            monitor-enter(r5)
            java.util.List r1 = r5.e     // Catch: java.lang.Throwable -> L54
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L54
            if (r1 == 0) goto L56
            r0 = 0
            r5.e = r0     // Catch: java.lang.Throwable -> L54
            r1 = 1
            r5.f562a = r1     // Catch: java.lang.Throwable -> L54
            af.w0 r2 = r5.f     // Catch: java.lang.Throwable -> L54
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L54
            if (r2 == 0) goto L53
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
        L1e:
            monitor-enter(r2)
            java.util.Collection r3 = r2.f642c     // Catch: java.lang.Throwable -> L2f
            java.util.List r3 = (java.util.List) r3     // Catch: java.lang.Throwable -> L2f
            boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L2f
            if (r3 == 0) goto L31
            r2.f642c = r0     // Catch: java.lang.Throwable -> L2f
            r2.f640a = r1     // Catch: java.lang.Throwable -> L2f
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2f
            goto L53
        L2f:
            r5 = move-exception
            goto L51
        L31:
            java.util.Collection r3 = r2.f642c     // Catch: java.lang.Throwable -> L2f
            java.util.List r3 = (java.util.List) r3     // Catch: java.lang.Throwable -> L2f
            r2.f642c = r5     // Catch: java.lang.Throwable -> L2f
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2f
            java.util.Iterator r5 = r3.iterator()
        L3c:
            boolean r4 = r5.hasNext()
            if (r4 == 0) goto L4c
            java.lang.Object r4 = r5.next()
            java.lang.Runnable r4 = (java.lang.Runnable) r4
            r4.run()
            goto L3c
        L4c:
            r3.clear()
            r5 = r3
            goto L1e
        L51:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2f
            throw r5
        L53:
            return
        L54:
            r0 = move-exception
            goto L74
        L56:
            java.util.List r1 = r5.e     // Catch: java.lang.Throwable -> L54
            r5.e = r0     // Catch: java.lang.Throwable -> L54
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L54
            java.util.Iterator r0 = r1.iterator()
        L5f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L6f
            java.lang.Object r2 = r0.next()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r2.run()
            goto L5f
        L6f:
            r1.clear()
            r0 = r1
            goto L5
        L74:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L54
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: af.s0.n():void");
    }

    public final void o(d0 d0Var) {
        Iterator it = this.f568i.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f568i = null;
        this.f564c.c(d0Var);
    }

    public final v0 p(b0 b0Var) {
        synchronized (this) {
            try {
                if (this.f564c != null) {
                    return null;
                }
                v8.i(b0Var, "stream");
                b0 b0Var2 = this.f564c;
                v8.l("realStream already set to %s", b0Var2 == null, b0Var2);
                this.f564c = b0Var;
                this.f567h = System.nanoTime();
                d0 d0Var = this.f563b;
                if (d0Var == null) {
                    this.e = null;
                    this.f562a = true;
                }
                if (d0Var == null) {
                    return null;
                }
                o(d0Var);
                return new v0(this, 1);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
