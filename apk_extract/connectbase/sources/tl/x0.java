package tl;

/* JADX INFO: loaded from: classes2.dex */
public final class x0 {
    public static final boolean a(@os.l v vVar) {
        kn.l0.p(vVar, "<this>");
        return vVar.B1();
    }

    public static final boolean b(@os.l g0 g0Var) {
        kn.l0.p(g0Var, "<this>");
        return g0Var.B1();
    }

    public static /* synthetic */ void c(v vVar) {
    }

    @lm.k(message = "Use endOfInput property instead", replaceWith = @lm.a1(expression = "endOfInput", imports = {}))
    public static /* synthetic */ void d(g0 g0Var) {
    }

    public static final boolean e(@os.l v vVar) {
        kn.l0.p(vVar, "<this>");
        return !vVar.B1();
    }

    public static final boolean f(@os.l g0 g0Var) {
        ul.b bVarJ;
        kn.l0.p(g0Var, "<this>");
        if (g0Var.B1() || (bVarJ = ul.k.j(g0Var, 1)) == null) {
            return false;
        }
        ul.k.e(g0Var, bVarJ);
        return true;
    }

    public static /* synthetic */ void g(v vVar) {
    }

    @lm.k(message = "This makes no sense for streaming inputs. Some use-cases are covered by endOfInput property", replaceWith = @lm.a1(expression = "!endOfInput", imports = {}))
    public static /* synthetic */ void h(g0 g0Var) {
    }
}
