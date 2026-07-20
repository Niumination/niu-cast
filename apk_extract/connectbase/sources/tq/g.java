package tq;

import androidx.constraintlayout.widget.ConstraintLayout;
import lm.d1;
import nq.l2;
import nq.r2;
import nq.s0;
import pq.d0;
import pq.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class g<T> extends e<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final sq.i<sq.i<T>> f16032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f16033e;

    public static final class a<T> implements sq.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l2 f16034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ar.d f16035b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d0<T> f16036c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ y<T> f16037d;

        /* JADX INFO: renamed from: tq.g$a$a, reason: collision with other inner class name */
        @xm.f(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1", f = "Merge.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0417a extends xm.o implements jn.p<s0, um.d<? super lm.l2>, Object> {
            final /* synthetic */ y<T> $collector;
            final /* synthetic */ sq.i<T> $inner;
            final /* synthetic */ ar.d $semaphore;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0417a(sq.i<? extends T> iVar, y<T> yVar, ar.d dVar, um.d<? super C0417a> dVar2) {
                super(2, dVar2);
                this.$inner = iVar;
                this.$collector = yVar;
                this.$semaphore = dVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<lm.l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                return new C0417a(this.$inner, this.$collector, this.$semaphore, dVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, lm.l2] */
            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                try {
                    if (i10 == 0) {
                        d1.n(obj);
                        sq.i<T> iVar = this.$inner;
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
                    this.$semaphore.release();
                    this = lm.l2.f10208a;
                    return this;
                } catch (Throwable th2) {
                    this.$semaphore.release();
                    throw th2;
                }
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super lm.l2> dVar) {
                return ((C0417a) create(s0Var, dVar)).invokeSuspend(lm.l2.f10208a);
            }
        }

        @xm.f(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2", f = "Merge.kt", i = {0, 0}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT}, m = "emit", n = {"this", "inner"}, s = {"L$0", "L$1"})
        public static final class b extends xm.d {
            Object L$0;
            Object L$1;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ a<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public b(a<? super T> aVar, um.d<? super b> dVar) {
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
        public a(l2 l2Var, ar.d dVar, d0<? super T> d0Var, y<T> yVar) {
            this.f16034a = l2Var;
            this.f16035b = dVar;
            this.f16036c = d0Var;
            this.f16037d = yVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // sq.j
        @os.m
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(@os.l sq.i<? extends T> iVar, @os.l um.d<? super lm.l2> dVar) {
            b bVar;
            if (dVar instanceof b) {
                bVar = (b) dVar;
                int i10 = bVar.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    bVar.label = i10 - Integer.MIN_VALUE;
                } else {
                    bVar = new b(this, dVar);
                }
            } else {
                bVar = new b(this, dVar);
            }
            Object obj = bVar.result;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i11 = bVar.label;
            if (i11 == 0) {
                d1.n(obj);
                l2 l2Var = this.f16034a;
                if (l2Var != null) {
                    r2.x(l2Var);
                }
                ar.d dVar2 = this.f16035b;
                bVar.L$0 = this;
                bVar.L$1 = iVar;
                bVar.label = 1;
                if (dVar2.b(bVar) == aVar) {
                    return aVar;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                iVar = (sq.i) bVar.L$1;
                this = (a) bVar.L$0;
                d1.n(obj);
            }
            nq.k.f(this.f16036c, null, null, new C0417a(iVar, this.f16037d, this.f16035b, null), 3, null);
            return lm.l2.f10208a;
        }
    }

    public /* synthetic */ g(sq.i iVar, int i10, um.g gVar, int i11, pq.i iVar2, int i12, kn.w wVar) {
        this(iVar, i10, (i12 & 4) != 0 ? um.i.INSTANCE : gVar, (i12 & 8) != 0 ? -2 : i11, (i12 & 16) != 0 ? pq.i.SUSPEND : iVar2);
    }

    @Override // tq.e
    @os.l
    public String g() {
        return "concurrency=" + this.f16033e;
    }

    @Override // tq.e
    @os.m
    public Object i(@os.l d0<? super T> d0Var, @os.l um.d<? super lm.l2> dVar) {
        Object objA = this.f16032d.a(new a((l2) dVar.getContext().get(l2.f11882k), ar.f.b(this.f16033e, 0, 2, null), d0Var, new y(d0Var)), dVar);
        return objA == wm.a.COROUTINE_SUSPENDED ? objA : lm.l2.f10208a;
    }

    @Override // tq.e
    @os.l
    public e<T> j(@os.l um.g gVar, int i10, @os.l pq.i iVar) {
        return new g(this.f16032d, this.f16033e, gVar, i10, iVar);
    }

    @Override // tq.e
    @os.l
    public f0<T> n(@os.l s0 s0Var) {
        return pq.b0.c(s0Var, this.f16029a, this.f16030b, l());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(@os.l sq.i<? extends sq.i<? extends T>> iVar, int i10, @os.l um.g gVar, int i11, @os.l pq.i iVar2) {
        super(gVar, i11, iVar2);
        this.f16032d = iVar;
        this.f16033e = i10;
    }
}
