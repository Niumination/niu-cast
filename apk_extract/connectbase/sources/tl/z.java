package tl;

/* JADX INFO: loaded from: classes2.dex */
@ul.d
@lm.k(level = lm.m.ERROR, message = "Will be removed in future releases.", replaceWith = @lm.a1(expression = "AbstractInput", imports = {"io.ktor.utils.io.core.AbstractInput"}))
public abstract class z extends w {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(@os.l ul.b bVar, long j10, @os.l bm.h<ul.b> hVar) {
        super(bVar, j10, hVar);
        kn.l0.p(bVar, "head");
        kn.l0.p(hVar, "pool");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ z(o0 o0Var, long j10, bm.h hVar) {
        this((ul.b) o0Var, j10, (bm.h<ul.b>) hVar);
        kn.l0.p(o0Var, "head");
        kn.l0.p(hVar, "pool");
    }
}
