package fl;

/* JADX INFO: loaded from: classes2.dex */
public final class y0 {
    @t0
    public static final <R> R a(@os.l x0 x0Var, @os.l jn.a<? extends R> aVar) {
        kn.l0.p(x0Var, "<this>");
        kn.l0.p(aVar, "block");
        try {
            x0Var.b();
            return aVar.invoke();
        } finally {
            x0Var.c();
        }
    }
}
