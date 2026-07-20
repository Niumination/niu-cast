package q1;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes.dex */
@o0
@b1.d
public final class b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f13408a = 2147483647999999999L;

    public static void a(@gm.a Object blocker, long nanos) {
        LockSupport.parkNanos(blocker, Math.min(nanos, f13408a));
    }
}
