package op;

import kn.l0;
import kn.n0;
import kn.w;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends op.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final up.i<h> f12402b;

    public static final class a extends n0 implements jn.a<h> {
        final /* synthetic */ jn.a<h> $getScope;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(jn.a<? extends h> aVar) {
            super(0);
            this.$getScope = aVar;
        }

        @Override // jn.a
        @os.l
        public final h invoke() {
            h hVarInvoke = this.$getScope.invoke();
            return hVarInvoke instanceof op.a ? ((op.a) hVarInvoke).i() : hVarInvoke;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @in.j
    public g(@os.l jn.a<? extends h> aVar) {
        this(null, aVar, 1, 0 == true ? 1 : 0);
        l0.p(aVar, "getScope");
    }

    @Override // op.a
    @os.l
    public h j() {
        return this.f12402b.invoke();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ g(up.n nVar, jn.a aVar, int i10, w wVar) {
        if ((i10 & 1) != 0) {
            nVar = up.f.f16364e;
            l0.o(nVar, "NO_LOCKS");
        }
        this(nVar, aVar);
    }

    @in.j
    public g(@os.l up.n nVar, @os.l jn.a<? extends h> aVar) {
        l0.p(nVar, "storageManager");
        l0.p(aVar, "getScope");
        this.f12402b = nVar.h(new a(aVar));
    }
}
