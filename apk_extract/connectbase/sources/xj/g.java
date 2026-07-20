package xj;

import kn.l0;
import kn.r1;
import lm.d1;
import lm.l2;
import os.l;
import os.m;
import pq.o;
import pq.p;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nReadiness.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Readiness.kt\nio/grpc/kotlin/Readiness\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n*L\n1#1,46:1\n530#2,5:47\n*S KotlinDebug\n*F\n+ 1 Readiness.kt\nio/grpc/kotlin/Readiness\n*L\n33#1:47,5\n*E\n"})
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final jn.a<Boolean> f20260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final pq.l<l2> f20261b;

    @xm.f(c = "io.grpc.kotlin.Readiness", f = "Readiness.kt", i = {0}, l = {42}, m = "suspendUntilReady", n = {"this"}, s = {"L$0"})
    public static final class a extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return g.this.b(this);
        }
    }

    public g(@l jn.a<Boolean> aVar) {
        l0.p(aVar, "isReallyReady");
        this.f20260a = aVar;
        this.f20261b = o.d(-1, null, null, 6, null);
    }

    public final void a() {
        Object objW = this.f20261b.w(l2.f10208a);
        if (objW instanceof p.c) {
            Throwable thF = p.f(objW);
            if (thF != null) {
                throw thF;
            }
            throw new AssertionError("Should be impossible; a CONFLATED channel should never return false on offer");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @m
    public final Object b(@l um.d<? super l2> dVar) {
        a aVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object obj = aVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        if (i11 != 0) {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (g) aVar.L$0;
        }
        d1.n(obj);
        while (!this.f20260a.invoke().booleanValue()) {
            pq.l<l2> lVar = this.f20261b;
            aVar.L$0 = this;
            aVar.label = 1;
            if (lVar.n(aVar) == aVar2) {
                return aVar2;
            }
        }
        return l2.f10208a;
    }
}
