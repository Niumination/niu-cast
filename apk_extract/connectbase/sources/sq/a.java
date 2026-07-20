package sq;

import lm.d1;
import lm.l2;
import nq.a2;

/* JADX INFO: loaded from: classes3.dex */
@a2
public abstract class a<T> implements i<T>, c<T> {

    /* JADX INFO: renamed from: sq.a$a, reason: collision with other inner class name */
    @xm.f(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", i = {0}, l = {230}, m = "collect", n = {"safeCollector"}, s = {"L$0"})
    public static final class C0375a extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ a<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0375a(a<T> aVar, um.d<? super C0375a> dVar) {
            super(dVar);
            this.this$0 = aVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.a(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // sq.i
    @os.m
    public final Object a(@os.l j<? super T> jVar, @os.l um.d<? super l2> dVar) throws Throwable {
        C0375a c0375a;
        tq.v vVar;
        if (dVar instanceof C0375a) {
            c0375a = (C0375a) dVar;
            int i10 = c0375a.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c0375a.label = i10 - Integer.MIN_VALUE;
            } else {
                c0375a = new C0375a(this, dVar);
            }
        } else {
            c0375a = new C0375a(this, dVar);
        }
        Object obj = c0375a.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = c0375a.label;
        if (i11 != 0) {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            vVar = (tq.v) c0375a.L$0;
            try {
                d1.n(obj);
                vVar.releaseIntercepted();
                return l2.f10208a;
            } catch (Throwable th2) {
                th = th2;
                vVar.releaseIntercepted();
                throw th;
            }
        }
        d1.n(obj);
        tq.v vVar2 = new tq.v(jVar, c0375a.getContext());
        try {
            c0375a.L$0 = vVar2;
            c0375a.label = 1;
            if (g(vVar2, c0375a) == aVar) {
                return aVar;
            }
            vVar = vVar2;
            vVar.releaseIntercepted();
            return l2.f10208a;
        } catch (Throwable th3) {
            th = th3;
            vVar = vVar2;
            vVar.releaseIntercepted();
            throw th;
        }
    }

    @os.m
    public abstract Object g(@os.l j<? super T> jVar, @os.l um.d<? super l2> dVar);
}
