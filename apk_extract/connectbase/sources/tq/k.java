package tq;

import java.util.Iterator;
import kn.r1;
import lm.d1;
import lm.l2;
import nq.s0;
import pq.d0;
import pq.f0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/internal/ChannelLimitedFlowMerge\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,100:1\n1855#2,2:101\n*S KotlinDebug\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/internal/ChannelLimitedFlowMerge\n*L\n95#1:101,2\n*E\n"})
public final class k<T> extends e<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final Iterable<sq.i<T>> f16044d;

    @xm.f(c = "kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge$collectTo$2$1", f = "Merge.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ y<T> $collector;
        final /* synthetic */ sq.i<T> $flow;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(sq.i<? extends T> iVar, y<T> yVar, um.d<? super a> dVar) {
            super(2, dVar);
            this.$flow = iVar;
            this.$collector = yVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new a(this.$flow, this.$collector, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                sq.i<T> iVar = this.$flow;
                y<T> yVar = this.$collector;
                this.label = 1;
                if (iVar.a(yVar, this) == aVar) {
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
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public /* synthetic */ k(Iterable iterable, um.g gVar, int i10, pq.i iVar, int i11, kn.w wVar) {
        this(iterable, (i11 & 2) != 0 ? um.i.INSTANCE : gVar, (i11 & 4) != 0 ? -2 : i10, (i11 & 8) != 0 ? pq.i.SUSPEND : iVar);
    }

    @Override // tq.e
    @os.m
    public Object i(@os.l d0<? super T> d0Var, @os.l um.d<? super l2> dVar) {
        y yVar = new y(d0Var);
        Iterator<sq.i<T>> it = this.f16044d.iterator();
        while (it.hasNext()) {
            nq.k.f(d0Var, null, null, new a(it.next(), yVar, null), 3, null);
        }
        return l2.f10208a;
    }

    @Override // tq.e
    @os.l
    public e<T> j(@os.l um.g gVar, int i10, @os.l pq.i iVar) {
        return new k(this.f16044d, gVar, i10, iVar);
    }

    @Override // tq.e
    @os.l
    public f0<T> n(@os.l s0 s0Var) {
        return pq.b0.c(s0Var, this.f16029a, this.f16030b, l());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(@os.l Iterable<? extends sq.i<? extends T>> iterable, @os.l um.g gVar, int i10, @os.l pq.i iVar) {
        super(gVar, i10, iVar);
        this.f16044d = iterable;
    }
}
