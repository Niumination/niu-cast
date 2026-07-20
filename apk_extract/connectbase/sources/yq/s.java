package yq;

import lm.c1;
import lm.d1;
import lm.l2;
import lm.z0;
import nq.s0;
import nq.t0;
import nq.u0;

/* JADX INFO: loaded from: classes3.dex */
@z0
public final class s<R> extends t<R> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public final nq.q<R> f21743i;

    @xm.f(c = "kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl$initSelectResult$1", f = "SelectOld.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
        int label;
        final /* synthetic */ s<R> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(s<R> sVar, um.d<? super a> dVar) {
            super(2, dVar);
            this.this$0 = sVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new a(this.this$0, dVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object, lm.l2] */
        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    d1.n(obj);
                    s<R> sVar = this.this$0;
                    this.label = 1;
                    sVar.getClass();
                    obj = t.O(sVar, this);
                    if (obj == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                p.c(this.this$0.f21743i, obj);
                this = l2.f10208a;
                return this;
            } catch (Throwable th2) {
                p.d(this.this$0.f21743i, th2);
                return l2.f10208a;
            }
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public s(@os.l um.d<? super R> dVar) {
        super(dVar.getContext());
        this.f21743i = new nq.q<>(wm.c.e(dVar), 1);
    }

    @z0
    public final void R(@os.l Throwable th2) {
        nq.q<R> qVar = this.f21743i;
        c1.a aVar = c1.Companion;
        qVar.resumeWith(c1.m59constructorimpl(d1.a(th2)));
    }

    @os.m
    @z0
    public final Object S() {
        if (this.f21743i.isCompleted()) {
            return this.f21743i.z();
        }
        nq.k.f(t0.a(this.f21718a), null, u0.UNDISPATCHED, new a(this, null), 1, null);
        return this.f21743i.z();
    }
}
