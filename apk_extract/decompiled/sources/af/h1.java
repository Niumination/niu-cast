package af;

import k3.t8;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h1 extends ze.e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j3 f306a;

    public h1(j3 j3Var) {
        this.f306a = j3Var;
    }

    @Override // ze.g
    public final String b() {
        return this.f306a.f362t.b();
    }

    @Override // ze.g
    public final ze.j e(ze.r1 r1Var, ze.f fVar) {
        return this.f306a.f362t.e(r1Var, fVar);
    }

    @Override // ze.e1
    public final ze.q h() {
        return this.f306a.h();
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.d(this.f306a, "delegate");
        return aVarA.toString();
    }
}
