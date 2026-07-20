package yj;

import vj.y2;
import vj.z2;
import wj.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r1.a f20888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f20889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f20891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y2 f20892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Throwable f20893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f20894g;

    public e(r1.a aVar) {
        this.f20888a = aVar;
    }

    public vj.a a(vj.a aVar) {
        return (this.f20889b || this.f20890c) ? aVar : this.f20888a.e(aVar);
    }

    public y2 b() {
        return this.f20892e;
    }

    public Throwable c() {
        return this.f20893f;
    }

    public void d(y2 y2Var) {
        if (this.f20890c) {
            return;
        }
        this.f20890c = true;
        this.f20888a.d(y2Var);
    }

    public void e(boolean z10) {
        if (z10 == this.f20891d) {
            return;
        }
        this.f20891d = z10;
        this.f20888a.c(z10);
    }

    public void f() {
        if (this.f20889b || this.f20890c) {
            return;
        }
        this.f20889b = true;
        this.f20888a.b();
    }

    @t1.a
    public boolean g(y2 y2Var) {
        d(y2Var);
        if (this.f20892e != null) {
            return false;
        }
        this.f20892e = y2Var;
        y2Var.getClass();
        this.f20893f = new z2(y2Var);
        return true;
    }

    public void h(y2 y2Var) {
        if (this.f20894g) {
            return;
        }
        this.f20894g = true;
        g(y2Var);
        this.f20888a.a();
    }
}
