package ik;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public enum n {
    ;

    public static final e COUNTER = new e();
    public static final f LONG_COUNTER = new f();
    public static final d OBJECT_EQUALS = new d();
    public static final m TO_ARRAY = new m();
    static final l RETURNS_VOID = new l();
    static final c ERROR_EXTRACTOR = new c();
    public static final ek.b ERROR_NOT_IMPLEMENTED = new ph.c();
    public static final ck.b IS_EMPTY = new tj.w(w.INSTANCE, 8);

    public static <T, R> ek.h createCollectorCaller(ek.c cVar) {
        return new p2.d();
    }

    public static final ek.g createRepeatDematerializer(ek.g gVar) {
        return new g(gVar, 0);
    }

    public static <T, R> ek.g createReplaySelectorAndObserveOn(ek.g gVar, ck.h hVar) {
        return new i1.a(gVar, hVar);
    }

    public static <T> ek.f createReplaySupplier(ck.c cVar) {
        return new j(cVar);
    }

    public static final ek.g createRetryDematerializer(ek.g gVar) {
        return new g(gVar, 1);
    }

    public static ek.g equalsWith(Object obj) {
        return new b(obj, 0);
    }

    public static ek.g isInstanceOf(Class<?> cls) {
        return new b(cls, 1);
    }

    public static <T> ek.f createReplaySupplier(ck.c cVar, int i8) {
        return new h(cVar, i8);
    }

    public static <T> ek.f createReplaySupplier(ck.c cVar, long j8, TimeUnit timeUnit, ck.h hVar) {
        return new i(cVar, j8, timeUnit, hVar);
    }

    public static <T> ek.f createReplaySupplier(ck.c cVar, int i8, long j8, TimeUnit timeUnit, ck.h hVar) {
        return new k(cVar, i8, j8, timeUnit, hVar);
    }
}
