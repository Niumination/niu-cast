package cf;

import af.h6;
import af.l6;
import ze.p1;
import ze.r1;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends af.c {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final qj.f f1595r = new qj.f();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final r1 f1596j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f1597k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final h6 f1598l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f1599m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final m f1600n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final se.e f1601o;
    public final ze.b p;
    public boolean q;

    public n(r1 r1Var, p1 p1Var, e eVar, q qVar, o0 o0Var, Object obj, int i8, int i9, String str, String str2, h6 h6Var, l6 l6Var, ze.f fVar) {
        super(new mg.a0(), h6Var, l6Var, p1Var, fVar, false);
        this.f1601o = new se.e(this, 5);
        this.q = false;
        this.f1598l = h6Var;
        this.f1596j = r1Var;
        this.f1599m = str;
        this.f1597k = str2;
        this.p = qVar.u;
        String str3 = r1Var.f11423b;
        this.f1600n = new m(this, i8, h6Var, obj, eVar, o0Var, qVar, i9);
    }

    @Override // af.d6
    public final af.h v() {
        return this.f1600n;
    }
}
