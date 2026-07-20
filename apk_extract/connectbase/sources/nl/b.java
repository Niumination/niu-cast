package nl;

import java.util.List;
import jn.q;
import kn.l0;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
@nl.a
public final class b<TSubject, TContext> implements f<TSubject, TContext>, h<TSubject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final TContext f11565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final List<q<f<TSubject, TContext>, TSubject, um.d<? super l2>, Object>> f11566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final um.g f11567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public TSubject f11568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11569e;

    @xm.f(c = "io.ktor.util.pipeline.DebugPipelineContext", f = "DebugPipelineContext.kt", i = {0}, l = {82}, m = "proceedLoop", n = {"this"}, s = {"L$0"})
    public static final class a extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ b<TSubject, TContext> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b<TSubject, TContext> bVar, um.d<? super a> dVar) {
            super(dVar);
            this.this$0 = bVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.e(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@os.l TContext tcontext, @os.l List<? extends q<? super f<TSubject, TContext>, ? super TSubject, ? super um.d<? super l2>, ? extends Object>> list, @os.l TSubject tsubject, @os.l um.g gVar) {
        l0.p(tcontext, "context");
        l0.p(list, "interceptors");
        l0.p(tsubject, "subject");
        l0.p(gVar, "coroutineContext");
        this.f11565a = tcontext;
        this.f11566b = list;
        this.f11567c = gVar;
        this.f11568d = tsubject;
    }

    @Override // nl.f
    @os.l
    public TSubject E() {
        return this.f11568d;
    }

    @Override // nl.f
    @os.m
    public Object J0(@os.l um.d<? super TSubject> dVar) {
        int i10 = this.f11569e;
        if (i10 < 0) {
            return this.f11568d;
        }
        if (i10 < this.f11566b.size()) {
            return e(dVar);
        }
        this.f11569e = -1;
        return this.f11568d;
    }

    @Override // nl.h
    @os.m
    public Object b(@os.l TSubject tsubject, @os.l um.d<? super TSubject> dVar) {
        this.f11569e = 0;
        this.f11568d = tsubject;
        return J0(dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object e(um.d<? super TSubject> dVar) {
        a aVar;
        q<f<TSubject, TContext>, TSubject, um.d<? super l2>, Object> qVar;
        TSubject tsubject;
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
        if (i11 != 0) {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (b) aVar.L$0;
        }
        d1.n(obj);
        do {
            int i12 = this.f11569e;
            if (i12 != -1) {
                List<q<f<TSubject, TContext>, TSubject, um.d<? super l2>, Object>> list = this.f11566b;
                if (i12 >= list.size()) {
                    this.f11569e = -1;
                } else {
                    qVar = list.get(i12);
                    this.f11569e = i12 + 1;
                    tsubject = this.f11568d;
                    aVar.L$0 = this;
                    aVar.label = 1;
                }
            }
            return this.f11568d;
        } while (qVar.invoke(this, tsubject, aVar) != aVar2);
        return aVar2;
    }

    @Override // nl.f
    public void finish() {
        this.f11569e = -1;
    }

    @Override // nl.f
    @os.l
    public TContext getContext() {
        return this.f11565a;
    }

    @Override // nq.s0
    @os.l
    public um.g getCoroutineContext() {
        return this.f11567c;
    }

    @Override // nl.f
    @os.m
    public Object v0(@os.l TSubject tsubject, @os.l um.d<? super TSubject> dVar) {
        this.f11568d = tsubject;
        return J0(dVar);
    }
}
