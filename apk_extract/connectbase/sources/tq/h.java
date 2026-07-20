package tq;

import kn.l0;
import lm.d1;
import lm.l2;
import nq.m0;
import pq.d0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h<S, T> extends e<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @in.f
    @os.l
    public final sq.i<S> f16038d;

    @xm.f(c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", f = "ChannelFlow.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends xm.o implements jn.p<sq.j<? super T>, um.d<? super l2>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ h<S, T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h<S, T> hVar, um.d<? super a> dVar) {
            super(2, dVar);
            this.this$0 = hVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            a aVar = new a(this.this$0, dVar);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                sq.j<? super T> jVar = (sq.j) this.L$0;
                h<S, T> hVar = this.this$0;
                this.label = 1;
                if (hVar.s(jVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l sq.j<? super T> jVar, @os.m um.d<? super l2> dVar) {
            return ((a) create(jVar, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(@os.l sq.i<? extends S> iVar, @os.l um.g gVar, int i10, @os.l pq.i iVar2) {
        super(gVar, i10, iVar2);
        this.f16038d = iVar;
    }

    public static <S, T> Object p(h<S, T> hVar, sq.j<? super T> jVar, um.d<? super l2> dVar) {
        if (hVar.f16030b == -3) {
            um.g context = dVar.getContext();
            um.g gVarE = m0.e(context, hVar.f16029a);
            if (l0.g(gVarE, context)) {
                Object objS = hVar.s(jVar, dVar);
                return objS == wm.a.COROUTINE_SUSPENDED ? objS : l2.f10208a;
            }
            um.e.b bVar = um.e.G;
            if (l0.g(gVarE.get(bVar), context.get(bVar))) {
                Object objR = hVar.r(jVar, gVarE, dVar);
                return objR == wm.a.COROUTINE_SUSPENDED ? objR : l2.f10208a;
            }
        }
        Object objH = e.h(hVar, jVar, dVar);
        return objH == wm.a.COROUTINE_SUSPENDED ? objH : l2.f10208a;
    }

    public static <S, T> Object q(h<S, T> hVar, d0<? super T> d0Var, um.d<? super l2> dVar) {
        Object objS = hVar.s(new y(d0Var), dVar);
        return objS == wm.a.COROUTINE_SUSPENDED ? objS : l2.f10208a;
    }

    @Override // tq.e, sq.i
    @os.m
    public Object a(@os.l sq.j<? super T> jVar, @os.l um.d<? super l2> dVar) {
        return p(this, jVar, dVar);
    }

    @Override // tq.e
    @os.m
    public Object i(@os.l d0<? super T> d0Var, @os.l um.d<? super l2> dVar) {
        return q(this, d0Var, dVar);
    }

    public final Object r(sq.j<? super T> jVar, um.g gVar, um.d<? super l2> dVar) {
        Object objD = f.d(gVar, f.e(jVar, dVar.getContext()), null, new a(this, null), dVar, 4, null);
        return objD == wm.a.COROUTINE_SUSPENDED ? objD : l2.f10208a;
    }

    @os.m
    public abstract Object s(@os.l sq.j<? super T> jVar, @os.l um.d<? super l2> dVar);

    @Override // tq.e
    @os.l
    public String toString() {
        return this.f16038d + " -> " + super.toString();
    }
}
