package nk;

import ik.r0;
import kn.l0;
import lm.d1;
import nq.c2;
import nq.k1;
import nq.l2;
import pl.m0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public fl.c f11540a;

    public static abstract class a extends s {
        @os.l
        public abstract byte[] j();
    }

    public static abstract class b extends s {
    }

    public static abstract class c extends s {
        @Override // nk.s
        @os.m
        public final r0 g() {
            r0.f8158c.getClass();
            return r0.f8162e;
        }

        @os.m
        public abstract Object j(@os.l pl.k kVar, @os.l pl.n nVar, @os.l um.g gVar, @os.l um.g gVar2, @os.l um.d<? super l2> dVar);
    }

    public static abstract class d extends s {

        @xm.f(c = "io.ktor.http.content.OutgoingContent$ReadChannelContent$readFrom$1", f = "OutgoingContent.kt", i = {0, 0}, l = {82, 84}, m = "invokeSuspend", n = {"$this$writer", "source"}, s = {"L$0", "L$1"})
        public static final class a extends xm.o implements jn.p<m0, um.d<? super lm.l2>, Object> {
            final /* synthetic */ tn.o $range;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(tn.o oVar, um.d<? super a> dVar) {
                super(2, dVar);
                this.$range = oVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<lm.l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                a aVar = d.this.new a(this.$range, dVar);
                aVar.L$0 = obj;
                return aVar;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                pl.k kVarJ;
                m0 m0Var;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 != 0) {
                    if (i10 == 1) {
                        kVarJ = (pl.k) this.L$1;
                        m0Var = (m0) this.L$0;
                        d1.n(obj);
                    } else {
                        if (i10 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        d1.n(obj);
                    }
                    return lm.l2.f10208a;
                }
                d1.n(obj);
                m0 m0Var2 = (m0) this.L$0;
                kVarJ = d.this.j();
                long j10 = this.$range.f15921a;
                this.L$0 = m0Var2;
                this.L$1 = kVarJ;
                this.label = 1;
                if (kVarJ.P(j10, this) == aVar) {
                    return aVar;
                }
                m0Var = m0Var2;
                long j11 = (this.$range.f15922b - this.$range.f15921a) + 1;
                pl.n nVarMo71a = m0Var.mo71a();
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
                if (pl.l.c(kVarJ, nVarMo71a, j11, this) == aVar) {
                    return aVar;
                }
                return lm.l2.f10208a;
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l m0 m0Var, @os.m um.d<? super lm.l2> dVar) {
                return ((a) create(m0Var, dVar)).invokeSuspend(lm.l2.f10208a);
            }
        }

        @os.l
        public abstract pl.k j();

        @os.l
        public pl.k k(@os.l tn.o oVar) {
            l0.p(oVar, "range");
            return oVar.isEmpty() ? pl.k.f13204a.a() : pl.v.k(c2.f11831a, k1.g(), true, new a(oVar, null)).a();
        }
    }

    public static abstract class e extends s {
        @os.m
        public abstract Object j(@os.l pl.n nVar, @os.l um.d<? super lm.l2> dVar);
    }

    public s() {
    }

    @os.m
    public Long b() {
        return null;
    }

    @os.m
    public ik.i c() {
        return null;
    }

    @os.l
    public ik.b0 e() {
        ik.b0.f7939b.getClass();
        return ik.b0.a.f7941b;
    }

    @os.m
    public <T> T f(@os.l fl.b<T> bVar) {
        l0.p(bVar, cb.b.c.f1408o);
        fl.c cVar = this.f11540a;
        if (cVar == null) {
            return null;
        }
        return (T) cVar.b(bVar);
    }

    @os.m
    public r0 g() {
        return null;
    }

    public <T> void i(@os.l fl.b<T> bVar, @os.m T t10) {
        l0.p(bVar, cb.b.c.f1408o);
        if (t10 == null && this.f11540a == null) {
            return;
        }
        if (t10 == null) {
            fl.c cVar = this.f11540a;
            if (cVar == null) {
                return;
            }
            cVar.c(bVar);
            return;
        }
        fl.c cVarB = this.f11540a;
        if (cVarB == null) {
            cVarB = fl.e.b(false, 1, null);
        }
        this.f11540a = cVarB;
        cVarB.g(bVar, t10);
    }

    public s(kn.w wVar) {
    }
}
