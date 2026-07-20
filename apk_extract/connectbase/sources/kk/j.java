package kk;

import kn.l0;
import kn.n0;
import kn.w;
import lm.d1;
import lm.l2;
import nq.a1;
import nq.s0;
import tl.v;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    public static final class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final v f9228a;

        public a(@os.l v vVar) {
            l0.p(vVar, "body");
            this.f9228a = vVar;
        }

        @Override // kk.j
        public void a() {
            this.f9228a.z2();
        }

        @os.l
        public final v b() {
            return this.f9228a;
        }
    }

    public static final class b extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final a1<f> f9229a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final pl.k f9230b;

        public static final class a extends n0 implements jn.l<Throwable, l2> {
            public a() {
                super(1);
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
                invoke2(th2);
                return l2.f10208a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@os.m Throwable th2) {
                if (th2 != null) {
                    b.this.f9229a.p().j();
                }
            }
        }

        /* JADX INFO: renamed from: kk.j$b$b, reason: collision with other inner class name */
        @xm.f(c = "io.ktor.http.cio.MultipartEvent$MultipartPart$release$2", f = "Multipart.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0244b extends xm.o implements jn.p<s0, um.d<? super Long>, Object> {
            int label;

            public C0244b(um.d<? super C0244b> dVar) {
                super(2, dVar);
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                return b.this.new C0244b(dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    pl.k kVar = b.this.f9230b;
                    this.label = 1;
                    obj = kVar.P(Long.MAX_VALUE, this);
                    if (obj == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                return obj;
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super Long> dVar) {
                return ((C0244b) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        public b(@os.l a1<f> a1Var, @os.l pl.k kVar) {
            l0.p(a1Var, "headers");
            l0.p(kVar, "body");
            this.f9229a = a1Var;
            this.f9230b = kVar;
        }

        @Override // kk.j
        public void a() throws InterruptedException {
            this.f9229a.k0(new a());
            nq.j.b(null, new C0244b(null), 1, null);
        }

        @os.l
        public final pl.k b() {
            return this.f9230b;
        }

        @os.l
        public final a1<f> c() {
            return this.f9229a;
        }
    }

    public static final class c extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final v f9231a;

        public c(@os.l v vVar) {
            l0.p(vVar, "body");
            this.f9231a = vVar;
        }

        @Override // kk.j
        public void a() {
            this.f9231a.z2();
        }

        @os.l
        public final v b() {
            return this.f9231a;
        }
    }

    public j() {
    }

    public abstract void a();

    public j(w wVar) {
    }
}
