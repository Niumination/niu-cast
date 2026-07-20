package wo;

import kn.l0;
import vp.f0;
import vp.g0;
import vp.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements rp.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final h f19790a = new h();

    @Override // rp.r
    @os.l
    public f0 a(@os.l yo.a.q qVar, @os.l String str, @os.l n0 n0Var, @os.l n0 n0Var2) {
        l0.p(qVar, "proto");
        l0.p(str, "flexibleId");
        l0.p(n0Var, "lowerBound");
        l0.p(n0Var2, "upperBound");
        if (l0.g(str, "kotlin.jvm.PlatformType")) {
            return qVar.hasExtension(bp.a.f1009g) ? new so.f(n0Var, n0Var2) : g0.d(n0Var, n0Var2);
        }
        n0 n0VarJ = vp.x.j("Error java flexible type with id: " + str + ". (" + n0Var + ".." + n0Var2 + ')');
        l0.o(n0VarJ, "createErrorType(\"Error j…owerBound..$upperBound)\")");
        return n0VarJ;
    }
}
