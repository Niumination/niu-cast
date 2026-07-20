package ar;

import kn.r1;
import lm.d1;
import os.l;
import os.m;
import vq.u0;
import vq.z0;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f704a = z0.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final u0 f705b = new u0("PERMIT");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final u0 f706c = new u0("TAKEN");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public static final u0 f707d = new u0("BROKEN");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public static final u0 f708e = new u0("CANCELLED");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f709f = z0.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);

    @r1({"SMAP\nSemaphore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt$withPermit$1\n*L\n1#1,397:1\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.sync.SemaphoreKt", f = "Semaphore.kt", i = {0, 0}, l = {86}, m = "withPermit", n = {"$this$withPermit", k4.f.f8937e}, s = {"L$0", "L$1"})
    public static final class a<T> extends xm.d {
        Object L$0;
        Object L$1;
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
            return f.k(null, null, this);
        }
    }

    @l
    public static final d a(int i10, int i11) {
        return new e(i10, i11);
    }

    public static d b(int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        return new e(i10, i11);
    }

    public static final g j(long j10, g gVar) {
        return new g(j10, gVar, 0);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @m
    public static final <T> Object k(@l d dVar, @l jn.a<? extends T> aVar, @l um.d<? super T> dVar2) {
        a aVar2;
        if (dVar2 instanceof a) {
            aVar2 = (a) dVar2;
            int i10 = aVar2.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar2.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar2 = new a(dVar2);
            }
        } else {
            aVar2 = new a(dVar2);
        }
        Object obj = aVar2.result;
        wm.a aVar3 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar2.label;
        if (i11 == 0) {
            d1.n(obj);
            aVar2.L$0 = dVar;
            aVar2.L$1 = aVar;
            aVar2.label = 1;
            if (dVar.b(aVar2) == aVar3) {
                return aVar3;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            aVar = (jn.a) aVar2.L$1;
            dVar = (d) aVar2.L$0;
            d1.n(obj);
        }
        try {
            return aVar.invoke();
        } finally {
            dVar.release();
        }
    }

    public static final <T> Object l(d dVar, jn.a<? extends T> aVar, um.d<? super T> dVar2) {
        dVar.b(dVar2);
        try {
            return aVar.invoke();
        } finally {
            dVar.release();
        }
    }
}
