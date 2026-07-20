package yj;

/* JADX INFO: loaded from: classes2.dex */
@vj.t0
public final class t {

    public final class a implements y.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z0.g f21295a;

        public a(z0.g gVar) {
            this.f21295a = gVar;
        }

        @Override // yj.y0.a
        public int b() {
            return this.f21295a.f21329a.b();
        }

        @Override // yj.y.a, yj.y0.a
        public y.b a() {
            return new y.c(this.f21295a.f21329a.a());
        }
    }

    public static vj.g a(y.a aVar) {
        return new f0(aVar);
    }

    public static y.a b(vj.g gVar) {
        z0.g gVarC = z0.c(gVar);
        if (gVarC.f21331c == null) {
            return new a(gVarC);
        }
        throw new IllegalArgumentException(gVarC.f21331c);
    }
}
