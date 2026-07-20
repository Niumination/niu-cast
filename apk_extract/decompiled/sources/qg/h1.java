package qg;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h1 extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ag.a f9075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f9076b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1(ag.a stopFunction) {
        super("KtorShutdownHook");
        Intrinsics.checkNotNullParameter(stopFunction, "stopFunction");
        this.f9075a = stopFunction;
        this.f9076b = new AtomicBoolean(true);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (this.f9076b.compareAndSet(true, false)) {
            this.f9075a.invoke();
        }
    }
}
