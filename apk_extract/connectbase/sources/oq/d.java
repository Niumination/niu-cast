package oq;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kn.l0;
import kn.n0;
import kn.r1;
import kn.w;
import lm.l2;
import nq.a3;
import nq.c1;
import nq.k1;
import nq.n1;
import nq.p;
import nq.p2;
import nq.x2;
import os.l;
import os.m;
import tn.u;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nHandlerDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerContext\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Runnable.kt\nkotlinx/coroutines/RunnableKt\n*L\n1#1,217:1\n1#2:218\n17#3:219\n*S KotlinDebug\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerContext\n*L\n147#1:219\n*E\n"})
public final class d extends e implements c1 {

    @m
    private volatile d _immediate;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final Handler f12419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m
    public final String f12420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final d f12422d;

    @r1({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n+ 2 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerContext\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,18:1\n148#2:19\n149#2:21\n1#3:20\n*E\n"})
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f12423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f12424b;

        public a(p pVar, d dVar) {
            this.f12423a = pVar;
            this.f12424b = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f12423a.G(this.f12424b, l2.f10208a);
        }
    }

    public static final class b extends n0 implements jn.l<Throwable, l2> {
        final /* synthetic */ Runnable $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Runnable runnable) {
            super(1);
            this.$block = runnable;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
            invoke2(th2);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@m Throwable th2) {
            d.this.f12419a.removeCallbacks(this.$block);
        }
    }

    public d(Handler handler, String str, boolean z10) {
        this.f12419a = handler;
        this.f12420b = str;
        this.f12421c = z10;
        this._immediate = z10 ? this : null;
        d dVar = this._immediate;
        if (dVar == null) {
            dVar = new d(handler, str, true);
            this._immediate = dVar;
        }
        this.f12422d = dVar;
    }

    public static final void Q0(d dVar, Runnable runnable) {
        dVar.f12419a.removeCallbacks(runnable);
    }

    @Override // oq.e, nq.c1
    @l
    public n1 E(long j10, @l final Runnable runnable, @l um.g gVar) {
        if (this.f12419a.postDelayed(runnable, u.C(j10, 4611686018427387903L))) {
            return new n1() { // from class: oq.c
                @Override // nq.n1
                public final void dispose() {
                    d.Q0(this.f12417a, runnable);
                }
            };
        }
        F0(gVar, runnable);
        return a3.f11823a;
    }

    public final void F0(um.g gVar, Runnable runnable) {
        p2.g(gVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        k1.c().dispatch(gVar, runnable);
    }

    @l
    public d J0() {
        return this.f12422d;
    }

    @Override // nq.c1
    public void b0(long j10, @l p<? super l2> pVar) {
        a aVar = new a(pVar, this);
        if (this.f12419a.postDelayed(aVar, u.C(j10, 4611686018427387903L))) {
            pVar.H(new b(aVar));
        } else {
            F0(pVar.getContext(), aVar);
        }
    }

    @Override // nq.n0
    public void dispatch(@l um.g gVar, @l Runnable runnable) {
        if (this.f12419a.post(runnable)) {
            return;
        }
        F0(gVar, runnable);
    }

    public boolean equals(@m Object obj) {
        return (obj instanceof d) && ((d) obj).f12419a == this.f12419a;
    }

    @Override // nq.x2
    public x2 f0() {
        return this.f12422d;
    }

    public int hashCode() {
        return System.identityHashCode(this.f12419a);
    }

    @Override // nq.n0
    public boolean isDispatchNeeded(@l um.g gVar) {
        return (this.f12421c && l0.g(Looper.myLooper(), this.f12419a.getLooper())) ? false : true;
    }

    @Override // oq.e
    public e p0() {
        return this.f12422d;
    }

    @Override // nq.x2, nq.n0
    @l
    public String toString() {
        String strJ0 = j0();
        if (strJ0 != null) {
            return strJ0;
        }
        String string = this.f12420b;
        if (string == null) {
            string = this.f12419a.toString();
        }
        return this.f12421c ? j.a.a(string, ".immediate") : string;
    }

    public d(@l Handler handler, @m String str) {
        this(handler, str, false);
    }

    public d(Handler handler, String str, int i10, w wVar) {
        this(handler, (i10 & 2) != 0 ? null : str, false);
    }
}
