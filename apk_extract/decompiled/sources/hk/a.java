package hk;

import ik.u;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f5478a;

    public a(u uVar) {
        this.f5478a = uVar;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f5478a.newThread(runnable);
        threadNewThread.setName(threadNewThread.getName() + " (Evictor)");
        return threadNewThread;
    }
}
