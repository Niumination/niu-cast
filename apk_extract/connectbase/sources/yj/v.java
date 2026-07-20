package yj;

import java.util.concurrent.Executor;
import vj.n2;
import wj.z1;

/* JADX INFO: loaded from: classes2.dex */
@vj.t0
public final class v {

    public final class a implements y.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z0.h f21296a;

        public a(z0.h hVar) {
            this.f21296a = hVar;
        }

        @Override // yj.y.d, yj.y0.b
        public /* bridge */ /* synthetic */ y0 a(z1 z1Var) {
            return a((z1<? extends Executor>) z1Var);
        }

        @Override // yj.y.d, yj.y0.b
        public y.b a(z1<? extends Executor> z1Var) {
            return new y.c(this.f21296a.f21332a.a(z1Var));
        }
    }

    public static n2 a(y.b bVar) {
        return new n0(z0.b(bVar));
    }

    public static n2 b(y.d dVar) {
        return new n0(dVar);
    }

    public static y.d c(n2 n2Var) {
        z0.h hVarD = z0.d(n2Var);
        if (hVarD.f21333b == null) {
            return new a(hVarD);
        }
        throw new IllegalArgumentException(hVarD.f21333b);
    }
}
