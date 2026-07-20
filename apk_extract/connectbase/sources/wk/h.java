package wk;

import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final b f19617a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final fl.b<h> f19618b = new fl.b<>("IgnoreTrailingSlash");

    public static final class a {
    }

    public static final class b implements dk.h<dk.c, a, h> {

        @xm.f(c = "io.ktor.routing.IgnoreTrailingSlash$Feature$install$1", f = "IgnoreTrailingSlash.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
            private /* synthetic */ Object L$0;
            int label;

            public a(um.d<? super a> dVar) {
                super(3, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                i.c((dk.b) ((nl.f) this.L$0).getContext(), true);
                return l2.f10208a;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l nl.f<l2, dk.b> fVar, @os.l l2 l2Var, @os.m um.d<? super l2> dVar) {
                a aVar = new a(dVar);
                aVar.L$0 = fVar;
                return aVar.invokeSuspend(l2.f10208a);
            }
        }

        public b() {
        }

        @Override // dk.h
        @os.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public h a(@os.l dk.c cVar, @os.l jn.l<? super a, l2> lVar) throws nl.c {
            kn.l0.p(cVar, "pipeline");
            kn.l0.p(lVar, "configure");
            h hVar = new h();
            dk.c.f3706v.getClass();
            cVar.x(dk.c.f3709y, new a(null));
            return hVar;
        }

        @Override // dk.h
        @os.l
        public fl.b<h> getKey() {
            return h.f19618b;
        }

        public b(kn.w wVar) {
        }
    }

    public h() {
    }

    public h(kn.w wVar) {
    }
}
