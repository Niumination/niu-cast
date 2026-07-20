package tq;

import java.util.ArrayList;
import kn.l0;
import kn.r1;
import lm.d1;
import lm.l2;
import nm.h0;
import nq.g2;
import nq.s0;
import nq.t0;
import nq.u0;
import nq.x0;
import pq.d0;
import pq.f0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nChannelFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelFlow.kt\nkotlinx/coroutines/flow/internal/ChannelFlow\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,245:1\n1#2:246\n*E\n"})
@g2
public abstract class e<T> implements r<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @in.f
    @os.l
    public final um.g f16029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @in.f
    public final int f16030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @in.f
    @os.l
    public final pq.i f16031c;

    @xm.f(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ sq.j<T> $collector;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ e<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(sq.j<? super T> jVar, e<T> eVar, um.d<? super a> dVar) {
            super(2, dVar);
            this.$collector = jVar;
            this.this$0 = eVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            a aVar = new a(this.$collector, this.this$0, dVar);
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
                s0 s0Var = (s0) this.L$0;
                sq.j<T> jVar = this.$collector;
                f0<T> f0VarN = this.this$0.n(s0Var);
                this.label = 1;
                if (sq.m.d(jVar, f0VarN, this) == aVar) {
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

    @xm.f(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends xm.o implements jn.p<d0<? super T>, um.d<? super l2>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ e<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e<T> eVar, um.d<? super b> dVar) {
            super(2, dVar);
            this.this$0 = eVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            b bVar = new b(this.this$0, dVar);
            bVar.L$0 = obj;
            return bVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                d0<? super T> d0Var = (d0) this.L$0;
                e<T> eVar = this.this$0;
                this.label = 1;
                if (eVar.i(d0Var, this) == aVar) {
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
        public final Object invoke(@os.l d0<? super T> d0Var, @os.m um.d<? super l2> dVar) {
            return ((b) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public e(@os.l um.g gVar, int i10, @os.l pq.i iVar) {
        this.f16029a = gVar;
        this.f16030b = i10;
        this.f16031c = iVar;
    }

    public static <T> Object h(e<T> eVar, sq.j<? super T> jVar, um.d<? super l2> dVar) {
        Object objG = t0.g(new a(jVar, eVar, null), dVar);
        return objG == wm.a.COROUTINE_SUSPENDED ? objG : l2.f10208a;
    }

    @Override // sq.i
    @os.m
    public Object a(@os.l sq.j<? super T> jVar, @os.l um.d<? super l2> dVar) {
        return h(this, jVar, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0013  */
    @Override // tq.r
    @os.l
    public sq.i<T> c(@os.l um.g gVar, int i10, @os.l pq.i iVar) {
        um.g gVarPlus = gVar.plus(this.f16029a);
        if (iVar == pq.i.SUSPEND) {
            int i11 = this.f16030b;
            if (i11 != -3) {
                if (i10 == -3) {
                    i10 = i11;
                } else if (i11 != -2) {
                    if (i10 == -2) {
                        i10 = i11;
                    } else {
                        i10 += i11;
                        if (i10 < 0) {
                            i10 = Integer.MAX_VALUE;
                        }
                    }
                }
            }
            iVar = this.f16031c;
        }
        return (l0.g(gVarPlus, this.f16029a) && i10 == this.f16030b && iVar == this.f16031c) ? this : j(gVarPlus, i10, iVar);
    }

    @os.m
    public String g() {
        return null;
    }

    @os.m
    public abstract Object i(@os.l d0<? super T> d0Var, @os.l um.d<? super l2> dVar);

    @os.l
    public abstract e<T> j(@os.l um.g gVar, int i10, @os.l pq.i iVar);

    @os.m
    public sq.i<T> k() {
        return null;
    }

    @os.l
    public final jn.p<d0<? super T>, um.d<? super l2>, Object> l() {
        return new b(this, null);
    }

    public final int m() {
        int i10 = this.f16030b;
        if (i10 == -3) {
            return -2;
        }
        return i10;
    }

    @os.l
    public f0<T> n(@os.l s0 s0Var) {
        return pq.b0.h(s0Var, this.f16029a, m(), this.f16031c, u0.ATOMIC, null, l(), 16, null);
    }

    @os.l
    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strG = g();
        if (strG != null) {
            arrayList.add(strG);
        }
        if (this.f16029a != um.i.INSTANCE) {
            arrayList.add("context=" + this.f16029a);
        }
        if (this.f16030b != -3) {
            arrayList.add("capacity=" + this.f16030b);
        }
        if (this.f16031c != pq.i.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.f16031c);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(x0.a(this));
        sb2.append(ks.a.f9445d);
        return l.a.a(sb2, h0.m3(arrayList, ", ", null, null, 0, null, null, 62, null), ']');
    }
}
