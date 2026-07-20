package ak;

import java.util.concurrent.atomic.AtomicReference;
import vj.h0;
import vj.i0;
import vj.v1;
import vj.w1;
import vj.y2;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    public static final class a implements vj.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v1 f288a;

        /* JADX INFO: renamed from: ak.j$a$a, reason: collision with other inner class name */
        public final class C0005a<ReqT, RespT> extends h0.a<ReqT, RespT> {
            public C0005a(vj.k<ReqT, RespT> kVar) {
                super(kVar);
            }

            @Override // vj.h0, vj.k
            public void h(vj.k.a<RespT> aVar, v1 v1Var) {
                v1Var.s(a.this.f288a);
                super.h(aVar, v1Var);
            }
        }

        public a(v1 v1Var) {
            this.f288a = (v1) c1.h0.F(v1Var, "extraHeaders");
        }

        @Override // vj.l
        public <ReqT, RespT> vj.k<ReqT, RespT> a(w1<ReqT, RespT> w1Var, vj.e eVar, vj.f fVar) {
            return new C0005a(fVar.g(w1Var, eVar));
        }
    }

    public static final class b implements vj.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference<v1> f290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReference<v1> f291b;

        public final class a<ReqT, RespT> extends h0.a<ReqT, RespT> {

            /* JADX INFO: renamed from: ak.j$b$a$a, reason: collision with other inner class name */
            public final class C0006a extends i0.a<RespT> {
                public C0006a(vj.k.a<RespT> aVar) {
                    super(aVar);
                }

                @Override // vj.i0.a, vj.i0, vj.b2, vj.k.a
                public void a(y2 y2Var, v1 v1Var) {
                    b.this.f291b.set(v1Var);
                    super.a(y2Var, v1Var);
                }

                @Override // vj.i0.a, vj.i0, vj.b2, vj.k.a
                public void b(v1 v1Var) {
                    b.this.f290a.set(v1Var);
                    super.b(v1Var);
                }
            }

            public a(vj.k<ReqT, RespT> kVar) {
                super(kVar);
            }

            @Override // vj.h0, vj.k
            public void h(vj.k.a<RespT> aVar, v1 v1Var) {
                b.this.f290a.set(null);
                b.this.f291b.set(null);
                super.h(new C0006a(aVar), v1Var);
            }
        }

        public b(AtomicReference<v1> atomicReference, AtomicReference<v1> atomicReference2) {
            this.f290a = (AtomicReference) c1.h0.F(atomicReference, "headersCapture");
            this.f291b = (AtomicReference) c1.h0.F(atomicReference2, "trailersCapture");
        }

        @Override // vj.l
        public <ReqT, RespT> vj.k<ReqT, RespT> a(w1<ReqT, RespT> w1Var, vj.e eVar, vj.f fVar) {
            return new a(fVar.g(w1Var, eVar));
        }
    }

    public static vj.l a(v1 v1Var) {
        return new a(v1Var);
    }

    public static vj.l b(AtomicReference<v1> atomicReference, AtomicReference<v1> atomicReference2) {
        return new b(atomicReference, atomicReference2);
    }
}
