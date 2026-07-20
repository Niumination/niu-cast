package sq;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kn.r1;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nShare.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/SubscribedFlowCollector\n+ 2 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,426:1\n329#2:427\n*S KotlinDebug\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/SubscribedFlowCollector\n*L\n417#1:427\n*E\n"})
public final class y0<T> implements j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final j<T> f15394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.p<j<? super T>, um.d<? super l2>, Object> f15395b;

    @xm.f(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", i = {0, 0}, l = {419, TypedValues.CycleType.TYPE_WAVE_PERIOD}, m = "onSubscription", n = {"this", "safeCollector"}, s = {"L$0", "L$1"})
    public static final class a extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ y0<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(y0<T> y0Var, um.d<? super a> dVar) {
            super(dVar);
            this.this$0 = y0Var;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.a(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y0(@os.l j<? super T> jVar, @os.l jn.p<? super j<? super T>, ? super um.d<? super l2>, ? extends Object> pVar) {
        this.f15394a = jVar;
        this.f15395b = pVar;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0068  */
    /* JADX WARN: Code duplicated, block: B:29:0x0077 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x007b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public final Object a(@os.l um.d<? super l2> dVar) throws Throwable {
        a aVar;
        Throwable th2;
        tq.v vVar;
        y0<T> y0Var;
        j<T> jVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(this, dVar);
            }
        } else {
            aVar = new a(this, dVar);
        }
        Object obj = aVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        if (i11 == 0) {
            d1.n(obj);
            tq.v vVar2 = new tq.v(this.f15394a, aVar.getContext());
            try {
                jn.p<j<? super T>, um.d<? super l2>, Object> pVar = this.f15395b;
                aVar.L$0 = this;
                aVar.L$1 = vVar2;
                aVar.label = 1;
                if (pVar.invoke(vVar2, aVar) == aVar2) {
                    return aVar2;
                }
                y0Var = this;
                vVar = vVar2;
                vVar.releaseIntercepted();
                jVar = y0Var.f15394a;
                if (jVar instanceof y0) {
                    return l2.f10208a;
                }
                aVar.L$0 = null;
                aVar.L$1 = null;
                aVar.label = 2;
                if (((y0) jVar).a(aVar) == aVar2) {
                    return aVar2;
                }
            } catch (Throwable th3) {
                th2 = th3;
                vVar = vVar2;
                vVar.releaseIntercepted();
                throw th2;
            }
        } else if (i11 == 1) {
            vVar = (tq.v) aVar.L$1;
            y0Var = (y0) aVar.L$0;
            try {
                d1.n(obj);
                vVar.releaseIntercepted();
                jVar = y0Var.f15394a;
                if (jVar instanceof y0) {
                    return l2.f10208a;
                }
                aVar.L$0 = null;
                aVar.L$1 = null;
                aVar.label = 2;
                if (((y0) jVar).a(aVar) == aVar2) {
                    return aVar2;
                }
            } catch (Throwable th4) {
                th2 = th4;
                vVar.releaseIntercepted();
                throw th2;
            }
        } else {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
        }
        return l2.f10208a;
    }

    @Override // sq.j
    @os.m
    public Object emit(T t10, @os.l um.d<? super l2> dVar) {
        return this.f15394a.emit(t10, dVar);
    }
}
