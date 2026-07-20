package dk;

import fl.w;
import kn.l0;
import kn.n0;
import kn.u1;
import lm.l2;
import lm.p;
import nq.n1;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final w<m<?>, ll.c> f3714a = new w<>();

    public static final class a extends ll.e implements n1 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public final jn.l<?, l2> f3715d;

        public a(@os.l jn.l<?, l2> lVar) {
            l0.p(lVar, "handler");
            this.f3715d = lVar;
        }

        @os.l
        public final jn.l<?, l2> N() {
            return this.f3715d;
        }

        @Override // nq.n1
        public void dispose() {
            G();
        }
    }

    public static final class b extends n0 implements jn.l<m<?>, ll.c> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final ll.c invoke(@os.l m<?> mVar) {
            l0.p(mVar, "it");
            return new ll.c();
        }
    }

    public final <T> void a(@os.l m<T> mVar, T t10) throws Throwable {
        l2 l2Var;
        l0.p(mVar, "definition");
        ll.c cVarB = this.f3714a.b(mVar);
        Throwable th2 = null;
        if (cVarB != null) {
            Throwable th3 = null;
            for (ll.e eVarX = (ll.e) cVarB.v(); !l0.g(eVarX, cVarB); eVarX = eVarX.x()) {
                if (eVarX instanceof a) {
                    try {
                        ((jn.l) u1.q(((a) eVarX).f3715d, 1)).invoke(t10);
                    } catch (Throwable th4) {
                        if (th3 == null) {
                            l2Var = null;
                        } else {
                            p.a(th3, th4);
                            l2Var = l2.f10208a;
                        }
                        if (l2Var == null) {
                            th3 = th4;
                        }
                    }
                }
            }
            th2 = th3;
        }
        if (th2 != null) {
            throw th2;
        }
    }

    @os.l
    public final <T> n1 b(@os.l m<T> mVar, @os.l jn.l<? super T, l2> lVar) {
        l0.p(mVar, "definition");
        l0.p(lVar, "handler");
        a aVar = new a(lVar);
        this.f3714a.a(mVar, b.INSTANCE).f(aVar);
        return aVar;
    }

    public final <T> void c(@os.l m<T> mVar, @os.l jn.l<? super T, l2> lVar) {
        l0.p(mVar, "definition");
        l0.p(lVar, "handler");
        ll.c cVarB = this.f3714a.b(mVar);
        if (cVarB == null) {
            return;
        }
        for (ll.e eVarX = (ll.e) cVarB.v(); !l0.g(eVarX, cVarB); eVarX = eVarX.x()) {
            if (eVarX instanceof a) {
                a aVar = (a) eVarX;
                if (l0.g(aVar.f3715d, lVar)) {
                    aVar.G();
                }
            }
        }
    }
}
