package ar;

import kn.r1;
import lm.d1;
import os.l;
import os.m;
import vq.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final u0 f689a = new u0("NO_OWNER");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final u0 f690b = new u0("ALREADY_LOCKED_BY_OWNER");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f691c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f692d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f693e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f694f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f695g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f696h = 2;

    @r1({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexKt$withLock$1\n*L\n1#1,310:1\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.sync.MutexKt", f = "Mutex.kt", i = {0, 0, 0}, l = {125}, m = "withLock", n = {"$this$withLock", "owner", k4.f.f8937e}, s = {"L$0", "L$1", "L$2"})
    public static final class a<T> extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
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
            return c.e(null, null, null, this);
        }
    }

    @l
    public static final ar.a a(boolean z10) {
        return new b(z10);
    }

    public static ar.a b(boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return new b(z10);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @m
    public static final <T> Object e(@l ar.a aVar, @m Object obj, @l jn.a<? extends T> aVar2, @l um.d<? super T> dVar) {
        a aVar3;
        if (dVar instanceof a) {
            aVar3 = (a) dVar;
            int i10 = aVar3.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar3.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar3 = new a(dVar);
            }
        } else {
            aVar3 = new a(dVar);
        }
        Object obj2 = aVar3.result;
        wm.a aVar4 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar3.label;
        if (i11 == 0) {
            d1.n(obj2);
            aVar3.L$0 = aVar;
            aVar3.L$1 = obj;
            aVar3.L$2 = aVar2;
            aVar3.label = 1;
            if (aVar.h(obj, aVar3) == aVar4) {
                return aVar4;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            aVar2 = (jn.a) aVar3.L$2;
            obj = aVar3.L$1;
            aVar = (ar.a) aVar3.L$0;
            d1.n(obj2);
        }
        try {
            return aVar2.invoke();
        } finally {
            aVar.f(obj);
        }
    }

    public static final <T> Object f(ar.a aVar, Object obj, jn.a<? extends T> aVar2, um.d<? super T> dVar) {
        aVar.h(obj, dVar);
        try {
            return aVar2.invoke();
        } finally {
            aVar.f(obj);
        }
    }

    public static Object g(ar.a aVar, Object obj, jn.a aVar2, um.d dVar, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = null;
        }
        aVar.h(obj, dVar);
        try {
            return aVar2.invoke();
        } finally {
            aVar.f(obj);
        }
    }
}
