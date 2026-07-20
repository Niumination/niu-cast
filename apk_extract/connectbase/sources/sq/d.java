package sq;

import kn.r1;
import lm.d1;
import lm.l2;
import nq.r2;

/* JADX INFO: loaded from: classes3.dex */
public final class d<T> implements c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final i<T> f15264a;

    @r1({"SMAP\nContext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Context.kt\nkotlinx/coroutines/flow/CancellableFlowImpl$collect$2\n+ 2 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,285:1\n329#2:286\n*S KotlinDebug\n*F\n+ 1 Context.kt\nkotlinx/coroutines/flow/CancellableFlowImpl$collect$2\n*L\n274#1:286\n*E\n"})
    public static final class a<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j<T> f15265a;

        /* JADX INFO: renamed from: sq.d$a$a, reason: collision with other inner class name */
        @xm.f(c = "kotlinx.coroutines.flow.CancellableFlowImpl$collect$2", f = "Context.kt", i = {}, l = {275}, m = "emit", n = {}, s = {})
        public static final class C0385a extends xm.d {
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ a<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0385a(a<? super T> aVar, um.d<? super C0385a> dVar) {
                super(dVar);
                this.this$0 = aVar;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(j<? super T> jVar) {
            this.f15265a = jVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // sq.j
        @os.m
        public final Object emit(T t10, @os.l um.d<? super l2> dVar) {
            C0385a c0385a;
            if (dVar instanceof C0385a) {
                c0385a = (C0385a) dVar;
                int i10 = c0385a.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    c0385a.label = i10 - Integer.MIN_VALUE;
                } else {
                    c0385a = new C0385a(this, dVar);
                }
            } else {
                c0385a = new C0385a(this, dVar);
            }
            Object obj = c0385a.result;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i11 = c0385a.label;
            if (i11 == 0) {
                d1.n(obj);
                r2.y(c0385a.getContext());
                j<T> jVar = this.f15265a;
                c0385a.label = 1;
                if (jVar.emit(t10, c0385a) == aVar) {
                    return aVar;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(@os.l i<? extends T> iVar) {
        this.f15264a = iVar;
    }

    @Override // sq.i
    @os.m
    public Object a(@os.l j<? super T> jVar, @os.l um.d<? super l2> dVar) {
        Object objA = this.f15264a.a(new a(jVar), dVar);
        return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
    }
}
