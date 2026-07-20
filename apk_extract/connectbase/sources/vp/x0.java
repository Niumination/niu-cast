package vp;

/* JADX INFO: loaded from: classes3.dex */
public interface x0 {

    public static final class a implements x0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final a f17772a = new a();

        @Override // vp.x0
        public void a(@os.l eo.d1 d1Var, @os.m eo.e1 e1Var, @os.l f0 f0Var) {
            kn.l0.p(d1Var, "typeAlias");
            kn.l0.p(f0Var, "substitutedArgument");
        }

        @Override // vp.x0
        public void b(@os.l fo.c cVar) {
            kn.l0.p(cVar, "annotation");
        }

        @Override // vp.x0
        public void c(@os.l h1 h1Var, @os.l f0 f0Var, @os.l f0 f0Var2, @os.l eo.e1 e1Var) {
            kn.l0.p(h1Var, "substitutor");
            kn.l0.p(f0Var, "unsubstitutedArgument");
            kn.l0.p(f0Var2, "argument");
            kn.l0.p(e1Var, "typeParameter");
        }

        @Override // vp.x0
        public void d(@os.l eo.d1 d1Var) {
            kn.l0.p(d1Var, "typeAlias");
        }
    }

    void a(@os.l eo.d1 d1Var, @os.m eo.e1 e1Var, @os.l f0 f0Var);

    void b(@os.l fo.c cVar);

    void c(@os.l h1 h1Var, @os.l f0 f0Var, @os.l f0 f0Var2, @os.l eo.e1 e1Var);

    void d(@os.l eo.d1 d1Var);
}
