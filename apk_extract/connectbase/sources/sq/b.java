package sq;

import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class b<T> extends f<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final jn.p<pq.d0<? super T>, um.d<? super l2>, Object> f15206e;

    @xm.f(c = "kotlinx.coroutines.flow.CallbackFlowBuilder", f = "Builders.kt", i = {0}, l = {334}, m = "collectTo", n = {"scope"}, s = {"L$0"})
    public static final class a extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ b<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b<T> bVar, um.d<? super a> dVar) {
            super(dVar);
            this.this$0 = bVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.i(null, this);
        }
    }

    public /* synthetic */ b(jn.p pVar, um.g gVar, int i10, pq.i iVar, int i11, kn.w wVar) {
        this(pVar, (i11 & 2) != 0 ? um.i.INSTANCE : gVar, (i11 & 4) != 0 ? -2 : i10, (i11 & 8) != 0 ? pq.i.SUSPEND : iVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // sq.f, tq.e
    @os.m
    public Object i(@os.l pq.d0<? super T> d0Var, @os.l um.d<? super l2> dVar) {
        a aVar;
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
            aVar.L$0 = d0Var;
            aVar.label = 1;
            if (f.o(this, d0Var, aVar) == aVar2) {
                return aVar2;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d0Var = (pq.d0) aVar.L$0;
            d1.n(obj);
        }
        if (d0Var.J()) {
            return l2.f10208a;
        }
        throw new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
    }

    @Override // sq.f, tq.e
    @os.l
    public tq.e<T> j(@os.l um.g gVar, int i10, @os.l pq.i iVar) {
        return new b(this.f15206e, gVar, i10, iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@os.l jn.p<? super pq.d0<? super T>, ? super um.d<? super l2>, ? extends Object> pVar, @os.l um.g gVar, int i10, @os.l pq.i iVar) {
        super(pVar, gVar, i10, iVar);
        this.f15206e = pVar;
    }
}
