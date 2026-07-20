package pq;

import nq.c3;
import vq.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final u0 f13243a = new u0("NO_ELEMENT");

    @lm.k(level = lm.m.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and StateFlow, and is no longer supported")
    @c3
    @os.l
    public static final <E> d<E> a(int i10) {
        if (i10 == -2) {
            l.f13292l.getClass();
            return new e(l.b.f13306h);
        }
        if (i10 == -1) {
            return new x();
        }
        if (i10 == 0) {
            throw new IllegalArgumentException("Unsupported 0 capacity for BroadcastChannel");
        }
        if (i10 != Integer.MAX_VALUE) {
            return new e(i10);
        }
        throw new IllegalArgumentException("Unsupported UNLIMITED capacity for BroadcastChannel");
    }
}
