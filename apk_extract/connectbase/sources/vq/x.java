package vq;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class x {
    public static final int a(@os.l AtomicInteger atomicInteger) {
        return atomicInteger.get();
    }

    public static final void b(@os.l AtomicInteger atomicInteger, int i10) {
        atomicInteger.set(i10);
    }
}
