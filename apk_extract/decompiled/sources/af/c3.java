package af;

import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class c3 extends ze.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3 f202a;

    public c3(f3 f3Var) {
        this.f202a = f3Var;
    }

    @Override // ze.g
    public final String b() {
        return this.f202a.f279b;
    }

    @Override // ze.g
    public final ze.j e(ze.r1 r1Var, ze.f fVar) {
        j3 j3Var = this.f202a.f281d;
        Logger logger = j3.c0;
        j3Var.getClass();
        Executor executor = fVar.f11348b;
        Executor executor2 = executor == null ? j3Var.f352h : executor;
        j3 j3Var2 = this.f202a.f281d;
        a0 a0Var = new a0(r1Var, executor2, fVar, j3Var2.f346a0, j3Var2.I ? null : this.f202a.f281d.f.f520a.f1560d, this.f202a.f281d.L);
        j3 j3Var3 = this.f202a.f281d;
        j3Var3.getClass();
        a0Var.q = j3Var3.f358n;
        a0Var.f137r = j3Var3.f359o;
        return a0Var;
    }
}
