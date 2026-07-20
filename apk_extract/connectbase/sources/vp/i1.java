package vp;

/* JADX INFO: loaded from: classes3.dex */
public interface i1 extends yp.r {

    public static final class a {
        @os.l
        public static yp.i a(@os.l i1 i1Var, @os.l yp.i iVar) {
            kn.l0.p(i1Var, "this");
            kn.l0.p(iVar, "receiver");
            yp.k kVarD = i1Var.d(iVar);
            return kVarD == null ? iVar : i1Var.c(kVarD, true);
        }
    }

    @os.l
    yp.i I(@os.l yp.p pVar);

    boolean R(@os.l yp.o oVar);

    @os.m
    ao.i Z(@os.l yp.o oVar);

    @os.m
    ao.i i(@os.l yp.o oVar);

    boolean k(@os.l yp.i iVar, @os.l dp.c cVar);

    @os.m
    dp.d m0(@os.l yp.o oVar);

    @os.m
    yp.i n0(@os.l yp.i iVar);

    boolean t0(@os.l yp.o oVar);

    @os.l
    yp.i z0(@os.l yp.i iVar);
}
