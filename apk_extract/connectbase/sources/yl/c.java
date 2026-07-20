package yl;

import java.util.concurrent.locks.LockSupport;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements f<Thread> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final c f21447a = new c();

    @Override // yl.f
    public void a(long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        LockSupport.parkNanos(j10);
    }

    @Override // yl.f
    @l
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Thread b() {
        Thread threadCurrentThread = Thread.currentThread();
        l0.o(threadCurrentThread, "currentThread()");
        return threadCurrentThread;
    }

    @Override // yl.f
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void c(@l Thread thread) {
        l0.p(thread, "token");
        LockSupport.unpark(thread);
    }
}
