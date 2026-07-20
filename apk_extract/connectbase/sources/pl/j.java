package pl;

import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f13203a = 4088;

    @os.m
    @lm.k(level = lm.m.ERROR, message = "This is going to become internal. Use ByteReadChannel receiver instead.")
    public static final Object a(@os.l f fVar, @os.l f fVar2, long j10, @os.l um.d<? super Long> dVar) {
        return wl.k.b(fVar, fVar2, j10, dVar);
    }

    public static Object b(f fVar, f fVar2, long j10, um.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return wl.k.b(fVar, fVar2, j10, dVar);
    }

    @os.m
    @lm.k(level = lm.m.ERROR, message = "This is going to become internal. Use ByteReadChannel receiver instead.")
    public static final Object c(@os.l f fVar, @os.l f fVar2, boolean z10, @os.l um.d<? super l2> dVar) {
        Object objD = wl.k.d(fVar, fVar2, z10, dVar);
        return objD == wm.a.COROUTINE_SUSPENDED ? objD : l2.f10208a;
    }
}
